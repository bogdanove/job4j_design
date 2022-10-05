package ru.job4j.ood.lsp;

public class BigBankDeposit extends Deposit {

    /*
     *
     * Дочерние классы не должны создавать больше предусловий, чем это определено в базовом классе
     *
     * */

    public BigBankDeposit(double account) {
        super(account);
    }

    public void addMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Invalid count money!");
        }
        if (money < 100) {
            throw new IllegalArgumentException("Invalid count money!");
        }
        super.addMoney(money);
    }
}
