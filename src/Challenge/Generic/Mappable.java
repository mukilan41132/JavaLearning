package Challenge.Generic;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;

public interface Mappable {

    void  render();

    static double @NotNull [] StringToLatLoc(String location){
        var splits = location.split(",");
        double lat = Double.valueOf(splits[0]);
        double lon = Double.valueOf(splits[1]);
        return new double[] {lat, lon};

    }
}

abstract class Point implements Mappable {

    private double[] location = new double[2];

    public Point(String location){
        this.location = Mappable.StringToLatLoc(location);
    }
    @Override
    public void render() {
        System.out.println("Render" + this + "as  point (" + location() + ")");
    }

    @Contract(pure = true)
    private @NotNull String location(){
        return Arrays.toString(location);
    }
}

abstract class Line  implements Mappable {

    private double[][] locations;

    public Line(String @NotNull ... locations) {
        this.locations = new double[locations.length][];
        int i = 0;
        for(var l: locations){
            this.locations[i++] = Mappable.StringToLatLoc(l);
        }
    }
    public void render() {
        System.out.println("Render" + this + "as Line (" + locations() + ")");
    }

    private @NotNull String locations(){
        return Arrays.deepToString(locations);
    }
}