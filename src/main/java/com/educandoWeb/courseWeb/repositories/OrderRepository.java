package com.educandoWeb.courseWeb.repositories;

import com.educandoWeb.courseWeb.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
