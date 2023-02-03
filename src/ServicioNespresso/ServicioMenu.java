package ServicioNespresso;

import Entidades.NespressoClass;

import java.util.Scanner;

public class ServicioMenu {

    private static int capActual;

    public static void Menu (NespressoClass c1) {
        Scanner sc = new Scanner (System.in).useDelimiter("\n");
        boolean bandera;

        do {
            System.out.printf("CAFETERA NESPRESSO: \n" +
                    "1= llenar cafetera \n" +
                    "2= servir taza \n" +
                    "3= vaciar cafetera \n" +
                    "4= agregar café \n" +
                    "5= Mostrar cantidad actual de café \n" +
                    "6= Salir\n");
            int opciones = sc.nextInt();

            switch (opciones) {
                case 1:
                    llenadoCafetera(c1);
                    System.out.println("UD. ha llenado la cafetera " );
                    break;
                case 2:
                    System.out.println("Ud. eligió servirse una taza de café- Qué capacidad tiene su taza a llenar ? \n" +
                            "1= taza de 150 \n" +
                            "2= taza de 200ml \n" +
                            "3= taza de 800ml \n");


                int opcLlenadoTazas = sc.nextInt();
                           do {
                               switch (opcLlenadoTazas) {
                                   case 1:
                                       servirCafe( 150, c1) ;
                                       break;
                                   case 2:
                                       servirCafe( 200, c1) ;
                                       break;
                                   case 3:
                                       servirCafe( 800, c1);
                                    break;

                                   default:
                                       System.out.println("Opcion incorrecta, elija un tamaño de taza correcto");
                               }

                }while (opcLlenadoTazas>0 && opcLlenadoTazas>3);

                case 3:
                    vaciarCafetera (c1);
                    break;
                case 4:
                    agregarCafe(c1);
                    break;
                case 5:
                    mostrarCantCafe(c1);
                    break;
                case 6:
                    //Salir (bandera);

            }


        } while (bandera = true);
    }



    //llenado de cafetera capActual = capMax
    public static void llenadoCafetera (NespressoClass c1) {
         c1.setCapacidadMaxima(1000);
        c1.setCapacidadActual(1000);
        System.out.println("la capacidad actual es "+ c1.getCapacidadActual() +("\n"));

    }

    //servir café
    public static void servirCafe (int tamanio, NespressoClass c1) {

        if(tamanio > c1.getCapacidadActual()) {
            System.out.println(" Solo hay " + ( c1.getCapacidadActual()) + "ml. de café. Sirviendo... \n");
          c1.setCapacidadActual(0);
        }
        else if(c1.getCapacidadActual()>tamanio){
            System.out.println("llenando taza con" + tamanio + "ml.");
            c1.setCapacidadActual(c1.getCapacidadActual()-tamanio);
            System.out.println("Queda " + c1.getCapacidadActual()+" café");
        }
        else {
            System.out.println("No hay más café :( \n");
        }
        System.out.println("\n");
    }

    public static void vaciarCafetera (NespressoClass c1) {
        c1.setCapacidadActual(0);
    }

    public static void agregarCafe (NespressoClass c1) {
        int cantAgregada;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        System.out.println("cuanto café querés agregar? ");
        cantAgregada = sc.nextInt();
        if (c1.getCapacidadMaxima()>= (c1.getCapacidadActual()+cantAgregada) ){
            /*if ( c1.getCapacidadActual() ){
                System.out.println("agregando " + cantAgregada + "ml");
                capActual= c1.getCapacidadActual()+cantAgregada;
                c1.setCapacidadActual(capActual);
                System.out.println("aprende a hacer el debug . Cap actual luego de llenar " + capActual);*/
            System.out.println("cap act "+ c1.getCapacidadActual());
            c1.setCapacidadActual( c1.getCapacidadActual()+cantAgregada );
            System.out.println("aprende a hacer el debug . Cap actual luego de llenar " + (c1.getCapacidadActual()));
            } else if ( (c1.getCapacidadMaxima()-c1.getCapacidadActual() ) > cantAgregada)  {
            System.out.println("La cafetera esta a punto de llenarse. Sólo se agrego " + (c1.getCapacidadMaxima()-cantAgregada ));

        }
        else {
            System.out.println("la cafetera tiene 1l de capacidad. Es demasiado café para agregar");
            // c1.setCapacidadActual(c1.getCapacidadMaxima());
        }

    }

    public static void mostrarCantCafe (NespressoClass c1) {
        System.out.println("mostrandoooooo   " + c1.getCapacidadActual()+" café");
    }

    public static void Salir (boolean bandera) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Quéres salir? S /N ");
        String salir = sc.next();
        if (salir=="S") {
            bandera = true;
        }
    }





}
