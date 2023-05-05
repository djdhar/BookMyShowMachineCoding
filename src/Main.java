import model.*;
import runner.SlotBookerThread1;
import service.SlotBooker;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user = new User(0, "Dibya");
        User user2 = new User(0, "Jyoti");
        Theatre theatre = new Theatre(0, "Star Theatre");
        Screen screen1 = new Screen(0, theatre);
        Screen screen2 = new Screen(1, theatre);
        Screen screen3 = new Screen(2, theatre);
        Slot slot1 = new Slot(0, screen1);
        Slot slot2 = new Slot(1, screen1);
        Slot slot3 = new Slot(2, screen1);
        Movie movie = new Movie(1, "MyMovie",
                new ArrayList<>(List.of(slot1, slot2, slot3))
                );
//       // System.out.println(movie);
//        System.out.println();
//        System.out.println();
//        System.out.println(movie.getSlots().get(0).getSeats().get(11));
//        SlotBooker slotBooker = new SlotBooker();
//        slotBooker.bookSlot(slot1,11, user);
//        System.out.println(movie.getSlots().get(0).getSeats().get(11));
//        slotBooker.bookSlot(slot1,11, user2);
//        System.out.println(movie.getSlots().get(0).getSeats().get(11));
//        slotBooker.unBookSlot(slot1,11, user);
//        System.out.println(movie.getSlots().get(0).getSeats().get(11));
//        slotBooker.bookSlot(slot1,11, user2);
//        System.out.println(movie.getSlots().get(0).getSeats().get(11));
//        slotBooker.unBookSlot(slot1,11, user);
//        System.out.println(movie.getSlots().get(0).getSeats().get(11));
//        slotBooker.unBookSlot(slot1,11, user2);
//        System.out.println(movie.getSlots().get(0).getSeats().get(11));
//        slotBooker.unBookSlot(slot1,11, user);
//        System.out.println(movie.getSlots().get(0).getSeats().get(11));
        SlotBookerThread1 slotBookerThread1 = new SlotBookerThread1(new SlotBooker(), slot1, user2);
        SlotBookerThread1 slotBookerThread2 = new SlotBookerThread1(new SlotBooker(), slot1, user);
        Thread t1 = new Thread(slotBookerThread1);
        Thread t2 = new Thread(slotBookerThread2);
        t1.start();
        t2.start();
    }

}