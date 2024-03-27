package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.ClientRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.ClientViewDTO;
import com.fatfrogdev.iemsbackend.services.IClientService;
import com.fatfrogdev.iemsbackend.services.impl.ClientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class ClientController   {
    private final  IClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<ClientViewDTO> save(@RequestBody ClientRegisterDTO personDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(personDTO));
    }


    @GetMapping("") // users?username=...
    public ResponseEntity<ClientViewDTO> findByUsername(@RequestParam("username") String username){
        return ResponseEntity.ok(clientService.findByUserUsername(username));
    }


    @PatchMapping("")
    public ResponseEntity<ClientViewDTO> deactivateByUsername(@RequestParam("username") String username){
        clientService.deleteByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
