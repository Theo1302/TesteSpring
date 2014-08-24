package br.com.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import br.com.entidade.Aluno;

@Repository
public class AlunoDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	public AlunoDao() {

		// System.out.println("Conectado >>>" + this.jdbcTemplate.getDataSource().getConnection());

	}

	public void save(Aluno aluno) {
		try {
		} catch (Exception e) {
		}
	}


	public void salvarArquivo(final File file) {

		try {
			final InputStream blobIn = new FileInputStream(file);
			this.jdbcTemplate.update("insert into tb_arquivo(id,arquivo) values (?,?)", new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, 3);
					ps.setBinaryStream(2, blobIn, (int) file.length());
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	@SuppressWarnings("unchecked")
	public byte[] find(int id) {
		String query = "select * from tb_arquivo where id = ?";
		id = 3;
		try {

			return this.jdbcTemplate.queryForObject(query, new Object[] {id}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					InputStream blobIn;


					blobIn = rs.getBinaryStream("arquivo");

					try {
						// converte o arquivo em um array byte
						return FileCopyUtils.copyToByteArray(blobIn);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;

				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
