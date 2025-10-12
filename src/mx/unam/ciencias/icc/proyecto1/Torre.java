import java.security.InvalidAlgorithmParameterException;

class Torre extends Lista {

        //Attributes Torre
        double discosEnTorre;
        double posicion;
        double alturaMaxima;
        double sinDisco = alturaMaxima - discosEnTorre;
        //Disco disco;

        //Constructor Torre
        public Torre(double discos, double posicion){
            this.discosEnTorre = discosEnTorre;
            this.posicion = posicion;
            this.alturaMaxima = alturaMaxima;

        }

        public class Disco {
            //attributos disco
            private double radio;        

            //constructor Disco
            public Disco(double radio){
                this.radio = radio;
            }

            //get Radio
            public double getRadio(){
                return radio;
            }

            //set Radio
            public double setRadio(double radio){
                return radio;
            }


        }

        //metodo mueve
      
//metodo espaciosDisco, cada espacio dentro del disco es un unaidad de radio
        public String estadoTorre(double alturaMaxima, double discosEnTorre, double sinDisco){
            //radios de disco rerepsentados por espacios en blanco, sin discops se ve la torre |
            

        }
        
    }    
    