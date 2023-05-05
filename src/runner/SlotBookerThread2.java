package runner;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Slot;
import model.User;
import service.SlotBooker;

@NoArgsConstructor
@AllArgsConstructor
public class SlotBookerThread2 implements Runnable{
    SlotBooker slotBooker;
    Slot slot;
    User user;
    @Override
    public void run() {
        try {
            slotBooker.bookSlot(slot,11, user);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
