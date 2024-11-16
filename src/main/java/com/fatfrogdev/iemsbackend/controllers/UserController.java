package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Client.UserRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.UserViewDTO;
import com.fatfrogdev.iemsbackend.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserViewDTO> save(@RequestBody UserRegisterDTO personDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(personDTO));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserViewDTO> findByUsername(@PathVariable("username") String username){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByUserUsername(username));
    }

    @PatchMapping("/{username}")
    public ResponseEntity<UserViewDTO> deactivateByUsername(@PathVariable("username") String username, @RequestParam("action") String action){
        userService.activateOrDeactivateByUsername(username, action);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}