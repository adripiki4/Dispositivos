import java.io.IOException;

public class DimoniPare extends Thread {

	private static final int MIDA = 10;
	private Thread[] fils = new Thread[MIDA];

	public DimoniPare(){
		setDaemon(true);
		start();
	}

	public void run(){
	
		for(int i = 0; i<MIDA; i++){
			fils[i]= new CrearDimoni(i);
		}

		for(int i=0; i<MIDA; i++){
			System.out.println("fils[" + i + "].isDaemon() = " + fils[i].isDaemon() );
		}
		
		while(true) yield();
	}



class CrearDimoni extends Thread {
	
	public CrearDimoni(int i){

		//si un fil no ens interessa que sigui dimoni, ho hem d’indicar aquí
		//setDaemon(false); abans del mètode start()
		//en cas contrari, hereta la qualitat de dimoni del seu pare.

		System.out.println("Dimoni creat " + i );
		start();
	}

	public void run(){
		while (true) yield();
	}

}

	public static void main(String[] args) throws IOException {
		
		Thread fil = new DimoniPare();
		System.out.println("isDaemon() = " + fil.isDaemon() );
		System.out.println("Pica una tecla per finalitzar");
		System.in.read();
	}
}
