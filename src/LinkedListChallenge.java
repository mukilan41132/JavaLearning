import java.util.LinkedList;

public class LinkedListChallenge {

    private String name;
    private int distance;
    private LinkedList<LinkedListChallenge> placevisit;

    public LinkedListChallenge(String name, int distance) {
        this.name = name;
        this.distance = distance;
        this.placevisit = new LinkedList<>();
    }

    public void addPlaceVisit(LinkedListChallenge place) {
        if (placevisit.contains(place)) {
            System.out.println("Place already visited: " + place);
            return;
        }
        placevisit.add(place);
    }

    public LinkedList<LinkedListChallenge> getPlacevisit() {
        return placevisit;
    }

    public void printPlaces() {
        if (placevisit.isEmpty()) {
            System.out.println("No places visited yet.");
            return;
        }
        System.out.print("Places Visited:"+ getPlacevisit());
        for (LinkedListChallenge place : placevisit) {
            System.out.println("- " + place.name + " (" + place.distance + " km)");
        }
    }


}
