import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
//import mx.unam.ciencias.icc.proyecto1;

public class Main {

    public static void main(String[] args){
	//preguntar a usuario numero de discos
	int alturaTotal = 0;
	Scanner scanner = new Scanner(System.in);

    //modo automatico o manual
    boolean modoAutomatico = false;

	while(true){
	System.out.println("Ingresa un numero mayor a 0 y menor que  2,147,483,647");
    
	//revisar si el numero es mayo a 0 y menor a Integer.MAX_VALUE
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
    Torre t1 = new Torre(alturaTotal, 1, alturaTotal, '1');

    int i;
    for(i = 1; i <= alturaTotal; i++){
        Torre.Disco disco = t1.new Disco(i);
        t1.agregaFinal(disco);
    }

    Torre t2 = new Torre(alturaTotal, 2, 0, '2');
    Torre t3 = new Torre(alturaTotal, 3, 0, '3');
    // imprimir estado inicial
    Lista pila = new Lista();
    mostrarTorres(t1, t2, t3);

    //llamar metodo hanoi
    hanoi(t1, t3, t2, alturaTotal, pila);
}

public static void hanoi(Torre start, Torre end, Torre temp, int discos, Lista pila) {

    //crear pila de ejecucion
    PilaEjecucion r = new PilaEjecucion(start.posicion, temp.posicion, end.posicion, discos, ' ');
    pila.agregaInicio(r);


    if (discos == 0) {
        
    return;
    
    } else{
    //mostrarTorres(t1, t2, t3);
    hanoi(start, temp, end, discos - 1, pila);
        //mostrarTorres(t1, t2, t3);
    start.mueve(end);
    if(pila instanceof PilaEjecucion)
        ((PilaEjecucion) pila).setTipo('d');
    mostrarPila(pila);
    mostrarTorres(start, temp, end);
        hanoi(temp, end, start, discos - 1, pila);
    }}


    public static void guionesPorImprimir(int alturaTotal){

        double guiones = 4 + (4 * alturaTotal) + 4;
        double i;
        for(i = 0; i <= guiones; i++){
            System.out.print("-");
            
        } 
    }

// Metodo para imprimir torres en consola
public static void mostrarTorres(Torre t1, Torre t2, Torre t3) {
    
 // línea en blanco para separar pasos
    if(t1.nombre == '1') {
    System.out.println(t1.nombre + ": " + t1.imprimeTorre());
    } else if(t2.nombre == '1') {
    System.out.println(t2.nombre + ": " + t2.imprimeTorre());
    } else {
    System.out.println(t3.nombre + ": "  + t3.imprimeTorre());
    }

    if(t1.nombre == '2') {
    System.out.println(t1.nombre + ": " + t1.imprimeTorre());
    } else if(t2.nombre == '2') {
    System.out.println(t2.nombre + ": " + t2.imprimeTorre());
    } else {
    System.out.println(t3.nombre + ": " + t3.imprimeTorre());
    }

    if(t1.nombre == '3') {
    System.out.println(t1.nombre + ": " + t1.imprimeTorre());
    } else if(t2.nombre == '3') {
    System.out.println(t2.nombre + ": " + t2.imprimeTorre());
    } else {
    System.out.println(t3.nombre + ": " + t3.imprimeTorre());
    }

    // imprimir guiones según la altura máxima de las torres
    int maxLong = Math.max(t1.longitud, Math.max(t2.longitud, t3.longitud));
    guionesPorImprimir(maxLong);
    System.out.println();
    } 
    public static void mostrarPila(Lista pila){
        Lista.Nodo n = pila.getCabeza();
        while(n != null){
            Object elem = n.get();
            if (elem instanceof PilaEjecucion){
                PilaEjecucion p = (PilaEjecucion) elem;
                System.out.println(p.toString());
            }
            n = n.getSiguiente();}
    }

    
    }

