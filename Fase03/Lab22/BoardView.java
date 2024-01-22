
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class BoardView extends JFrame {

    private static final String[] COLUMN_LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public BoardView(ArrayList<ArrayList<Soldado>> army1, ArrayList<ArrayList<Soldado>> army2) {
        setTitle("Tablero de Batalla");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(12, 12));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenuItem exitMenuItem = new JMenuItem("Salir");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Configurar el tamaño predeterminado de la ventana
        setSize(100, 800);

        mainPanel.add(new JLabel(" "));
        for (String letter : COLUMN_LETTERS) {
            mainPanel.add(new JLabel("   " + letter));
        }

        mainPanel.add(new JLabel("  "));
        for (String letter : COLUMN_LETTERS) {
            mainPanel.add(new JLabel("   " + letter));
        }

        for (int i = 0; i < 10; i++) {
            mainPanel.add(new JLabel(String.valueOf(i + 1)));
            for (int j = 0; j < 10; j++) {
                JLabel label = new JLabel();
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                label.setHorizontalAlignment(JLabel.CENTER);

                if (army1.get(i).get(j) != null && army2.get(i).get(j) != null) {
                    if(army1.get(i).get(j).getLifeActual() > army2.get(i).get(j).getLifeActual()){
                        army1.get(i).get(j).setLifeActual(army1.get(i).get(j).getLifeActual() - army2.get(i).get(j).getLifeActual()); //Cambiamos 
                        army2.get(i).set(j, null); 
                        label.setText("1" + obtenerInicial(army1.get(i).get(j)) + army1.get(i).get(j).getLifeActual());
                    }else if(army2.get(i).get(j).getLifeActual() > army1.get(i).get(j).getLifeActual()){
                        army2.get(i).get(j).setLifeActual(army2.get(i).get(j).getLifeActual() - army1.get(i).get(j).getLifeActual());
                        army1.get(i).set(j, null);;
                        label.setText("2" + obtenerInicial(army2.get(i).get(j)) + army2.get(i).get(j).getLifeActual());
                    }else{
                        army2.get(i).set(j, null);
                        army1.get(i).set(j, null);
                    }
                } else if (army1.get(i).get(j) != null) {
                    label.setText("1" + obtenerInicial(army1.get(i).get(j)) + army1.get(i).get(j).getLifeActual());
                } else if (army2.get(i).get(j) != null) {
                    label.setText("2" + obtenerInicial(army2.get(i).get(j)) + army2.get(i).get(j).getLifeActual());
                }
                mainPanel.add(label);
            }
        }

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static String obtenerInicial(Soldado soldado) {
        if (soldado instanceof Espadachin) {
            return "E";
        } else if (soldado instanceof Arquero) {
            return "A";
        } else if (soldado instanceof Caballero) {
            return "C";
        } else if (soldado instanceof Lancero) {
            return "L";
        } else if (soldado instanceof EspadachinReal){
            return "ER";
        } else if (soldado instanceof CaballeroFranco){
            return "CF";
        } else if (soldado instanceof EspadachinTeutonico){
            return "ET";
        } else if (soldado instanceof EspadachinConquistador){
            return "EC";
        } else if (soldado instanceof CaballeroMoro){
            return "CM";
        }else{
            return " ";
        }
    }
}