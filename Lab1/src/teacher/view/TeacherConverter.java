package teacher.view;

import teacher.model.TeacherArray;

public class TeacherConverter {
    public static String[][] convertTeacherArrayToString(TeacherArray ta) {
        String[][] tmp = new String[ta.getSize()][7];
        for (int i = 0; i < ta.getSize(); i++) {
            tmp[i] = ta.getArray()[i].toStrings();
        }
        return tmp;
    }
    public static String convertTeachersStringDoubleArrayToString(String[][] res){
        String tmp = "";
        tmp+=String.format("%-16s%-16s%-16s%-16s%-24s%-16s%-16s%n", "Surname", "Name", "Patronymic", "Gender", "Disciplines", "Cathedra", "Post");
        tmp+=String.format("------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < res.length; i++) {
            tmp+=String.format("%-16s%-16s%-16s%-16s%-24s%-16s%-16s%n", res[i][0], res[i][1], res[i][2], res[i][3], res[i][4], res[i][5], res[i][6]);
        }
        return tmp;
    }

    public static String convertTeachersToString(TeacherArray ta) {
        String[][] res = convertTeacherArrayToString(ta);
        String tmp = "";
        tmp+=String.format("%-16s%-16s%-16s%-16s%-24s%-16s%-16s%n", "Surname", "Name", "Patronymic", "Gender", "Disciplines", "Cathedra", "Post");
        tmp+=String.format("------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < res.length; i++) {
            tmp+=String.format("%-16s%-16s%-16s%-16s%-24s%-16s%-16s%n", res[i][0], res[i][1], res[i][2], res[i][3], res[i][4], res[i][5], res[i][6]);
        }
        return tmp;
    }

}
