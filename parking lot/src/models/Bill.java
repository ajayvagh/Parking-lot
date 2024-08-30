package models;

import java.time.LocalDateTime;

public class Bill extends BaseModel {
    private LocalDateTime exitTime;
    private int amount;
    private Ticket ticket;
    private Gate gate;
//    private models.Payment payment;

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

//    public models.Payment getPayment() {
//        return payment;
//    }
//
//    public void setPayment(models.Payment payment) {
//        this.payment = payment;
//    }
}
