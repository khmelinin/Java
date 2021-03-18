package teacher.service;

import teacher.view.TeacherView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtility {
    private static Scanner sc = new Scanner(System.in);

    public static int inputIntValueWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_INT_DATA);
        while (true) {
            try {
//                if (!sc.hasNextInt())
//                    throw new WrongInputException();
                return sc.nextInt();
            } catch (InputMismatchException ex) {
                view.printMessage(view.WRONG_INPUT_DATA);
                sc.next();
            }
        }
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
        view.printMessage(TeacherView.INPUT_STRING_GENDER_DATA);
        return sc.next();

    }

    public static String inputDisciplineWithScanner(TeacherView view) {
        view.printMessage(TeacherView.INPUT_STRING_DISCIPLINE_DATA);
        return sc.next();
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
