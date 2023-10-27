package ERP;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Desconnection {

	private static Connection conn;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/oceano";
		
	public void desconexion() {
		conn = null;
	}
	
}
