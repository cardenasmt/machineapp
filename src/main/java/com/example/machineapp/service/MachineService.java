package com.example.machineapp.service;

import com.example.machineapp.model.Machine;
import com.example.machineapp.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MachineService {
    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(Integer Id) {
        return machineRepository.getMachine(Id);
    }

    public Machine save(Machine machine) {
        if (machine.getId() == null) {
            return machineRepository.save(machine);
        } else {
            Optional<Machine> e = machineRepository.getMachine(machine.getId());
            if (e.isEmpty()) {
                return machineRepository.save(machine);
            } else {
                return machine;
            }
        }
    }

    public Machine update(Machine machine) {
        if (machine.getId() != null) {
            Optional<Machine> e = machineRepository.getMachine(machine.getId());
            if (!e.isEmpty()) {
                if (machine.getName() != null) {
                    e.get().setName(machine.getName());
                }
                if (machine.getBrand() != null) {
                    e.get().setBrand(machine.getBrand());
                }
                if (machine.getYear() != null) {
                    e.get().setYear(machine.getYear());
                }
                if (machine.getDescription() != null) {
                    e.get().setDescription(machine.getDescription());
                }
                if (machine.getCategory() != null) {
                    e.get().setCategory(machine.getCategory());
                }
                machineRepository.save(e.get());
                return e.get();
            } else {
                return machine;
            }
        } else {
            return machine;
        }
    }

    public boolean deleteMachine(Integer id) {
        Boolean d = getMachine(id).map(machine -> {
            machineRepository.delete(machine);
            return true;
        }).orElse(false);
        return d;

    }
}