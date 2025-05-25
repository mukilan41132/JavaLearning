public class Employee extends WorkerChallenge {

    private long EmployeeId;
    private String HireDate;
    private static  int employeeNo = 1;


    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.EmployeeId = employeeNo++;
        HireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId=" + EmployeeId +
                ", HireDate='" + HireDate + '\'' +
                '}'+ super.toString();
    }
}
