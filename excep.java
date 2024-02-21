import java.util.Scanner;
class SalaryExc extends Exception{
    public SalaryExc(String err){
        System.out.println(err);
    }
}
class Employee{
    int empid;
    void accept1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Employee Id:");
        empid = sc.nextInt();
    }
}
class Manager extends Employee{
    int salary;
    void accept2(){
        super.accept1();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Salary of Manager:");
        salary = sc.nextInt();
        System.out.println("Details of Manager: \nEmpid: " + empid + "\n Manager salary:" + salary);
    }
}
class Worker extends Employee{
    int salary;
    void accept3(int min) throws SalaryExc{
        super.accept1();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Salary of Worker:");
        salary = sc.nextInt();
        if(min < this.salary){
            throw new SalaryExc("Worker's Salary cannot be greater than Manager's salary!");
        }
        System.out.println("Details of Worker: \nEmpid:" + empid + "\n Worker salary:" + salary);
    }
}
class Excep{
    public static void main(String args[]){
        int min = 1000000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees:");
        int n = sc.nextInt();
        Manager a[] = new Manager[n];
        Worker b[] = new Worker[n];
        for(int i = 0; i < n; i++){
            a[i] = new Manager();
            a[i].accept2();
            if(a[i].salary < min){
                min = a[i].salary;
            }
            b[i] = new Worker();
            try{
                b[i].accept3(min);
            }
            catch(SalaryExc e){
                System.out.println("Salary exception has been handled");
            }
            catch(Exception ee){
                System.out.println("Unexpected error: " + ee);
            }
        }
    }
}