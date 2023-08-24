//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 21/08/2023
//Última modificación: 23/08/2023

public class Habitacion {
    private String Tipo;
    private int Cant_personas;
    private int Precio;
    
    //Constructor mediante el cual se definen los valores de todas las variables
    public Habitacion(String Tipo, int Cant_personas, int Precio){
        this.Tipo = Tipo;
        this.Cant_personas = Cant_personas;
        this.Precio = Precio;
    }

    //Se obtiene el tipo de la habitación
    public String getTipo(){
        return Tipo;
    }

    //Se obtiene la capacidad
    public int getCant_personas(){
        return Cant_personas;
    }

    //Se obtiene el precio de la habitación
    public int getPrecio(){
        return Precio;
    }


    
}
