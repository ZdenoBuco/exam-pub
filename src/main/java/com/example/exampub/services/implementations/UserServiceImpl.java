package com.example.exampub.services.implementations;

import com.example.exampub.DTOs.OrderDTO;
import com.example.exampub.DTOs.UserDTO;
import com.example.exampub.DTOs.UserResponseDTO;
import com.example.exampub.models.Order;
import com.example.exampub.models.User;
import com.example.exampub.repositories.UserRepo;
import com.example.exampub.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Iterable<UserDTO> findAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userRepo.findAll().forEach(user -> userDTOList.add(new UserDTO(user)));
        return userDTOList;
    }

    @Override
    public UserResponseDTO findUserByID(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setId(user.get().getId());
            userResponseDTO.setName(user.get().getName());
            userResponseDTO.setActive(user.get().isActive());
            userResponseDTO.setDateOfBirth(user.get().getDateOfBirth());
            userResponseDTO.setPocket(user.get().getPocket());

            List<OrderDTO> orderDTOs = new ArrayList<>();
            for (Order order : user.get().getOrders()) {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setProductName(order.getProductName());
                orderDTO.setAmount(order.getAmount());
                orderDTO.setPrice(order.getPrice());
                orderDTOs.add(orderDTO);
            }
            userResponseDTO.setOrders(orderDTOs);

            return userResponseDTO;
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
