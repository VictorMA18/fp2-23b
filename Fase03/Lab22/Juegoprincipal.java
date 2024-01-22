import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Juegoprincipal{
    public static void main(String[] args) {
        JFrame ventanaBienvenida = new JFrame("MENU DE BATALLA");
        ventanaBienvenida.setSize(350, 145);
        ventanaBienvenida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelPrincipal = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));
        JLabel mensajeLabel = new JLabel("¿Desea iniciar el juego?");
        JButton botonSi = new JButton("Sí");
        JButton botonNo = new JButton("No");
        botonSi.setBackground(Color.GREEN);
        botonNo.setBackground(Color.RED);
        panelPrincipal.add(mensajeLabel);
        panelPrincipal.add(botonSi);
        panelPrincipal.add(botonNo);
        botonSi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {             
                ventanaBienvenida.dispose();
                Mapa mapa = new Mapa();
                mapa.iniciarJuego();
            }
        });
        botonNo.addActionListener(new ActionListener() {              
            public void actionPerformed(ActionEvent e) {
        	    ventanaBienvenida.dispose();
        	    JOptionPane.showMessageDialog(null, "Programa finalizado.");
            }
        });
        ventanaBienvenida.add(panelPrincipal);
        ventanaBienvenida.setLocationRelativeTo(null); 
        ventanaBienvenida.setVisible(true);      
    }
}