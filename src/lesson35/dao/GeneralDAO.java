package lesson35.dao;

import lesson35.exception.BadRequestException;
import lesson35.model.ModelObject;

import java.io.*;
import java.util.LinkedList;

public abstract class GeneralDAO<T extends ModelObject> {

    public abstract String getPath();

    public LinkedList<T> readAll() throws Exception {

        return new LinkedList<>();
    }

    protected LinkedList<String> readFile() {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getPath()))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error: the file could not be read, the specified data is incorrect.");
        }
        return lines;
    }

    public void addObjectToFile(T t) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(), true))) {
            File file = new File(getPath());
            String write = t.toFileString();
            if (file.length() == 0) {
                writer.write(write);
            } else {
                writer.newLine();
                writer.write(write);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteObjectFromFile(long id) throws Exception {
        LinkedList<T> objects = readAll();
        objects.removeIf(objectsId -> objectsId.getId() == id);
        try (BufferedWriter ignore = new BufferedWriter(new FileWriter(getPath(), false))) {
            for (T o : objects) {
                addObjectToFile(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public T findObject(long id) throws Exception {
        for (T t : readAll()) {
            if (t != null && t.getId() == id) {
                return t;
            }
        }
        throw new BadRequestException("Error : the data is incorrect, the " + id + " with this ID does not exist");
    }

    public void verify(long id) throws Exception {
        for (T t : readAll()) {
            if (t != null && t.getId() == id) {
                throw new BadRequestException("Error : " + id + " with such an ID already exists");
            }
        }
    }
}
