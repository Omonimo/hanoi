import java.util.InputMismatchException;
import java.util.Scanner;

public class Hanoi {

	public static void main(String[] args){
	//preguntar a usuario numero de discos
	Scanner scannerDiscos = new Scanner(System.in);
	System.out.println("Ingresa un numero mayor a 0 y menor que 3.402823x10^38");
	//revisar si el numero es mayo a 0 y menor a Double.MAX_VALUE
	
	double discosPiso = 0;
	try {
		double discos = scannerDiscos.nextDouble();
		if(discos > 0 && discos < Double.MAX_VALUE)
		//redondear numero de discos al entero mas bajo usando Math.floo();
			discosPiso = Math.floor(discos);
		
	} catch (InputMismatchException e) {
		System.out.println("Ingresa un numero mayor a 0 y menor que 3.402823x10^38");

	}
	
	//preguntar a usuario modo automatico o manual
	Scanner scannerModo = new Scanner(System.in);
	System.out.println("Ingresa \"true\" para ejecutar el progrma en modo automatico. \n" +
	"Ingresa \"false\"  para ejecutar modo manual.");
	try {
		boolean modoUsuario = scannerModo.nextBoolean();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Ingresa \"true\" para ejecutar el progrma en modo automatico. \n" +
	"Ingresa \"false\"  para ejecutar modo manual.");
	}


}
}
