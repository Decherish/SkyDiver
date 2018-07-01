package com.sky.service;

import java.sql.SQLException;
import java.util.List;

import com.sky.bean.resouce;
import com.sky.dao.dowloadDao;

public class dowloadService {

	public List<resouce> show() throws SQLException {
		dowloadDao lDao = new dowloadDao();
		return lDao.show();
	}

}
