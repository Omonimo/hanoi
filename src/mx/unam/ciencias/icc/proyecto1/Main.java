import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int alturaTotal = 0;
        boolean automatico = false; // false = manual, true = automático
        
        // 1. Validar el número correcto de argumentos
        if (args.length != 3) {
            System.out.println("Uso correcto: java TorreDeHanoi -d <numerodediscos> -a|-m");
            System.out.println("  -d: Número de discos (entero positivo).");
            System.out.println("  -a: Modo automático.");
            System.out.println("  -m: Modo manual.");
            return; // Salir si no hay argumentos correctos
        }

        // 2. Procesar el argumento -d para el número de discos
        if (args[0].equals("-d")) {
            try {
                int discos = Integer.parseInt(args[1]);
                if (discos > 0 && discos < Integer.MAX_VALUE) {
                    alturaTotal = discos;
                } else {
                    System.out.println("Ingresa un numero mayor a 0 y menor a " + Integer.MAX_VALUE);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero mayor a 0 y menor a " + Integer.MAX_VALUE);
                return;
            }
        } else {
            System.out.println("Ingresa el numero de discos con la bandera -d");
            return;
        }

        // 3. Procesar el argumento para el modo de juego (-a o -m)
        if (args[2].equals("-a")) {
            automatico = true;
        } else if(args[2].equals("-m")) {
            automatico = false;
        } else {
            System.out.println("Error: La tercera bandera debe ser '-a' para modo automático o '-m' para modo manual.");
            return;
        }

        // Instanciar torres en estado de inicio
        Torre t1 = new Torre(alturaTotal, 1, alturaTotal, '1');

        int i;
        for(i = 1; i <= alturaTotal; i++){
            Torre.Disco disco = t1.new Disco(i);
            t1.agregaFinal(disco);
        }

        Torre t2 = new Torre(alturaTotal, 2, 0, '2');
        Torre t3 = new Torre(alturaTotal, 3, 0, '3');
        
        // Crear pila de ejecución
        Lista pila = new Lista();

        // Llamar método hanoi con pila de ejecución
        hanoi(t1, t2, t3, alturaTotal, pila, automatico);
        
        // Mostrar estado final (pila vacía)
        mostrarTorres(t1, t2, t3);
        System.out.println("¡Resuelto!");
    }

    // Método hanoi con pila de ejecución y control de modo
    public static void hanoi(Torre t1, Torre t2, Torre t3, int discos, Lista pila, boolean automatico){
        // Crear entrada en la pila de ejecución (sin tipo inicial)
        PilaEjecucion r = new PilaEjecucion(t1.posicion, t2.posicion, t3.posicion, discos, ' ');
        pila.agregaInicio(r);
        
        // Mostrar pila y torres al entrar a la llamada
        mostrarPila(pila);
        mostrarTorres(t1, t2, t3);
        
        // Esperar en modo manual
        if (!automatico) {
            esperarEnter();
        }
        
        if(discos == 1){
            // Mover el disco
            t1.mueve(t3);
            r.setTipo('i');
            
            // Mostrar después del movimiento
            mostrarPila(pila);
            mostrarTorres(t1, t2, t3);
            
            // Esperar en modo manual
            if (!automatico) {
                esperarEnter();
            }
            
            // Eliminar de la pila al completar
            pila.eliminaPrimero();
            return;
        }
        
        // Primera llamada recursiva: mover n-1 discos de t1 a t2 usando t3
        hanoi(t1, t3, t2, discos-1, pila, automatico);
        
        // Mover el disco más grande de t1 a t3
        t1.mueve(t3);
        // Cambiar tipo a 'd' (después de mover)
        r.setTipo('d');
        // Mostrar pila y torres después del movimiento
        mostrarPila(pila);
        mostrarTorres(t1, t2, t3);
        
        // Esperar en modo manual después del movimiento principal
        if (!automatico) {
            esperarEnter();
        }
        
        // Segunda llamada recursiva: mover n-1 discos de t2 a t3 usando t1
        hanoi(t2, t1, t3, discos-1, pila, automatico);
        
        // Eliminar de la pila al completar todas las operaciones
        pila.eliminaPrimero();
    }

    // Método para esperar a que el usuario presione ENTER
    public static void esperarEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Presiona ENTER para continuar...");
        scanner.nextLine();
    }

    public static void guionesPorImprimir(int alturaTotal){
        int guiones = 4 + (4 * alturaTotal) + 4;
        for(int i = 0; i <= guiones; i++){
            System.out.print("-");
        } 
    }

    // Método para imprimir torres en consola
    public static void mostrarTorres(Torre t1, Torre t2, Torre t3) {
        // Mostrar torre 1
        if(t1.nombre == '1') {
            System.out.println(t1.nombre + ": " + t1.imprimeTorre());
        } else if(t2.nombre == '1') {
            System.out.println(t2.nombre + ": " + t2.imprimeTorre());
        } else {
            System.out.println(t3.nombre + ": " + t3.imprimeTorre());
        }

        // Mostrar torre 2
        if(t1.nombre == '2') {
            System.out.println(t1.nombre + ": " + t1.imprimeTorre());
        } else if(t2.nombre == '2') {
            System.out.println(t2.nombre + ": " + t2.imprimeTorre());
        } else {
            System.out.println(t3.nombre + ": " + t3.imprimeTorre());
        }

        // Mostrar torre 3
        if(t1.nombre == '3') {
            System.out.println(t1.nombre + ": " + t1.imprimeTorre());
        } else if(t2.nombre == '3') {
            System.out.println(t2.nombre + ": " + t2.imprimeTorre());
        } else {
            System.out.println(t3.nombre + ": " + t3.imprimeTorre());
        }

        System.out.println(); // Línea en blanco después de las torres
    }
    
    public static void mostrarPila(Lista pila){
        // Solo mostrar si la pila no está vacía
        if(!pila.esVacia()){
            System.out.println("Pila de ejecución:");
            Lista.Nodo n = pila.getCabeza();
            while(n != null){
                Object elem = n.get();
                if (elem instanceof PilaEjecucion){
                    PilaEjecucion p = (PilaEjecucion) elem;
                    System.out.println(p.toString());
                }
                n = n.getSiguiente();
            }
            System.out.println(); // Línea en blanco después de la pila
        }
    }
}