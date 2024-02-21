import java.util.Scanner;
class Quad
{
   public static void main(String args[])
  {
    Scanner s1=new Scanner (System.in);
    System.out.println("enter the coefficients of the quadratic equation");
    double a = s1.nextDouble();
    double b = s1.nextDouble();
    double c = s1.nextDouble();
    double d = b*b-4*a*c;
    if(d>0)
    {
    System.out.println("Roots are real and distinct");
    System.out.println("Roots:"+"\n r1="+(-b+Math.sqrt(d))/(2*a));
    System.out.println("Roots:"+"\n r2="+(-b-Math.sqrt(d))/(2*a));
    }
    else if(d==0)
    {
    System.out.println("Roots are real and equal");
    System.out.println("Roots:"+"\n r1=r2="+(-b/2*a));
    }
    else
    {
    System.out.println("Roots are real and imaginary");
    double r1=(-b/2*a);
    double r2=Math.abs(d);
    System.out.println("Roots:"+"\n r1="+r1+'+'+r2+"i");
    System.out.println("Roots:"+"\n r1="+r1+'-'+r2+"i"); 
    }
  }
}
 
    