package edu.cmu.cs214.booking;

import edu.cmu.cs214.booking.domain.Room;
import edu.cmu.cs214.booking.domain.TimeInterval;
import edu.cmu.cs214.booking.domain.User;
import edu.cmu.cs214.booking.repo.InMemoryBookingStore;
import edu.cmu.cs214.booking.service.BookingService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class IsAvailableTest {

    @Test
    void notAvailableWhenAnEarlierBookingRunsIntoTheRequest() {
        BookingService svc = new BookingService(new InMemoryBookingStore());
        Room roomA = new Room("A", "Room A", 10);
        User alice = new User("u1", "Alice");

        svc.book(roomA, alice, new TimeInterval(570, 630));
        assertFalse(svc.isAvailable(roomA, new TimeInterval(600, 660)));
    }
}
