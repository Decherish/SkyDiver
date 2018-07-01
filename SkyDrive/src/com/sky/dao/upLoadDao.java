package com.sky.dao;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import com.sky.uitl.DataSourceUtils;

public class upLoadDao {

	public void upLoad(String uuidname, String realname,
			String randomDirectory, String time, String description) throws SQLException {
		String sql = "insert into resources values(null,?,?,?,?,?)";
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDateSource());
		runner.update(sql,uuidname,realname,randomDirectory,time,description);
	}

}
