package entities;

public class Account {
    private int number;

    private String holder;

    private double balance;

    public Account(int accountNo, String accountHolder) {
        this.number = accountNo;
        this.holder = accountHolder;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double depositValue) {
        this.balance += depositValue;
    }

    public void withdraw(double withdrawValue) {
        this.balance -= (withdrawValue + 5.0);
    }

    public String toString() {
        return "Account "
                + getNumber()
                + ", Holder: "
                + getHolder()
                + ", Balance: R$"
                + String.format("%.2f", getBalance());
    }


}
