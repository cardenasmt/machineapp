package com.example.machineapp.repository.crudrepository;

import com.example.machineapp.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <Message, Integer> {
}
