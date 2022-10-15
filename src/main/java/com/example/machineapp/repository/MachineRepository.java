package com.example.machineapp.repository;

import com.example.machineapp.model.Machine;
import com.example.machineapp.repository.crudrepository.MachineCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MachineRepository {
    @Autowired
    private MachineCrudRepository machineCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }
    public Optional<Machine> getMachine(Integer id){
        return machineCrudRepository.findById(id);
    }

    public Machine save(Machine machine){
        return machineCrudRepository.save(machine);
    }

    public void delete(Machine machine){
        machineCrudRepository.delete(machine);
    }

}