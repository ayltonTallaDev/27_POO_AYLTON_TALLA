package vallegrande.edu.pe.sistema_poo.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import vallegrande.edu.pe.sistema_poo.model.Socio;
import vallegrande.edu.pe.sistema_poo.dao.SocioDAO;


public class SocioForm {


    private TextField txtDni;
    private TextField txtNombres;
    private TextField txtApellidos;
    private DatePicker dpFechaNacimiento;
    private ComboBox<String> cbSexo;
    private TextField txtTelefono;
    private TextField txtDireccion;
    private TextField txtComunidad;
    private DatePicker dpFechaIngreso;
    private ComboBox<String> cbEstado;

    private Button btnGuardar;

    private SocioDAO socioDAO = new SocioDAO();

    public void mostrar() {


        Stage ventana = new Stage();

        ventana.setTitle("Registrar Socio");



        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20));

        grid.setHgap(10);

        grid.setVgap(10);



        // Campos

        txtDni = new TextField();
        txtNombres = new TextField();
        txtApellidos = new TextField();

        dpFechaNacimiento = new DatePicker();

        cbSexo = new ComboBox<>();
        cbSexo.getItems().addAll(
                "Masculino",
                "Femenino"
        );


        txtTelefono = new TextField();

        txtDireccion = new TextField();

        txtComunidad = new TextField();


        dpFechaIngreso = new DatePicker();


        cbEstado = new ComboBox<>();
        cbEstado.getItems().addAll(
                "Activo",
                "Inactivo"
        );



        btnGuardar = new Button("Guardar");

        btnGuardar.setOnAction(e -> guardarSocio());



        // Diseño

        grid.add(new Label("DNI:"),0,0);
        grid.add(txtDni,1,0);


        grid.add(new Label("Nombres:"),0,1);
        grid.add(txtNombres,1,1);


        grid.add(new Label("Apellidos:"),0,2);
        grid.add(txtApellidos,1,2);


        grid.add(new Label("Fecha nacimiento:"),0,3);
        grid.add(dpFechaNacimiento,1,3);


        grid.add(new Label("Sexo:"),0,4);
        grid.add(cbSexo,1,4);


        grid.add(new Label("Teléfono:"),0,5);
        grid.add(txtTelefono,1,5);


        grid.add(new Label("Dirección:"),0,6);
        grid.add(txtDireccion,1,6);


        grid.add(new Label("Comunidad:"),0,7);
        grid.add(txtComunidad,1,7);


        grid.add(new Label("Fecha ingreso:"),0,8);
        grid.add(dpFechaIngreso,1,8);


        grid.add(new Label("Estado:"),0,9);
        grid.add(cbEstado,1,9);


        grid.add(btnGuardar,1,10);



        Scene escena = new Scene(grid,400,500);


        ventana.setScene(escena);


        ventana.show();

    }

    private void guardarSocio(){

        Socio socio = new Socio();


        socio.setDni(txtDni.getText());
        socio.setNombres(txtNombres.getText());
        socio.setApellidos(txtApellidos.getText());


        socio.setFechaNacimiento(
                dpFechaNacimiento.getValue()
        );


        socio.setSexo(
                cbSexo.getValue()
        );


        socio.setTelefono(
                txtTelefono.getText()
        );


        socio.setDireccion(
                txtDireccion.getText()
        );


        socio.setComunidad(
                txtComunidad.getText()
        );


        socio.setFechaIngreso(
                dpFechaIngreso.getValue()
        );


        socio.setEstado(
                cbEstado.getValue()
        );



        boolean guardado = socioDAO.insertar(socio);


        if(guardado){

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Registro exitoso");
            alerta.setHeaderText(null);
            alerta.setContentText("Socio guardado correctamente");
            alerta.show();


        }else{

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("No se pudo guardar el socio");
            alerta.show();

        }

    }


}
