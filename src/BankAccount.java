public class BankAccount {

    private int AccountNumber;
    private double AccountBalance;
    private int phonenumber;
    private String CustomerName;
    private String EmailAddress;

    public void deposit(double amount) {
    AccountBalance+=amount;


    System.out.println("Deposited " + amount + " Balance " + AccountBalance);
    }

    public void withdraw(double amount) {

        if(AccountBalance-amount<0) {
            System.out.println("Insufficient Balance");
        }else {
            AccountBalance-=amount;
            System.out.println("withdraw " + amount + " Balance " + AccountBalance);
        }

    }
    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setPhonenumber(int Phonenumber) {
        this.phonenumber = Phonenumber;
    }

    public void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }



    public int getPhonenumber() {
        return phonenumber;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public double getAccountBalance() {
        return AccountBalance;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }


}
