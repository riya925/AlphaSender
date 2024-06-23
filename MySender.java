import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MySender
{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(4321);
			String msg="";
			byte b[]=new byte[20];
			DatagramPacket pack=null;
			Scanner scan=new Scanner(System.in);
			
			System.out.println("\n Enter string : ");
			msg=scan.nextLine();
			b=msg.getBytes();
			
			InetAddress ip=InetAddress.getByName("localhost");
			pack=new DatagramPacket(b,b.length,ip,1234);
			ds.send(pack);
			
			pack=new DatagramPacket(b,b.length);
			ds.receive(pack);
			b=pack.getData();
			msg=new String(b);
			System.out.println("\n COUNT = "+msg);
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println("\n Receiver error : "+e.getMessage());
		}
	}
}