package ventanas;

import javax.swing.JOptionPane;

public class ventanaEntradaValor {

    public double getValue() throws Exception{
        String valor = JOptionPane.showInputDialog("Ingresa la cantidad  a convertir");
        try {
            return  Double.parseDouble(valor);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor no válido, solo valores enteros o con punto decimal",
            "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }

    }

}
