package teacher.controller;

import teacher.model.TeacherArray;
import teacher.view.TeacherView;

import java.io.*;

public class TeacherFile {
    static TeacherView tv = new TeacherView();
    static void Save(TeacherArray ta){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teachers.dat")))
        {
            oos.writeObject(ta);
            tv.printMessage(TeacherView.ANSI_GREEN + TeacherView.FILE_SAVED + TeacherView.ANSI_RESET);
        }
        catch(Exception ex){
            tv.printMessage(ex.getMessage());
        }
    }

    static void SaveTmp(String s){
        try(FileWriter writer = new FileWriter("tmp_teachers.txt", false))
        {
            writer.write(s);
            writer.flush();
        }
        catch(IOException ex){
            tv.printMessage(ex.getMessage());
        }
    }

    static TeacherArray Load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teachers.dat"))) {
            tv.printMessage(TeacherView.ANSI_GREEN + TeacherView.FILE_LOADED + TeacherView.ANSI_RESET);
            return (TeacherArray) ois.readObject();
        } catch (Exception ex) {
            tv.printMessage(ex.getMessage());
            return null;
        }
    }

}
