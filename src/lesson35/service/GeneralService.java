package lesson35.service;

import lesson35.dao.WriteToFile;
import lesson35.exception.BadRequestException;

import java.util.LinkedList;

public class GeneralService<T> {
    private LinkedList<T> readFile;

    public void setReadFile(LinkedList<T> readFile) {
        this.readFile = readFile;
    }

    public T findIdObject(long id) throws Exception {
        for (T t : readFile) {
            if (t != null && ((WriteToFile) t).id() == id) {
                return t;
            }
        }
        throw new BadRequestException("Error : the data is incorrect, the " + id + " with this ID does not exist");
    }

    protected boolean verificationObjectID(long id) throws Exception {
        for (T t : readFile) {
            if (t != null && ((WriteToFile) t).id() == id) {
                throw new BadRequestException("Error : " + id + " with such an ID already exists");
            }
        }
        return true;
    }
}
