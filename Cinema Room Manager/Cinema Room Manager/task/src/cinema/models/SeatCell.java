package cinema.models;

import lombok.Data;

public class SeatCell {
    boolean isEmpty;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
