package com.example.webapp;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class SalesDAO {
	private JdbcTemplate jdbcTemplate;
	
	public SalesDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Sale> list() {
		String sql = "Select * FROM SALES";
		List<Sale> listsale = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sale.class));
		return listsale;
	}
	
	public void save(Sale sale) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
		insert.withTableName("sales").usingColumns("id", "item", "quantity", "amount");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		insert.execute(param);		
	}
	
	public Sale get(int id) {
		String sql = "Select * from sales WHERE id = ?";
		Object[] args = {id};
		Sale sale = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Sale.class));
		return sale;
	}
	
	public void update(Sale sale) {
		String sql = "Update sales SET id=:id, item=:item, quantity=:quantity, amount=:amount WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sale);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);
	}
	
	public void delete(int id) {
		String sql = "Delete from sales WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
