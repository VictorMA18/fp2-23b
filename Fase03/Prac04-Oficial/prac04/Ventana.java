import java.awt.*;
import java.awt.event.*;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.*;

public class Ventana extends JFrame {

    ImageIcon imgLancero;
    ImageIcon imgArquero;
    ImageIcon imgCaballero;
    ImageIcon imgEspadachin;
    JButton[][] casilleros;
    boolean seleccionado = false;
    JButton origen;
    JButton destino;
    Jugador j1, j2, jActual;

    Ventana() {
        setTitle("Juego");
        casilleros = new JButton[10][10];
        setSize(650, 650);
        // setLayout ordena los casilleros[x][y] de forma automatica en una tablero de
        // 10x10
        setLayout(new GridLayout(10, 10));
        barraDeMenu();
        // se ingresan y redimensionan las imagenes a iconos de 50x50 px
        generarImagenes();
        // se inicializa los casilleros y se generan mismos eventos (de movimiento) para
        // cada boton
        generarTablero();
        WriteLog.writeFile("***Se inicio una nueva partida***");
        j1 = new Jugador("Jugador Azul", Color.blue);
        j2 = new Jugador("Jugador Rojo", Color.red);
        jActual = j1;
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // memoria ram consumida
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                Runtime runtime = Runtime.getRuntime();
                long ramTotal = runtime.totalMemory() / (1024 * 1024);
                long ramLibre = runtime.freeMemory() / (1024 * 1024);
                long ramUsada = (ramTotal - ramLibre);
                System.out.println("Memoria ram usada: " + ramUsada + " MB");
            }
        });

    }

    private void barraDeMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem cargar = new JMenuItem("Cargar");
        JMenuItem salir = new JMenuItem("Salir");
        JMenuItem nPartida = new JMenuItem("Nueva Partida");
        // evento para crear una nueva partida
        nPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetearTablero();
                WriteLog.writeFile("***Se inicio una nueva partida***");
                TerminalGUI terminalGUI1 = new TerminalGUI();
                // Muestra la ventana
                terminalGUI1.setVisible(true);
                System.out.println("****************************************************");
                System.out.println("***Se inicio una nueva partida***");
                System.out.println("****************************************************");
                System.out.println("****************************************************");
                System.out.println("Los soldados creados para el ejercito Azul");
                System.out.println("****************************************************");
                Ejercito e1 = new Ejercito(1);
                System.out.println("****************************************************");
                System.out.println("Los soldados creados para el ejercito Rojo");
                System.out.println("****************************************************");
                Ejercito e2 = new Ejercito(2);
                Ventana.this.asignarAlTablero(e1);
                Ventana.this.asignarAlTablero(e2);
                terminalGUI1.mostrarEnVentana();
            }
        });
        menuArchivo.add(nPartida);
        menuArchivo.add(guardar);
        menuArchivo.add(cargar);
        menuArchivo.add(salir);
        menuBar.add(menuArchivo);
        JMenu menuConfigurar = new JMenu("Configurar");
        menuBar.add(menuConfigurar);
        JMenu menuOpciones = new JMenu("Opciones");
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

    }

    // Se asigna valores nulos a todo el tablero sin quitar sus eventos
    private void resetearTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                casilleros[i][j].setIcon(null);
                casilleros[i][j].putClientProperty("color", null);
                casilleros[i][j].putClientProperty("soldado", null);
                casilleros[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                casilleros[i][j].setEnabled(true);
            }
        }
    }

    private void generarImagenes() {
        // imagen Lancero
        this.imgLancero = new ImageIcon("./Img/Lancero.jpg");
        Image img = this.imgLancero.getImage().getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE);
        this.imgLancero.setImage(img);
        // imagen Arquero
        this.imgArquero = new ImageIcon("./Img/Arquero.jpg");
        img = this.imgArquero.getImage().getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE);
        this.imgArquero.setImage(img);
        // imagen Caballero
        this.imgCaballero = new ImageIcon("./Img/Caballero.jpg");
        img = this.imgCaballero.getImage().getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE);
        this.imgCaballero.setImage(img);
        // imagen Espadachin
        this.imgEspadachin = new ImageIcon("./Img/Espadachin.jpg");
        img = this.imgEspadachin.getImage().getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE);
        this.imgEspadachin.setImage(img);
    }

    public void generarTablero() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                this.casilleros[i][j] = new JButton();
                this.casilleros[i][j].setBackground(Color.white);
                // evento para el moviento al hacer click
                this.casilleros[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x = 0, y = 0;
                        JButton b = (JButton) e.getSource();
                        for (int i = 0; i < 10; i++) {
                            for (int j = 0; j < 10; j++) {
                                if (casilleros[i][j] == b) {
                                    x = i;
                                    y = j;
                                    break;
                                }
                            }
                        }
                        // pregunta si ya existe un casillero seleccionado
                        if (!seleccionado) {
                            // si es asi, el casillero seleccionado se asigna a origen
                            origen = casilleros[x][y];
                            origen.setBackground(Color.black);
                            seleccionado = true;
                        } else {
                            // si no, el casillero seleccionado se asigna a destino
                            destino = casilleros[x][y];
                            seleccionado = false;
                            // se verifica el turno
                            if (verificarTurno()) {
                                // si el casillero de destino es color blanco se mueve
                                if ((Soldado) destino.getClientProperty("soldado") == null) {
                                    mover();
                                    cambiarTurno();
                                } else if ((Color) origen.getClientProperty("color") != (Color) destino
                                        .getClientProperty("color")) {
                                    // si el casillero de destino es un enemigo, se abre una lucha
                                    // luego se posiciona al ganador
                                    JButton ganador = lucha(origen, destino);
                                    if (ganador == destino) {
                                        Soldado soldado = (Soldado) origen.getClientProperty("soldado");
                                        WriteLog.writeFile(soldado.getNombre() + " se movio a la posición: ("
                                                + getX(destino) + "," + getY(destino) + ")"); // Registro en log
                                    }

                                    if (ganador == destino) {

                                        origen.putClientProperty("soldado", null);
                                        origen.putClientProperty("color", null);
                                        origen.setIcon(null);
                                        origen.setBorder(BorderFactory.createLineBorder(Color.black));
                                        cambiarTurno();
                                    } else if (ganador != destino) {
                                        mover();
                                        cambiarTurno();
                                    }

                                }
                            }
                            origen.setBackground(Color.white);
                            // se verifica si exite un ganador
                            verificarTablero();

                        }

                    }
                });
                this.casilleros[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                this.add(casilleros[i][j]);
            }
        }
    }

    public void cambiarTurno() {
        if (jActual == j1) {
            jActual = j2;
        } else {
            jActual = j1;
        }

        JOptionPane.showMessageDialog(rootPane, "Turno de " + jActual.getNombre(), getTitle(), 1);

    }

    private boolean verificarTurno() {
        if ((Color) origen.getClientProperty("color") == (Color) jActual.getColor()) {
            return true;
        } else if ((Color) origen.getClientProperty("color") == null) {
            JOptionPane.showMessageDialog(rootPane, "Espacio en blanco, no puedes mover", getTitle(), 0);
            return false;
        } else {
            JOptionPane.showMessageDialog(rootPane, "No puedes mover las piezas del otro jugador.", getTitle(), 0);
            return false;
        }
    }

    // se hace una cantabilizacion de soldados
    // si hay un ganador , el tablero es bloqueado
    private void verificarTablero() {
        int cantidadAzul = 0;
        int cantidadRoja = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (casilleros[i][j].getClientProperty("color") == Color.blue) {
                    cantidadAzul++;
                } else if (casilleros[i][j].getClientProperty("color") == Color.red) {
                    cantidadRoja++;
                }
            }
        }
        System.out.println("Azules:" + cantidadAzul + "\nRojos:" + cantidadRoja);
        if (cantidadAzul == 0) {
            JOptionPane.showMessageDialog(rootPane, "Gana rojo", getTitle(), 0);
            bloquearTablero();
            WriteLog.writeFile("Todos los soldados azules han muerto. ¡Gana el jugador rojo!");

        }
        if (cantidadRoja == 0) {
            JOptionPane.showMessageDialog(rootPane, "Gana azul", getTitle(), 0);
            bloquearTablero();
            WriteLog.writeFile("Todos los soldados rojos han muerto. ¡Gana el jugador azul!");
        }
    }

    // mueve los datos del casillero de origen al casillero de destino
    // luego se asignan valores nulos al casillero de origen
    private void mover() {

        Soldado soldado = (Soldado) origen.getClientProperty("soldado");
        Color colorOrigen = (Color) origen.getClientProperty("color");
        destino.putClientProperty("soldado", soldado);
        destino.putClientProperty("color", colorOrigen);
        destino.setBorder(origen.getBorder());
        asignarSoldado(getX(destino), getY(destino), soldado);
        origen.setIcon(null);
        origen.putClientProperty("soldado", null);
        origen.putClientProperty("color", null);
        origen.setBorder(BorderFactory.createLineBorder(Color.black));
        WriteLog.writeFile(soldado.getNombre() + " se movio a la posición: ("
                + getX(destino) + "," + getY(destino) + ")"); // Registro en log

    }

    // retorna la coordenada x de un casillero
    public int getX(JButton b) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (casilleros[i][j] == b)
                    return i;
            }
        }
        return -1;
    }

    // retorna la coordenada y de un casillero
    public int getY(JButton b) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (casilleros[i][j] == b)
                    return j;
            }
        }
        return -1;
    }

    // este metodo asigna los ejercitos creados a un casillero aleatorio en el
    // tablero
    public void asignarAlTablero(Ejercito e) {

        Soldado[] ejercito = e.getSoldados();
        int i = 0, x, y;
        while (i < ejercito.length) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (comprobar(x, y)) {
                asignarSoldado(x, y, ejercito[i]);
                this.casilleros[x][y].setBorder(BorderFactory.createLineBorder(e.getColor(), 2));
                this.casilleros[x][y].putClientProperty("reino", e.getReino());
                this.casilleros[x][y].putClientProperty("color", e.getColor());
                i++;
            }
        }
    }

    public boolean comprobar(int x, int y) {
        if (this.casilleros[x][y].getIcon() == null)
            return true;
        return false;
    }

    // este metodo asigna al soldado a su respectivo casillero, evalua su
    // tipo(lancero, caballero,...)
    // luego se le asigna un icono
    public void asignarSoldado(int x, int y, Soldado s) {
        int t = s.getTipo();
        if (t == 0) {
            this.casilleros[x][y].setIcon(imgArquero);
            this.casilleros[x][y].putClientProperty("soldado", s);
        }
        if (t == 1) {
            this.casilleros[x][y].setIcon(imgCaballero);
            this.casilleros[x][y].putClientProperty("soldado", s);
        }
        if (t == 2) {
            this.casilleros[x][y].setIcon(imgEspadachin);
            this.casilleros[x][y].putClientProperty("soldado", s);
        }
        if (t == 3) {
            this.casilleros[x][y].setIcon(imgLancero);
            this.casilleros[x][y].putClientProperty("soldado", s);
        }
    }

    // metodo que devuelve al ganador de una batalla cuando se ubican 2 soldados de
    // distintos bandos
    // en un mismo casillero
    private JButton lucha(JButton b1, JButton b2) {
        Soldado s1 = (Soldado) b1.getClientProperty("soldado");
        Soldado s2 = (Soldado) b2.getClientProperty("soldado");
        int vidaTotal1 = s1.getDefensa() + s1.getDefensa();
        int vidaTotal2 = s2.getDefensa() + s2.getDefensa();
        int r = 1;
        while (r == 1) {
            vidaTotal2 -= s1.getAtaque();
            vidaTotal1 -= s2.getAtaque();
            if (vidaTotal1 <= 0) {
                s2.setVida(vidaTotal2);
                b2.putClientProperty("soldado", s2);
                WriteLog.writeFile("El soldado " + s1.getNombre() + " murio en la lucha"); // Registro en Log
                return b2;
            } else if (vidaTotal2 <= 0) {
                s1.setVida(vidaTotal1);
                b1.putClientProperty("soldado", s1);
                WriteLog.writeFile("El soldado " + s2.getNombre() + " murio en la lucha"); // Registro en Log
                return b1;
            }
        }
        return null;

    }

    private void bloquearTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                casilleros[i][j].setEnabled(false);
            }
        }
    }
}
