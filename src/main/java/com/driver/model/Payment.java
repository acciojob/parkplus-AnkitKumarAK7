package com.driver.model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Boolean paymentCompleted;

    private PaymentMode paymentMode;

    @JoinColumn
    @OneToOne
    private Reservation reservation;

    public Payment(Reservation reservation, int amountSent, String mode) {
    }

    public Payment(int id, Boolean paymentCompleted, PaymentMode paymentMode, Reservation reservation) {
        this.id = id;
        this.paymentCompleted = paymentCompleted;
        this.paymentMode = paymentMode;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getPaymentCompleted(boolean b) {
        return paymentCompleted;
    }

    public void setPaymentCompleted(Boolean paymentCompleted) {
        this.paymentCompleted = paymentCompleted;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
