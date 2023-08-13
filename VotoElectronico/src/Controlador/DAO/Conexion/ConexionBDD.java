/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author saul_
 */
public class ConexionBDD {
    //https://www.codejava.net/java-se/jdbc/connect-to-oracle-database-via-jdbc
    private Connection connection;
    // Librería de MySQL
    public String driver = "oracle.jdbc.driver.OracleDriver";//oracle.jdbc.driver.OracleDriver o OracleThin

    // Nombre de la base de datos
    public String database = "base_voto";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "1521";//1521

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    //String aux = "jdbc:oracle:thin:@"+hostname+":"+port+":"+database;
    public String url = "jdbc:oracle:thin:@localhost:1521:XE";  //"jdbc:oracle:thin:@"+hostname+":"+port+":"+database;

    // Nombre de usuario
    public String username = "VOTO_ELECTRONICO";

    // Clave de usuario
    public String password = "Dante1234@";

    private Connection conectar() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public Connection getConnection() {
        if(connection == null)
            connection = conectar();
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    
    /*private XStream xstream;
    public static String URL = "data/";
    private void conectar() {         
        xstream = new XStream(new JettisonMappedXmlDriver());        
         xstream.setMode(XStream.NO_REFERENCES);
         xstream.addPermission(AnyTypePermission.ANY);
    }
    public XStream getXstream() {
        if(xstream == null)
            conectar();
        return xstream;
    }
    public void setXstream(XStream xstream) {
        this.xstream = xstream;
    }*/    
}
