package co.micol.prj.comm;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DataSource { //DAO 생성 Data Access Object
	private static DataSource dataSource = new DataSource(); // 싱글톤 클래스 ->항상 private으로
															//  외부에서 생성자를 만들지 못하도록 설정
	private Connection conn; //db에서 다룰 변수 설정
	private String driver;
	private String url;
	private String user;
	private String password;

	private DataSource() {config();} //생성될 때 한번만 읽어줌! 그래서 가급적 생성자에 넣기!!

	public static DataSource getinstance() {
		return dataSource;
	} // 여기까지

	private void config() { //properties파일을 읽음 
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getFile();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
//		config(); 생성자에 안넣었을 때 
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {

		}
		return conn;
	}

}
