package com.driver.model;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numberOfHours;

    @JoinColumn
    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Payment payment;

    @JoinColumn
    @ManyToOne
    private Spot spot;

    public Reservation() {
    }

    public Reservation(int id, int numberOfHours, User user, Payment payment, Spot spot) {
        this.id = id;
        this.numberOfHours = numberOfHours;
        this.user = user;
        this.payment = payment;
        this.spot = spot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}
