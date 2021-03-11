package teacher.model;

public class TeacherModel {

    TeacherArray array;

    public TeacherModel() {
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
        TeacherArray tmp = new TeacherArray(10, true);
        int count = 0;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getArray()[i].getCathedra().equals(c)) {
                tmp.getArray()[count] = array.getArray()[i];
                count++;
            }
        }
        TeacherArray tmp1 = new TeacherArray(count, true);
        System.arraycopy(tmp.getArray(), 0, tmp1.getArray(), 0, tmp1.getSize());
        return tmp1;

    }

    public TeacherArray findByDiscipline(String d) {
        TeacherArray tmp = new TeacherArray(10, true);
        int count = 0;
        for (int i = 0; i < array.getSize(); i++) {
            for (int j = 0; j < array.getArray()[i].getDisciplines().length; j++) {
                if (array.getArray()[i].getDisciplines()[j].equals(d)) {
                    tmp.getArray()[count] = array.getArray()[i];
                    count++;
                    continue;
                }
            }
        }
        TeacherArray tmp1 = new TeacherArray(count, true);
        System.arraycopy(tmp.getArray(), 0, tmp1.getArray(), 0, tmp1.getSize());
        return tmp1;

    }

    public TeacherArray findByGenderAndPost(String g, String p) {
        TeacherArray tmp = new TeacherArray(10, true);
        int count = 0;
        for (int i = 0; i < array.getSize(); i++) {
            if (array.getArray()[i].getGender().equals(g) && array.getArray()[i].getPost().equals(p)) {
                tmp.getArray()[count] = array.getArray()[i];
                count++;
            }
        }
        TeacherArray tmp1 = new TeacherArray(count, true);
        System.arraycopy(tmp.getArray(), 0, tmp1.getArray(), 0, tmp1.getSize());
        return tmp1;

    }
}
