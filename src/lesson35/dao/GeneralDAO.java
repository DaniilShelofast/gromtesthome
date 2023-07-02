package lesson35.dao;

import lesson35.exception.BadRequestException;
import lesson35.model.ParametersFile;

import java.io.*;
import java.util.LinkedList;

public abstract class GeneralDAO<T extends ParametersFile> {
    private String path;

    public void txtPath(String path) {
        this.path = path;
    }

    public abstract LinkedList<T> map(LinkedList<String> strings) throws Exception;

    protected LinkedList<String> readAll() {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void addObjectToFile(T t) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            File file = new File(path);
            if (file.length() == 0) {
                writer.write(t.toFileString());
            } else {
                writer.newLine();
                writer.write(t.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteObjectFromFile(long id) throws Exception {
        LinkedList<T> objects = map(readAll());
        objects.removeIf(objectId -> objectId.id() == id);
        try (BufferedWriter ignore = new BufferedWriter(new FileWriter(path, false))) {
            for (T o : objects) {
                addObjectToFile(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T findIdObject(long id) throws Exception {
        for (T t : map(readAll())) {
            if (t != null && t.id() == id) {
                return t;
            }
        }
        throw new BadRequestException("Error : the data is incorrect, the " + id + " with this ID does not exist");
    }

    public boolean verify(long id) throws Exception {
        for (T t : map(readAll())) {
            if (t != null && t.id() == id) {
                throw new BadRequestException("Error : " + id + " with such an ID already exists");
            }
        }
        return true;
    }

}
