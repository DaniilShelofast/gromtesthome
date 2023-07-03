package lesson35.dao;

import lesson35.exception.BadRequestException;
import lesson35.model.ParametersFile;

import java.io.*;
import java.util.LinkedList;

public abstract class GeneralDAO<T extends ParametersFile> {

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
            e.printStackTrace();
        }
        return lines;
    }

    public void addObjectToFile(T t) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(), true))) {
            File file = new File(getPath());
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
        LinkedList<T> objects = readAll();
        objects.removeIf(objectId -> {
            try {
                return (long) objectId.getClass().getMethod("getId").invoke(objectId) == id;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        try (BufferedWriter ignore = new BufferedWriter(new FileWriter(getPath(), false))) {
            for (T o : objects) {
                addObjectToFile(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public T findIdObject(long id) throws Exception {
        for (T t : readAll()) {
            if (t != null && (long) t.getClass().getMethod("getId").invoke(t) == id) {
                return t;
            }
        }
        throw new BadRequestException("Error : the data is incorrect, the " + id + " with this ID does not exist");
    }

    public boolean verify(long id) throws Exception {
        for (T t : readAll()) {
            if (t != null && (long) t.getClass().getMethod("getId").invoke(t) == id) {
                throw new BadRequestException("Error : " + id + " with such an ID already exists");
            }
        }
        return true;
    }
}
