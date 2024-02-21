import java.util.Scanner;

abstract class Shape {
    int len;
    int bre;
    abstract void printArea();
}

class Rectangle extends Shape {
    Rectangle(int l, int br) {
        len = l;
        bre = br;
    }
    void printArea() {
        int area = len * bre;
        System.out.println("The area of rectangle is: " + area);
    }
}

class Triangle extends Shape {
    Triangle(int b, int h) {
        len = b;
        bre = h;
    }
    void printArea() {
        double area = 0.5 * len * bre;
        System.out.println("The area of triangle is: " + area);
    }
}

class Circle extends Shape {
    Circle(int r) {
        len = r;
    }
    void printArea() {
        double area = 3.14 * len * len;
        System.out.println("The area of circle is: " + area);
    }
}

class Areas {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Rectangle r = new Rectangle(s.nextInt(), s.nextInt());
        r.printArea();
        Triangle t = new Triangle(s.nextInt(), s.nextInt());
        t.printArea();
        Circle c = new Circle(s.nextInt());
        c.printArea();
    }
}

