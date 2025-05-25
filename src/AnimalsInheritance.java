public class AnimalsInheritance {
    private  String type;
    private String size;
    private  double weight;

    public AnimalsInheritance(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }
    public AnimalsInheritance() {

    }
    @Override
    public String toString() {
        return "AnimalsInheritance{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void Move(String speed){
          System.out.println("Moving " + type + " from " + size + " to " + speed);
    }

    public void MakeNoise(){
        System.out.println(type+"MakeNoise");
    }
}
