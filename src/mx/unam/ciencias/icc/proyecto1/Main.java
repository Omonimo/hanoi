import java.util.InputMismatchException;
import java.util.Scanner;
//import mx.unam.ciencias.icc.proyecto1;

public class Main {

    public static void main(String[] args){
	//preguntar a usuario numero de discos
	int longitud = 0;
	Scanner scanner = new Scanner(System.in);
	while(true){
	System.out.println("Ingresa un numero mayor a 0 y menor que  2,147,483,647");
    
	//revisar si el numero es mayo a 0 y menor a Double.MAX_VALUE
	
	
	
	try {
        int discos = scanner.nextInt();
        if(discos > 0 && discos < Integer.MAX_VALUE) {
            // asignar el valor ingresado
            longitud = discos;
            // consumir el salto de linea restante
            scanner.nextLine();
            break;
        } else {
            System.out.println("Incorrecto");
        }
	} catch (InputMismatchException e) {
		System.out.println("Incorrecto");
		
		scanner.next();
	
	} 
    } 
	String modo;
	//preguntar a usuario modo automatico o manual
    while(true) {
        System.out.println("Ingresa \"a\" para modo automatico, ingresa \"m\" para modo manual");
        try {
            modo = scanner.nextLine();
            if(!modo.isEmpty() && (modo.charAt(0) == 'a' || modo.charAt(0) == 'm')) 
                break;
            throw new InputMismatchException();
        } catch(InputMismatchException e) {
            System.out.println("Error: ingreasa una opcion valida (a/m)");
        }
    }


    scanner.close();



    //intanciar torres en estado de inicio
	//numero de discos, posicion, altura maxima, sinDisco
    Torre t1 = new Torre(longitud, 1, longitud);

    int i;
    for(i = 1; i <= longitud; i++){
        Torre.Disco disco = t1.new Disco(i);
        t1.agregaFinal(disco);
    }

    Torre t2 = new Torre(0, 2, longitud);
    Torre t3 = new Torre(0, 3, longitud);
    // imprimir estado inicial
    mostrarTorres(t1, t2, t3);

    //llamar metodo hanoi
    hanoi(t1, t2, t3, longitud);
}

// Metodo hanoi para resolver el problema
public static void hanoi(Torre t1, Torre t2, Torre t3, int discos) {
    if (discos == 1) {
        t1.mueve(t3);
        mostrarTorres(t1, t2, t3);
        return;
    }
    hanoi(t1, t3, t2, discos - 1);
    t1.mueve(t3);
        mostrarTorres(t1, t2, t3);
    hanoi(t2, t1, t3, discos - 1);
}

// Metodo para imprimir torres en consola
public static void mostrarTorres(Torre t1, Torre t2, Torre t3) {
    System.out.println("1: " + t1.imprimeTorre() +
            "\n2: " + t2.imprimeTorre() +
            "\n3: " + t3.imprimeTorre());
}

}