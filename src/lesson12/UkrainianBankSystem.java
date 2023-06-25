package lesson12;

public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommissions(amount));

    }

    @Override

    public void fund(User user, int amount) {
        if (!checkFund(user, amount))
            return;
        user.setBalance(user.getBalance() + amount - amount * user.getBank().getCommissions(amount));
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (!checkTransferMoney(fromUser, toUser, amount))
            return;

        if (fromUser.getBank().getCurrency() == toUser.getBank().getCurrency())
            return;
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommissions(amount));
        toUser.setBalance(toUser.getBalance() + amount - amount * toUser.getBank().getCommissions(amount));


    }

    @Override
    public void paySalary(User user) {

        fund(user, user.getSalary());
        System.out.println("salary " + user.getId() + user.getName() + "listed " + user.getBank());
    }


    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());

    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommissions(amount) > limit) {
            printWithdrawalErrorMsq(amount, user);
            return false;
        }
        return true;
    }

    private void printWithdrawalErrorMsq(int amount, User user) {
        System.err.println("Can`t withdrawal " + amount + "from user" + user.toString());

    }

    private boolean checkFund(User user, int amount) {
        return checkFundLimits(user, amount, user.getBank().getLimitOfFunding());

    }

    private boolean checkFundLimits(User user, int amount, double limit) {
        return !(amount + user.getBank().getCommissions(amount) > limit);
    }

    private boolean checkTransferMoney(User fromUser, User toUser, int amount) {
        return checkWithdraw(fromUser, amount) && checkFund(toUser, amount);
    }


}
