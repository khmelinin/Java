package teacher.controller;

import teacher.model.TeacherArray;
import teacher.view.TeacherView;

import java.io.*;

public class TeacherFile {
    static TeacherView tv = new TeacherView();

    public static void save(TeacherArray ta) throws IOException, NullPointerException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teachers.dat"));
        oos.writeObject(ta);
        oos.close();
    }

    public static void saveTmp(String s) throws IOException {
        FileWriter writer = new FileWriter("tmp_teachers.txt", false);
        writer.write(s);
        writer.flush();
    }

    public static TeacherArray load() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teachers.dat"));
        return (TeacherArray) ois.readObject();
    }

}
