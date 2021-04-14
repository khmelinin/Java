package teacher.view;

public class TeacherView {
    public static final String HELLO = "Hello ༼ º͜º ༽\n";
    public static final String INPUT_INT_DATA = "Enter an integer = ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    public static final String WRONG_INPUT_DISCIPLINE_DATA = "Wrong input! Teacher must have at least one(first) discipline ";
    public static final String INPUT_STRING_NAME_DATA = "Enter teacher's name = ";
    public static final String INPUT_STRING_SURNAME_DATA = "Enter teacher's surnname = ";
    public static final String INPUT_STRING_PATRONYMIC_DATA = "Enter teacher's patronymic = ";
    public static final String INPUT_STRING_GENDER_DATA = "Enter teacher's gender (Male, Female, Another) = ";
    public static final String INPUT_STRING_CATHEDRA_DATA = "Enter teacher's cathedra = ";
    public static final String INPUT_STRING_POST_DATA = "Enter teacher's post = ";
    public static final String INPUT_STRING_DISCIPLINE_DATA = "Enter teacher's discipline = ";
    public static final String FILE_LOADED = "Teacher file loaded";
    public static final String FILE_SAVED = "Teacher file saved";
    public static final String NO_RESULTS = "Nothing was found";
    public static final String CREATE_TEACHERS = "Teachers was created";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String MAIN_MENU_SELECT =
            "\n1. Create and generate teachers\n" +
                    "2. List of teachers\n" +
                    "3. Find teachers by cathedra\n" +
                    "4. Find teachers by discipline\n" +
                    "5. Find teacher by gender and post\n" +
                    "6. Add teacher\n" +
                    "7. Save current teachers\n" +
                    "8. Exit\n";

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
