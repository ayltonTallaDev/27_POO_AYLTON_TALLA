package vallegrande.edu.pe.sistema_poo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import vallegrande.edu.pe.sistema_poo.controller.SocioController;
import vallegrande.edu.pe.sistema_poo.view.MainView;


public class Main extends Application {


    @Override
    public void start(Stage stage) {


        // Crear vista principal
        MainView view = new MainView();


        // Conectar controlador con la vista
        new SocioController(view);



        // Crear escena
        Scene scene = new Scene(view, 900, 600);



        // Configuración de ventana
        stage.setTitle(
                "Cooperativa Agraria Cafetalera Río Tambo"
        );


        stage.setScene(scene);


        stage.show();

    }



    public static void main(String[] args) {

        launch(args);

    }

}
