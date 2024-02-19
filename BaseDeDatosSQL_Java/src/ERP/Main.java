package ERP;

import java.util.Scanner;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.*;

import java.awt.*;
import java.awt.event.*;

//import CicloSpuerior2.BaseDeDatos;
//import ConexionClase.Conexion;

public class Main {

	
	private static Connection conn;
	private static Statement st;
	private static final String user = "root";
	private static final String pass = "";
	private static final String driver = "com.mysql.jdbc.Driver";
	
	public static void main(String[] args) throws SQLException {
	
	String nombreTabla = null;	
	
	
	int opcion;
	Scanner sc = new Scanner(System.in);
	
	Conexiones ua = null;
	Desconnection ue = null;
	
	
	String nombreBD = "oceano";
	
	try {
		
		System.out.println("****************************************");
		System.out.println("*******************ERP******************");
		System.out.println("****************************************");
		System.out.println("");
		
		do {
			try {

				ua = new Conexiones(nombreBD);
				
				Thread.sleep(200);
				
			}catch(Exception e) {
				System.out.println("No se ha podido conectar a la base de datos" + e);
			}
		}while(ua == null);
		
		
		do {




			System.out.println("***************");
			System.out.println("*****MENU******");
			System.out.println("***************");
			System.out.println("1. Crear proyecto");
			System.out.println("2. Crear trabajador");
			System.out.println("3. Crear cliente");
			
			System.out.println("4. Read proyecto");
			System.out.println("5. Read trabajador");
			System.out.println("6. Read cliente");
			
			System.out.println("7. Modificar proyecto");
			System.out.println("8. Modificar trabajador");
			System.out.println("9. Modificar cliente");
			
			System.out.println("10. Delete proyecto");
			System.out.println("11. Delete trabajador");
			System.out.println("12. Delete cliente");
			
			//System.out.println("13. Meter a trabajador en proyecto");
			//System.out.println("14. Consulta");
			
			System.out.println("0. Salir del programa");
			
			System.out.print("Opcion: ");
			opcion = sc.nextInt();
			
			
			try {
				switch(opcion)
				{
				
				case 1:
					ua.crearProject();
					break;
				
				case 2: 
					ua.crearTrabajadores();							
					break;
					
				case 3:
					ua.crearCliente();
					break;
					
				case 4:
					ua.mostrarTodosProyectos();
					break;
					
				case 5:
					ua.mostrarTodosTrabajadores();					
					break;
					
				case 6:
					ua.mostrarTodosClientes();
					break;
					
				case 7:
					ua.modificarProject();
					break;
				
				case 8:
					ua.modificarTrabajadores();						
					break;
					
				case 9:
					ua.modificarClientes();
					break;
					
				case 10:
					ua.eliminarProject();
					break;
					
				case 11:
					ua.eliminarTrabajadores();						
					break;
					
				case 12:
					ua.eliminarCliente();
					break;

					
				case 0:
					System.out.print("El programa ha finalizado");
					System.exit(0);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}while( opcion != 0);
		System.out.println("Ha salido del programa");
	
	
	}catch(Exception e) {
		e.printStackTrace();

		}finally {
			if(ua != null) {
			//ua.Desconnection();
		}
	}
}


}


	
	
	

	

