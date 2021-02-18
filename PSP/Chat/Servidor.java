import java.util.*;
import java.io.*;
import java.net.InetAddress;
import java.net.SocketException;
import java.lang.Object;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

class DatagramSocketServer {
	String role = "";
	String role2 = "";
	String nombrechat = "";
	int aux = 0;
	DatagramSocket socket;
	
	//Constructor
	public DatagramSocketServer(int puerto) throws SocketException {
		socket = new DatagramSocket(puerto);
	}

	// Procesamamos la peticiones por parte del cliente
	private byte[] processData(String peticion) {
		String respuesta = "";
		Scanner sc = new Scanner(System.in);
		
		
		//Comprobamos la peticion cerrar
		if(peticion.equals("cerrarchat")){
			respuesta = "Hasta Pronto!";
		} else if(aux == 0){
			String[] partes = peticion.split("/");
			role2 = partes[0];
			nombrechat = partes[1];
			
			//Inicio del chat
			System.out.println("-----"+nombrechat+"-----");
			System.out.println("Introduzca su nombre de º:");
			role = sc.nextLine();
			respuesta = role;
			aux++;
		} else {
			System.out.println("["+role2+"]:" + peticion);
			System.out.print("["+role+"]:");
			respuesta = sc.nextLine();
		}
		return respuesta.getBytes();
	}
	
	// Convertimos el paquete recibido a String para mostrarlo en el chat
	private String traducirData(byte[] data, int length) {
		String mostrar = new String(data, 0, length);
		return mostrar;
	}
	
	// Condicion de cerrar el servidor
	private boolean mustContinue(String mensajeRecibido) {
		return (mensajeRecibido.equals("cerrarchat")) ? false : true;
	}
	

	
	public void runServer() throws IOException{

		byte [] receivingData = new byte[1024];
		byte [] sendingData;
		InetAddress clientIP;
		int clientPort;
		String peticionTraducida = "";
	
		//el servidor atiende el puerto indefinidamente
		while(mustContinue(peticionTraducida)) {

			//creación del paquete para recibir los datos
			DatagramPacket packet = new DatagramPacket(receivingData, 1024);
			socket.receive(packet);

			

				//procesamiento de los datos recibidos
				peticionTraducida = traducirData(packet.getData(), packet.getLength());
				sendingData = processData(peticionTraducida);

				//obtención de la dirección del cliente
				clientIP = packet.getAddress();
	
				//obtención del puesto del cliente
				clientPort = packet.getPort();
	
				//creación del paquete para enviar la respuesta
				packet = new DatagramPacket(sendingData, sendingData.length, clientIP, clientPort);
		
				//envío de la respuesta
				socket.send(packet);
			
		
		}
		
		//si hemos salido del bucle es porque tenemos que cerrar el servidor y por lo tanto el socket
		close();

	}
	
	public void close(){

		if(socket!=null && !socket.isClosed()){
			socket.close();
		}
	}

}

public class Servidor {
	
	public static void main(String[] args){
			
		try {
			
			DatagramSocketServer servidor = new DatagramSocketServer(5555);
			servidor.runServer();

		} catch (IOException e) {
			System.out.println("Error al crear el servidor");
		}
	}
}
