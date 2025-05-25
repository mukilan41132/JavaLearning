package Theatre.Seating;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Theatre {

    class Seat implements Comparable<Seat> {
        private String seatNum;
        private boolean reserved;

        public Seat(char rowChar, int seatNo) {
            this.seatNum = "%c%03d".formatted(rowChar, seatNo);
        }

        @Override
        public String toString() {
            return this.seatNum;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }

    private String theatreName;
    private int seatsPerRow;
    private NavigableSet<Seat> seats;

    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats / rows;

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i % seatsPerRow + (int) 'A');
            int seatInRow = i / seatsPerRow + 1;
            seats.add(new Seat(rowChar, seatInRow));
        }
        System.out.println("42"+ seats);
    }

    public void printSeatMap() {

        String seperatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", seperatorLine, theatreName);
        int index = 0;
        for (Seat s : seats) {
            System.out.printf("%-8s%s", s.seatNum + ((s.reserved) ? "(●)" : ""),
                    ((index++ + 1) % seatsPerRow == 0) ? "\n" : "");
        }
        System.out.println(seperatorLine);
    }

    public String reservedSeat(char rowChar, int seatNo) {
        Seat seat = new Seat(rowChar, seatNo);
        Seat requested = seats.ceiling(seat);

        if (requested == null || !requested.seatNum.equals(seat.seatNum)) {
            System.out.print("--> No Such seat available");
            System.out.printf(": Seat must be between %s and %s%n",
                    seats.first().seatNum, seats.last().seatNum);

        } else {
            if (!requested.reserved) {
                requested.reserved = true;
                System.out.printf("--> %s reserved successfully%n", requested.seatNum);
                return requested.seatNum;

            } else {
                System.out.println("--> Seat already reserved");
            }
        }
        return null;
    }

    private boolean validation(int count, char first, char last, int min, int max) {
        boolean result = (min > 0 || seatsPerRow >= count || (max - min + 1) >= count);
        result = result && seats.contains(new Seat(first, min));
        if (!result) {
            System.out.printf("Invalid! %1$d seats between " +
                            "%2$c[%3$d-4$d]-%5$c[%3$d-%4$d] try again]",
                    count, first, last, min, max, last);
            System.out.printf(": Seats must be between %s and %s%n",
                    seats.first().seatNum,
                    seats.last().seatNum);

        }
        return result;
    }


    public Set<Seat> reservedSeats(int count, char minRow, char maxRow, int minSeat,
                                   int maxSeat) {
        char lastValid = seats.last().seatNum.charAt(0);
        maxRow = (maxRow < lastValid) ? maxRow : lastValid;

        if (!validation(count, minRow, maxRow, minSeat, maxSeat)) {
            return null;
        }

        NavigableSet<Seat> selected = null;
        for (char letter = minRow; letter <= maxRow; letter++) {
            NavigableSet<Seat> contiguous = seats.subSet(
                    new Seat(letter, minSeat), true,
                    new Seat(letter, maxSeat), true);
            int index = 0;
            Seat first = null;
            for (Seat current : contiguous) {
                if (current.reserved) {
                    index = 0;
                    continue;
                }
                first = (index == 0) ? current : first;
                if (++index == count) {
                    selected = contiguous.subSet(first, true, current, true);
                    break;
                }

            }
            if (selected != null) {
                break;
            }

        }
        Set<Seat> reservedSeats = null;
        if (selected != null) {
            selected.forEach(s -> s.reserved = true);
            reservedSeats = new TreeSet<>(selected);
        }

        return reservedSeats;
    }

}
