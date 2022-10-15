package com.example.machineapp.repository.crudrepository;

import com.example.machineapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository <Category, Integer> {
}
