package com.educandoWeb.courseWeb.repositories;

import com.educandoWeb.courseWeb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
