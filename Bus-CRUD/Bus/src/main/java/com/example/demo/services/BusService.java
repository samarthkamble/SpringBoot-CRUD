package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Bus;
import com.example.demo.repo.BusRepository;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Optional<Bus> getBusById(Long id) {
        return busRepository.findById(id);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Optional<Bus> updateBus(Long id, Bus busDetails) {
        Optional<Bus> optionalBus = busRepository.findById(id);
        if (optionalBus.isPresent()) {
            Bus existingBus = optionalBus.get();
            existingBus.setBusName(busDetails.getBusName());
            existingBus.setDestination(busDetails.getDestination());
            existingBus.setBusType(busDetails.getBusType());
            existingBus.setDepartureTime(busDetails.getDepartureTime());
            existingBus.setArrivalTime(busDetails.getArrivalTime());
            existingBus.setTotalSeat(busDetails.getTotalSeat());
            existingBus.setPrice(busDetails.getPrice());
            busRepository.save(existingBus);
        }
        return optionalBus;
    }

    public boolean deleteBus(Long id) {
        try {
            busRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

