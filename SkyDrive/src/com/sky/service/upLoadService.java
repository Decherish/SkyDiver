package com.sky.service;

import java.sql.SQLException;

import com.sky.dao.upLoadDao;

public class upLoadService {

	public void upLoad(String uuidname, String realname,
			String randomDirectory, String time, String description) throws SQLException {
		upLoadDao uDao = new upLoadDao();
		uDao.upLoad(uuidname,realname,randomDirectory,time,description);
	}

}
