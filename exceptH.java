class WrongAge extends Exception {
    public WrongAge(String message) {
        super(message);
    }
}


class Father {
    private int age;

    public Father(int age) throws WrongAge {
        if (age < 0) {
            throw new WrongAge("Age cannot be negative");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}


class Son extends Father {
    private int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);

        if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age should be less than Father's age");
        }

        this.sonAge = sonAge;
    }

    public int getSonAge() {
        return sonAge;
    }
}

public class ExceptH {
    public static void main(String[] args) {
        try {
            Father father = new Father(40);

            Son son = new Son(father.getAge(), 56);

            System.out.println("Father's age: " + father.getAge());
            System.out.println("Son's age: " + son.getSonAge());
        } catch (WrongAge e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}