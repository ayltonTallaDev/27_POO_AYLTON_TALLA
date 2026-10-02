package vallegrande.edu.pe.sistema_poo.dao;

import vallegrande.edu.pe.sistema_poo.config.Conexion;
import vallegrande.edu.pe.sistema_poo.model.Socio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SocioDAO {


    // ==========================
    // LISTAR SOCIOS
    // ==========================

    public List<Socio> listar() {


        List<Socio> lista = new ArrayList<>();

        String sql = "SELECT * FROM socios";


        try (
                Connection conn = Conexion.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {


            while (rs.next()) {


                Socio socio = new Socio();


                socio.setIdSocio(
                        rs.getInt("id_socio")
                );


                socio.setDni(
                        rs.getString("dni")
                );


                socio.setNombres(
                        rs.getString("nombres")
                );


                socio.setApellidos(
                        rs.getString("apellidos")
                );


                if(rs.getDate("fecha_nacimiento") != null){

                    socio.setFechaNacimiento(
                            rs.getDate("fecha_nacimiento")
                                    .toLocalDate()
                    );

                }


                socio.setSexo(
                        rs.getString("sexo")
                );


                socio.setTelefono(
                        rs.getString("telefono")
                );


                socio.setDireccion(
                        rs.getString("direccion")
                );


                socio.setComunidad(
                        rs.getString("comunidad")
                );


                if(rs.getDate("fecha_ingreso") != null){

                    socio.setFechaIngreso(
                            rs.getDate("fecha_ingreso")
                                    .toLocalDate()
                    );

                }


                socio.setEstado(
                        rs.getString("estado")
                );


                lista.add(socio);

            }


        } catch(SQLException e){


            System.out.println("ERROR MYSQL:");

            System.out.println(e.getMessage());

            e.printStackTrace();


            return lista;

        }


        return lista;

    }



    // ==========================
    // INSERTAR SOCIO
    // ==========================

    public boolean insertar(Socio socio) {


        String sql = "INSERT INTO socios " +
                "(dni, nombres, apellidos, fecha_nacimiento, sexo, telefono, direccion, comunidad, fecha_ingreso, estado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (
                Connection conn = Conexion.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {


            stmt.setString(1, socio.getDni());


            stmt.setString(2, socio.getNombres());


            stmt.setString(3, socio.getApellidos());



            stmt.setDate(4,
                    java.sql.Date.valueOf(
                            socio.getFechaNacimiento()
                    )
            );



            stmt.setString(5, socio.getSexo());


            stmt.setString(6, socio.getTelefono());


            stmt.setString(7, socio.getDireccion());


            stmt.setString(8, socio.getComunidad());



            stmt.setDate(9,
                    java.sql.Date.valueOf(
                            socio.getFechaIngreso()
                    )
            );



            stmt.setString(10, socio.getEstado());



            int filas = stmt.executeUpdate();



            return filas > 0;



        } catch(SQLException e){


            System.out.println("ERROR AL INSERTAR SOCIO:");

            System.out.println(e.getMessage());

            e.printStackTrace();


            return false;

        }

    }


}