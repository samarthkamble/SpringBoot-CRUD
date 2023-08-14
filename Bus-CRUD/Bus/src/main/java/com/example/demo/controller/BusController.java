package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bus;
import com.example.demo.services.BusService;

@RestController
@RequestMapping("/buses")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping
    public ResponseEntity<Bus> saveBus(@RequestBody Bus bus) {
        Bus savedBus = busService.saveBus(bus);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        Optional<Bus> bus = busService.getBusById(id);
        return bus.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus busDetails) {
        Optional<Bus> bus = busService.updateBus(id, busDetails);
        return bus.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBus(@PathVariable Long id) {
        boolean deleted = busService.deleteBus(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

