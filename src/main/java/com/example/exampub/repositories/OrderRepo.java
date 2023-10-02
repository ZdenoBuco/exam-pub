package com.example.exampub.repositories;

import com.example.exampub.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {
    @Query(value = "SELECT * FROM order WHERE user_id = :id", nativeQuery = true)
    Order findOrderByUserId(@Param("id") Long id);
}
