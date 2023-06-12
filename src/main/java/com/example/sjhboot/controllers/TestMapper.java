package com.example.sjhboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mariadb.jdbc.Driver;

@RestController
public class TestMapper {

	@Autowired
	SqlSession sqlSession;

	@GetMapping("/testMapper")
	public String wer() {

		System.out.println(Driver.class.getName());
		return "GOGO gg";
	}

	@GetMapping("/useSqlMapper")
	public String useSqlMapper() {

		List<Map<String, String>> mm = sqlSession.selectList("admin.test", new HashMap<>());
		System.out.println(mm);

		return "HOHO";
	}

	@GetMapping("/plainJdbc")
	public String werraa() throws SQLException {

		String url = "jdbc:mariadb://localhost:3306/newlec?";
		String userName = "root";
		String password = "whdgus159!";
		String clas = Driver.class.getName();

		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;

		conn = DriverManager.getConnection(url, "root", "whdgus159!");
		stmnt = conn.createStatement();
		rs = stmnt.executeQuery("select * from user");

		while (rs.next()) {
			String nm = rs.getString("name");
			System.out.println(nm);
		}

		return "GOGOa";
	}
}
