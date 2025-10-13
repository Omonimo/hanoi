import java.security.InvalidAlgorithmParameterException;

class Torre extends Lista {

        //Attributes Torre
        int discosEnTorre;
        int posicion;
        int longitud;
    
        //Disco disco;

        //Constructor Torre
        public Torre(int discosEnTorre, int posicion, int longitud){
            this.discosEnTorre = discosEnTorre;
            this.posicion = posicion;
            this.longitud = longitud;
       
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


        }

        //metodo mueve
/*         public static void mueve(Torre origen, Torre destino){

            if(origen instanceof Torre && destino instanceof Torre){
            //obtener el primer nodo de la torre origen
            Lista.Nodo nodoOrigen = origen.getCabeza();
            //instanciar nodo a mover
            Disco discoDesplazado = null;
            if (nodoOrigen != null && nodoOrigen.get() instanceof Disco)
                discoDesplazado = (Disco) nodoOrigen.get();
               
            //agregar disco a torre destino
            destino.agregaInicio(discoDesplazado);

            //eliminar disco de torre origen
            Lista.Nodo nodoDestino = destino.getCabeza();
            if (nodoDestino != null && nodoDestino.get() instanceof Disco) 
                origen.eliminaPrimero();
            } 
        } */

        public String imprimeTorre(Torre aImprimir){
            //conseguir 
            return aImprimir.reversa().toString(); 
        }

         public void mueve(Torre destino){

            if(destino instanceof Torre){
            //obtener el primer nodo de la torre origen
            Lista.Nodo nodoOrigen = this.getCabeza();
            Disco discoDesplazado = null;
            if (nodoOrigen != null && nodoOrigen.get() instanceof Disco)
                discoDesplazado = (Disco) nodoOrigen.get();

            destino.agregaInicio(discoDesplazado);
            this.eliminaPrimero();
           
        }}

        public void agregaDisco(double radio){
            Disco nuevoDisco = new Disco(radio);
            this.agregaInicio(nuevoDisco);
        }
        
    }    
    