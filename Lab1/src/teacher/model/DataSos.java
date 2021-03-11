package teacher.model;

import java.util.Random;

public class DataSos {
    static String g[] = new String[]{"Male", "Female", "Another"};
    static String p[] = new String[]{"Docent", "Postgraduate", "Head of departament", "Scientific director"};
    static String d[] = new String[]{"Math", "DevOps", "English", "Ukrainian", "Networks", "-"};
    static String c[] = new String[]{"AUTS", "ASOIU", "TK"};

    public static Teacher getTeacherModel() {
        Teacher tm = new Teacher(
                randomString(7),
                randomString(7),
                randomString(7),
                randomGender(),
                randomDisciplines(),
                randomCathedra(),
                randomPost());
        return tm;
    }

    public static String randomString(int n) {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(n);
        buffer.append((char) (65 + (int) (random.nextFloat() * (90 - 65 + 1))));
        for (int i = 1; i < n; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    public static String randomGender() {
        return g[new Random().nextInt(3)];
    }

    public static String randomPost() {
        return p[new Random().nextInt(4)];
    }

    public static String randomDiscipline1() {
        return d[new Random().nextInt(5)];
    }

    public static String randomDiscipline2() {
        return d[new Random().nextInt(6)];
    }

    public static String randomCathedra() {
        return c[new Random().nextInt(3)];
    }

    public static String[] randomDisciplines() {
        String tmp[] = new String[2];
        tmp[0] = randomDiscipline1();
        for (int i = 1; i < tmp.length; i++) {
            String r = randomDiscipline2();
            if (tmp[i - 1] != r) {
                tmp[i] = r;
            } else {
                i--;
            }
        }
        return tmp;
    }

}
