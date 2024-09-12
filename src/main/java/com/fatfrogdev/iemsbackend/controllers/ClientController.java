package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Client.ClientViewDTO;
import com.fatfrogdev.iemsbackend.services.IClientService;
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

    @GetMapping("/{username}")
    public ResponseEntity<ClientViewDTO> findByUsername(@PathVariable("username") String username){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByUserUsername(username));
    }

    @PatchMapping("/{username}") // TODO: Redirect to the proper function according to the parameters given in the request.
    public ResponseEntity<ClientViewDTO> deactivateByUsername(@PathVariable("username") String username, @RequestParam("action") String action){
        clientService.activateOrDeactivateByUsername(username, action);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}