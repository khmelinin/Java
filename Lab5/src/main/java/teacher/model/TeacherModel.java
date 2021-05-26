package teacher.model;

import teacher.controller.TeacherFile;
import teacher.view.TeacherConverter;

import java.io.IOException;

public class TeacherModel {

    private TeacherArray array;

    public TeacherModel() throws IOException, ClassNotFoundException {
        array = TeacherFile.load();
//        array = new TeacherArray(10, false);
//        try {
//            TeacherFile.save(array);
//        }
//        catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
    }

    public void generateTeachers() {

        array = new TeacherArray(10, false);

    }


    public TeacherArray getArray() {
        return array;
    }

    public void addTeacher(String s, String n, String p, String g, String[] d, String c, String ps) {
        Teacher model = new Teacher();

        model.setSurname(s);
        model.setName(n);
        model.setPatronymic(p);
        model.setGender(g);
        model.setDisciplines(d);
        model.setCathedra(c);
        model.setPost(ps);
        array.addTeacher(model);
    }

    public TeacherArray findByCathedra(String c) {
        TeacherArray tmp = new TeacherArray(0, true);
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getArray()[i].getCathedra().equals(c)) {
                tmp.addTeacher(array.getArray()[i]);
            }
        }
        return tmp;

    }

    public TeacherArray findByDiscipline(String d) {
        TeacherArray tmp = new TeacherArray(0, true);
        for (int i = 0; i < array.getSize(); i++) {
            for (int j = 0; j < array.getArray()[i].getDisciplines().length; j++) {
                if (array.getArray()[i].getDisciplines()[j].equals(d)) {
                    tmp.addTeacher(array.getArray()[i]);
                    continue;
                }
            }
        }
        return tmp;

    }

    public TeacherArray findByGenderAndPost(String g, String p) {
        TeacherArray tmp = new TeacherArray(0, true);
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getArray()[i].getGender().equals(g) && array.getArray()[i].getPost().equals(p)) {
                tmp.addTeacher(array.getArray()[i]);
            }
        }
        return tmp;

    }

    public void save() throws IOException {
        TeacherFile.save(array);
    }

    public void saveTmp() throws IOException {
        TeacherFile.saveTmp(TeacherConverter.convertTeachersToString(array));
    }
}
