package teacher.model;

import java.util.Arrays;

public class Teacher {

    private String surname;
    private String name;
    private String patronymic;
    private String gender;
    private String[] disciplines;
    private String cathedra;
    private String post;

    public Teacher() {

    }

    public Teacher(String surname, String name, String patronymic, String gender, String[] disciplines, String cathedra, String post) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.disciplines = disciplines;
        this.cathedra = cathedra;
        this.post = post;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getGender() {
        return gender;
    }

    public String[] getDisciplines() {
        return disciplines;
    }

    public String getCathedra() {
        return cathedra;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String[] toStrings() {
        return new String[]{surname, name, patronymic, gender, String.join(", ", disciplines), cathedra, post};
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    public String toStringFull() {
        return "TeacherModel{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender='" + gender + '\'' +
                ", disciplines=" + Arrays.toString(disciplines) +
                ", cathedra='" + cathedra + '\'' +
                ", post='" + post + '\'' +
                '}';
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDisciplines(String[] disciplines) {
        this.disciplines = disciplines;
    }

    public void setCathedra(String cathedra) {
        this.cathedra = cathedra;
    }
}
