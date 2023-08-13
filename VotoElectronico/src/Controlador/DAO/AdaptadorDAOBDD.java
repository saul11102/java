/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.DAO.Conexion.ConexionBDD;
import Controlador.DAO.InterfazDAO.InterfazDao;
import Controlador.ed.lista.ListaEnlazada;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author saul_
 */
public class AdaptadorDAOBDD<T> implements InterfazDao<T> {

    /**
     * Obejto Conexion
     */
    private ConexionBDD conexion;
    /**
     * Class del modelo a usar
     */
    private Class clazz;

    /**
     * Constructor de la clase
     *
     * @param clazz El objeto de la clase del modelo Ejemplo: Persona.class
     */
    public AdaptadorDAOBDD(Class clazz) {
        this.conexion = new ConexionBDD();
        this.clazz = clazz;
    }

    /**
     * Metodo que permite guardar
     *
     * @param obj El objeto del modelo lleno
     * @return La llave primaria generada por el motor de base de datos (se
     * sugiere construir la tabla de base de datos con la generacion de id auto
     * incementable)
     * @throws Exception Cuando no se puede guardar en la base de datos
     */
    @Override
    public Integer guardar(T obj) throws Exception {
        String query = queryInsert(obj);
        Integer idGenerado = -1;
        PreparedStatement statement = conexion.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
/*
        if (generatedKeys.next()) {
            idGenerado = generatedKeys.getInt(1);
        }
*/
        conexion.getConnection().close();
        conexion.setConnection(null);
        return idGenerado;
    }

    /**
     * Metodo que permite modificar un registro en la base de datos, para
     * modificar se debe primero consultar el Objeto haciendo uso del metodo
     * Obtener
     *
     * @param obj El objeto del modelo a modificar
     * @throws Exception Alguna Excepcion si no modifica
     */
    @Override
    public void modificar(T obj) throws Exception {
        String query = queryUpdate(obj);
        Statement st = conexion.getConnection().createStatement();
        st.executeUpdate(query);
        conexion.getConnection().close();
        conexion.setConnection(null);
    }

    /**
     * Metodo que permite sacar los datos de la base de datos
     *
     * @return Un Objeto de la ListaEnlazada con los datos llenos
     */
    @Override
    public ListaEnlazada<T> listar() {

        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            Statement stmt = conexion.getConnection().createStatement();
            String query = "SELECT * FROM " + clazz.getSimpleName().toLowerCase();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                lista.insertarNodo(llenarObjeto(rs));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    /**
     * Permite obtener un objeto de la base de datos a travez del Id
     *
     * @param id El id a buscar en la base de datos
     * @return El objeto buscado, es null si no esxiste el objeto
     */
    @Override
    public T obtener(Integer id) {
        T data = null;
        try {
            Statement stmt = conexion.getConnection().createStatement();
            String query = "select * from " + clazz.getSimpleName().toLowerCase() + " where id = " + id;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                data = llenarObjeto(rs);
            }
        } catch (Exception e) {
        }
        return data;
    }

    //--------------ESTO ES DEL CRUD NO MODIFICAR AL MENOS QUE LO AMERITE------
    private T llenarObjeto(ResultSet rs) {
        T data = null;
        try {
            data = (T) clazz.getDeclaredConstructor().newInstance();
            for (Field f : clazz.getDeclaredFields()) {
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                fijarDatos(f, rs, data, atributo);
            }
            for (Field f : clazz.getSuperclass().getDeclaredFields()) {
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                fijarDatos(f, rs, data, atributo);
            }

        } catch (Exception e) {
            System.out.println("error " + e);
        }
        return data;
    }

    private void fijarDatos(Field f, ResultSet rs, T data, String atributo) {
        try {
            Method m = null;

            if (f.getType().getSimpleName().equalsIgnoreCase("String")) {
                m = clazz.getMethod("set" + atributo, String.class);
                m.invoke(data, rs.getString(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Integer")) {
                m = clazz.getMethod("set" + atributo, Integer.class);
                m.invoke(data, rs.getInt(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Double")) {
                m = clazz.getMethod("set" + atributo, Double.class);
                m.invoke(data, rs.getDouble(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
                m = clazz.getMethod("set" + atributo, Boolean.class);
                m.invoke(data, rs.getBoolean(atributo));
            }

            if (f.getType().getSimpleName().equalsIgnoreCase("Date")) {
                m = clazz.getMethod("set" + atributo, Date.class);
                m.invoke(data, rs.getDate(atributo));
            }

            if (f.getType().isEnum()) {

                m = clazz.getMethod("set" + atributo, (Class<Enum>) f.getType());
                m.invoke(data, Enum.valueOf((Class<Enum>) f.getType(), rs.getString(atributo)));
            }
        } catch (Exception e) {
            System.out.println("chiqui error " + e);
        }
    }

    private HashMap<String, Object> obtenerObjeto(T obj) {
        HashMap<String, Object> mapa = new HashMap<>();
        try {
            for (Field f : clazz.getDeclaredFields()) {
                Method m = null;
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                m = clazz.getMethod("get" + atributo);
                Object aux = m.invoke(obj);
                if (aux != null) {
                    if (aux instanceof Date) {
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        mapa.put(f.getName().toLowerCase(), formato.format(aux));
                    } else {
                        mapa.put(f.getName().toLowerCase(), aux);
                    }
                }
            }

            for (Field f : clazz.getSuperclass().getDeclaredFields()) {
                Method m = null;
                String atributo = f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                m = clazz.getMethod("get" + atributo);
                Object aux = m.invoke(obj);
                if (aux != null) {
                    if (aux instanceof Date) {
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        mapa.put(f.getName().toLowerCase(), formato.format(aux));
                    } else {
                        mapa.put(f.getName().toLowerCase(), aux);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener el dato: " + e);
        }
        return mapa;
    }

    private String queryInsert(T obj) {
        HashMap<String, Object> mapa = obtenerObjeto(obj);
        String query = "INSERT INTO " + clazz.getSimpleName().toLowerCase() + " (";
        String columns = "";
        String values = "";

        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            columns += entry.getKey() + ",";
            Object value = entry.getValue();

            if (value != null) {
                if (value instanceof Number || value instanceof Boolean) {
                    values += value + ",";
                } else if (value instanceof Date) {
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    values += "TO_DATE('" + formato.format(value) + "', 'YYYY-MM-DD HH24:MI:SS'),";
                } else if (value instanceof Enum || value instanceof String) {
                    values += "'" + value.toString() + "',";
                }
            } else {
                values += "NULL,";
            }
        }

        columns = columns.substring(0, columns.length() - 1);
        values = values.substring(0, values.length() - 1);

        query = query + columns + ") VALUES (" + values + ")";
        return query;
    }

    private String queryUpdate(T obj) {
        HashMap<String, Object> mapa = obtenerObjeto(obj);
        String query = "UPDATE " + clazz.getSimpleName().toLowerCase() + " SET ";
        Integer id = null;

        for (Map.Entry<String, Object> entry : mapa.entrySet()) {
            if (entry.getKey().toString().equalsIgnoreCase("id")) {
                id = (Integer) entry.getValue();
            } else {
                query += entry.getKey() + " = ";

                Object value = entry.getValue();
                if (value != null) {
                    if (value instanceof Number || value instanceof Boolean) {
                        query += value + ", ";
                    } else if (value instanceof Date) {
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        query += "TO_DATE('" + formato.format(value) + "', 'YYYY-MM-DD HH24:MI:SS'), ";
                    } else if (value instanceof Enum || value instanceof String) {
                        query += "'" + value.toString() + "', ";
                    }
                } else {
                    query += "NULL, ";
                }
            }
        }

        query = query.substring(0, query.length() - 2);
        query += " WHERE id = " + id;
        return query;
    }

}
