package com.educandoWeb.courseWeb.repositories;

import com.educandoWeb.courseWeb.entities.Category;
import com.educandoWeb.courseWeb.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
