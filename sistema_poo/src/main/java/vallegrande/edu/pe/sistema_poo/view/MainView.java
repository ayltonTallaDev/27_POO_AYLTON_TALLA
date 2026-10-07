package vallegrande.edu.pe.sistema_poo.view;


import java.time.LocalDate;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;


import vallegrande.edu.pe.sistema_poo.model.Socio;



public class MainView extends BorderPane {



    private Button btnInicio;

    private Button btnSocios;

    private Button btnNuevoSocio;

    private Button btnActualizar;

    private Button btnEliminar;



    private TableView<Socio> tablaSocios;





    public MainView(){


        crearMenu();

        crearTabla();

        mostrarInicio();


    }






    // ==========================
    // CREAR MENU LATERAL
    // ==========================


    private void crearMenu(){


        VBox menu = new VBox(15);


        menu.setPadding(new Insets(25));


        menu.setPrefWidth(220);




        Label titulo = new Label(
                "COOPERATIVA\nRÍO TAMBO"
        );



        titulo.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );




        btnInicio = crearBoton("Inicio");


        btnSocios = crearBoton("Socios");



        btnNuevoSocio = crearBoton("Nuevo Socio");


        btnActualizar = crearBoton("Actualizar");


        btnEliminar = crearBoton("Eliminar");





        menu.getChildren().addAll(

                titulo,

                btnInicio,

                btnSocios

        );



        menu.setStyle(

                "-fx-background-color: #166534;"

        );



        setLeft(menu);


    }







    private Button crearBoton(String texto){


        Button boton = new Button(texto);


        boton.setPrefWidth(170);


        boton.setPrefHeight(40);



        return boton;


    }








    // ==========================
    // INICIO
    // ==========================


    public void mostrarInicio(){



        VBox contenido = new VBox(10);


        contenido.setAlignment(Pos.CENTER);



        Label titulo = new Label(
                "BIENVENIDO"
        );


        titulo.setStyle(
                "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;"
        );



        Label texto = new Label(

                "Sistema de gestión de socios\n" +
                        "Cooperativa Agraria Cafetalera Río Tambo"

        );



        contenido.getChildren().addAll(

                titulo,

                texto

        );



        setCenter(contenido);



    }








    // ==========================
    // PANTALLA SOCIOS
    // ==========================


    public void mostrarSocios(){


        VBox contenido = new VBox(20);



        contenido.setPadding(

                new Insets(30)

        );



        Label titulo = new Label(

                "SOCIOS"

        );



        titulo.setStyle(

                "-fx-font-size: 26px;" +
                        "-fx-font-weight: bold;"

        );






        HBox botones = new HBox(15);


        botones.setAlignment(

                Pos.CENTER_LEFT

        );



        botones.getChildren().addAll(

                btnNuevoSocio,

                btnActualizar,

                btnEliminar

        );






        contenido.getChildren().addAll(

                titulo,

                botones,

                tablaSocios

        );



        setCenter(contenido);



    }










    // ==========================
    // CREAR TABLA
    // ==========================


    private void crearTabla(){



        tablaSocios = new TableView<>();




        TableColumn<Socio,Integer> colId =
                new TableColumn<>("ID");


        TableColumn<Socio,String> colDni =
                new TableColumn<>("DNI");


        TableColumn<Socio,String> colNombres =
                new TableColumn<>("Nombres");


        TableColumn<Socio,String> colApellidos =
                new TableColumn<>("Apellidos");


        TableColumn<Socio,LocalDate> colFechaNacimiento =
                new TableColumn<>("Fecha Nacimiento");


        TableColumn<Socio,String> colSexo =
                new TableColumn<>("Sexo");


        TableColumn<Socio,String> colTelefono =
                new TableColumn<>("Teléfono");


        TableColumn<Socio,String> colDireccion =
                new TableColumn<>("Dirección");


        TableColumn<Socio,String> colComunidad =
                new TableColumn<>("Comunidad");


        TableColumn<Socio,LocalDate> colFechaIngreso =
                new TableColumn<>("Fecha Ingreso");


        TableColumn<Socio,String> colEstado =
                new TableColumn<>("Estado");






        colId.setCellValueFactory(
                new PropertyValueFactory<>("idSocio")
        );


        colDni.setCellValueFactory(
                new PropertyValueFactory<>("dni")
        );


        colNombres.setCellValueFactory(
                new PropertyValueFactory<>("nombres")
        );


        colApellidos.setCellValueFactory(
                new PropertyValueFactory<>("apellidos")
        );


        colFechaNacimiento.setCellValueFactory(
                new PropertyValueFactory<>("fechaNacimiento")
        );


        colSexo.setCellValueFactory(
                new PropertyValueFactory<>("sexo")
        );


        colTelefono.setCellValueFactory(
                new PropertyValueFactory<>("telefono")
        );


        colDireccion.setCellValueFactory(
                new PropertyValueFactory<>("direccion")
        );


        colComunidad.setCellValueFactory(
                new PropertyValueFactory<>("comunidad")
        );


        colFechaIngreso.setCellValueFactory(
                new PropertyValueFactory<>("fechaIngreso")
        );


        colEstado.setCellValueFactory(
                new PropertyValueFactory<>("estado")
        );






        tablaSocios.getColumns().addAll(

                colId,

                colDni,

                colNombres,

                colApellidos,

                colFechaNacimiento,

                colSexo,

                colTelefono,

                colDireccion,

                colComunidad,

                colFechaIngreso,

                colEstado

        );



    }








    // ==========================
    // CARGAR DATOS
    // ==========================


    public void mostrarDatosSocios(List<Socio> socios){



        tablaSocios.getItems().clear();



        tablaSocios.setItems(

                FXCollections.observableArrayList(socios)

        );



    }








    public Socio getSocioSeleccionado(){


        return tablaSocios.getSelectionModel()

                .getSelectedItem();


    }








    // ==========================
    // GETTERS
    // ==========================


    public Button getBtnInicio(){

        return btnInicio;

    }



    public Button getBtnSocios(){

        return btnSocios;

    }



    public Button getBtnNuevoSocio(){

        return btnNuevoSocio;

    }



    public Button getBtnActualizar(){

        return btnActualizar;

    }



    public Button getBtnEliminar(){

        return btnEliminar;

    }



    public TableView<Socio> getTablaSocios(){

        return tablaSocios;

    }



}