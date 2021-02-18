import java.util.*;
import java.io.*;
import java.net.InetAddress;
import java.net.SocketException;
import java.lang.Object;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.UnknownHostException;
import java.net.SocketTimeoutException;

class DatagramSocketClient {
	
	DatagramSocket socket;
	InetAddress serverIP;
	int serverPort;
	
	//Constructor
	public DatagramSocketClient(String host, int port) throws SocketException, UnknownHostException {
		serverIP = InetAddress.getByName(host);
		serverPort = port;
		socket = new DatagramSocket();
	}
	

	private String getDataToRequest(byte[] data, int length) {
		String mensajeTraducido = new String(data, 0, length);
		return mensajeTraducido;
	}

	private byte[] getRequest(String peticion) {
		byte[] mensaje = peticion.getBytes();
		return mensaje;
	}

	private boolean mustContinue(String mensajeRecibido) {
		return (mensajeRecibido.equals("Adios")) ? false : true;
	}
	
	private byte[] timeoutExceeded(DatagramPacket packet) {
		byte[] mensaje = "El tiempo expiró".getBytes();
		return mensaje;
	}
	

	public void runClient() throws IOException {

		byte [] receivedData = new byte[1024];
		byte [] sendingData;
		String mensajeRecibido;
		int numPeticion = 0;
		Scanner sc = new Scanner(System.in);
		// inicialización del mensaje recibido
		mensajeRecibido = "";
		String role = "";
		String role2 ="";
		String nombrechat = "";
		
		//el cliente atenderá al servidor mientras no se reciba la acción de cierre
		while(mustContinue(mensajeRecibido)){
			String peticion;
			DatagramPacket packet;
			if (numPeticion == 0) {
				//Introducción datos principales
				System.out.println("Introduzca el nombre del chat:");
				nombrechat = sc.nextLine();	
				
				System.out.println("Introduzca su nombre:");
				role = sc.nextLine();
			
				
				
				//Inicio del chat
				System.out.println("-----"+nombrechat+"-----");
				
				//Mensaje de peticion
				sendingData = getRequest(role + "/" + nombrechat);
				
				//Creacion del packet para enviar al servidor
				 packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);

				//Envío de la respuesta
				socket.send(packet);

			} else {

				//Enviar mensaje de role
				System.out.print("["+role+"]:");
				peticion = sc.nextLine();
				
				//el cliente crea el mensaje con la petición
				sendingData = getRequest(peticion);
				
				//se crea el paquete que se va a enviar al servidor
				packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);
			
				//envío de la respuesta
				socket.send(packet);
			}
			
			//creación del paquet para recibir los datos
			packet = new DatagramPacket(receivedData, 1024);
			
			try {
			
				//espera de los datos
				socket.receive(packet);
				
				//procesamiento de los datos recibidos y obtención de la respuesta
				mensajeRecibido = getDataToRequest(packet.getData(), packet.getLength());

				if (numPeticion == 0){
					role2 = mensajeRecibido;
					numPeticion++;
				}
					
				// El servidor ha dicho:
				System.out.println("["+role2+"]:"+mensajeRecibido);
				
				
			
			
			} catch(SocketTimeoutException e){
				sendingData = timeoutExceeded(packet);
			}
		}
	
		//si hemos salido del bucle es porque tenemos que cerrar el cliente y por lo tanto el socket	
		close();

	}
	
	public void close(){

		if(socket!=null && !socket.isClosed()){
			socket.close();
		}
	}

}

public class Cliente {
	
	public static void main(String[] args){
			
		try {
			
			//DatagramSocketClient cliente = new DatagramSocketClient("192.168.0.159", 5555);
			DatagramSocketClient cliente = new DatagramSocketClient("localhost", 5555);
			cliente.runClient();
			
		} catch (IOException e) {
			System.out.println("Error al crear el cliente");
		}
	}
}
