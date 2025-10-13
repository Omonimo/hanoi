import java.util.InputMismatchException;
import java.util.Scanner;

public class Hanoi {

    public static void hanoi(Torre t1, Torre t2,  Torre t3, int discos){
		
		
			//invicacionHanoi(t1, t2, t3, discos);
			if(discos == 1){
				t1.mueve(t3);
					return;
			}
			hanoi(t1, t3, t2, discos-1);
				t1.mueve(t3);
			hanoi(t2, t1, t3, discos-1);	
}
}
	