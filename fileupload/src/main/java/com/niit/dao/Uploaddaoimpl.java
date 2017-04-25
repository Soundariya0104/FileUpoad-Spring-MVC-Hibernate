package com.niit.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Upload;

@Repository
public class Uploaddaoimpl implements Uploaddao {
	@Autowired
	private SessionFactory sessionFactory;
@Transactional
	public void save(Upload upload) {
	sessionFactory.getCurrentSession().save(upload);
	    }
	}

