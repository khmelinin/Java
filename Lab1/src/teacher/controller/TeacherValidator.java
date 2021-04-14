package teacher.controller;

import teacher.exceptions.WrongDisciplineException;
import teacher.exceptions.WrongInputException;

public class TeacherValidator {
    static void ValidateDiscipline(String d) {
        if (d.equals(" ") || d.equals("-"))
            throw new WrongDisciplineException();
    }
    static void ValidateYesNo(String yn) {
        if (!yn.equals("y") && !yn.equals("Y") && !yn.equals("Yes") && !yn.equals("yes") && !yn.equals("n") && !yn.equals("N") && !yn.equals("no") && !yn.equals("No"))
            throw new WrongInputException();
    }
    static void ValidateGender(String g) {
        if (!g.equals("Male") && !g.equals("Female") && !g.equals("Another"))
            throw new WrongInputException();
    }
}
