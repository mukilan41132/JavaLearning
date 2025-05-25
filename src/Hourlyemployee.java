public class Hourlyemployee extends Employee {

    private double houerlysalary;

    public Hourlyemployee(String name, String birthDate, String hireDate, double houerlysalary) {
        super(name, birthDate, hireDate);
        this.houerlysalary = houerlysalary;
    }
}
