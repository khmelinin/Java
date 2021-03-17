package teacher.controller;

import teacher.model.TeacherModel;
import teacher.service.InputUtility;
import teacher.view.TeacherConverter;
import teacher.view.TeacherView;

public class TeacherController {
    private TeacherModel model = new TeacherModel();
    private TeacherView view = new TeacherView();

    public void startMenu() {
        view.printMessage(TeacherView.HELLO);
        while (true) {
            try {
                view.printMessage(TeacherView.MAIN_MENU_SELECT);
                switch (InputUtility.inputIntValueWithScanner(view)) {
                    case 1:
                        view.printTeachers(TeacherConverter.convertTeacherArrayToString(model.getArray()));
                        break;
                    case 2: {
                        findByCathedra();
                        break;
                    }
                    case 3: {
                        findByDiscipline();
                        break;
                    }
                    case 4: {
                        findByGenderAndPost();
                        break;
                    }
                    case 5:
                        addTeacher();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        throw new Exception(TeacherView.WRONG_INPUT_DATA);
                        //view.printMessage(TeacherView.WRONG_INPUT_DATA);
                }
            }
            catch (Exception ex)
            {
                view.printMessage(ex.getMessage());
            }

        }
    }

    private void findByCathedra() {
        String c = InputUtility.inputCathedraWithScanner(view);
        var tmp = model.findByCathedra(c);
        if (tmp.getSize() == 0 || tmp.getArray() == null) {
            view.printMessage(TeacherView.NO_RESULTS);
        } else {
            view.printTeachers(TeacherConverter.convertTeacherArrayToString(tmp));
        }
    }

    private void findByDiscipline() {
        String d = InputUtility.inputDisciplineWithScanner(view);
        var tmp = model.findByDiscipline(d);
        if (tmp.getSize() == 0 || tmp.getArray() == null) {
            view.printMessage(TeacherView.NO_RESULTS);
        } else {
            view.printTeachers(TeacherConverter.convertTeacherArrayToString(tmp));
        }
    }

    private void findByGenderAndPost() {
        String g = InputUtility.inputGenderWithScanner(view);
        String p = InputUtility.inputPostWithScanner(view);
        var tmp = model.findByGenderAndPost(g, p);
        if (tmp.getSize() == 0 || tmp.getArray() == null) {
            view.printMessage(TeacherView.NO_RESULTS);
        } else {
            view.printTeachers(TeacherConverter.convertTeacherArrayToString(tmp));
        }
    }
    private void addTeacher(){
        model.addTeacher(
                InputUtility.inputSurnameWithScanner(view),
                InputUtility.inputNameWithScanner(view),
                InputUtility.inputPatronymicWithScanner(view),
                InputUtility.inputGenderWithScanner(view),
                new String[]{InputUtility.inputDiscipline0WithScanner(view), InputUtility.inputDisciplineWithScanner(view)},
                InputUtility.inputCathedraWithScanner(view),
                InputUtility.inputPostWithScanner(view)
        );
    }

}
