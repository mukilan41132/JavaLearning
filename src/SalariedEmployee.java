public class SalariedEmployee extends Employee {

  private double annualSalary;
  private boolean retaired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;

    }

    public double collectpay() {
        return (int) annualSalary / 26;
    }
    public void retire() {
        terminate("12/12/2025");
        retaired = true;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "annualSalary=" + annualSalary +
                ", retaired=" + retaired +
                ", EndDate='" + EndDate + '\'' +
                '}';
    }
}
