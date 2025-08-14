package exceptions;

public class Account {
    private  double balance;

    public void deposit(double amount){
        balance +=amount;
    }
    public void withdraw(double amount) throws InsuficientFundsException {
        if (amount > balance)
            throw  new InsuficientFundsException();
        balance -= amount;
    }
}
