package teacher.service;

import teacher.view.TeacherView;

import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static int inputIntValueWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_INT_DATA);
        while (!sc.hasNextInt()) {
            view.printMessage(TeacherView.WRONG_INPUT_DATA + TeacherView.INPUT_INT_DATA);
            sc.next();
        }
        return sc.nextInt();
    }

    public static String inputNameWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_STRING_NAME_DATA);
        return sc.next();
    }

    public static String inputSurnameWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_STRING_SURNAME_DATA);
        return sc.next();
    }

    public static String inputPatronymicWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_STRING_PATRONYMIC_DATA);
        return sc.next();
    }

    public static String inputGenderWithScanner(TeacherView view) {
        while (true) {
            view.printMessage(TeacherView.INPUT_STRING_GENDER_DATA);
            var g = sc.nextLine();
            while (g.equals("")) g = sc.nextLine();
            try {
//                if (g.equals("Male") || g.equals("Female") || g.equals("Another")) {
//                    return g;
//                }
                if (!g.equals("Male") && !g.equals("Female") && !g.equals("Another"))
                    throw new Exception(TeacherView.WRONG_INPUT_DATA);
                return g;
            } catch (Exception ex) {
                view.printMessage(ex.getMessage());
            }
        }
    }

    public static String inputDisciplineWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_STRING_DISCIPLINE_DATA);
        return sc.next();
    }

    public static String inputDiscipline0WithScanner(TeacherView view) {
        while (true) {
            view.printMessage(TeacherView.INPUT_STRING_DISCIPLINE_DATA);
            var d = sc.nextLine();
            while (d.equals("")) d = sc.nextLine();
            try {
//                if (!d.equals(" ") && !d.equals("-")) {
//                    return d;
//                }
                if (d.equals(" ") || d.equals("-"))
                    throw new Exception(TeacherView.WRONG_INPUT_DISCIPLINE_DATA);
                return d;
                //view.printMessage(TeacherView.WRONG_INPUT_DISCIPLINE_DATA);
            } catch (Exception ex) {
                view.printMessage(ex.getMessage());
            }
        }
    }

    public static String inputCathedraWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_STRING_CATHEDRA_DATA);
        return sc.next();
    }

    public static String inputPostWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_STRING_POST_DATA);
        return sc.next();
    }


}
