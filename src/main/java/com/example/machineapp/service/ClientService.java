package com.example.machineapp.service;



import java.util.List;
import java.util.Optional;

import com.example.machineapp.model.Client;
import com.example.machineapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getALL();
    }

    public Optional<Client> getClient (Integer Id) {

        return clientRepository.getClient(Id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (e.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if (!e.isEmpty()) {
                if (client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }


    public boolean deleteClient(int id) {
        Boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}



