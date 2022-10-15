package com.example.machineapp.repository;

import com.example.machineapp.model.Client;
import com.example.machineapp.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
 @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getALL(){

        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(Integer id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client client){
        return  clientCrudRepository.save(client);
    }
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }


}
