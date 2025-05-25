package Challenge.Generic;

public class Run {

    public static void main(String[] args) {

        var park = new Park[]{
                new Park("shivan Park","12.995108639046144, 80.23043454030366"),
                new Park("shivan2 Park","12.9951086390, 80.23043454030"),
                new Park("shivan3 Park","12.9951086, 80.230434")
        };
        Layer<Park> parkLayer = new Layer<>(park);
        parkLayer.renderLayer();

        var river = new River[]{
                new River("shivan Park","12.995108639046144, 80.23043454030366"),
                new River("shivan2 Park","12.9951086390, 80.23043454030"),
                new River("shivan3 Park","12.9951086, 80.230434")
        };
        Layer<River> riverlayer = new Layer<>(river);
        riverlayer.addElement(
                new River("shivan Park","12.995108639046144, 80.23043454030366"),
                new River("shivan2 Park","12.9951086390, 80.23043454030")
        );
        riverlayer.renderLayer();
    }
}
