package br.com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ConJdbc {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// private DriverManagerDataSource dataSource;

	public ConJdbc() {
		/*
		 * this.dataSource = new
		 * DriverManagerDataSource("jdbc:postgresql://localhost:5432/dbEscolaSaber", "postgres",
		 * "admin"); this.dataSource.setDriverClassName("org.postgresql.Driver");
		 * 
		 * this.jdbcTemplate = new JdbcTemplate(this.dataSource); try { if
		 * (this.dataSource.getConnection() != null) { System.out.println("conectado"); } } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}



	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
