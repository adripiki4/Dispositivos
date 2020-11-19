import java.lang.*;



class Sumador implements Runnable {

	private int[] vector;
	private int ini;
	private int fin;
	private int resultado = 0;

	public Sumador( int[] vecAux, int i, int f ) {
		vector = vecAux;
		ini = i;
		fin = f;
	}
	
	public int getResultado() {
		return resultado;
	}

	public void run() {
	   
		for (int i = ini; i < fin; i++) {

			resultado += vector[i];
		
			try {
				// thread to sleep for 1000 milliseconds
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
      
		System.out.println(Thread.currentThread().getName() + " - Resultado: " + resultado);      
	}
}

public class SumadorDeVector {
	
	private static int vector[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
	private static int resultado = 0;
	
	public static void main(String[] args) throws Exception {
      
		Sumador s1 = new Sumador(vector, 0, 3);
		Sumador s2 = new Sumador(vector, 3, 6);
		Sumador s3 = new Sumador(vector, 6, 9);
		Sumador s4 = new Sumador(vector, 9, 12);
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		Thread t4 = new Thread(s4);
      
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();

		resultado = s1.getResultado() + s2.getResultado() + s3.getResultado() + s4.getResultado();
		
		System.out.println("Suma total: "+ resultado);

   }
}
