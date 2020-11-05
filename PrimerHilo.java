/*
 * PrimerHilo.java
 * 
 * Copyright 2020 adriba <adriba@PC17>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


public class sumadorVector {
	private static int vector[] ={1,2,3,34,5,6,7,8,9,10,11,12};
	private static int resultado = 0;
	
	public static void main (String[] args)  throws Exception{
		Sumador s1 = new Sumador(vector, 0,2);
		Sumador s2 = new Sumador(vector, 3,6);
		Sumador s3 = new Sumador(vector, 6,9);
		Sumador s4 = new Sumador(vector, 10,12);
		
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
		
		
	}
	
	class Sumador implements Runnable{
		private int[] vector;
		private int ini;
		private int fin;
		private int resultado = 0;
		
		public Sumador(int[] vector, int ini, int fin){
			this.vector = vector;
			this.ini = ini;
			this.fin = fin;
}

