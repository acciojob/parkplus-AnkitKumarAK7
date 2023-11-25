//package com.driver.controllers;
//
//import com.driver.model.Reservation;
//import com.driver.services.impl.ReservationServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/reservation")
//public class ReservationController {
//    @Autowired
//    ReservationServiceImpl reservationService;
//    @PostMapping("/reserveSpot")
//    public ResponseEntity<Reservation> reserveSpot(@RequestParam Integer userId, @RequestParam Integer parkingLotId, @RequestParam Integer timeInHours, @RequestParam Integer numberOfWheels) throws Exception{
//        //Reserve a spot in the given parkingLot such that the total price is minimum. Note that the price per hour for each spot is different
//        //Note that the vehicle can only be parked in a spot having a type equal to or larger than given vehicle
//        //If parkingLot is not found, user is not found, or no spot is available, throw "Cannot make reservation" exception.
//
////        try {
////            // Reserve a spot
////            Reservation reservation = reservationService.reserveSpot(userId, parkingLotId, timeInHours, numberOfWheels);
////            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
////        } catch (Exception e) {
////            // Handle exceptions and return an appropriate response
////            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
////        }
//        return null;
//    }
//}
