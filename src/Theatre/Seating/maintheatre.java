package Theatre.Seating;

public class maintheatre {

    public static void main(String[] args){
        int rows = 10;
        int totalSeats = 100;

        Theatre rodgersNYC = new Theatre("Palazzo",rows, totalSeats);

        rodgersNYC.printSeatMap();
        booking(rodgersNYC,'D',5);
        booking(rodgersNYC,'J',5);
        bookingseats(rodgersNYC,2,'B',3,10);
    }

    private static void booking(Theatre theatre, char row, int seatNo){
        String seat = theatre.reservedSeat(row, seatNo);
        if(seat !=null){
            System.out.println("Congratulation !! Your reaserved seat is " + seat);
            theatre.printSeatMap();
        }else{
            System.out.println("Sorry !! This seat is already reserved");
        }
    }



    private static void bookingseats(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat){
        bookingseats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }


    private  static void bookingseats(Theatre theatre, int tickets, char minRow,
                                 char maxRow,int minSeat,int maxSeat){
        var seats = theatre.reservedSeats(tickets, minRow, maxRow, minSeat,maxSeat);

        if(seats != null){
            System.out.println("Congratulations! Your reserrved seats are " + seats);
            theatre.printSeatMap();
        }else{
            System.out.println("Sorry !! No matching contiguous seats in rows: "
            + minRow + " _ " + maxRow);
        }
    }
}
