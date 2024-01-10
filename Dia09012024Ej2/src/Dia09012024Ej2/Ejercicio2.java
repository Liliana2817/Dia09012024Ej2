package Dia09012024Ej2;

import java.util.Scanner;

public class Ejercicio2 {

	// 2.Simulador de Cajero Automático 
			//  - Descripción: Desarrollar un simulador de cajero automático que permita retirar dinero, depositar y consultar saldo. El programa debe manejar cuentas múltiples con ID y contraseña.
			//  - Retos: Crear un sistema de autenticación, manejar el saldo de las cuentas, y realizar operaciones básicas de un cajero automático.
	        /*2.Simulador de Cajero Automático
	   -Pasos:
	     1. Crea estructuras para almacenar la información de las cuentas (por ejemplo, usando arrays para IDs, contraseñas y saldos).
	     2. Implementa un sistema de login que pida al usuario su ID y contraseña y verifique estos datos.
	     3. Una vez autenticado, muestra un menú con opciones como retirar, depositar y ver saldo.
	     4. Para cada opción, realiza las operaciones correspondientes (actualizar saldo, mostrar información, etc.).
	     5. Asegúrate de validar las entradas del usuario (por ejemplo, no permitir retirar más dinero del disponible en la cuenta).
	*/
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
	        int[] ids = {1, 2};
	        int[] contraseñas = {2233, 5665};
	        double[] saldos = {900.50, 650.50};

	        System.out.println("Cajero automático");
	        System.out.println("Introduce tu ID: ");
	        int id = sc.nextInt();
	        System.out.println("Introduce tu contraseña: ");
	        int contraseña = sc.nextInt();

	        int autenticado = -1;

	       
	        for (int i = 0; i < ids.length; i++) {
	            if (id == ids[i] && contraseña == contraseñas[i]) { 
	                autenticado = i;
	                break; 
	            }
	        }

	        if (autenticado == -1) {
	            System.out.println("Datos incorrectos");
	            sc.close();
	            return;
	        }
	        
	      
	        int opcion;
	        do {
	            System.out.println("1) Ver saldo");
	            System.out.println("2) Depositar dinero");
	            System.out.println("3) Retirar dinero");
	            System.out.println("4) Salir");
	            System.out.print("Elige una opción: ");
	            opcion = sc.nextInt();

	            switch (opcion) {
	                case 1:
	                    System.out.println("Tu saldo actual es: " + saldos[autenticado]);
	                    break;
	                case 2:
	                    System.out.print("Cantidad a depositar: ");
	                    double depositar = sc.nextDouble();
	                    saldos[autenticado] += depositar; 
	                    System.out.println("Dinero depositado correctamente, saldo  " + saldos[autenticado]);
	                    break;
	                case 3:
	                    System.out.print("Cantidad a retirar: ");
	                    double retirar = sc.nextDouble();

	                  
	                    if (retirar <= saldos[autenticado]) {
	                        saldos[autenticado] -= retirar;
	                        System.out.println(" Retirado correctamente, saldo actualizado " + saldos[autenticado]);
	                    } else {
	                        System.out.println(" No tiene suficiente saldo ");
	                    }
	                    break;
	                case 4:
	                    System.out.println("Saliendo del cajero");
	                    break;
	                default:
	                    System.out.println("Opción no válida.");
	            }
	        } while (opcion != 4);

	        sc.close();
	}

}
