package vallegrande.edu.pe.minijuego;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Random;

public class CachipunController {

    @FXML private Label lblJugador;
    @FXML private Label lblPC;
    @FXML private Label lblResultado;
    @FXML private Label lblPuntosJugador;
    @FXML private Label lblPuntosPC;

    @FXML private Button btnPiedra;
    @FXML private Button btnPapel;
    @FXML private Button btnTijera;

    private int puntosJugador = 0;
    private int puntosPC = 0;
    private final Random random = new Random();

    private final String[] emojis = {"👊", "✋", "✌️"};
    private final String[] nombres = {"Piedra", "Papel", "Tijera"};

    // Colores de feedback
    private static final String COLOR_GANA = "-fx-text-fill: #06a77d; -fx-font-size: 17px; -fx-font-weight: bold;";
    private static final String COLOR_PIERDE = "-fx-text-fill: #d90429; -fx-font-size: 17px; -fx-font-weight: bold;";
    private static final String COLOR_EMPATE = "-fx-text-fill: #f77f00; -fx-font-size: 17px; -fx-font-weight: bold;";

    @FXML
    public void jugarPiedra() {
        jugar(0);
    }

    @FXML
    public void jugarPapel() {
        jugar(1);
    }

    @FXML
    public void jugarTijera() {
        jugar(2);
    }

    private void jugar(int jugada) {
        // Evita doble clic mientras se muestra el resultado
        setBotonesHabilitados(false);

        int jugadaPC = random.nextInt(3);

        lblJugador.setText(emojis[jugada]);
        lblPC.setText(emojis[jugadaPC]);

        int resultado = determinarGanador(jugada, jugadaPC);

        if (resultado == 0) {
            lblResultado.setText("¡Empate! Ambos eligieron " + nombres[jugada]);
            lblResultado.setStyle(COLOR_EMPATE);
        } else if (resultado == 1) {
            puntosJugador++;
            lblResultado.setText("¡Ganaste! " + nombres[jugada] + " le gana a " + nombres[jugadaPC]);
            lblResultado.setStyle(COLOR_GANA);
        } else {
            puntosPC++;
            lblResultado.setText("Perdiste. " + nombres[jugadaPC] + " le gana a " + nombres[jugada]);
            lblResultado.setStyle(COLOR_PIERDE);
        }

        lblPuntosJugador.setText("Tú: " + puntosJugador);
        lblPuntosPC.setText("PC: " + puntosPC);

        // Reactiva los botones tras una breve pausa
        PauseTransition pausa = new PauseTransition(Duration.seconds(0.8));
        pausa.setOnFinished(e -> setBotonesHabilitados(true));
        pausa.play();
    }

    private void setBotonesHabilitados(boolean habilitados) {
        btnPiedra.setDisable(!habilitados);
        btnPapel.setDisable(!habilitados);
        btnTijera.setDisable(!habilitados);
    }

    private int determinarGanador(int jugador, int pc) {
        if (jugador == pc) return 0;
        if ((jugador == 0 && pc == 2) ||
                (jugador == 1 && pc == 0) ||
                (jugador == 2 && pc == 1)) {
            return 1;
        }
        return -1;
    }

    @FXML
    public void reiniciar() {
        puntosJugador = 0;
        puntosPC = 0;
        lblJugador.setText("❓");
        lblPC.setText("❓");
        lblResultado.setText("Elige tu jugada");
        lblResultado.setStyle("-fx-font-size: 16px; -fx-text-fill: #4a4e69;");
        lblPuntosJugador.setText("Tú: 0");
        lblPuntosPC.setText("PC: 0");
        setBotonesHabilitados(true);
    }
}
