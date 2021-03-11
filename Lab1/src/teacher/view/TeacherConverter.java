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
}
