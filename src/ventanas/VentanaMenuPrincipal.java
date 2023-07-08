package ventanas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaMenuPrincipal extends JFrame implements ActionListener {

    private JButton btn1, btn2;
    private JLabel lb1;
    private JComboBox<String> combo1;
    private static Double valorOriginal;

    public static Double getValorOriginal() {
        return valorOriginal;
    }

    public VentanaMenuPrincipal() {
        setSize(230, 170);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setLayout(null);

        lb1 = new JLabel("Selecciona el tipo de conversión");
        lb1.setBounds(10, 30, 200, 10);
        // lb1.setSize(300, 20);
        add(lb1);

        combo1 = new JComboBox<>();
        combo1.setBounds(10, 50, 190, 20);
        // combo1.setSize(100, 20);
        add(combo1);
        combo1.addItem("Moneda");
        combo1.addItem("Temperatura");

        btn1 = new JButton();
        btn1.setText("OK");
        btn1.setBounds(10, 80, 90, 30);
        // btn1.setSize(100, 20);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton();
        btn2.setText("Cancelar");
        btn2.setBounds(110, 80, 90, 30);
        btn2.addActionListener(this);
        add(btn2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            // JOptionPane.showMessageDialog(null, "Boton presionado");
            // lb1.setText("Boton Presionado 1");
            // valorOriginal = Double.parseDouble(JOptionPane.showInputDialog("Ingresa a
            // cantidad de dinero a convertir"));
            try {
                valorOriginal = new ventanaEntradaValor().getValue();
                int opcion = combo1.getSelectedIndex();
                switch (opcion) {
                    case 0:
                        System.out.println("opcion 0 monedas");
                        ventanaOpcionesMoneda ventanaOpciones = new ventanaOpcionesMoneda();
                        ventanaOpciones.setVisible(true);
                        dispose();
                        break;
                    case 1:
                        System.out.println("opcion 1 temperatura");
                        VentanaOpcionesTemperatura ventanaOpciones2 = new VentanaOpcionesTemperatura();
                        ventanaOpciones2.setVisible(true);
                        dispose();
                        break;
                
                    default:
                        break;
                }
                System.out.println(valorOriginal + " " + opcion);
            } catch (Exception exc) {
                System.out.println(exc);
            }

        } else if (e.getSource() == btn2) {
            // lb1.setText("Boton Presionado 2");
            dispose();
        }
    }
}
