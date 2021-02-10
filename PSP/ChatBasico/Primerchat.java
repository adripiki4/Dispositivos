import java.util.*;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.*;
import java.lang.Object;

public class Primerchat{
	
	public static void main(String[] args) {
		//bytes del missatge a enviar
		byte[] missatge = "Saludos".getBytes();
		
		try{
		
		//adreça IP del destí
		InetAddress adrecaDesti = InetAddress.getByName("localhost");
		//port destí
		int portDesti = 5555;
		//creació del paquet a enviar
		DatagramPacket packet = new DatagramPacket(missatge, missatge.length, adrecaDesti, portDesti);
		//creació d’un socket temporal amb el qual realitzar l’enviament
		DatagramSocket socket = new DatagramSocket();
		//Enviament del missatge
		socket.send(packet);
		} catch (IOException ex) {
				System.out.println(ex);
		//} catch (java.net.UnknownHostException e){
			//System.out.println(e);
		//} catch (java.net.SocketException e){
			//System.out.println("Error con el socket ");
		//}

	}
}
}
