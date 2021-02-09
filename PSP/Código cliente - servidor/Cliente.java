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

	InetAddress serverIP;
	int serverPort;
	DatagramSocket socket;

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
	
	
	public DatagramSocketClient(String host, int port) throws SocketException, UnknownHostException {
		serverIP = InetAddress.getByName(host);
		serverPort = port;
		socket = new DatagramSocket();
	}


	public void runClient() throws IOException {

		byte [] receivedData = new byte[1024];
		byte [] sendingData;
		String mensajeRecibido;
		String[] peticiones = {"noticias", "hora", "otro", "aleatorio", "cerrar"};
		int numPeticion = 0;

		// inicialización del mensaje recibido
		mensajeRecibido = "";

		//el cliente atenderá al servidor mientras no se reciba la acción de cierre
		while(mustContinue(mensajeRecibido)){

			//el cliente crea el mensaje con la petición n-ésima
			sendingData = getRequest(peticiones[numPeticion]);

			//se crea el paquete que se va a enviar al servidor
			DatagramPacket packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);

			//envío de la respuesta
			socket.send(packet);

			//creación del paquet para recibir los datos
			packet = new DatagramPacket(receivedData, 1024);
			
			try {
			
				//espera de los datos
				System.out.println("Solicitando: "+peticiones[numPeticion]);
				socket.receive(packet);
				
				//procesamiento de los datos recibidos y obtención de la respuesta
				mensajeRecibido = getDataToRequest(packet.getData(), packet.getLength());

				// El servidor ha dicho:
				System.out.println("El servidor ha dicho: "+mensajeRecibido);
			
				// incrementamos el número de petición
				numPeticion++;
			
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
			System.out.println("Error al crear el servidor");
		}
	}
}
