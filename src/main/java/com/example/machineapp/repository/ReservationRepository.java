package com.example.machineapp.repository;

import com.example.machineapp.model.Client;
import com.example.machineapp.model.ClientReport;
import com.example.machineapp.model.Reservation;
import com.example.machineapp.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository

public class  ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(Integer id) {
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    public List<Reservation>getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }
    public List<ClientReport> getTopClients(){
        List<ClientReport> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClinet();
        for (int i = 0; i < report.size(); i++) {
            res.add(new ClientReport((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res ;
    }
}