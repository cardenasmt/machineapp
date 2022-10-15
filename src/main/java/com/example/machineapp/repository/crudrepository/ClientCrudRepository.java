package com.example.machineapp.repository.crudrepository;

import com.example.machineapp.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository <Client, Integer> {
}
