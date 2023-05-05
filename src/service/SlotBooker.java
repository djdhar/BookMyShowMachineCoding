package service;

import model.Slot;
import model.User;

import java.util.Random;

public class SlotBooker {

    public void bookSlot(Slot slot, int seatId, User user) throws InterruptedException {
        Thread.sleep(new Random().nextInt(6)*1000);
        synchronized (slot) {
            if(slot.getSeats().get(seatId).isBooked()) {
                System.out.println("Seat "+seatId+ " of slot "+slot.getSlotId()+ " is already booked!");
            } else {
                slot.getSeats().get(seatId).setBooked(true);
                slot.getSeats().get(seatId).setUser(user);
                System.out.println("Booked Slot Seat : "+slot.getSeats().get(seatId) );
            }
        }
    }

    public void unBookSlot(Slot slot, int seatId, User user) throws InterruptedException {
        Thread.sleep(new Random().nextInt(6)*1000);
        synchronized (slot) {

            if(slot.getSeats().get(seatId).isBooked() && slot.getSeats().get(seatId).getUser().equals(user)) {
                slot.getSeats().get(seatId).setBooked(false);
                slot.getSeats().get(seatId).setUser(null);
            } else if(slot.getSeats().get(seatId).isBooked()) {
                System.out.println("Seat "+seatId+ " of slot "+slot.getSlotId()+  " is already booked! by other");
            } else {
                System.out.println("Seat "+seatId+ " of slot "+slot.getSlotId()+ " is already free!");
            }
        }
    }
}
