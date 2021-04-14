package teacher.exceptions;

import teacher.view.TeacherView;

public class NothingFoundException extends RuntimeException {
    public NothingFoundException() {
        super(TeacherView.NO_RESULTS);
    }
}