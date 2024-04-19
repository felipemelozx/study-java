package application;

import entities.Student;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student student = new Student();

        System.out.print("Enter the student's name: ");
        student.name = scan.next();

        System.out.println("Enter the student's three grades:");
        student.notaFirst = scan.nextDouble();
        student.notaSecond = scan.nextDouble();
        student.notaThird = scan.nextDouble();

        student.averageNote();

        if(student.approve){
            System.out.println("FINAL GRADE = " + student.grade);
            System.out.println("PASS");
        } else {
            System.out.println("FINAL GRADE = " + student.grade);
            System.out.println("FAILED");
            System.out.printf("MISSING %.0f POINTS", student.missing);
        }

        scan.close();
    }

}
