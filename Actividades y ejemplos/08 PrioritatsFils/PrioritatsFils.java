public class PrioritatsFils implements Runnable {
	String strImprimir;

	public PrioritatsFils(String strP) {
		strImprimir=strP;
	}

	public void run(){

		for(int x=0;x<10;x++){
			System.out.println(strImprimir);
		}
	}


	public static void main(String[] args) {
		
		PrioritatsFils objRunnable1 = new PrioritatsFils("Corredor 1");
		PrioritatsFils objRunnable2 = new PrioritatsFils("Corredor 2");

		//Creem el fil amb l’objecte runnable
		Thread primer = new Thread(objRunnable1);
		
		//Assignem un nom al fil primer
		primer.setName("Corredor 1");

		Thread segon = new Thread(objRunnable2);

		//Assignem un nom al fil segon
		segon.setName("Corredor 2");

		//Canviem la prioritat de fil primer i li posem la més baixa
		primer.setPriority(Thread.MIN_PRIORITY);

		//Mostrem el nom del fil i la seva prioritat
		System.out.println("Prioritat " + primer.getName()+ ": " + primer.getPriority());

		//Canviem la prioritat de fil segon i li posem la més alta
		segon.setPriority(Thread.MAX_PRIORITY);
		
		//Mostrem el nom del fil i la seva prioritat
		System.out.println("Prioritat " + segon.getName()+ ": " + segon.getPriority());

		// Cridem al mètode start() per tal que comenci per posar-los a preparats
		primer.start();
		segon.start();

		System.out.println("Final Fil Principal");
	}

}
