import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class ejemplo{
	

public static void main(String[] args) {
	try{

		InetAddress[] addresses = new InetAddress[3];
		addresses[0] = InetAddress.getLoopbackAddress();
		addresses[1] = InetAddress.getByName("iesserpis.org");
		addresses[2] = InetAddress.getByName("PC17");
		
		for(InetAddress adress: addresses){
			if(adress.isLoopbackAddress()){
			System.out.println(adress.getHostName()+" té una adreça loopback");
			
			}	else{
				System.out.println(adress.getHostName() + " no té una adreça loopback");
			}
		}
	}catch( UnknownHostException uhe){
		System.out.println("Host error");
	}
}
}
