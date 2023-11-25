package com.driver.services.impl;

import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.model.SpotType;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot newParkingLot = new ParkingLot();
        newParkingLot.setName(name);
        newParkingLot.setAddress(address);
        return parkingLotRepository1.save(newParkingLot);
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
        // Retrieve the parking lot by ID
        ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId)
                .orElseThrow(() -> new RuntimeException("Parking Lot not found with id: " + parkingLotId));

        // Determine the spot type based on the number of wheels
        SpotType spotType = determineSpotType(numberOfWheels);

        // Create a new spot
        Spot newSpot = new Spot();
        newSpot.setSpotType(spotType);
        newSpot.setPricePerHour(pricePerHour);
        newSpot.setOccupied(false);
        newSpot.setParkingLot(parkingLot);

        // Add the spot to the parking lot
     //   parkingLot.addSpot(newSpot);

        // Save the updated parking lot (assuming the ParkingLot entity has a method like addSpot)
        parkingLotRepository1.save(parkingLot);

        return newSpot;
    }

    private SpotType determineSpotType(Integer numberOfWheels) {
        // Logic to determine the spot type based on the number of wheels
        // You can customize this logic based on your specific requirements
        if (numberOfWheels == 2) {
            return SpotType.TWO_WHEELER;
        } else if (numberOfWheels == 4) {
            return SpotType.FOUR_WHEELER;
        } else {
            return SpotType.OTHERS;
        }
    }

    @Override
    public void deleteSpot(int spotId) {
        // Delete the spot from the database
        spotRepository1.deleteById(spotId);
    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {
        // Retrieve the spot from the database
        Spot existingSpot = spotRepository1.findById(spotId)
                .orElseThrow(() -> new RuntimeException("Spot not found with id: " + spotId));

        // Validate that the spot belongs to the specified parking lot
        if (existingSpot.getParkingLot().getId() != parkingLotId) {
            throw new RuntimeException("Spot with id " + spotId + " does not belong to Parking Lot with id " + parkingLotId);
        }

        // Update the spot details
        existingSpot.setPricePerHour(pricePerHour);

        // Save the updated spot
        return spotRepository1.save(existingSpot);

    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
        // Delete the parking lot from the database
        parkingLotRepository1.deleteById(parkingLotId);
    }
}
