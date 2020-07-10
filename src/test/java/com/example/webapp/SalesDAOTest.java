package com.example.webapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class SalesDAOTest {
	
	private SalesDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:mysql://127.0.0.1:3310/myusers");
		datasource.setUsername("abhinavp403");
		datasource.setPassword("root");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		dao = new SalesDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Sale> listsale = dao.list();
		assertTrue(listsale.isEmpty());
	}

	@Test
	void testSave() {
		Sale sale = new Sale(1, "Fan", 1, 29.99f);
		dao.save(sale);
	}

	@Test
	void testGet() {
		int id = 1;
		Sale sale = dao.get(id);
		assertNotNull(sale);
	}

	@Test
	void testUpdate() {
		Sale sale = new Sale();
		sale.setId(2);
		sale.setItem("Chair New");
		sale.setQuantity(40);
		dao.update(sale);
	}

	@Test
	void testDelete() {
		int id = 1;
		dao.delete(id);
	}

}
