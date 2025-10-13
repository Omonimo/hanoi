import java.util.InputMismatchException;
import java.util.Scanner;
//import mx.unam.ciencias.icc.proyecto1;

public class Main {

    public static void main(String[] args){
	//preguntar a usuario numero de discos
	int discosFloor = 0;
	Scanner scanner = new Scanner(System.in);
	while(true){
	System.out.println("Ingresa un numero mayor a 0 y menor que  2,147,483,647");
    
	//revisar si el numero es mayo a 0 y menor a Double.MAX_VALUE
	
	
	
	try {
		int discos = scanner.nextInt();
		if(discos > 0 && discos < Integer.MAX_VALUE)
		//redondear numero de discos al entero mas bajo usando Math.floo();
			discosFloor = (int)Math.round(discosFloor);
		break;
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
    Torre t1 = new Torre(discosFloor, 1, discosFloor, 0	);
    Torre t2 = new Torre(0, 2, discosFloor, 0);
    Torre t3 = new Torre(0, 3, discosFloor, 0);

    System.out.println(t1.imprimeTorre(t1));


}
}