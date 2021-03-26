package controller;

import java.util.concurrent.Semaphore;

public class CruzamentoThread extends Thread{

	private int sentido;
	private Semaphore semaforo;
	
	public CruzamentoThread(Semaphore semaforo) {
		this.semaforo=semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			cruzar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void cruzar() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sentido = (int) (Math.random() * 4) + 1;
		
		switch (sentido) {
			case 1:
				System.out.println("Carro #"+getId()+" passando do Norte para o Sul");
				break;
				
			case 2:
				System.out.println("Carro #"+getId()+" passando do Sul para o Norte");
				break;
				
			case 3:
				System.out.println("Carro #"+getId()+" passando do Leste para o Oeste");
				break;
				
			case 4:
				System.out.println("Carro #"+getId()+" passando do Oeste para o Leste");
				break;
		}
	}
}
