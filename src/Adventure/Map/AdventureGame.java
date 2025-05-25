package Adventure.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventureGame {
    private static final String GAME_LOCATION = """
            road,at the end of the road, W: hill, E:well house,S:valley,N:forest
            hill,on top of hill with a view in all directions,N:forest, E:road
            well house,inside a well house for a small spring,W:road,N:lake,S:stream
            valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
            forest,at the edge of a thick dark forest,S:road,E:lake
            lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
            stream,near a stream with a rocky bed,W:valley, N:well house
            """;

    private enum Compass {
        E, N, S, W;
        private static final String[] directions = {"East", "North", "South", "West"};

        public String getString() {
            return directions[this.ordinal()];
        }

    }

    private record Location(String description, Map<Compass, String> nextPlaces) {
    }

    private String lastplace;
    private Map<String, Location> adventureMap = new HashMap<>();


    public AdventureGame() {
        this(null);
    }

    public AdventureGame(String customLocation) {
        loadLocation(GAME_LOCATION);
        if (customLocation != null) {
            loadLocation(customLocation);
        }
    }

    private void loadLocation(String data) {
        for (String s : data.split("\\R")) {
            String[] parts = s.split(",", 3);
            Arrays.asList(parts).replaceAll(String::trim);
            Map<Compass, String> nextPlaces = loadDirection(parts[2]);
            Location location = new Location(parts[0], nextPlaces);
            adventureMap.put(parts[0], location);

        }
//        adventureMap.forEach((k, v) -> {
//            System.out.println("Location: " + v);
//            System.out.printf("%s: %s%n", k, v);
//        });
    }

    private Map<Compass, String> loadDirection(String nextPlace) {
        Map<Compass, String> directions = new HashMap<>();
        List<String> nextSteps = Arrays.asList(nextPlace.split(","));

        nextSteps.replaceAll(String::trim);

        for (String s : nextSteps) {
            String[] compassAndLocation = s.split(":");
            Compass compass = Compass.valueOf(compassAndLocation[0].trim());
            String destination = compassAndLocation[1].trim();
            directions.put(compass, destination);
        }
        return directions;
    }

    private void vist(Location location) {
        System.out.printf("*** You're standing %s *** %n", location.description);
        System.out.println("\tFrom here , you can see");

        location.nextPlaces.forEach((k, v) -> {
            System.out.printf("\t● A %s to the %s (%s)   %n", v, k.getString(), k);
        });
        System.out.print("Select Your Compass (Q to quit) >> ");
    }

    public void move(String direction) {
        var nextPlaces = adventureMap.get(lastplace).nextPlaces;
        String nextPlace = null;
        if ("ENSW".contains(direction)) {
            nextPlace = nextPlaces.get(Compass.valueOf(direction));
            if (nextPlace == null) {
                System.out.println("Invalid direction");
                return;
            } else {
                play(nextPlace);
            }
        }
    }

    public void play(String location) {
        if (adventureMap.containsKey(location)) {
            Location next = adventureMap.get(location);
            lastplace = location;
            vist(next);
        } else {
            System.out.println(location + " is an invalid location. Please try again.");
        }
    }
}


