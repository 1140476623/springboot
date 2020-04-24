package springbootdemo.dao;

import javax.annotation.Resource;
import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import springbootdemo.bean.Demo;
@Repository
public class DemoDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public Demo getById(long id){
		String sql = "select * from Demo where Id = ?";
		RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
}
