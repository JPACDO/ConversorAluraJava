package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.Convertir;

public class VentanaOpcionesTemperatura extends JFrame implements ActionListener {

    private JButton btn1, btn2;
    private JLabel lb1;
    private JComboBox<String> combo1;

    public VentanaOpcionesTemperatura(){

        setSize(230, 170);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setLayout(null);

        lb1 = new JLabel("Elije la temperatura a convertir");
        lb1.setBounds(10, 30, 200, 10);
        add(lb1);

        combo1 = new JComboBox<>();
        combo1.setBounds(10, 50, 190, 20);
        add(combo1);

        combo1.addItem("Celcius a Fahrenheit");
        combo1.addItem("Celcius a Kelvin");
        combo1.addItem("Fahrenheit a Celcius");
        combo1.addItem("Fahrenheit a Kelvin");
        combo1.addItem("Kelvin a Celcius");
        combo1.addItem("Kelvin a Fahrenheit");


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
                String resultado;
                switch (opcion) {
                    case 0:
                        resultado = Mensaje(Convertir.Celcius_to_Fahrenheit( VentanaMenuPrincipal.getValorOriginal()), "Fahrenheit");
                        break;
                    case 1:
                        resultado = Mensaje(Convertir.Celcius_to_Kelvin(VentanaMenuPrincipal.getValorOriginal()), "Kelvin");
                        break;
                    case 2:
                        resultado = Mensaje(Convertir.Fahrenheit_to_Celcius(VentanaMenuPrincipal.getValorOriginal()), "Celcius");
                        break;
                    case 3:
                        resultado = Mensaje(Convertir.Fahrenheit_to_Kelvin(VentanaMenuPrincipal.getValorOriginal()),"Kelvin");
                        break;
                    case 4:
                        resultado = Mensaje(Convertir.Kelvin_to_Celcius(VentanaMenuPrincipal.getValorOriginal()), "Celcius");
                        break;
                    case 5:
                        resultado = Mensaje(Convertir.Kelvin_to_Celcius(VentanaMenuPrincipal.getValorOriginal()), "Celcius");
                        break;
                    default:
                        resultado = Mensaje(Convertir.Kelvin_to_Fahrenheit(VentanaMenuPrincipal.getValorOriginal()), "Fahrenheit");
                        break;
                }
                JOptionPane.showMessageDialog(null, resultado, "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

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

    private String Mensaje(Double result, String unidad){
        return "EL resultado es: "+ result + "º "+ unidad; 
    }
}
