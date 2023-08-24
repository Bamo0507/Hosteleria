//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 21/08/2023
//Última modificación: 23/08/2023

import java.util.Scanner;
import java.util.InputMismatchException;

public class Vendedor {
    private Comprador[] compradores = new Comprador[50];
    private Habitacion habitacion1 = new Habitacion("Estandar", 4, 150);
    private Habitacion habitacion2 = new Habitacion("Deluxe", 4, 300);
    private Habitacion habitacion3 = new Habitacion("Suite", 4, 500);
    private int vendidas1 = 0;
    private int vendidas2 = 0;
    private int vendidas3 = 0;
    private int cant_habitaciones = 0;
    private int[] habitacionesE = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109};
    private int[] habitacionesD = {200, 201, 202, 203, 204, 205, 206, 207, 208, 209};
    private int[] habitacionesS = {300, 301, 302, 303, 304, 305, 306, 307, 308, 309};
    private boolean[] disponibilidad = {false, false, false};
    private String[] habitaciones = {"Estandar", "Deluxe", "Suite"};
    private String aprob1 = null;
    private String aprob2 = null;
    private String aprob3 = null;
    private Scanner teclado = new Scanner(System.in);
    private int seleccion1;
    private int seleccion2;
    private int cant_compradores = 0;
    private int posiciones = 0;
    private int posiciones2 = 0;

    //Obtenemos la cantidad de compradores ingresados hasta el momento en el hotel
    public int getCant_compradores(){
        for (int z = 0; z < compradores.length-1; z++){
            if (compradores[z] != null){
                cant_compradores++;
            }
        }
        return this.cant_compradores;
    }

    //Se registra un nuevo comprador, y se agrega en la posición debida en el array de compradores
    public void nuevoComprador(Comprador comprador) {
        for (int i = posiciones2; i < compradores.length; i++){
            posiciones2++;
            if(compradores[i] == null){
                compradores[i] = comprador;
                break;
            }
        }
    }

    //Se revisan las asignaciones que se tienen guardas hasta el momento y se decide qué habitación darles
    public void asignarHabitaciones() {
        System.out.println("Lista de espera de compradores: \n");
        //Se revisa la últimas posición en la que nos hayamos quedado
        for (int i = posiciones; i < compradores.length; i++) {
            //Se revisan que se tenga algún valor en la posición que nos toca
            if (compradores[i] != null){
                posiciones++;
                //Mostramos los datos de la solicitud que se está estudiando
                System.out.println("...Verificando Disponibilidad...");
                System.out.println("-------------------------");
                System.out.println("Nombre: " + compradores[i].getNombre());
                System.out.println("Cantidad de Visitas: " + compradores[i].getCant_visitas());
                System.out.println("Cantidad de Personas: " + compradores[i].getCant_personas());
                System.out.println("-------------------------");

                //Código a correr en caso que la persona nos haya visitado menos de 5 veces
                if (compradores[i].getCant_visitas() < 5){
                    //Se aproxima el valor al siguiente entero más grande
                    cant_habitaciones = (int) Math.ceil(((float) compradores[i].getCant_personas())/4);
                    //Se verifica que haya disponibilidad
                    if ((10-vendidas1) >= cant_habitaciones){
                        System.out.println("-------------------------");
                        System.out.println("Solo se pueden vender estándar.");
                        System.out.println("-------------------------");
                        System.out.println("El costo total a pagar es de: $" + (cant_habitaciones * habitacion1.getPrecio()) + ".");
                        System.out.println("-------------------------");
                        System.out.println("Se le entregaran las siguientes habitaciones.");
                        System.out.println("-------------------------");
                        for (i = vendidas1; i < vendidas1 + cant_habitaciones; i++){
                            System.out.println(habitacionesE[i]);
                        }
                        System.out.println("-------------------------");
                        vendidas1 += cant_habitaciones;
                    }
                    
                    else {
                        System.out.println("Lamentablemente no hay espacio para la zona espacio, y es la única a la que es elegible");
                    }
                }

                //Código a correr en caso que la persona nos haya visitado más de 5 veces pero menos de 10
                else if (compradores[i].getCant_visitas() >= 5 && compradores[i].getCant_visitas() < 10){
                    System.out.println("...Verificando Disponibilidad...");
                    //Se aproxima el valor al siguiente entero más grande
                    cant_habitaciones = (int) Math.ceil(((float) compradores[i].getCant_personas())/4);
                    //Verificamos disponibilidad en las estandar
                    if ((10-vendidas1) >= cant_habitaciones){
                        disponibilidad[0] = true;
                    }
                    //Verificamos disponbilidad en las deluxe
                    if ((10-vendidas2) >= cant_habitaciones){
                        disponibilidad[1] = true;
                    }

                    //Se meustran las opciones que puede tomar el usuario
                    System.out.println("Se están analizando las habitaciones que puede tomar... \n");
                    for (int j = 0; j < disponibilidad.length-1; j++){
                        if (disponibilidad[j] == true){
                            System.out.println((j+1) + " ----- " + habitaciones[j]);
                            if (j == 0){
                                aprob1 = "1";
                            }
                            else if (j == 1){
                                aprob2 = "2";
                            }
                        }
                    }

                    //Se verifica que se coloque una opción valida de elección para el comprador
                    do{
                        if (aprob1 != null || aprob2 != null){
                            System.out.println("¿Cuál opción desea darle?");
                            if(teclado.hasNextInt()){
                                seleccion1 = teclado.nextInt();
                                teclado.nextLine();

                                if (seleccion1 == 1 && !aprob1.equals("1")){
                                    while(true){
                                        System.out.println("---------------");
                                        System.out.println("Esa no es una opción válida, por favor seleccione algo que sí lo sea.");
                                        System.out.println("¿Qué opción desea darle?");
                                        seleccion1 = teclado.nextInt();
                                        teclado.nextLine();
                                        if(seleccion1 == 2){
                                            break;
                                        }
                                    }
                                }
                                if (seleccion1 == 2 && !aprob2.equals("2")){
                                    while(true){
                                        System.out.println("---------------");
                                        System.out.println("Esa no es una opción válida, por favor seleccione algo que sí lo sea.");
                                        System.out.println("¿Qué opción desea darle?");
                                        seleccion1 = teclado.nextInt();
                                        teclado.nextLine();
                                        if(seleccion1 == 1){
                                            break;
                                        }
                                    }
                                }
                                //Cóidgo a correr dependiendo de la eleccion
                                if(seleccion1 == 1 || seleccion1 == 2){
                                    if(seleccion1 == 1){
                                        //Se hace un reporte
                                        System.out.println("-------------------------");
                                        System.out.println("Se le darán habitaciones estándar.");
                                        System.out.println("-------------------------");
                                        System.out.println("El costo total a pagar es de: $" + (cant_habitaciones * habitacion1.getPrecio()) + ".");
                                        System.out.println("-------------------------");
                                        System.out.println("Se le otorgarán las siguientes habitaciones.");
                                        System.out.println("-------------------------");
                                        for (int k = vendidas1; k < vendidas1 + cant_habitaciones; k++){
                                            //Se muestran las habitaciones que le toquen a la persona
                                            System.out.println(habitacionesE[k]);
                                        }
                                        System.out.println("-------------------------");
                                        vendidas1 += cant_habitaciones;
                                    }
                                    else if(seleccion1 == 2){
                                        //Se hace un reporte
                                        System.out.println("-------------------------");
                                        System.out.println("Se le darán habitaciones deluxe.");
                                        System.out.println("-------------------------");
                                        System.out.println("El costo total a pagar es de: $" + (cant_habitaciones * habitacion2.getPrecio()) + ".");
                                        System.out.println("-------------------------");
                                        System.out.println("Se le otorgarán las siguientes habitaciones.");
                                        System.out.println("-------------------------");
                                        for (int j = vendidas2; j < vendidas2 + cant_habitaciones; j++){
                                            //Se muestran las habitacioens que le toquen a la persona
                                            System.out.println(habitacionesD[j]);
                                        }
                                        System.out.println("-------------------------");
                                        vendidas2 += cant_habitaciones;
                                    }
                                    break;
                                    }
                                }
                            else {
                                System.out.println("Por favor, asegurese de estar ingresando un número válido.");
                                teclado.next();
                            }
                            }
                        else {
                            System.out.println("No fue elegible para ninguna opción.");
                        }     
                    }
                    //Se resetean los valores para la próxima vez que se corra
                    while(true);
                    aprob1 = null;
                    aprob2 = null;
                    disponibilidad[0] = false;
                    disponibilidad[1] = false;
                    cant_habitaciones = 0;
                    seleccion1 = -1;
                }

                //Iniciamos código a correr si es VIP
                else if (compradores[i].getCant_visitas() >= 10){
                    System.out.println("...Verificando Disponibilidad...");
                    //Se aproxima al próximo entero más grande
                    cant_habitaciones = (int) Math.ceil(((float) compradores[i].getCant_personas())/4);
                    //Verificamos disonibilidad en estandar
                    if ((10-vendidas1) >= cant_habitaciones){
                        disponibilidad[0] = true;
                    }
                    //Verificamos disponibildiad en deluxe
                    if ((10 -vendidas2) >= cant_habitaciones){
                        disponibilidad[1] = true;
                    }
                    //Verificamos disponibilidad en suite
                    if ((10 - vendidas3) >= cant_habitaciones){
                        disponibilidad[2] = true;
                    }

                    //Se aprueban las que se pueden elegir
                    System.out.println("Se están analizando las habitaciones que puede tomar... \n");
                    for(int p = 0; p < disponibilidad.length; p++){
                        if (disponibilidad[p] == true){
                            System.out.println((p+1) + " ----- " + habitaciones[p]);
                            if (p == 0){
                                aprob1 = "1";
                            }
                            else if (p == 1){
                                aprob2 = "2";
                            }
                            else if (p == 2){
                                aprob3 = "3";
                            }
                        }
                    }

                    //Establecemos que se escoja una opción valida para el comprador
                    do{
                        if(aprob1 != null || aprob2 != null || aprob3 != null){
                            System.out.println("¿Cuál opción desea darle?");
                            if(teclado.hasNextInt()){
                                seleccion2 = teclado.nextInt();
                                teclado.nextLine();

                                if (seleccion2 == 1 && !aprob1.equals("1")){
                                    while(true){
                                        System.out.println("---------------");
                                        System.out.println("Esa no es una opción válida, por favor seleccione algo que sí lo sea.");
                                        System.out.println("¿Qué opción desea darle?");
                                        seleccion2 = teclado.nextInt();
                                        teclado.nextLine();
                                        if(seleccion2 == 2 && aprob2.equals("2")){
                                            break;
                                        }
                                        else if(seleccion2 == 3 && aprob3.equals("3")){
                                            break;
                                        }
                                    }
                                }

                                if (seleccion2 == 2 && !aprob2.equals("2")){
                                    while(true){
                                        System.out.println("---------------");
                                        System.out.println("Esa no es una opción válida, por favor seleccione algo que sí lo sea.");
                                        System.out.println("¿Qué opción desea darle?");
                                        seleccion2 = teclado.nextInt();
                                        teclado.nextLine();
                                        if(seleccion1 == 1 && aprob2.equals("1")){
                                            break;
                                        }
                                        else if(seleccion2 == 3 && aprob3.equals("3")){
                                            break;
                                        }
                                    }
                                }

                                if (seleccion2 == 3 && !aprob3.equals("3")){
                                    while(true){
                                        System.out.println("---------------");
                                        System.out.println("Esa no es una opción válida, por favor seleccione algo que sí lo sea.");
                                        System.out.println("¿Qué opción desea darle?");
                                        seleccion2 = teclado.nextInt();
                                        teclado.nextLine();
                                        if(seleccion2 == 2 && aprob2.equals("2")){
                                            break;
                                        }
                                        else if(seleccion2 == 1 && aprob3.equals("1")){
                                            break;
                                        }
                                    }
                                }
                                //Código a correr dependiendo de lo que escoja el vendedor
                                if(seleccion2 == 1 || seleccion2 == 2 || seleccion2 == 3){
                                    if(seleccion2 == 1){
                                        //Se muestra un reporte
                                        System.out.println("-------------------------");
                                        System.out.println("Se le darán habitaciones estándar.");
                                        System.out.println("-------------------------");
                                        System.out.println("El costo total a pagar es de: $" + (cant_habitaciones * habitacion1.getPrecio()) + ".");
                                        System.out.println("-------------------------");
                                        System.out.println("Se le otorgarán las siguientes habitaciones.");
                                        System.out.println("----------------");
                                        for (int h = vendidas1; h < vendidas1 + cant_habitaciones; h++){
                                            //Se enseñan los números de habitación que le tocaron
                                            System.out.println(habitacionesE[h]);
                                        }
                                        vendidas1 += cant_habitaciones;
                                    }
                                    else if(seleccion2 == 2){
                                        //Se muestra un reporte
                                        System.out.println("-------------------------");
                                        System.out.println("Se le darán habitaciones deluxe.");
                                        System.out.println("-------------------------");
                                        System.out.println("El costo total a pagar es de: $" + (cant_habitaciones * habitacion2.getPrecio()) + ".");
                                        System.out.println("-------------------------");
                                        System.out.println("Se le otorgarán las siguientes habitacioens.");
                                        System.out.println("-----------------");
                                        for (int m = vendidas2; m < vendidas2 + cant_habitaciones; m++){
                                            //Se enseñan los números de habitación que le tocaron
                                            System.out.println(habitacionesD[m]);
                                        }
                                        vendidas2 += cant_habitaciones;
                                    }
                                    else if(seleccion2 == 3){
                                        //Se muestra un reporte
                                        System.out.println("-------------------------");
                                        System.out.println("Se le darán habitaciones suite.");
                                        System.out.println("-------------------------");
                                        System.out.println("El costo total a pagar es de: $" + (cant_habitaciones * habitacion3.getPrecio()) + ".");
                                        System.out.println("-------------------------");
                                        System.out.println("Se le otorgarán las siguientes habitacioens.");
                                        System.out.println("-----------------");
                                        for(int g = vendidas3; g < vendidas3 + cant_habitaciones; g++){
                                            //Se enseñan los números de habitación que le tocaron
                                            System.out.println(habitacionesS[g]);
                                        }
                                        vendidas3 += cant_habitaciones;
                                    }
                                    break;
                                }
                            }
                        else {
                            System.out.println("Por favor, asegurese de estar ingresando un número válido.");
                            teclado.next();
                        }
                        }
                    else{
                        System.out.println("No fue elebible para ninguna opción.");
                    }
                }
                //Se resetean los valores para la próxima que se corra
                while(true);
                aprob1 = null;
                aprob2 = null;
                aprob3 = null;
                disponibilidad[0] = false;
                disponibilidad[1] = false;
                disponibilidad[2] = false;
                cant_habitaciones = 0;
                seleccion2 = -1;

                }

            }
        
        }
        
    }
}
