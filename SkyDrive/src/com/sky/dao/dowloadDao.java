package com.sky.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sky.bean.resouce;
import com.sky.uitl.DataSourceUtils;

public class dowloadDao {

	public List<resouce> show() throws SQLException {
		String sql = "select * from resources";
		QueryRunner runner = new QueryRunner(new DataSourceUtils().getDateSource());
		return runner.query(sql, new BeanListHandler<resouce>(resouce.class));
	}

}
