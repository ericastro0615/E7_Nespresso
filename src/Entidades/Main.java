package Entidades;

import ServicioNespresso.ServicioCafetera;
import ServicioNespresso.ServicioMenu;

public class Main {
    public static void main(String[] args) {
        ServicioCafetera sc = new ServicioCafetera();
        NespressoClass c1 = sc.confCafetera();
        System.out.println(sc.confCafetera().toString());
        ServicioMenu.Menu(c1);

    }
}