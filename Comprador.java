//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 21/08/2023
//Última modificación: 23/08/2023

import java.util.Scanner;
import java.util.InputMismatchException;

public class Comprador {
    private String nombre;
    private int cant_personas;
    Scanner teclado = new Scanner(System.in);
    private int cant_visitas;
    private boolean validar1 = false;
    private boolean validar2 = false;
    private boolean validar3 = false;

    //Método para generar un nuevo comprador y registrar sus datos
    public Comprador(){
        //Se verifica que lo que se haya ingresado al nombre sea válido
        do{
            try{
                System.out.println("=========================================================");
                System.out.println("-------------------------");
                System.out.println("Hola muy buen día querido comprador :)");
                System.out.println("------------------------");
                System.out.println("¿Cuál es su nombre? ");
                nombre = teclado.nextLine();
                System.out.println("------------------------");
                validar1 = true;
            }

            catch(InputMismatchException e) {
                System.out.println("------------------------");
                System.out.println("Por favor, asegurese de estar colocando un nombre válido....");
                System.out.println("------------------------");
                teclado.nextLine();
            }
        }
        while (!validar1);
        validar1 = false;

        //Se verifica que lo que haya ingresado para la cantidad de personas que van con el comprador sea válido
        do{
            try{
                System.out.println("=========================================================");
                System.out.println("¿Cuántas personas vienen con usted?");
                cant_personas = teclado.nextInt();
                teclado.nextLine();
                while (true){
                    if (cant_personas > 40){
                        System.out.println("Esas son demasiadas personas, por favor ingrese un número menor o igual a 40.");
                        cant_personas = teclado.nextInt();
                        teclado.nextLine();
                    }
                    else if (cant_personas <= 40){
                        break;
                    }
                }
                validar2 = true;
            }

            catch(InputMismatchException e) {
                System.out.println("------------------------");
                System.out.println("Por favor asegurése que esté colocando un número válido....");
                System.out.println("------------------------");
                teclado.nextLine();
            }
        }

        while(!validar2);
        validar2 = false;

        //Se verifica que el valor que haya ingresado la persona para la cantidad de visitas sea válido
        do{
            try{
                System.out.println("=========================================================");
                System.out.println("¿Cuántas veces nos ha visitado?");
                cant_visitas = teclado.nextInt();
                teclado.nextLine();
                validar3 = true;
            }

            catch(InputMismatchException e) {
                System.out.println("------------------------");
                System.out.println("Por favor asegurése que esté colocando un número válido....");
                System.out.println("------------------------");
                teclado.nextLine();
            }
        }

        while(!validar3);
        validar3 = false;
    }

    //Obtenemos el nombre
    public String getNombre(){
        return this.nombre;
    }

    //Obtenemos la cantidad de personas para la reserva
    public int getCant_personas() {
        return this.cant_personas;
    }

    //Obtenemos la cantidad de visitas que ha hecho el cliente
    public int getCant_visitas() {
        return this.cant_visitas;
    }

    


    
}
