package lesson35.dao;

import lesson35.exception.BadRequestException;
import lesson35.model.ModelObject;

import java.io.*;
import java.util.LinkedList;

public abstract class GeneralDAO<T extends ModelObject> {

    public abstract String getPath();

    public abstract T convert(String string) throws Exception;

    public LinkedList<T> readAll() throws Exception {
        LinkedList<T> list = new LinkedList<>();
        for (String s : readFile()) {
            list.add(convert(s));
        }
        return list;
    }

    private LinkedList<String> readFile() {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getPath()))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException ignored) {
        }
        return lines;
    }

    public void addObjectToFile(T t) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(), true))) {
            File file = new File(getPath());
            if (file.length() != 0) {
                writer.newLine();
            }
            writer.append(t.toFileString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteObjectFromFile(long id) throws Exception {
        LinkedList<T> objects = readAll();
        objects.removeIf(objectsId -> objectsId.getId() == id);
        FileWriter file = new FileWriter(getPath(), false);
        file.close();
        for (T o : objects) {
            addObjectToFile(o);
        }
    }

    public T findObject(long id) throws Exception {
        for (T t : readAll()) {
            if (t != null && t.getId() == id) {
                return t;
            }
        }
        throw new BadRequestException("Error :" + id + " ID does not exist");
    }

    public void verify(long id) throws Exception {
        for (T t : readAll()) {
            if (t != null && t.getId() == id) {
                throw new BadRequestException("Error:" + id + " ID already exists");
            }
        }
    }

}
