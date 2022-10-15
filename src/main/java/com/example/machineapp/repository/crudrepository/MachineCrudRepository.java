package com.example.machineapp.repository.crudrepository;

import com.example.machineapp.model.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineCrudRepository extends CrudRepository <Machine,Integer> {
}
