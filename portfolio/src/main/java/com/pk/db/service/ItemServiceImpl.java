package com.pk.db.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.db.dao.HibernateDao;
import com.pk.db.dao.ItemDao;
import com.pk.db.domain.Item;

//Bean�� �ڵ��������ִ� ������̼�
@Service
public class ItemServiceImpl implements ItemService {
	//ItemDao Ÿ���� Bean�� ������ �ڵ����� ���Խ����ִ� ������̼�
	@Autowired
	private ItemDao itemDao;
	
	//Hibernate �����ϴ� Bean�� �ڵ� ����
	//������ �ڷ����� Bean�� ������ �ڵ� ����
	@Autowired
	private HibernateDao hibernateDao;

	@Override
	@Transactional
	public List<Item> allItem(HttpServletRequest request) {
		//Dao�� �޼ҵ忡 �Ķ���Ͱ� ���� ���� Dao �޼ҵ带 ȣ���ؼ� ����
		//return itemDao.allItem();
		return hibernateDao.allItem();
	}

	@Override
	@Transactional
	public Item getItem(HttpServletRequest request) {
		//�Ķ���� �о����
		String itemid = request.getParameter("itemid");
		//�Ķ���͸� ������ ��ȯ�ؼ� Dao �޼ҵ带 ȣ��
		//return itemDao.getItem(Integer.parseInt(itemid));
		return hibernateDao.getItem(Integer.parseInt(itemid));
	}

	@Override
	@Transactional
	public Item getItem(HttpServletRequest request, int itemid) {
		//return itemDao.getItem(itemid);
		return hibernateDao.getItem(itemid);
	}

}