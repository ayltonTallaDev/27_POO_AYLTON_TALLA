package vallegrande.edu.pe.sistema_poo.view;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.function.Consumer;

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


    // Socio que será actualizado
    private Socio socioEditar;

    private Consumer<Void> refrescar;



    // Constructor nuevo socio

    public SocioForm(){

    }





    // Constructor actualizar

    public SocioForm(Socio socio){

        this.socioEditar = socio;

    }

    public SocioForm(Socio socio, Consumer<Void> refrescar){

        this.socioEditar = socio;

        this.refrescar = refrescar;

    }




    public void mostrar(){



        Stage ventana = new Stage();



        if(socioEditar == null){

            ventana.setTitle("Registrar Socio");

        }else{

            ventana.setTitle("Actualizar Socio");

        }






        GridPane grid = new GridPane();


        grid.setPadding(new Insets(20));

        grid.setHgap(10);

        grid.setVgap(10);







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





        // cargar datos si es actualización

        if(socioEditar != null){

            cargarDatos();

        }





        btnGuardar = new Button();


        if(socioEditar == null){

            btnGuardar.setText("Guardar");

        }else{

            btnGuardar.setText("Actualizar");

        }





        btnGuardar.setOnAction(e -> {

            guardarSocio();


            if(refrescar != null){

                refrescar.accept(null);

            }


            ventana.close();

        });









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









    private void cargarDatos(){



        txtDni.setText(
                socioEditar.getDni()
        );


        txtNombres.setText(
                socioEditar.getNombres()
        );


        txtApellidos.setText(
                socioEditar.getApellidos()
        );


        dpFechaNacimiento.setValue(
                socioEditar.getFechaNacimiento()
        );


        cbSexo.setValue(
                socioEditar.getSexo()
        );


        txtTelefono.setText(
                socioEditar.getTelefono()
        );


        txtDireccion.setText(
                socioEditar.getDireccion()
        );


        txtComunidad.setText(
                socioEditar.getComunidad()
        );


        dpFechaIngreso.setValue(
                socioEditar.getFechaIngreso()
        );


        cbEstado.setValue(
                socioEditar.getEstado()
        );


    }









    private void guardarSocio(){



        Socio socio = new Socio();



        socio.setDni(
                txtDni.getText()
        );


        socio.setNombres(
                txtNombres.getText()
        );


        socio.setApellidos(
                txtApellidos.getText()
        );


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





        boolean resultado;



        if(socioEditar == null){


            resultado = socioDAO.insertar(socio);



        }else{



            socio.setIdSocio(
                    socioEditar.getIdSocio()
            );



            resultado = socioDAO.actualizar(socio);



        }







        Alert alerta;



        if(resultado){



            alerta = new Alert(
                    Alert.AlertType.INFORMATION
            );


            alerta.setTitle("Correcto");

            alerta.setHeaderText(null);



            if(socioEditar == null){


                alerta.setContentText(
                        "Socio registrado correctamente"
                );


            }else{


                alerta.setContentText(
                        "Socio actualizado correctamente"
                );


            }



        }else{



            alerta = new Alert(
                    Alert.AlertType.ERROR
            );


            alerta.setTitle("Error");

            alerta.setHeaderText(null);


            alerta.setContentText(
                    "No se pudo guardar la información"
            );


        }



        alerta.show();



    }



}