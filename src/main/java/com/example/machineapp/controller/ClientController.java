package com.example.machineapp.controller;

import com.example.machineapp.model.Client;
import com.example.machineapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")

public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/all")
    public List<Client> getClient(){
        return clientService.getAll();
    }

    @PostMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") Integer id){
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return clientService.deleteClient(id);
    }


}
