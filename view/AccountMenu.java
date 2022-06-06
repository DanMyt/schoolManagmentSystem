package view;

import java.util.List;
import java.util.Scanner;

import model.School;
import model.Student;
import model.Teacher;
import service.StudentAccountService;
import service.TeacherAccountService;

public class AccountMenu {

    /**
     * Singleton pattern.
     * Ensures that only one objects of Account menu exists.
     */
    private static final AccountMenu accountMenu = new AccountMenu();
    public static AccountMenu getInstance() {
        return accountMenu;
    }
    private AccountMenu() {}
    private final Scanner scanner = new Scanner(System.in);
    private final Input input = new Input();
    private final School school = School.getInstance();
    private final StudentAccountService studentAccountService = StudentAccountService.getInstance();
    private final TeacherAccountService teacherAccountService = TeacherAccountService.getInstance();

    /**
     * Menu of the Student's account .
     * @param student - student account
     */
    public void accountMenuStudent(Student student) {
        System.out.println("*********************************\n" +
                "Enter your choice: \n" +
                "A| Show fees total\n" +
                "B| Show paid fees\n" +
                "C| Show remaining fees\n" +
                "D| Pay fees\n" +
                "E| Exit\n"
        );

        char choice;
        try {

            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'A':
                    //show total fees which student must pay in one school year
                    System.out.println(student.getFeesTotal());
                    this.accountMenuStudent(student);
                    break;
                case 'B':
                    //show fees that are already paid
                    System.out.println(student.getFeesPaid());
                    this.accountMenuStudent(student);
                    break;

                case 'C':
                    //show remaining fees
                    System.out.println(student.getRemainingFees());
                    this.accountMenuStudent(student);
                    break;

                case 'D':
                    //pay fees
                    int value = this.input.enterInt("Enter the value to pay");
                    student.payFees(value);
                    this.accountMenuStudent(student);
                    break;

                case 'E':
                    //log out
                    System.out.println("You are logged out!");
                    break;

                default:
                    this.accountMenuStudent(student);
            }

        } catch (Exception e) {
            scanner.nextLine();
            this.accountMenuStudent(student);
        }
    }

    /**
     * Menu of the teachers account.
     * @param teacher - teacher account
     */
    public void accountMenuTeacher(Teacher teacher) {
        System.out.println("*********************************\n" +
                "Enter your choice: \n" +
                "A| Show my month salary\n" +
                "B| Show my salary earned\n" +
                "C| Change password\n" +
                "D| Show information about my account\n" +
                "E| Exit\n"
        );

        char choice;
        try {

            choice = scanner.next().charAt(0);

            switch (choice) {
                case 'A':
                    //show month salary of the teacher
                    System.out.println(teacher.getSalary());
                    this.accountMenuTeacher(teacher);
                    break;
                case 'B':
                    //show salary earned for the whole working period
                    System.out.println(teacher.getSalaryEarned());
                    this.accountMenuTeacher(teacher);
                    break;

                case 'C':
                    //change password
                    String password = this.input.enterChar("Enter the new password");
                    teacher.setPassword(password);
                    this.accountMenuTeacher(teacher);
                    break;

                case 'D':
                    //show information about teacher
                    System.out.println("Your ID: " +teacher.getId());
                    System.out.println("Your name: " +teacher.getName());
                    System.out.println("Your second name: " +teacher.getSecondName());
                    System.out.println("Your password: " +teacher.getPassword());
                    System.out.println("Your month salary: " +teacher.getSalary());
                    System.out.println("Your salary earned: " +teacher.getSalaryEarned());
                    this.accountMenuTeacher(teacher);
                    break;

                case 'E':
                    //log out
                    System.out.println("You are logged out!");
                    break;

                default:
                    this.accountMenuTeacher(teacher);
            }

        } catch (Exception e) {
            scanner.nextLine();
            this.accountMenuTeacher(teacher);
        }
    }

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

        final String name = this.input.enterCharUser("name");
        final String secondName = this.input.enterCharUser("second name");

        Teacher teacherToPay = this.teacherAccountService.findTeacherByNameSecondName(name, secondName);

        if (teacherToPay != null) {

            final int payment = this.input.enterIntUser("salary");
            teacherToPay.receiveSalary(payment);
            school.updateTotalMoneySpend(payment);

            System.out.println("Teacher" +
                    name +
                    " " +
                    secondName +
                    "has received salary" +
                    " " +
                    payment +
                    "."
            );

        } else {
            System.out.println("Account with this name or second name does not exists.");
        }
    }
}
