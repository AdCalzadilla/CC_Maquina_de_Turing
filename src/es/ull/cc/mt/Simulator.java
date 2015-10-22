package es.ull.cc.mt;

import java.util.Scanner;

public class Simulator {
	
	public static void menuInit(){
		System.out.println(" = Máquina de Turing = ");
		System.out.println(" ==================== ");
		System.out.print(" Introduce MT (fichero): ");
	}
	public static void menu(){
		System.out.println(" \n 1.- Representación formal de la MT ");
		System.out.println(" 2.- Ejecutar MT");
		System.out.println(" 3.- Salir ");
		System.out.print(" - Opcion: ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String rute;
		int choice;
		
		menuInit();
		rute = sc.nextLine();
		rute = "files/"+ rute;
		Mt machine = new Mt(rute);
		menu();
		choice = sc.nextInt();
		while(choice != 3){
			switch(choice){
				case 1:
					machine.printMt();
					break;
				case 2:
					machine.execute();
					break;
			}
			menu();
			choice = sc.nextInt();
		}
		sc.close();
	}

}
