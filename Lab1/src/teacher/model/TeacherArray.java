package teacher.model;

import java.util.Arrays;

public class TeacherArray {
    private int size = 0;
    private int maxsize = 30;
    private Teacher[] teacherArray = new Teacher[maxsize];

    public TeacherArray(int s, boolean empty) {
        this.size = s;
        if (!empty) {
            fillArray(this.size);
        }
    }

    public int getSize() {
        return size;
    }

    public Teacher[] getArray() {
        return Arrays.copyOf(teacherArray, this.size);
    }

    public void addTeacher(Teacher tm) {
//        int n = teacherArray.length;
//        Teacher[] newArr = new Teacher[n + 1];
//        System.arraycopy(teacherArray, 0, newArr, 0, teacherArray.length);
//        newArr[n] = tm;
//        teacherArray = newArr;

        if (this.size >= maxsize) {
            maxsize += 30;
            Teacher[] tmp = new Teacher[maxsize];
            System.arraycopy(teacherArray, 0, tmp, 0, size);
            teacherArray = tmp;
        }
        teacherArray[size] = tm;
        this.size++;
    }

    private void fillArray(int s) {
        for (int i = 0; i < s; i++) {
            this.teacherArray[i] = DataSos.getTeacherModel();
        }
    }
}
