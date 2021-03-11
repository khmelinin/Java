package teacher.model;

public class TeacherArray {

    private Teacher[] teacherArray;

    public TeacherArray(int s, boolean empty) {
        if(empty)
        {
            this.teacherArray = new Teacher[s];
        }
        else{
            this.teacherArray = new Teacher[s];
            for (int i = 0; i < s; i++) {
                this.teacherArray[i] = DataSos.getTeacherModel();
            }
        }
    }

    public Teacher[] getArray() {
        return teacherArray;
    }

    public void addTeacher(Teacher tm) {
        int n = teacherArray.length;
        Teacher[] newArr = new Teacher[n + 1];
        System.arraycopy(teacherArray,0,newArr,0, teacherArray.length);
        newArr[n] = tm;
        teacherArray = newArr;
    }

    public int getSize() {
        return teacherArray.length;
    }



}
