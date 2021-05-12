package teacher.controller;

import teacher.model.TeacherArray;

import java.io.*;

public class TeacherFile {

    public static void save(TeacherArray ta) throws IOException, NullPointerException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teachers.dat"))) {
            oos.writeObject(ta);
        }
    }

    public static void saveTmp(String s) throws IOException {
        try (FileWriter writer = new FileWriter("tmp_teachers.txt", false)) {
            writer.write(s);
            writer.flush();
        }
    }

    public static TeacherArray load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teachers.dat"))) {
            return (TeacherArray) ois.readObject();
        }
    }

}
