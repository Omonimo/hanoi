import java.util.InputMismatchException;
import java.util.Scanner;
//import mx.unam.ciencias.icc.proyecto1;

public class Main {

    public static void main(String[] args){
	//preguntar a usuario numero de discos
	
	System.out.println("Ingresa un numero mayor a 0 y menor que 3.402823x10^38");
    Scanner scanner = new Scanner(System.in);
	//revisar si el numero es mayo a 0 y menor a Double.MAX_VALUE
	
	double discosFloor = 0;
	try {
		double discos = scanner.nextDouble();
		if(discos > 0 && discos < Double.MAX_VALUE)
		//redondear numero de discos al entero mas bajo usando Math.floo();
			discosFloor = Math.floor(discos);
		
	} catch (InputMismatchException e) {
		System.out.println("Ingresa un numero mayor a 0 y menor que 3.402823x10^38");

	} 
	
	//preguntar a usuario modo automatico o manual
	System.out.println("Ingresa \"true\" para ejecutar el progrma en modo automatico. \n" +
	"Ingresa \"false\"  para ejecutar modo manual.");
	try {
		boolean modoUsuario = scanner.nextBoolean();

	} 
    catch (Exception e) {
		// TODO: handle exception
		System.out.println("Ingresa \"true\" para ejecutar el progrma en modo automatico. \n" +
	"Ingresa \"false\"  para ejecutar modo manual.");
	}

    scanner.close();

    //intanciar torres en estado de inicio
    Torre t1 = new Torre(discosFloor, 1);
    Torre t2 = new Torre(0, 2);
    Torre t3 = new Torre(0, 3);

    System.out.println(t1.toString());


}
}