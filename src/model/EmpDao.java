package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class EmpDao {

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/batch9";
	String uname = "root";
	String pass = "abc123";
	

	private Connection getConnect() throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		Connection con=	 DriverManager.getConnection(url,uname,pass);
		return con;
	}


	public int save(Emp e) throws ClassNotFoundException, SQLException {
		Connection con = getConnect();
		PreparedStatement ps = con.prepareStatement("Insert into emp22 values (?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getFname());
		ps.setString(3, e.getAddress());
		
		int a = ps.executeUpdate();
		con.close();
		
		return a;

	}
	
	public List<Emp> getAllData() throws ClassNotFoundException, SQLException{
		String sql = "Select * from emp22";
		Connection con = getConnect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Emp> le = new ArrayList<Emp>();
		
		while(rs.next())
		{
			Emp e=new Emp(rs.getInt(1),rs.getString(2), rs.getString(3));
			
			le.add(e);
		}
		
		
		return le;
	}


	public int delete(int id) throws ClassNotFoundException, SQLException {
		Connection con = getConnect();
		PreparedStatement ps = con.prepareStatement("delete from emp22 where id = ?");
		ps.setInt(1,id);
		
		int a = ps.executeUpdate();
		con.close();
		return a;
	}


	public int update(Emp e) throws ClassNotFoundException, SQLException {
		Connection con = getConnect();
		PreparedStatement ps = con.prepareStatement("update  emp22 set fname = ?, Address =? where Id = ?");
		ps.setString(1, e.getFname());
		ps.setString(2, e.getAddress());
		ps.setInt(3, e.getId());

		
		int a = ps.executeUpdate();
		con.close();
		
		return a;

	}


	public Emp getOneEmp(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
