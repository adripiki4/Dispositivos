import java.util.*;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.*;
import java.lang.Object;

public class Segundochat {
	public static void main(String[] args) {
		try{
					//port a escoltar el servei que estem implementant
				int portAEscoltar = 5555;
				//vector de bytes en el cual recibir el mensaje con capacidad de 1.024 bytes
				byte[] missatge = new byte[1024];
				//creació del paquet en el qual rebre les dades de 1.024 bytes com a màxim
				DatagramPacket packet = new DatagramPacket(missatge, missatge.length);
				//creació d’un socket que escolti el port passat per paràmetre
				DatagramSocket socket = new DatagramSocket(portAEscoltar);
				//recepció d’un paquet
				socket.receive(packet);
				String mensaje = new String(packet.getData(),0,packet.getLength());
				System.out.printf("Mensaje recibido:%s " + mensaje);
				
				}catch (IOException ex) {
						System.out.println(ex);
				//}catch (java.net.UnknownHostException e){
					//System.out.println(e);
				//} catch (java.net.SocketException e){
					//System.out.println("Error con el socket ");
				//}
			}
}
}
