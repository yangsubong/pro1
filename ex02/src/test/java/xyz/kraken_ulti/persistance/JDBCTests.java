package xyz.kraken_ulti.persistance;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
		
		try(Connection con =
				DriverManager.getConnection(
						"jdbc:oracle:thin:@58.74.90.2:1521/xe","BOOK_EX14","BOOK_EX14")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
