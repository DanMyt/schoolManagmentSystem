package view.accountMenu;

import model.School;
import model.Student;
import model.Teacher;
import service.StudentAccountService;
import service.TeacherAccountService;
import view.Input;

import java.util.List;
import java.util.Scanner;

public class SchoolAccountMenu {
    private static final SchoolAccountMenu SCHOOL_ACCOUNT_MENU = new SchoolAccountMenu();
    public static SchoolAccountMenu getInstance() {
        return SCHOOL_ACCOUNT_MENU;
    }
    private SchoolAccountMenu() {}
    private final Input input = new Input();
    private final Scanner scanner = new Scanner(System.in);
    private final School school = School.getInstance();
    private final StudentAccountService studentAccountService = StudentAccountService.getInstance();
    private final TeacherAccountService teacherAccountService = TeacherAccountService.getInstance();

    /**
     * Menu of the school account.
     */
    public void accountMenuSchool() {
        System.out.println("*********************************\n" +
                "Enter your choice: \n" +
                "A| Show total money earned\n" +
                "B| Show total money spend\n" +
                "C| Show list of students\n" +
                "D| Show list od teachers\n" +
                "E| Pay the teacher\n" +
                "F| Exit\n"
        );

        char choice;
        try {

            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'A':
                    //Show total money earned by the school (fees paid by students).
                    System.out.println(school.getTotalMoneyEarned());
                    this.accountMenuSchool();
                    break;
                case 'B':
                    //Show total money spent by school (teachers salary).
                    System.out.println(school.getTotalMoneySpend());
                    this.accountMenuSchool();
                    break;

                case 'C':
                    //Show list of students in school.
                    this.showListOfStudents();
                    this.accountMenuSchool();
                    break;

                case 'D':
                    //Show list of teachers in school.
                    this.showListOfTeachers();
                    this.accountMenuSchool();
                    break;

                case 'E':
                    this.payTeacher();
                    this.accountMenuSchool();
                    break;

                case 'F':
                    //Log out.
                    System.out.println("You are logged out!");
                    break;
                default:
                    this.accountMenuSchool();
            }

        } catch (Exception e) {
            scanner.nextLine();
            this.accountMenuSchool();
        }
    }

    private void showListOfStudents(){
        List<Student> listOfStudents = this.studentAccountService.getListOfStudents();
        if(listOfStudents.isEmpty()){
            System.out.println("No students in school");
            return;
        }
        for(Student account : listOfStudents) {
            System.out.println(account.toString());
        }
    }

    private  void showListOfTeachers() {
        List<Teacher> listOfTeachers = this.teacherAccountService.getListOfTeachers();
        if(listOfTeachers.isEmpty()){
            System.out.println("No teachers in school");
            return;
        }
        for(Teacher account : listOfTeachers) {
            System.out.println(account.toString());
        }
    }

    /**
     * Function to pay month salary to teacher.
     */
    private void payTeacher() {

        //name of the teacher to pay salary
        final String name = this.input.enterCharUser("name");
        //second name of the teacher to pay salary
        final String secondName = this.input.enterCharUser("second name");

        //finds if required account exists and returns it
        Teacher teacherToPay = this.teacherAccountService.findTeacherByNameSecondName(name, secondName);

        if (teacherToPay != null) {
            //if account exists, ask user to enter payment
            final int payment = this.input.enterIntUser("salary");
            //teacher account receive payment
            teacherToPay.receiveSalary(payment);
            //school increase total money spend and decrease total money earned
            school.updateTotalMoneySpend(payment);

            System.out.println(
                    "Teacher" +
                            " " +
                            name +
                            " " +
                            secondName +
                            " " +
                            "has received salary" +
                            " " +
                            payment +
                            "."
            );

        } else {
            //if required account does not match any account in list of teachers
            System.out.println("Account with this name or second name does not exists.");
        }
    }
}
