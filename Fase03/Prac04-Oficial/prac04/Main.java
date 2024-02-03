/*
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
*/
public class Main /* extends Application */ {
    public static void main(String[] args) {
        Conectar conexion1 = new Conectar();
		conexion1.conexion();
		partidaRapida();
    }
    public static void partidaRapida() {
		Ventana v = new Ventana();
        // Crea la instancia de la GUI
        TerminalGUI terminalGUI = new TerminalGUI();

        // Muestra la ventana
        terminalGUI.setVisible(true);

        // Simula la información que se imprimiría en el terminal
        System.out.println("****************************************************");
        System.out.println("Los soldados creados para el ejercito Azul");
        System.out.println("****************************************************"); 
        Ejercito e1 = new Ejercito(1);
        System.out.println("****************************************************");
        System.out.println("Los soldados creados para el ejercito Rojo");    
        System.out.println("****************************************************"); 
        Ejercito e2 = new Ejercito(2); 
        v.asignarAlTablero(e1);
        v.asignarAlTablero(e2);
        terminalGUI.mostrarEnVentana();
    }

    /*
     * public static void main(String[] args) {
     * launch(args);
     * }
     * 
     * @Override
     * public void start(Stage primaryStage) {
     * Button btn = new Button("JUGAR");
     * primaryStage.setTitle("INICIO DEL JUEGO");
     * 
     * StackPane root = new StackPane();
     * 
     * // Cargar la imagen
     * Image backgroundImage = new
     * Image(getClass().getResourceAsStream("/Img/Portada.jpg"));
     * 
     * // Crear un ImageView con la imagen
     * ImageView backgroundImageView = new ImageView(backgroundImage);
     * 
     * // Ajustar el tamaño preferido del StackPane para que coincida con el tamaño
     * de la imagen
     * root.setPrefSize(backgroundImage.getWidth(), backgroundImage.getHeight());
     * 
     * // Añadir el ImageView al StackPane
     * root.getChildren().add(backgroundImageView);
     * 
     * // Aplicar estilos al botón
     * btn.setPrefSize(100, 60);
     * btn.setStyle(
     * "-fx-font-size: 18; " +
     * "-fx-background-color: #4CAF50; " +
     * "-fx-text-fill: white; " +
     * "-fx-border-color: #45a049; " +
     * "-fx-border-width: 2; " +
     * "-fx-border-radius: 5; " +
     * "-fx-background-radius: 5; " +
     * "-fx-padding: 10 20; " +
     * "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 10, 0, 0, 0);"
     * );
     * btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
     * 
     * @Override public void handle(MouseEvent e) {
     * btn.setStyle("-fx-background-color: #5EBE5E;"+
     * "-fx-font-size: 18; " +
     * "-fx-text-fill: white; ");
     * }
     * });
     * btn.setOnMouseExited(new EventHandler<MouseEvent>() {
     * 
     * @Override public void handle(MouseEvent e) {
     * btn.setStyle("-fx-background-color: #4CAF50;"+
     * "-fx-font-size: 18; " +
     * "-fx-text-fill: white; ");
     * }
     * });
     * 
     * btn.setOnAction(event -> {
     * Ventana v = new Ventana();
     * Ejercito e1 = new Ejercito(1);
     * Ejercito e2 = new Ejercito(2);
     * v.asignarAlTablero(e1);
     * v.asignarAlTablero(e2);
     * });
     * 
     * // Desplazar el botón "JUGAR" 110 píxeles hacia abajo
     * btn.setTranslateY(110);
     * 
     * root.getChildren().add(btn);
     * 
     * Scene scene = new Scene(root);
     * primaryStage.setScene(scene);
     * 
     * primaryStage.show();
     * 
     * }
     */
}
