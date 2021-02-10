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
	
	DatagramSocket socket;

	// Procesamiento del servicio socilitado por el cliente
	private byte[] processData(String peticion) {
		
		String respuesta = "";
		
		switch (peticion) {
			
			case "noticias": respuesta = "¡Por fin la vacuna ya está en España!"; break;
			case "hora": respuesta = getFecha(); break;
			case "aleatorio": respuesta =  Double. toString(Math.random()*10); break;
			case "cerrar": respuesta = "Adios"; break;
			case "cerrarServidor": respuesta = "Adios"; break;			
			default: respuesta = "petición desconocida";
		}
		
		return respuesta.getBytes();
	}
	
	// Método que traducirá el paquete recibido en un String
	private String traducirData(byte[] data, int length) {
		String mensajeTraducido = new String(data, 0, length);
		return mensajeTraducido;
	}
	
	// La condición de salida del servidior
	private boolean mustContinue(String mensajeRecibido) {
		return (mensajeRecibido.equals("cerrarServidor")) ? false : true;
	}
	
	//devuelve la fecha y hora de este mismo instante
	private String getFecha() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
    
		return formattedDate;
    }
	
	public DatagramSocketServer(int port) throws SocketException {
		socket = new DatagramSocket(port);
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

			//a la espera de los datos
			System.out.println("Servidor a la espera... ");
			socket.receive(packet);
	
			try {
				// espera de 10 segundos
				Thread.sleep (3000);

			} catch (Exception e) {
				
			}
			
			//procesamiento de los datos recibidos
			peticionTraducida = traducirData(packet.getData(), packet.getLength());
			sendingData = processData(peticionTraducida);

	
			// El cliente ha dicho:
			System.out.println("El cliente ha solicitado: "+peticionTraducida);

	
	
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
