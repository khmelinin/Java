package teacher.controller;

import teacher.exceptions.WrongDisciplineException;
import teacher.exceptions.WrongInputException;

public class TeacherValidator {
    static void ValidateDiscipline(String d) {
        if (d.equals(" ") || d.equals("-"))
            throw new WrongDisciplineException();
    }
    static void ValidateGender(String g) {
        if (!g.equals("Male") && !g.equals("Female") && !g.equals("Another"))
            throw new WrongInputException();
    }
}
