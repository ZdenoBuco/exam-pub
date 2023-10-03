package com.example.exampub.services.implementations;

import com.example.exampub.DTOs.BuyDTO;
import com.example.exampub.models.Drink;
import com.example.exampub.models.Order;
import com.example.exampub.models.User;
import com.example.exampub.repositories.DrinkRepo;
import com.example.exampub.repositories.OrderRepo;
import com.example.exampub.repositories.UserRepo;
import com.example.exampub.services.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final DrinkRepo drinkRepo;

    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo, DrinkRepo drinkRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.drinkRepo = drinkRepo;
    }

    @Override
    public void addDrinkIntoOrder(BuyDTO buyDTO) {
        Optional<User> user = userRepo.findById(buyDTO.getUserId());
        if (user.isEmpty()) {
            throw new IllegalArgumentException("user not found");
        }
        Optional<Drink> drink = drinkRepo.findById(buyDTO.getProductId());
        if (drink.isEmpty()) {
            throw new IllegalArgumentException("drink not found");
        }
        if (drink.get().isForAdult()) {
            if (!isUserAdult(user.get())) {
                throw new IllegalArgumentException("user is not adult");
            }
        }
        List<Order> ordersOfUser = orderRepo.findOrdersByUserId(buyDTO.getUserId());
        boolean drinkIsntInOrder = true;
        for (Order order : ordersOfUser) {
            if (order.getProductName().equals(drink.get().getProductName())) {
                drinkIsntInOrder = false;
                order.setAmount(order.getAmount() + buyDTO.getAmount());
                order.setPrice(order.getPrice() + buyDTO.getAmount() * drink.get().getPrice());
                orderRepo.save(order);
                break;
            }
        }
        if (drinkIsntInOrder) {
            double price = buyDTO.getAmount() * drink.get().getPrice();
            orderRepo.save(new Order(drink.get().getProductName(), buyDTO.getAmount(), price));
        }
    }

    @Override
    public void buyOrderedItems(BuyDTO buyDTO) {

    }

    private boolean isUserAdult(User user) {
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(user.getDateOfBirth(), currentDate);
        int legalAdultAge = 18;
        return age.getYears() >= legalAdultAge;
    }
}
