import java.util.Scanner;

class Student {
    int USN;
    String Name;
    int credits[];
    int marks[];
    int subcou;
    Scanner s1 = new Scanner(System.in);

    void accept() {
        System.out.println("Enter the USN of the student:");
        USN = s1.nextInt();
        System.out.println("Enter the name of the student:");
        Name = s1.next();
        System.out.println("Enter the no of subjects:");
        subcou = s1.nextInt();
        credits = new int[subcou];
        marks = new int[subcou];
        for (int i = 0; i < subcou; i++) {
            System.out.println("Enter the credits of each subject:");
            credits[i] = s1.nextInt();
            System.out.println("Enter the marks of each subject:");
            marks[i] = s1.nextInt();
        }
    }

    void display() {
        System.out.println("USN:" + USN);
        System.out.println("Name:" + Name);
        for (int i = 0; i < subcou; i++) {
            System.out.println("Marks are:" + marks[i]);
        }
    }

    float gradecalc(int marks) {
        if (marks >= 90) {
            return 10;
        }
        if (marks >= 80 && marks < 90) {
            return 9;
        }
        if (marks >= 70 && marks < 80) {
            return 8;
        }
        if (marks >= 60 && marks < 70) {
            return 7;
        }
        if (marks >= 50 && marks < 60) {
            return 6;
        }
        if (marks < 50) {
            return 0;
        }
        return 0;
    }

    float calc() {
        int totalgradepoints = 0;
        int totalcredits = 0;
        float sgpa;
        for (int i = 0; i < subcou; i++) {
            totalgradepoints += gradecalc(marks[i]) * credits[i];
            totalcredits += credits[i];
        }
        return (float) totalgradepoints / totalcredits;
    }

    public static void main(String args[]) {
        Student s2 = new Student();
        s2.accept();
        s2.display();
        System.out.println("The SGPA of the student is:" + s2.calc());
    }
}