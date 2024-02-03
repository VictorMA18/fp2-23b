import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.OutputStream;
import java.io.PrintStream;


public class TerminalGUI extends JFrame {

    private JTextArea textArea;
    private StringBuffer outputBuffer;

    public TerminalGUI() {
        setTitle("Terminal GUI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);

        outputBuffer = new StringBuffer();

        // Redirige la salida estándar al JTextArea
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                outputBuffer.append((char) b);
            }
        }));
    }

    public void mostrarEnVentana() {
        textArea.append(outputBuffer.toString());
        outputBuffer.setLength(0); // Limpia el buffer después de mostrar en la ventana
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}

