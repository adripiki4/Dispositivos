import java.io.*;

 
class SeientsAvio {
	
	//comencem amb 5 seients lliures a l’avió
	private int seientsLliures = 11;
 
	public int getSeientsLliures(){
		return seientsLliures;
		}
 
		
	public boolean getSeientsLliures(int numPlaces){
		if (numPlaces<=seientsLliures)
			
			return true;
			
			else
				
				return false;
		}
 
	public void reservaSeients(int numSeientsReserva){
		seientsLliures = seientsLliures - numSeientsReserva;
		}
 
} 
//FIN CLASE AsientosAvion



 
//Implementem runnable per poder crear fils sobre les seves instàncies
public class AgenciaViatges implements Runnable {
 
	private SeientsAvio sa = new SeientsAvio();
 
 
 
 
	public void run(){
		System.out.println(Thread.currentThread().getName()+" vol fer una reserva");
		gestioSeientsAvio(3);
		if(sa.getSeientsLliures()<=0)
			System.out.println("No hi ha seients lliures");
			}
 
	public synchronized void gestioSeientsAvio(int numSeientsReserva){
 
		//Comprovem si hi ha seients suficients
		if(sa.getSeientsLliures()>=numSeientsReserva) {
			
			
			System.out.println(Thread.currentThread().getName()+" farà una reserva de "+ numSeientsReserva +" places");
			try {
				Thread.sleep(1000); //adormim el fil 1 segon
				}
				catch (InterruptedException ex) {	
					ex.printStackTrace();
					}
			//Fem la reserva dels seients
			sa.reservaSeients(numSeientsReserva);
 
			System.out.println(Thread.currentThread().getName() + " Reserva realitzada amb èxit."+" Les places lliures són "+sa.getSeientsLliures());
			
		} else {
				
				System.out.println("No hi ha places suficients pel client." + Thread.currentThread().getName()+" Les places lliures són "+sa.getSeientsLliures());
				try {
					Thread.sleep(1000);
					}
					catch (InterruptedException ex) {
						ex.printStackTrace();
						}
		}// fin gestioSeientsAvio(3)
 
 
}
 
 //MAIN
	public static void main(String[] args) {
 
AgenciaViatges objAg = new AgenciaViatges();
 
//creem els dos fils sobre la mateixa instància
Thread Fil_1 = new Thread(objAg);
Thread Fil_2 = new Thread(objAg);
Thread Fil_3 = new Thread(objAg);
Thread Fil_4 = new Thread(objAg);

Fil_1.setName("Client 1");
Fil_2.setName("Client 2");
Fil_3.setName("Client 3");
Fil_4.setName("Client 4");
 
Fil_1.start();
Fil_2.start();
Fil_3.start();
Fil_4.start();
 
}
} //FIN MAIN
 
