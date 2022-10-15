package com.example.machineapp.controller;

import com.example.machineapp.model.ClientReport;
import com.example.machineapp.model.Reservation;
import com.example.machineapp.model.ReservationReport;
import com.example.machineapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")

public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @GetMapping ("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Integer id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-status")
    public ReservationReport getReservationStatusReport(){
        return reservationService.getReservationStatusReport();
    }
    @GetMapping("/report-date/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable ("dateTwo")String datetwo){
        return reservationService.getReservationPeriod(dateOne,datetwo);
    }

    @GetMapping("/report-clients")
    public List<ClientReport> getReportClients(){
        return reservationService.getTopClients();
    }
}
