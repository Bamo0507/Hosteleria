//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 21/08/2023
//Última modificación: 23/08/2023

import java.util.Scanner;
import java.util.InputMismatchException;


public class Hotel {

    private static Scanner teclado = new Scanner(System.in);
    private static int Seleccion1 = 0;
    private static boolean validar1 = false;

    public static void main(String[] args){
        //Se crea al vendedor que se va a encargar de llevar el control de las asignaciones
        Vendedor trabajador = new Vendedor();

        //Se presenta el menú principal
        while(true){
            System.out.println("=========================================================");
            System.out.println("          MENU PRINCIPAL");
            System.out.println("=========================================================");
            System.out.println("Opción para huésped: ");
            System.out.println("1. Hacer solicitud de habitación.");
            System.out.println("=========================================================");
            System.out.println("Opción para trabajador: ");
            System.out.println("2. Aprobar solicitud de habitación.");
            System.out.println("=========================================================");
            System.out.println("3. Salir del menú.");
            System.out.println("=========================================================");
            System.out.println("---------------¿A qué desea ingresar?---------------");

        //Se verifica que lo que se haya ingresado un entero
            do{
                try{
                    Seleccion1 = teclado.nextInt();
                    teclado.nextLine();
                    validar1 = true;
                }
                catch(InputMismatchException e) {
                    System.out.println("Por favor, asegurese de estar colocando un número....");
                    teclado.nextLine();
                }
            }
            while (!validar1);
            validar1 = false;

            //Código a correr si se quiere hacer una asignación
            if (Seleccion1 == 1) {
            //Se revisa que no se hayan llegado a los 50 compradores
                if (trabajador.getCant_compradores() < 50){
                    Comprador huesped = new Comprador();
                    trabajador.nuevoComprador(huesped);
                }
                else {
                    System.out.println("Lamentamos informarle que hemos llegado a nuestro límite de huéspedes, vuelva más tarde.");
                }
            }

            //Código a correr para verificar las asignaciones que se hayan colocado hasta el momento
            else if (Seleccion1 == 2){
                if (trabajador.getCant_compradores() != 0){
                    trabajador.asignarHabitaciones();
                }
                else{
                    System.out.println("-------------------------");
                    System.out.println("Todavía no se han solicitado habitaciones.");
                    System.out.println("-------------------------");
                }
            }

            //Salimos de todo el programa
            else if (Seleccion1 == 3){
                System.out.println("Qué tenga un buen día ");
                System.exit(0);
            }

            //Informamos al usuario que ha ingresado una opción invalida
            else {
                System.out.println("Por favor, verifica que estés ingresando una opción válida");
            }
        }
    }           
}