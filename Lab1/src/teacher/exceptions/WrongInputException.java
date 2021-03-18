package teacher.exceptions;

import teacher.view.TeacherView;

public class WrongInputException extends Exception {
    public WrongInputException() {
        super(TeacherView.ANSI_RED + TeacherView.WRONG_INPUT_DATA + TeacherView.ANSI_RESET);
    }
}
