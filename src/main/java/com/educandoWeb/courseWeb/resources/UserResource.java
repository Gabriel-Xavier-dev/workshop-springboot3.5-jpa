package com.educandoWeb.courseWeb.resources;

import com.educandoWeb.courseWeb.dto.UserDTO;
import com.educandoWeb.courseWeb.dto.UserInsertDTO;
import com.educandoWeb.courseWeb.dto.UserUpdateDTO;
import com.educandoWeb.courseWeb.entities.User;
import com.educandoWeb.courseWeb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = service.findAll()
                .stream()
                .map(x -> new UserDTO(x))
                .toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User obj = service.findById(id);
        UserDTO dto = new UserDTO(obj);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserInsertDTO obj) {
        User entity = insertDtoToEntity(obj);
        service.insert(entity);
        UserDTO newDto = new UserDTO(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserUpdateDTO obj){
        User entity = UpdateDtoToEntity(obj);
        entity = service.update(id,entity);
        UserDTO dto = new UserDTO(entity);
        return ResponseEntity.ok().body(dto);
    }

    // --- Métodos auxiliares: convertem cada DTO de entrada em User ---
    private User insertDtoToEntity(UserInsertDTO dto){
        User entity = new User();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    private User UpdateDtoToEntity(UserUpdateDTO dto){
        User entity = new User();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}