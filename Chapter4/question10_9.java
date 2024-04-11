import java.util.Arrays;

public class question10_9 
{
    public static void main(String[] args) {
        Course course = new Course("Computer Science");

        course.addStudent("홍길동");
        course.addStudent("고길동");
        course.addStudent("둘리");

        System.out.println("코스에 있는 학생 :");
        String[] students = course.getStudents();
        for (String student : students) {
            System.out.println(student);
        }

        course.dropStudent("고길동");

        System.out.println("\n학생 드롭 후 :");
        students = course.getStudents();
        for (String student : students) {
            System.out.println(student);
        }

        course.clear();

        System.out.println("\n코스 클리어 후 :");
        students = course.getStudents();
        for (String student : students) {
            System.out.println(student);
        }
    }
}



class Course {
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new String[1];
        this.numberOfStudents = 0;
    }

    private void ensureCapacity() {
        int newSize = students.length * 2;
        students = Arrays.copyOf(students, newSize);
    }

    public void addStudent(String student) {
        if (numberOfStudents == students.length) {
            ensureCapacity();
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public void dropStudent(String student) {
        int index = -1;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < numberOfStudents - 1; i++) {
                students[i] = students[i + 1];
            }
            students[numberOfStudents - 1] = null;
            numberOfStudents--;
        }
    }

    public void clear() {
        students = new String[1];
        numberOfStudents = 0;
    }

    public String[] getStudents() {
        return Arrays.copyOf(students, numberOfStudents);
    }
}
