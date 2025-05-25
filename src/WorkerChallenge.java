public class WorkerChallenge {
   private String Name;
   private String BirthDate;
   protected String EndDate;

;
    public WorkerChallenge() {}
    public WorkerChallenge(String name, String birthDate) {
        this.Name = name;
        this.BirthDate = birthDate;
    }

    public int getAge() {
        int currentYear = 2025;
        int birthYear = Integer.parseInt(BirthDate.substring(6));

        return (currentYear - birthYear);
    }

    public Double collectPayment() {
       return 0.0;
    }

    public void  terminate(String endDate) {
        this.EndDate = endDate;
    }

    @Override
    public String toString() {
        return "WorkerChallenge{" +
                "Name='" + Name + '\'' +
                ", BirthDate='" + BirthDate + '\'' +
                ", EndDate='" + EndDate + '\'' +
                '}';
    }
}
