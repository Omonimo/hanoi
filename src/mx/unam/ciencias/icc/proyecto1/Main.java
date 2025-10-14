import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
//import mx.unam.ciencias.icc.proyecto1;

public class Main {

    /* Flag que indica si el algoritmo de Hanoi se está ejecutando. */
    private static final AtomicBoolean hanoiRunning = new AtomicBoolean(false);

    /**
     * Regresa true si Hanoi está en ejecución.
     */
    public static boolean isHanoiRunning() {
        return hanoiRunning.get();
    }

    /**
     * Wrapper que marca el inicio/final de la ejecución y llama al método
     * recursivo `hanoi`.
     */
    public static void startHanoi(Torre t1, Torre t2, Torre t3, int discos) {
        hanoiRunning.set(true);
        try {
            hanoi(t1, t2, t3, discos);
        } finally {
            hanoiRunning.set(false);
        }
    }

    public static void main(String[] args){
	//preguntar a usuario numero de discos
	int alturaTotal = 0;
	Scanner scanner = new Scanner(System.in);
	while(true){
	System.out.println("Ingresa un numero mayor a 0 y menor que  2,147,483,647");
    
	//revisar si el numero es mayo a 0 y menor a Double.MAX_VALUE
	
	
	
	try {
        int discos = scanner.nextInt();
        if(discos > 0 && discos < Integer.MAX_VALUE) {
            // asignar el valor ingresado
            alturaTotal = discos;
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
    Torre t1 = new Torre(alturaTotal, 1, alturaTotal, 'A');

    int i;
    for(i = 1; i <= alturaTotal; i++){
        Torre.Disco disco = t1.new Disco(i);
        t1.agregaFinal(disco);
    }

    Torre t2 = new Torre(alturaTotal, 2, 0, 'B');
    Torre t3 = new Torre(alturaTotal, 3, 0, 'C');
    // imprimir estado inicial
    mostrarTorres(t1, t2, t3);

    //llamar metodo hanoi
    hanoi(t1, t3, t2, alturaTotal);
}

// Metodo hanoi recursivo
// from/t1 to/t2 auxiliary/t3
//from aux to 
//aux to from
/* public static void hanoi(Torre t1, Torre t2, Torre t3, int discos) {
    if (discos == 1) {
        t1.mueve(t3);
        mostrarTorres(t1, t2, t3);
        return;
    } else{
    //System.out.println("Antes de 1 2 3");
    //mostrarTorres(t1, t2, t3);
    hanoi(t1, t3, t2, discos - 1);
    //System.out.println("Antes de mueve");
    mostrarTorres(t1, t2, t3);
    t1.mueve(t3);
    //System.out.println("Despues de mueve");
        mostrarTorres(t1, t2, t3);
    hanoi(t2, t1, t3, discos - 1);
    //System.out.println("Despues de 2 1 3");
        //mostrarTorres(t1, t2, t3);
}} */
//t1,t3,t2
/* public static void hanoi(Torre start, Torre end, Torre temp, int discos) {
    if (discos == 1) {
        //t1.mueve(t3);
        //mostrarTorres(t1, t2, t3);
        System.out.println("Moviendo disco superior de " + start.nombre + " a torre " + end.nombre);
        //return;
        start.mueve(end);
        mostrarTorres(start, temp, end);
    } else{
    //System.out.println("Antes de 1 2 3");
    //mostrarTorres(t1, t2, t3);
    hanoi(start, temp, end, discos - 1);
    //System.out.println("Antes de mueve");
    //mostrarTorres(t1, t2, t3);
    //t1.mueve(t3);
    //System.out.println("Despues de mueve");
        //mostrarTorres(t1, t2, t3);
        System.out.println("Moviendo disco superior de " + start.nombre + " a torre " + end.nombre);
    start.mueve(end);
    mostrarTorres(start, end, temp);
        hanoi(temp, end, start, discos - 1);
    //System.out.println("Despues de 2 1 3");
        //mostrarTorres(t1, t2, t3);
    }} */

public static void hanoi(Torre start, Torre end, Torre temp, int discos) {
    if (discos == 0) {
        
    return;
    
    } else{
    //System.out.println("Antes de 1 2 3");/
    //mostrarTorres(t1, t2, t3);
    hanoi(start, temp, end, discos - 1);
    //System.out.println("Antes de mueve");
    //mostrarTorres(t1, t2, t3);
    //t1.mueve(t3);
    //System.out.println("Despues de mueve");
        //mostrarTorres(t1, t2, t3);
        System.out.println("Moviendo disco superior de " + start.nombre + " a torre " + end.nombre);
    start.mueve(end);
    mostrarTorres(start, temp, end);
        hanoi(temp, end, start, discos - 1);
    //System.out.println("Despues de 2 1 3");
        //mostrarTorres(t1, t2, t3);
    }}


// Metodo para imprimir torres en consola
public static void mostrarTorres(Torre t1, Torre t2, Torre t3) {
    
 // línea en blanco para separar pasos
    if(t1.nombre == 'A') {
    System.out.println(t1.imprimeTorre());
    } else if(t2.nombre == 'A') {
    System.out.println(t2.imprimeTorre());
    } else {
    System.out.println(t3.imprimeTorre());
    }

    if(t1.nombre == 'B') {
    System.out.println(t1.imprimeTorre());
    } else if(t2.nombre == 'B') {
    System.out.println(t2.imprimeTorre());
    } else {
    System.out.println(t3.imprimeTorre());
    }

    if(t1.nombre == 'C') {
    System.out.println(t1.imprimeTorre());
    } else if(t2.nombre == 'C') {
    System.out.println(t2.imprimeTorre());
    } else {
    System.out.println(t3.imprimeTorre());
    }




    /* System.out.println(t1.nombre + ": " + t1.imprimeTorre() +
            "\n" + t2.nombre + ": "+ t2.imprimeTorre() +
            "\n" + t3.nombre + ": " + t3.imprimeTorre() +
            "\n---------------------");
*/
    } 
    /**
     * Regresa true si el algoritmo de Hanoi se está ejecutando.
     */
    public static boolean ejecucioHanoi(){
        return isHanoiRunning();
    }

}