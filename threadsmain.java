import java.util.Scanner;
import java.lang.*;
class DisplayMessage extends Thread
{
	String mess;
	int delay;
	public DisplayMessage(String mess,int delay)
	{
		this.mess=mess;
		this.delay=delay;
	}
	public void run()
	{
	for(int i=0;i<3;i++){
			System.out.println(mess);
			try{
			Thread.sleep(delay*1000);
			}
			catch(InterruptedException e){
			e.printStackTrace();
			}
		}
	}
}
public class ThreadsMain{
	public static void main(String XX[])
	{
		DisplayMessage thread1=new DisplayMessage("BMS College of Engineering",10);
		DisplayMessage thread2=new DisplayMessage("CSE",2);
		thread1.start();
		thread2.start();
	}
}
		