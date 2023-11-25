package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ParkingLotService;
import com.driver.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {
        // Check if the user and parkingLot exist
//        User user = userRepository3.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
//
//        ParkingLot parkingLot = parkingLotRepository3.findById(parkingLotId)
//                .orElseThrow(() -> new RuntimeException("ParkingLot not found with ID: " + parkingLotId));
//
//        // Get the best available spot based on the provided parameters
//        Spot spot =spotService.getBestAvailableSpot(parkingLotId, timeInHours, numberOfWheels);
//
//        if (spot == null) {
//            throw new RuntimeException("No available spot found for reservation");
//        }
//
//        // Create a new reservation entity
//        Reservation reservation = new Reservation();
//        reservation.setUser(user);
//       // reservation.setSpot(spot);
//        reservation.setNumberOfHours(timeInHours);
//
//        // Save the reservation
//        reservationRepository3.save(reservation);
//
//        return reservation;

        return null;

    }
}
