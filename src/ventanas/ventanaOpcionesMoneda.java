package ventanas;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.Convertir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ventanaOpcionesMoneda extends JFrame implements ActionListener {
   
    private JButton btn1, btn2;
    private JLabel lb1;
    private JComboBox<String> combo1;
    private enum changesName {
                                    SOLESDORALES,
                                    SOLESEUROS,
                                    SOLESLIBRASESTERLINAS,
                                    SOLESYENES,
                                    SOLESWON,
                                    DORALESSOLES,
                                    EUROSSOLES,
                                    LIBRASSOLES,
                                    YENESSOLES,
                                    WONSOLES
                                };                       

    private Map<changesName, Double> map = new HashMap<changesName, Double>();
    public static Double factor;

    public static Double getFactor() {
        return factor;
    }

    public ventanaOpcionesMoneda(){
        map.put(changesName.SOLESDORALES, 0.28);
        map.put(changesName.SOLESEUROS, 0.25);
        map.put(changesName.SOLESLIBRASESTERLINAS, 0.22);
        map.put(changesName.SOLESYENES, 39.40);
        map.put(changesName.SOLESWON, 360.02);
        map.put(changesName.DORALESSOLES, 3.61);
        map.put(changesName.EUROSSOLES, 3.96);
        map.put(changesName.LIBRASSOLES, 4.63);
        map.put(changesName.YENESSOLES, 0.025);
        map.put(changesName.WONSOLES, 0.0028);

        setSize(230, 170);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setLayout(null);

        lb1 = new JLabel("Elije la moneda a la que deseas convertir tu dnero");
        lb1.setBounds(10, 30, 200, 10);
        // lb1.setSize(300, 20);
        add(lb1);

        combo1 = new JComboBox<>();
        combo1.setBounds(10, 50, 190, 20);
        // combo1.setSize(100, 20);
        add(combo1);
        combo1.addItem("Soles a Dolares");
        combo1.addItem("Soles a Euros");
        combo1.addItem("Soles a Libras Esterlinas");
        combo1.addItem("Soles a Yen Japonés");
        combo1.addItem("Soles a Won sul-coreano");
        combo1.addItem("Dolares a Soles");
        combo1.addItem("Euros a Soles");
        combo1.addItem("Libras Esterlinas a Soles");
        combo1.addItem("Yen Japonés a Soles");
        combo1.addItem("Won sul-coreano a Soles");

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


        VentanaMenuPrincipal ventanaMenu = new VentanaMenuPrincipal();

        if (e.getSource() == btn1) {
            try {
                int opcion = combo1.getSelectedIndex();
                factor = map.get(changesName.values()[opcion]);
                String resultado;
                switch (opcion) {
                    case 0:
                        resultado = Convertir.toDolares(VentanaMenuPrincipal.getValorOriginal(),factor);
                        break;
                    case 1:
                        resultado = Convertir.toEuros(VentanaMenuPrincipal.getValorOriginal(),factor);
                        break;
                    case 2:
                        resultado = Convertir.toLibrasEsterlinas(VentanaMenuPrincipal.getValorOriginal(),factor);
                        break;
                    case 3:
                        resultado = Convertir.toYen(VentanaMenuPrincipal.getValorOriginal(),factor);
                        break;
                    case 4:
                        resultado = Convertir.toWon(VentanaMenuPrincipal.getValorOriginal(),factor);
                        break;
                    default:
                        resultado = Convertir.toSoles(VentanaMenuPrincipal.getValorOriginal(),factor);
                        break;
                }
                JOptionPane.showMessageDialog(null, "Tienes " 
                                            + resultado,
                "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

                String[] options = {"Si", "No", "Cancelar"};
                int x = JOptionPane.showOptionDialog(null, "Desea continuar, regresando al menu principal","Select a option",
                                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                    null, options, options[0]);
                switch (x) {
                    case 0:
                        ventanaMenu.setVisible(true);
                        dispose();
                        break;
                
                    case 1:
                        JOptionPane.showMessageDialog(null, "Programa Terminado",
                        "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        break;
                
                    default:
                        break;
                }

            } catch (Exception exc) {
                System.out.println(exc);
            }

        } else if (e.getSource() == btn2) {
            VentanaMenuPrincipal ventanaInicio;
            ventanaInicio = new VentanaMenuPrincipal();
            ventanaInicio.setVisible(true);
            dispose();
        }
    }


}
