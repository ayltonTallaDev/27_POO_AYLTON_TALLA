package vallegrande.edu.pe.sistema_poo.controller;


import vallegrande.edu.pe.sistema_poo.model.Socio;
import vallegrande.edu.pe.sistema_poo.dao.SocioDAO;
import vallegrande.edu.pe.sistema_poo.view.MainView;
import vallegrande.edu.pe.sistema_poo.view.SocioForm;


import java.util.List;



public class SocioController {


    private MainView view;

    private SocioDAO socioDAO;

    private Socio socioSeleccionado;



    public SocioController(MainView view){


        this.view = view;

        socioDAO = new SocioDAO();


        configurarEventos();

    }







    public void configurarEventos(){



        // ==========================
        // BOTON INICIO
        // ==========================

        view.getBtnInicio().setOnAction(e -> {


            view.mostrarInicio();


        });







        // ==========================
        // BOTON SOCIOS
        // ==========================

        view.getBtnSocios().setOnAction(e -> {


            view.mostrarSocios();


            cargarSocios();


        });








        // ==========================
        // NUEVO SOCIO
        // ==========================

        view.getBtnNuevoSocio().setOnAction(e -> {


            SocioForm formulario = new SocioForm();


            formulario.mostrar();



        });









        // ==========================
        // SELECCIONAR SOCIO
        // ==========================


        view.getTablaSocios().setOnMouseClicked(e -> {



            socioSeleccionado = view.getSocioSeleccionado();




            if(socioSeleccionado != null){



                System.out.println(

                        "Socio seleccionado: "

                                + socioSeleccionado.getNombres()

                );


            }



        });









        // ==========================
        // ELIMINAR SOCIO
        // ==========================


        view.getBtnEliminar().setOnAction(e -> {



            if(socioSeleccionado != null){



                boolean eliminado = socioDAO.eliminar(

                        socioSeleccionado.getIdSocio()

                );





                if(eliminado){



                    System.out.println(

                            "Socio eliminado correctamente"

                    );



                    cargarSocios();



                }



            }else{



                System.out.println(

                        "Seleccione un socio primero"

                );


            }




        });









        // ==========================
        // ACTUALIZAR SOCIO
        // ==========================


        view.getBtnActualizar().setOnAction(e -> {



            if(socioSeleccionado != null){



                SocioForm formulario = new SocioForm(

                        socioSeleccionado,

                        v -> cargarSocios()

                );



                formulario.mostrar();





            }else{



                System.out.println(

                        "Seleccione un socio primero"

                );



            }



        });





    }









    // ==========================
    // CARGAR TABLA
    // ==========================


    private void cargarSocios(){


        List<Socio> socios = socioDAO.listar();


        view.mostrarDatosSocios(socios);


    }





}