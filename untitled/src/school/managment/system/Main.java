package school.managment.system;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher Lizzy = new Teacher(1, "Lizzy", 500);
        Teacher Melissa = new Teacher(2, "Melissa", 700);
        Teacher Vanderhorn = new Teacher(3, "Vanderhorn", 600);
        List<Teacher> teachersList = new ArrayList<>();
        teachersList.add(Lizzy);
        teachersList.add(Melissa);
        teachersList.add(Vanderhorn);

        Student Tamara = new Student(1, "Tamara", 4);
        Student Rakshith = new Student(2, "Rahshitch", 12);
        Student Daniela = new Student(3, "Rabbi", 5);
        List<Student> studentList = new ArrayList<>();
        studentList.add(Tamara);
        studentList.add(Rakshith);
        studentList.add(Daniela);

        School gph = new School(teachersList,studentList);
        System.out.println("Gph has earned " +gph.getTotalMoneyEarned());

        Tamara.payFees(5000);
        System.out.println("Gph has earned " +gph.getTotalMoneyEarned());
    }
}
