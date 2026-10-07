package vallegrande.edu.pe.formularioregistro;

import javax.swing.*;
import java.awt.*;

public class FormularioRegistro {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Sistema de Registro de Usuarios");
        ventana.setSize(500, 450);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);


        // Panel principal
        JPanel principal = new JPanel();
        principal.setLayout(new BorderLayout(10,10));
        principal.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        principal.setBackground(new Color(240,245,250));


        // Título
        JLabel titulo = new JLabel(
                "FORMULARIO DE REGISTRO",
                JLabel.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(new Color(30,70,120));

        principal.add(titulo, BorderLayout.NORTH);



        // Panel de datos
        JPanel datos = new JPanel(new GridLayout(4,2,10,15));
        datos.setBorder(
                BorderFactory.createTitledBorder("Datos personales")
        );

        datos.setBackground(Color.WHITE);


        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();


        JLabel lblApellido = new JLabel("Apellido:");
        JTextField txtApellido = new JTextField();


        JLabel lblCorreo = new JLabel("Correo:");
        JTextField txtCorreo = new JTextField();


        JLabel lblEdad = new JLabel("Edad:");
        JTextField txtEdad = new JTextField();



        datos.add(lblNombre);
        datos.add(txtNombre);

        datos.add(lblApellido);
        datos.add(txtApellido);

        datos.add(lblCorreo);
        datos.add(txtCorreo);

        datos.add(lblEdad);
        datos.add(txtEdad);



        // Panel intereses
        JPanel intereses = new JPanel(new FlowLayout(FlowLayout.CENTER));

        intereses.setBorder(
                BorderFactory.createTitledBorder("Intereses")
        );

        intereses.setBackground(Color.WHITE);


        JCheckBox chkProgramacion =
                new JCheckBox("Programación");

        JCheckBox chkDiseño =
                new JCheckBox("Diseño");

        JCheckBox chkMusica =
                new JCheckBox("Música");

        JCheckBox chkDeportes =
                new JCheckBox("Deportes");


        intereses.add(chkProgramacion);
        intereses.add(chkDiseño);
        intereses.add(chkMusica);
        intereses.add(chkDeportes);



        // Panel central
        JPanel centro = new JPanel(new GridLayout(2,1,10,10));

        centro.setBackground(
                new Color(240,245,250)
        );

        centro.add(datos);
        centro.add(intereses);


        principal.add(centro, BorderLayout.CENTER);



        // Botón
        JButton registrar =
                new JButton("Registrar Usuario");


        registrar.setFont(
                new Font("Arial",Font.BOLD,15)
        );


        registrar.setBackground(
                new Color(50,120,200)
        );

        registrar.setFocusPainted(false);

        registrar.setForeground(Color.WHITE);



        principal.add(
                registrar,
                BorderLayout.SOUTH
        );



        // Evento botón

        registrar.addActionListener(e -> {


            if(txtNombre.getText().isEmpty()
                    || txtApellido.getText().isEmpty()
                    || txtCorreo.getText().isEmpty()){


                JOptionPane.showMessageDialog(
                        ventana,
                        "Debe completar todos los datos",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );


            }else{


                String gustos="";


                if(chkProgramacion.isSelected())
                    gustos+="Programación\n";

                if(chkDiseño.isSelected())
                    gustos+="Diseño\n";

                if(chkMusica.isSelected())
                    gustos+="Música\n";

                if(chkDeportes.isSelected())
                    gustos+="Deportes\n";



                JOptionPane.showMessageDialog(
                        ventana,

                        "DATOS REGISTRADOS\n\n"+
                                "Nombre: "+txtNombre.getText()+
                                "\nApellido: "+txtApellido.getText()+
                                "\nCorreo: "+txtCorreo.getText()+
                                "\nEdad: "+txtEdad.getText()+
                                "\n\nIntereses:\n"+gustos,

                        "Registro exitoso",

                        JOptionPane.INFORMATION_MESSAGE
                );

            }

        });



        ventana.add(principal);

        ventana.setVisible(true);

    }
}