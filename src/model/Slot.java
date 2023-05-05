package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    int slotId;
    List<Seat> seats = generateSeats();
    Screen screen;

    public Slot(int id, Screen screen) {
        this.slotId = id;
        this.screen = screen;
    }

    List<Seat> generateSeats() {
        List<Seat> seats = new ArrayList<>();
        for(int i=0;i<100;i++) {
            seats.add(new Seat(i, false, null));
        }
        return seats;
    }
}
