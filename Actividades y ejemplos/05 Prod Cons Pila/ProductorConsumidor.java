import java.io.*;



class Monitor {
 
	private int cuaNumeros[] = new int[6];
	private int segNum = 0;
 
	private boolean cuaPlena = false;
	private boolean cuaBuida = true;
 
	//cola LIFO
	//metodo get
	public synchronized int afagar() {
 
		// Si la cua es troba buida envia el fil a la cua d'espera
		//surt quan cuaBuida és false
		while( cuaBuida ) {
			try {
				wait();
				} catch( InterruptedException e ) {
 
					}
			}



		// Disminueix segNum perquè agafa un número i hi haurà un número menys a la cua
		segNum--;
		
		// Si no queden números
		if( segNum == 0 )
			cuaBuida = true; // La cua es troba buida
			
			
		cuaPlena = false;// La cua no està plena perquè hem consumit un número
 
		notify();
 
		// Retorna el número al fil consumidor
		return( cuaNumeros[segNum] );
 
	}
 


	//metodo put
	public synchronized void deixar( int num ) {
		
		// Si la cua està plena, no hi entren més números, enviem el fil a la cua d'espera
		
		//Si cuaPlena és false, podrà continuar produint
		while( cuaPlena ) {
			try {
				wait();
				} catch( InterruptedException e ) {
 
					}
			}
			
			
			
		// afegim el nou número a la cua al primer lloc disponible
		cuaNumeros[segNum] = num;
		// augmentem els números a la cua
		segNum++;


		// Mirem si la cua està plena
		if( segNum == 6 )
			cuaPlena = true;


		cuaBuida = false; //és false perquè acaben de produir un número
		
		notify();
		}
	} //acaba monitor





//clase productor

class Productor implements Runnable {
	
	private Monitor safata;
 

	public Productor( Monitor s ) {
		safata = s;
		}

	private int numero =0;
 
	public void run() {
 
		// Posa 10 lletres a la canonada

		for( int i=0; i < 5; i++ ) {
			numero= (int)(10*Math.random());
			safata.deixar(numero);
			System.out.println( "Produït el número "+numero );
			try {
				Thread.sleep( (int)(Math.random() * 1000 ) );
				} catch( InterruptedException e ) {;}
		
			}
		} //acaba run
		
		
		
	} //acaba productor





//clase consumidor

class Consumidor implements Runnable {
 
	private Monitor safata;
 

	public Consumidor( Monitor s ) {
		safata = s;
		}
 
 

	public void run() {
		int num;
 
		for( int i=0; i < 5; i++ ){
			
			num = safata.afagar();
			System.out.println( "Número agafat: "+num );
			
			try {
				Thread.sleep( (int)(Math.random() * 2000 ) );
				} catch( InterruptedException e ) {;}
			}
		
		} //acaba run


	}//acaba run


//clase publica


 
public class ProductorConsumidor {
 
	public static void main(String[] args) throws InterruptedException {
	
	Monitor saf = new Monitor();
 
	Productor p = new Productor(saf);
	Consumidor c = new Consumidor(saf);


	Thread productor = new Thread(p);
	Thread consumidor = new Thread(c);
 
	productor.start();
	consumidor.start();
 
 
	}
 
}

