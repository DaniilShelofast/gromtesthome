package lesson20.task2;


import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws BadRequestException {
        validateAmount(transaction);
        validatePerDayCount(transaction);
        validateSum(transaction);
        validateCity(transaction);

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;
                break;
            }
        }
        return transaction;
    }

    public Transaction[] transactionList() throws BadRequestException {

        Transaction transaction = null;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                transaction = transactions[i];
                break;
            }
        }

        if (transaction == null) {
            throw new BadRequestException("error :");
        }
        validateAmount(transaction);
        validatePerDayCount(transaction);
        validateSum(transaction);
        validateCity(transaction);

        //validateParameters(transaction);

        int add = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null && transactions[i].getId() == transaction.getId() && transactions[i].getAmount() == transaction.getAmount() &&
                    transactions[i].getCity().equals(transaction.getCity()) && transactions[i].getDescription().equals(transaction.getDescription()) && transactions[i].getType() == transaction.getType()) {
                add++;
            }
        }

        int count = 0;
        Transaction[] box = new Transaction[add];
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null && transactions[i].getId() == transaction.getId() && transactions[i].getAmount() == transaction.getAmount() &&
                    transactions[i].getCity().equals(transaction.getCity()) && transactions[i].getDescription().equals(transaction.getDescription()) && transactions[i].getType() == transaction.getType()) {
                box[count] = transactions[i];
                count++;
            }
        }
        return box;
    }

    public Transaction[] transactionList(String city) throws BadRequestException {

        Transaction transaction = null;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null && city == transactions[i].getCity()) {
                transaction = transactions[i];
                break;
            }
        }

        if (transaction == null) {
            throw new BadRequestException("error :");
        }

        validateAmount(transaction);
        validatePerDayCount(transaction);
        validateSum(transaction);
        validateCity(transaction);

        //validateParameters(transaction);
        //тут я не докінця зрозумів завдання,тому забрав перевірку, перевірив в умові.
        int add = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null && transactions[i].getId() == transaction.getId() && transactions[i].getAmount() == transaction.getAmount() &&
                    transactions[i].getCity().equals(transaction.getCity()) && transactions[i].getDescription().equals(transaction.getDescription()) && transactions[i].getType() == transaction.getType()) {
                add++;

            }
        }

        int count = 0;
        Transaction[] box = new Transaction[add];
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null && transactions[i].getId() == transaction.getId() && transactions[i].getAmount() == transaction.getAmount() &&
                    transactions[i].getCity().equals(transaction.getCity()) && transactions[i].getDescription().equals(transaction.getDescription()) && transactions[i].getType() == transaction.getType()) {
                box[count] = transactions[i];
                count++;

            }
        }
        return box;
    }

    public Transaction[] transactionList(int amount) throws BadRequestException {
        Transaction transaction = null;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null && amount == transactions[i].getAmount()) {
                transaction = transactions[i];
                break;
            }
        }

        if (transaction == null) {
            throw new BadRequestException("error :");
        }

        validateAmount(transaction);
        validatePerDayCount(transaction);
        validateSum(transaction);
        validateCity(transaction);

        validateParameters(transaction);
        //тут я навпаки залишив перевірку.не знаю чи так краще.
        int add = 0;
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                add++;
            }
        }

        int count = 0;
        Transaction[] box = new Transaction[add];
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null) {
                box[count] = transactions[i];
                count++;
            }
        }
        return box;
    }

    private boolean validateAmount(Transaction transaction) throws LimitExceeded {

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can`t be saved");
        }
        return true;
    }

    private boolean validateSum(Transaction transaction) throws LimitExceeded {
        int sum = 0;
        for (Transaction tr : getTransactionPerDey(transaction.getDateCreated())) {
            if (tr != null) {
                sum += tr.getAmount();
            }
        }
        if (sum > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can`t be saved");
        }
        return true;
    }

    private boolean validatePerDayCount(Transaction transaction) throws LimitExceeded {

        int count = 0;
        for (Transaction tr : getTransactionPerDey(transaction.getDateCreated())) {
            if (tr != null) {
                count++;
            }
        }
        if (count > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can`t be saved");
        }
        return true;
    }


    private boolean validateCity(Transaction transaction) throws BadRequestException {
        for (int i = 0; i < utils.getCities().length; i++) {
            if (utils.getCities()[i] != null && utils.getCities()[i].equals(transaction.getCity())) {
                return true;
            }
        }
        throw new BadRequestException("transfer " + transaction.getId() + " to these cities is not possible");
    }


    private boolean validateParameters(Transaction transaction) throws BadRequestException {
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] != null && transactions[i].getId() == transaction.getId() && transactions[i].getAmount() == transaction.getAmount() &&
                    transactions[i].getCity().equals(transaction.getCity()) && transactions[i].getDescription().equals(transaction.getDescription()) && transactions[i].getType() == transaction.getType()) {
                return true;
            }
        }
        throw new BadRequestException("error : transmission is not possible " + transaction.getId() + " the data is incorrect.");
    }

    private Transaction[] getTransactionPerDey(Date dataOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }

            }
        }
        return result;
    }
}
