package com.educandoWeb.courseWeb.repositories;

import com.educandoWeb.courseWeb.entities.Category;
import com.educandoWeb.courseWeb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
