package vallegrande.edu.pe.sistema_poo.controller;

import vallegrande.edu.pe.sistema_poo.model.Socio;
import vallegrande.edu.pe.sistema_poo.dao.SocioDAO;
import vallegrande.edu.pe.sistema_poo.view.MainView;
import vallegrande.edu.pe.sistema_poo.view.SocioForm;

import java.util.List;

public class SocioController {

    private MainView view;
    private SocioDAO socioDAO;


    public SocioController(MainView view){

        this.view = view;
        socioDAO = new SocioDAO();

        configurarEventos();
    }


    public void configurarEventos(){

        view.getBtnInicio().setOnAction(e -> {

            view.mostrarInicio();

        });


        view.getBtnSocios().setOnAction(e -> {

            view.mostrarSocios();

            cargarSocios();

        });


        view.getBtnNuevoSocio().setOnAction(e -> {

            SocioForm formulario = new SocioForm();

            formulario.mostrar();

        });

    }


    private void cargarSocios(){

        List<Socio> socios = socioDAO.listar();

        view.mostrarDatosSocios(socios);

    }
}
