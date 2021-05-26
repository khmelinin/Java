package teacher.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import teacher.exceptions.NothingFoundException;
import teacher.exceptions.WrongDisciplineException;
import teacher.exceptions.WrongInputException;
import teacher.model.TeacherArray;
import teacher.model.TeacherModel;
import teacher.utility.InputUtility;
import teacher.view.TeacherConverter;
import teacher.view.TeacherMesseges;
import teacher.view.TeacherView;

import java.io.IOException;


public class TeacherController {
    private TeacherModel model;
    private TeacherView view = new TeacherView();
    private Logger logger = LogManager.getLogger(TeacherController.class);

    public void startMenu() {
        logger.info("Program started");
        view.printMessage(TeacherMesseges.HELLO);
        try {
            model = new TeacherModel();
            view.printMessage(TeacherMesseges.ANSI_GREEN + TeacherMesseges.FILE_LOADED + TeacherMesseges.ANSI_RESET);
        } catch (IOException | ClassNotFoundException ex) {

            view.printMessage(TeacherMesseges.LOAD_ERROR);
            logger.fatal(TeacherMesseges.LOAD_ERROR);
            //model.generateTeachers();

            //return;
        }

        while (true) {
            view.printMessage(TeacherMesseges.MAIN_MENU_SELECT);
            switch (InputUtility.inputIntValueWithScanner(view)) {
                case 1:
                    model.generateTeachers();
                    view.printMessage(TeacherMesseges.CREATE_TEACHERS);
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
                    try {
                        TeacherFile.save(model.getArray());
                        view.printMessage(TeacherMesseges.ANSI_GREEN + TeacherMesseges.FILE_SAVED + TeacherMesseges.ANSI_RESET);
                    } catch (IOException ex) {
                        view.printMessage(TeacherMesseges.SAVE_ERROR);
                    }
                    break;
                case 8:
                    try {
                        model.save();
                    } catch (IOException ex) {
                        view.printMessage(TeacherMesseges.SAVE_ERROR);
                    }
                    System.exit(0);
                default:
                    view.printMessage(TeacherMesseges.WRONG_INPUT_DATA);
            }
        }


    }

    private void checkSaveTmp(String s) {
        try {
            String yn = InputUtility.inputSaveTmp(view);
            TeacherValidator.validateYesNo(yn);
            if (yn.toUpperCase().equals("Y") || yn.toUpperCase().equals("YES")) {
                try {
                    model.saveTmp();
                    view.printMessage(TeacherMesseges.ANSI_GREEN + TeacherMesseges.FILE_SAVED_TMP + TeacherMesseges.ANSI_RESET);
                } catch (IOException ex) {
                    view.printMessage(TeacherMesseges.SAVE_ERROR);
                    logger.error(TeacherMesseges.SAVE_ERROR);
                }
                view.printMessage(TeacherMesseges.FILE_SAVED);
            }
        } catch (WrongInputException ex) {
            view.printMessage(ex.getMessage());
            logger.warn(ex.getMessage());
        }
    }

    private void findByCathedra() {
        try {
            String c = InputUtility.inputCathedraWithScanner(view);
            var tmp = model.findByCathedra(c);
            checkResult(tmp);
        } catch (NothingFoundException ex) {
            view.printMessage(TeacherMesseges.NO_RESULTS);
        }
    }


    private void findByDiscipline() {
        try {
            String d = InputUtility.inputDisciplineWithScanner(view);
            TeacherValidator.validateDiscipline(d);
            var tmp = model.findByDiscipline(d);
            checkResult(tmp);
        } catch (WrongDisciplineException ex) {
            view.printMessage(TeacherMesseges.WRONG_INPUT_DISCIPLINE_DATA);
            logger.warn(ex.getMessage());
        }
        catch(NothingFoundException ex) {
            view.printMessage(TeacherMesseges.NO_RESULTS);
        }

    }

    private void findByGenderAndPost() {
        try {
            String g = InputUtility.inputGenderWithScanner(view);
            TeacherValidator.validateGender(g);
            String p = InputUtility.inputPostWithScanner(view);
            var tmp = model.findByGenderAndPost(g, p);
            checkResult(tmp);
        } catch (WrongInputException ex) {
            view.printMessage(TeacherMesseges.WRONG_INPUT_DATA);
            logger.warn(TeacherMesseges.WRONG_INPUT_DATA);
        }
        catch(NothingFoundException ex) {
            view.printMessage(TeacherMesseges.NO_RESULTS);
        }
    }

    private void addTeacher() {
        try {
            String g = InputUtility.inputGenderWithScanner(view);
            TeacherValidator.validateGender(g);
            String d1 = InputUtility.inputDisciplineWithScanner(view);
            TeacherValidator.validateDiscipline(d1);
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
        } catch (WrongInputException | WrongDisciplineException ex) {
            view.printMessage(TeacherMesseges.WRONG_INPUT_DATA);
            logger.warn(ex.getMessage());
        }
    }

    private void checkResult(TeacherArray tmp) {
//        if (tmp.getSize() == 0 || tmp.getArray() == null) {
//            view.printMessage(TeacherView.NO_RESULTS);
//        } else {
//            view.printTeachers(TeacherConverter.convertTeacherArrayToString(tmp));
//        }

        if (tmp.getSize() == 0 || tmp.getArray() == null) {
            throw new NothingFoundException();
        } else {
            String[][] s = TeacherConverter.convertTeacherArrayToString(tmp);
            view.printTeachers(s);
            checkSaveTmp(TeacherConverter.convertTeachersStringDoubleArrayToString(s));
        }
    }

}
