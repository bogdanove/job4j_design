package ru.job4j.oodtheory.lsp;

public class Deposit {

    private double account;

    public Deposit(double account) {
        this.account = account;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public void addMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Invalid count money!");
        }
        account += money;
    }
}
