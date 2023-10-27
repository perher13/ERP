package ERP;


import com.mysql.jdbc.Connection;

import ConexionClase.montana;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Conexiones {

	private static Connection conn;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/";
	
	private static final String nombreBD = "oceano";
	
	public Conexiones(String nombreTabla) {
		conn = null;
		try {
			Class.forName(driver);
			conn = (Connection)DriverManager.getConnection(url + nombreTabla, user, password);
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error al conectar"+e);
		}
	}
	
	public static void crearTrabajadores() throws SQLException, InterruptedException{
	
		Scanner sc = new Scanner(System.in);
		
		workers w = new workers();
		
		String nombre = "";
		String mail = "";
		String password = "";
		
		System.out.print("Introduce el nombre del nuevo trabajador/a: ");
		nombre = sc.next();
		System.out.print("Introduce el mail del nuevo trabajador/a: ");
		mail = sc.next();
		System.out.print("Introduce la contraseña del nuevo trabajador/a: ");
		password = sc.next();
		
		w.setMail(mail);
		w.setNombre(nombre);
		w.setPassword(password);
		
		String sql = "INSERT INTO `" + nombreBD + "`.`usuarios` (`nombre`, `mail`, `password`) VALUES ('"
				+ w.getNombre() + 
				"', '"
				+ w.getMail() +
				"', '"
				+ w.getPassword() + 
				"')";
		
		Statement st = null;
		
		try {
			st = conn.createStatement();
			int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			rs.close();
		}finally {
			if (st != null) { st.close(); }
		}
		Thread.sleep(1000);
		
	}
	
	public static void crearProject() throws SQLException, InterruptedException{
		
		Scanner sc = new Scanner(System.in);
		
		projects p = new projects();
		
		String nombre = "";
		int horas = 0;
		
		System.out.print("Introduce el nombre del nuevo proyecto: ");
		nombre = sc.next();
		
		
		
		p.setHours(horas);
		p.setNombre(nombre);
		
		String sql = "INSERT INTO `" + nombreBD + "`.`project` (`nombre`, `horas`) VALUES ('"
				+ p.getNombre() + 
				"', '"
				+ p.getHours() + 
				"')";
		
		Statement st = null;
		
		try {
			st = conn.createStatement();
			int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			rs.close();
		}finally {
			if (st != null) { st.close(); }
		}
		Thread.sleep(1000);
		
	}
	
	public static void crearCliente() throws SQLException, InterruptedException{
		
		Scanner sc = new Scanner(System.in);
		
		clientes c = new clientes();
		
		String nombre = "";
		int horas = 0;
		
		System.out.print("Introduce el nombre del nuevo cliente: ");
		nombre = sc.next();
		
		
		c.setNombre(nombre);
		
		String sql = "INSERT INTO `" + nombreBD + "`.`clientes` (`nombre`) VALUES ('"
				+ c.getNombre() +  
				"')";
		
		Statement st = null;
		
		try {
			st = conn.createStatement();
			int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			rs.close();
		}finally {
			if (st != null) { st.close(); }
		}
		Thread.sleep(1000);
		
	}
	
	public static void eliminarTrabajadores() throws SQLException, InterruptedException
	{
		
		int id = 0;
		
		Scanner sc = new Scanner(System.in);
		
		java.sql.Statement st = null;
		st = conn.createStatement();
		
		mostrarTodosTrabajadores();
		
		System.out.print("Que id quieres eliminar: ");
		id = sc.nextInt();
		
		String sql = ("DELETE FROM `" + nombreBD + "`.`usuarios` WHERE id=" + id);
		st.executeUpdate(sql);
		
		System.out.println("Trabajador/a eliminado/a correctamente");
		
		Thread.sleep(1000);
	}
	
	public static void eliminarProject() throws SQLException, InterruptedException
	{
		
		int id = 0;
		
		Scanner sc = new Scanner(System.in);
		
		java.sql.Statement st = null;
		st = conn.createStatement();
		
		mostrarTodosTrabajadores();
		
		System.out.print("Que id quieres eliminar: ");
		id = sc.nextInt();
		
		String sql = ("DELETE FROM `" + nombreBD + "`.`project` WHERE id=" + id);
		st.executeUpdate(sql);
		
		System.out.println("Proyecto eliminado correctamente");
		
		Thread.sleep(1000);
	}
	
	public static void eliminarCliente() throws SQLException, InterruptedException
	{
		
		int id = 0;
		
		Scanner sc = new Scanner(System.in);
		
		java.sql.Statement st = null;
		st = conn.createStatement();
		
		mostrarTodosTrabajadores();
		
		System.out.print("Que id quieres eliminar: ");
		id = sc.nextInt();
		
		String sql = ("DELETE FROM `" + nombreBD + "`.`clientes` WHERE id=" + id);
		st.executeUpdate(sql);
		
		System.out.println("Cliente eliminado correctamente");
		
		Thread.sleep(1000);
	}
	
	public static void mostrarTodosTrabajadores() throws SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		
		java.sql.Statement st = null;
		st = conn.createStatement();
		
		
		String sql = ("SELECT * FROM `" + nombreBD + "`.`usuarios`");
		
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String mail = rs.getString("mail");
				String password = rs.getString("password");
				
				System.out.println("ID: " + id + ", Nombre: " + nombre + ", Mail: " + mail + ", Password: " + password);
			}
			
		}finally {
			if (st != null) { 
				st.close(); 
				}
		}
		Thread.sleep(1000);
	}
	
	public static void mostrarTodosProyectos() throws SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		
		java.sql.Statement st = null;
		st = conn.createStatement();
		
		
		String sql = ("SELECT * FROM `" + nombreBD + "`.`project`");
		
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int horas = rs.getInt("horas");
				
				System.out.println("ID: " + id + ", Nombre: " + nombre + ", Horas: " + horas);
			}
			
		}finally {
			if (st != null) { 
				st.close(); 
				}
		}
		Thread.sleep(1000);
	}
	
	public static void mostrarTodosClientes() throws SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		
		java.sql.Statement st = null;
		st = conn.createStatement();
		
		
		String sql = ("SELECT * FROM `" + nombreBD + "`.`clientes`");
		
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				System.out.println("ID: " + id + ", Nombre: " + nombre);
			}
			
		}finally {
			if (st != null) { 
				st.close(); 
				}
		}
		Thread.sleep(1000);
	}
	
	public static void modificarTrabajadores() throws SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		
		workers w = new workers();
		
		String nombre = "";
		String mail = "";
		String password = "";
		int ids = 0;
		
		mostrarTodosTrabajadores();
		
		System.out.print("Introduce el id de la montana a editar: ");
		ids = sc.nextInt();

		System.out.print("Introduce el nombre del nuevo trabajador/a: ");
		nombre = sc.next();
		System.out.print("Introduce el mail del nuevo trabajador/a: ");
		mail = sc.next();
		System.out.print("Introduce el password del nuevo trabajador/a: ");
		password = sc.next();
		
		w.setNombre(nombre);
		w.setMail(mail);
		w.setPassword(password);
		
		
		String sql = "UPDATE `" + nombreBD + "`.`usuarios` SET `nombre` = '" + w.getNombre() + "', `mail` = '" + w.getMail() + "', `password` = '" + w.getPassword() + "' WHERE id = '" + ids + "'";

		
		System.out.println("Trabajador/a modificado/a correctamente");
		mostrarTodosTrabajadores();
		
		Statement st = null;
		
		try {
			st = conn.createStatement();
			int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			//System.out.println(num);
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			//int id = rs.getInt(1);
			rs.close();
		}finally {
			if (st != null) { st.close(); }
		}
		Thread.sleep(1000);
	}
	
	public static void modificarClientes() throws SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		
		clientes c = new clientes();
		
		String nombre = "";
		String mail = "";
		String password = "";
		int ids = 0;
		
		mostrarTodosClientes();
		
		System.out.print("Introduce el id de la montana a editar: ");
		ids = sc.nextInt();

		System.out.print("Introduce el nombre del nuevo trabajador/a: ");
		nombre = sc.next();
			
		c.setNombre(nombre);
		
		String sql = "UPDATE `" + nombreBD + "`.`clientes` SET `nombre` = '" + c.getNombre() + "' WHERE id = " + ids;
		
		System.out.println("Cliente modificado correctamente");
		mostrarTodosClientes();
		
		Statement st = null;
		
		try {
			st = conn.createStatement();
			int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			//System.out.println(num);
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			//int id = rs.getInt(1);
			rs.close();
		}finally {
			if (st != null) { st.close(); }
		}
		Thread.sleep(1000);
	}

	public static void modificarProject() throws SQLException, InterruptedException
	{
		Scanner sc = new Scanner(System.in);
		
		projects p = new projects();
		
		String nombre = "";
		int horas = 0;
		String password = "";
		int ids = 0;
		
		mostrarTodosProyectos();
		
		System.out.print("Introduce el id de la montana a editar: ");
		ids = sc.nextInt();
		
		System.out.print("Introduce horas a editar: ");
		horas = sc.nextInt();

		System.out.print("Introduce el nombre del nuevo trabajador/a: ");
		nombre = sc.next();
			
		p.setNombre(nombre);
		p.setHours(horas);
		
		String sql = "UPDATE `" + nombreBD + "`.`project` SET `nombre` = '" + p.getNombre() + "', `horas` = " + p.getHours() + " WHERE id = " + ids;

		
		System.out.println("Projecto modificado correctamente");
		
		Statement st = null;
		
		try {
			st = conn.createStatement();
			int num = st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			//System.out.println(num);
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			//int id = rs.getInt(1);
			rs.close();
		}finally {
			if (st != null) { st.close(); }
		}
		Thread.sleep(1000);
	}
	
	
}
