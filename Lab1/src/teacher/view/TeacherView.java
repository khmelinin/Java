package teacher.view;

public class TeacherView {

    public void printTeachers(String[][] res) {
        System.out.printf("%-16s%-16s%-16s%-16s%-24s%-16s%-16s%n", "Surname", "Name", "Patronymic", "Gender", "Disciplines", "Cathedra", "Post");
        System.out.printf("------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < res.length; i++) {
                System.out.printf("%-16s%-16s%-16s%-16s%-24s%-16s%-16s%n", res[i][0], res[i][1], res[i][2], res[i][3], res[i][4], res[i][5], res[i][6]);
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
