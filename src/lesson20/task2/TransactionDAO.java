package lesson20.task2;


import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();


    public Transaction save(Transaction transaction) throws Exception {
        validateAmount(transaction);
        validatePerDayCount(transaction);
        validateSum(transaction);
        validateCity(transaction);

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;

                return transaction;
            }
        }
        throw new InternalServerException(" error :the transaction cannot be saved " + transaction.getId() + ".contact support.");

    }

    public Transaction[] transactionList() {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                count++;
            }
        }

        Transaction[] newOverwrite = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                newOverwrite[index] = tr;
                index++;
            }
        }

        return newOverwrite;
    }

    public Transaction[] transactionList(String city) {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                count++;
            }
        }

        Transaction[] newOverwrite = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(city)) {
                newOverwrite[index] = tr;
                index++;
            }
        }

        return newOverwrite;
    }

    public Transaction[] transactionList(int amount) {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                count++;
            }
        }

        Transaction[] newOverwrite = new Transaction[count];

        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                newOverwrite[index] = tr;
                index++;
            }
        }

        return newOverwrite;
    }


    private void validateAmount(Transaction transaction) throws LimitExceeded {

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can`t be saved");
        }

    }

    private void validateSum(Transaction transaction) throws LimitExceeded {
        int sumDay = transaction.getAmount();
        for (Transaction tr : getTransactionPerDey(transaction.getDateCreated())) {
            sumDay += tr.getAmount();
        }

        if (sumDay > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can`t be saved");
        }

    }

    private void validatePerDayCount(Transaction transaction) throws LimitExceeded {


        long count = getTransactionPerDey(transaction.getDateCreated()).length + 1;

        if (count > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can`t be saved");
        }


    }


    private boolean validateCity(Transaction transaction) throws BadRequestException {
        for (String tr : utils.getCities()) {
            if (tr != null && tr.equals(transaction.getCity())) {
                return true;
            }
        }
        throw new BadRequestException("transfer " + transaction.getId() + " to these cities is not possible");
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
