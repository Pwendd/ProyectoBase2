
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

    public class Conexion {
        private static Conexion conex;

        // Nombre de la base de datos
        private String database = "parcial1";

        // Host
        private String hostname = "localhost"; // 127.0.0.1 == localhost

        // Puerto
        private String port = "5432";

        // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
        private String url = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;

        // Nombre de usuario
        private String username = "postgres";

        // Clave de usuario
        private String password = "123456";

        private Connection conn;

        public Conexion() {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(url, username, password);
                JOptionPane.showMessageDialog(null, "Conexión PostgreSQL-Java exitosa", "Conexión", JOptionPane.INFORMATION_MESSAGE);
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Sin conexión", "Conexión" + e, JOptionPane.ERROR_MESSAGE);
            }
        }


        public Connection getConnection() {
            return conn;
        }

        public static Conexion getInstance(){
            if (conex == null){
                conex = new Conexion();
            }
            return conex;
        }


        public void ejecutarSQL(String sql) {
            try {
                Statement st= conn.createStatement();
                st.executeUpdate(sql);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public void desconectar(){
            try {
                conn.close();
                JOptionPane.showMessageDialog(null,"SE HA DESCONECTADO LA CONEXION CON EXITO!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //
    }
