package teacher.controller;

import teacher.exceptions.NothingFoundException;
import teacher.exceptions.WrongDisciplineException;
import teacher.exceptions.WrongInputException;
import teacher.model.TeacherArray;
import teacher.model.TeacherModel;
import teacher.service.InputUtility;
import teacher.view.TeacherConverter;
import teacher.view.TeacherView;

public class TeacherController {
    private TeacherModel model;
    private TeacherView view = new TeacherView();

    public void startMenu() {
        view.printMessage(TeacherView.HELLO);

        model = new TeacherModel(TeacherFile.Load());

        while (true) {
            view.printMessage(TeacherView.MAIN_MENU_SELECT);
            switch (InputUtility.inputIntValueWithScanner(view)) {
                case 1:
                    model = new TeacherModel();
                    view.printMessage(TeacherView.CREATE_TEACHERS);
                    break;
                case 2:
                    view.printTeachers(TeacherConverter.convertTeacherArrayToString(model.getArray()));
                    break;
                case 3: {
                    findByCathedra();
                    break;
                }
                case 4: {
                    findByDiscipline();
                    break;
                }
                case 5: {
                    findByGenderAndPost();
                    break;
                }
                case 6:
                    addTeacher();
                    break;
                case 7:
                    TeacherFile.Save(model.getArray());
                    break;
                case 8:
                    TeacherFile.Save(model.getArray());
                    System.exit(0);
                    break;
                default:
                    view.printMessage(TeacherView.WRONG_INPUT_DATA);
            }
        }


    }


    private void findByCathedra() {
        try {
            String c = InputUtility.inputCathedraWithScanner(view);
            var tmp = model.findByCathedra(c);
            CheckResult(tmp);
        } catch (NothingFoundException ex) {
            view.printMessage(ex.getMessage());
        }
    }


    private void findByDiscipline() {
        try {
            String d = InputUtility.inputDisciplineWithScanner(view);
            TeacherValidator.ValidateDiscipline(d);
            var tmp = model.findByDiscipline(d);
            CheckResult(tmp);
        } catch (WrongDisciplineException ex) {
            view.printMessage(ex.getMessage());
        } catch (NothingFoundException ex) {
            view.printMessage(ex.getMessage());
        }

    }

    private void findByGenderAndPost() {
        try {
            String g = InputUtility.inputGenderWithScanner(view);
            TeacherValidator.ValidateGender(g);
            String p = InputUtility.inputPostWithScanner(view);
            var tmp = model.findByGenderAndPost(g, p);
            CheckResult(tmp);
        } catch (WrongInputException ex) {
            view.printMessage(ex.getMessage());
        } catch (NothingFoundException ex) {
            view.printMessage(ex.getMessage());
        }

    }

    private void addTeacher() {
        try {
            String g = InputUtility.inputGenderWithScanner(view);
            TeacherValidator.ValidateGender(g);
            String d1 = InputUtility.inputDisciplineWithScanner(view);
            TeacherValidator.ValidateDiscipline(d1);
            String d2 = InputUtility.inputDisciplineWithScanner(view);
            model.addTeacher(
                    InputUtility.inputSurnameWithScanner(view),
                    InputUtility.inputNameWithScanner(view),
                    InputUtility.inputPatronymicWithScanner(view),
                    g,
                    new String[]{d1, d2},
                    InputUtility.inputCathedraWithScanner(view),
                    InputUtility.inputPostWithScanner(view)
            );
        } catch (WrongInputException ex) {
            view.printMessage(ex.getMessage());
        }
        catch (WrongDisciplineException ex) {
            view.printMessage(ex.getMessage());
        }
    }

    private void CheckResult(TeacherArray tmp) {
//        if (tmp.getSize() == 0 || tmp.getArray() == null) {
//            view.printMessage(TeacherView.NO_RESULTS);
//        } else {
//            view.printTeachers(TeacherConverter.convertTeacherArrayToString(tmp));
//        }

        if (tmp.getSize() == 0 || tmp.getArray() == null) {
            throw new NothingFoundException();
        } else {
            view.printTeachers(TeacherConverter.convertTeacherArrayToString(tmp));
        }
    }

}
