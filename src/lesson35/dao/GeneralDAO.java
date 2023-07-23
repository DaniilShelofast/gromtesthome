package lesson35.dao;

import lesson35.exception.BadRequestException;
import lesson35.exception.DataWritingException;
import lesson35.exception.ObjectFileReadException;
import lesson35.model.ModelObject;

import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

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

    private LinkedList<String> readFile() throws ObjectFileReadException {
        String line;
        LinkedList<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getPath()))) {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new ObjectFileReadException("Error: data cannot be entered.", e);
        }
        return lines;
    }

    public void addObjectToFile(T t) throws DataWritingException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(), true))) {
            File file = new File(getPath());
            if (file.length() != 0) {
                writer.newLine();
            }
            t.setId(generatedID());
            writer.append(t.toFileString());
        } catch (Exception e) {
            throw new DataWritingException("Error: data cannot be entered.", e);
        }
    }

    public void deleteObjectFromFile(long id) throws Exception {
        LinkedList<T> objects = readAll();
        objects.removeIf(objectsId -> objectsId.getId() == id);
        fileClear();

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

    private void fileClear() throws IOException {
        FileWriter file = new FileWriter(getPath(), false);
        file.close();
    }

    public long generatedID() throws Exception {
        long id = ThreadLocalRandom.current().nextLong(1L, Long.MAX_VALUE);
        if (verify(id)) {
            return generatedID();
        }
        return id;
    }

    private boolean verify(long id) throws Exception {
        for (T t : readAll()) {
            if (t != null && t.getId() == id) {
                return true;
            }
        }
        return false;
    }
}


