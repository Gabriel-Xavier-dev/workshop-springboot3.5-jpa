package com.educandoWeb.courseWeb.repositories;

import com.educandoWeb.courseWeb.entities.Order;
import com.educandoWeb.courseWeb.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
