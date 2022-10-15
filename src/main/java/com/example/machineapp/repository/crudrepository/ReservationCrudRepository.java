package com.example.machineapp.repository.crudrepository;

import com.example.machineapp.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository <Reservation, Integer> {
}
