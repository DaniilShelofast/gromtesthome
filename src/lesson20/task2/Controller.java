package lesson20.task2;


import lesson20.task2.exception.BadRequestException;


public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws BadRequestException {

        return transactionDAO.save(transaction);
    }

    Transaction[] transactionList() throws BadRequestException {

        return transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) throws BadRequestException {

        return transactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) throws BadRequestException {

        return transactionDAO.transactionList(amount);
    }


}
