package com.driver.services.impl;

import com.driver.model.Payment;
import com.driver.model.PaymentMode;
import com.driver.model.Reservation;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
        // Fetch the reservation
        Reservation reservation = reservationRepository2.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        // Validate the payment amount
        if (reservation.getSpot().getPricePerHour() > amountSent) {
            throw new InsufficientAmountException("Insufficient Amount");
        }
        // Validate the payment mode
        if (!isValidPaymentMode(mode)) {
            throw new InvalidPaymentModeException("Payment mode not detected");
        }

        // Update payment attributes for the reservation
        reservation.getPayment().getPaymentCompleted(true);
        reservation.getPayment().setPaymentMode(PaymentMode.valueOf(mode));

        // Save the updated reservation to the database
        reservationRepository2.save(reservation);

        // Create and return a Payment object (you may need to adjust based on your model structure)
        Payment payment = new Payment(reservation, amountSent, mode);
        return payment;
    }

    private boolean isValidPaymentMode(String mode) {
        // Implement logic to validate payment mode (cash, card, or upi)
        return mode.equalsIgnoreCase("cash") || mode.equalsIgnoreCase("card") || mode.equalsIgnoreCase("upi");
    }
}

