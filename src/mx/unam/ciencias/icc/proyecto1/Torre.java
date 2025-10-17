package mx.unam.ciencias.icc.proyecto1;

class Torre extends Lista {

        //Attributes Torre
        int alturaMaxima;
        int posicion;
        int longitud; // discos en torres
        char nombre; 
    
    
        //Disco disco;

        //Constructor Torre
        public Torre(int alturaMaxima, int posicion, int longitud, char nombre){
            this.alturaMaxima = alturaMaxima;
            this.posicion = posicion;
            this.longitud = longitud;
            this.nombre = nombre;
       
        }

        public class Disco {
            //attributos disco
            private int radio;        

            //constructor Disco
            public Disco(int radio){
                this.radio = radio;
            }

            //get Radio
            public int getRadio(){
                return radio;
            }

            //set Radio
            public int setRadio(int radio){
                return radio;
            }

            @Override
            public String toString(){
                // formatea con dos dígitos, por ejemplo 01, 02, 10
                return String.format("%02d", radio);
            }


        }

        public String imprimeTorre(){
           //imprimir desde la base hacia la cima
           Lista rev = this.reversa();
           String s = "";
           Nodo n = rev.getCabeza();
           while(n != null){
               Object elem = n.get();
               if (elem instanceof Disco){
                   Disco d = (Disco)elem;
                   s = s + "[" + String.format("%02d", d.getRadio()) + "]";
               } else if (elem != null){
                   s = s + "[" + elem.toString() + "]";
               } else {
                   s = s + "[  ]";
               }
               n = n.getSiguiente();
           }
           return s;
        }

         public void mueve(Torre destino){

            if(destino instanceof Torre){
            //System.out.println("Moviendo disco de torre " + this.nombre + " a torre " + destino.nombre);
            //obtener nodo cabeza de la torre origen
            Lista.Nodo nodoOrigen = this.getCabeza();
            Disco discoDesplazado = null;
            if (nodoOrigen != null && nodoOrigen.get() instanceof Disco)
                discoDesplazado = (Disco) nodoOrigen.get();

            destino.agregaInicio(discoDesplazado);
            this.eliminaPrimero();
           
        }}

        public void agregaDisco(int radio){
            Disco nuevoDisco = new Disco(radio);
            this.agregaInicio(nuevoDisco);
        }

        public int setLongitud(int longitud){
            return longitud;
        }
        
    }    
    