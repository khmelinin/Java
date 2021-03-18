package teacher.exceptions;

import teacher.view.TeacherView;

public class WrongDisciplineException extends Exception {
    public WrongDisciplineException() {
        super(TeacherView.ANSI_YELLOW + TeacherView.WRONG_INPUT_DISCIPLINE_DATA + TeacherView.ANSI_RESET);
    }
}
