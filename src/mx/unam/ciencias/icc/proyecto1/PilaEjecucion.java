/* class PilaEjecucion extends Lista {
    private int a;
    private int b;
    private int c;    
    private int disco;     
    private char tipo; // It's best practice to make fields private

    public PilaEjecucion(int a, int b, int c, int disco, char tipo) {
        this.a = a; 
        this.b = b; 
        this.c = c;
        this.disco = disco;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String etiqueta = (tipo == ' ') ? " " : String.valueOf(tipo);
        
        return String.format("[ %d %d %d %02d %s ]", a, b, c, disco, etiqueta);
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getTipo() {
        return tipo;
    }   
} */

// PilaEjecucion.java

class PilaEjecucion extends Lista {
    private int a;
    private int b;
    private int c;    
    private int discos; 
    private char tipo; 

    public PilaEjecucion(int a, int b, int c, int discos, char tipo) {
        this.a = a; 
        this.b = b; 
        this.c = c;
        this.discos = discos;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String etiqueta = (tipo == '\0' || tipo == ' ') ? " " : String.valueOf(tipo);
        return String.format("[ %d %d %d %02d %s ]", a, b, c, discos, etiqueta);
    }
    // setTipo and getTipo are correct
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    public char getTipo() {
        return tipo;
    }   
}