package principal;

import ventanas.VentanaCombo;

public class Relaciones {

    public void iniciar() {

        VentanaCombo miVentanaCombo=new VentanaCombo();
        Coordinador miCoordinador=new Coordinador();

        //miVentanaCombo.setCoordinador(miCoordinador);
        //miCoordinador.setVentanaCombo(miVentanaCombo);

       // miCoordinador.cargarRegistro();
        miVentanaCombo.setVisible((true));
    }
}
