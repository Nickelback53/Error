package com.pk.db.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.db.domain.Item;

//Bean(�������� �����ϴ� �ν��Ͻ�)�� �ڵ��������ְ� 
//������ ���õ� Ŭ������� �˷��ֱ� ���� ������̼�
@Repository
public class HibernateDao {
	//���̹�����Ʈ�� ����� �� �ִ� �ν��Ͻ��� ����
	@Autowired
	private SessionFactory sessionFactory;
	
	//��ü ������ �������� �޼ҵ�
	public List<Item> allItem(){
		return sessionFactory.getCurrentSession()
				.createCriteria(Item.class).list();
	}
	
	//������ 1���� �������� �޼ҵ�
	public Item getItem(int itemid) {
		return sessionFactory.getCurrentSession()
				.get(Item.class, itemid);
	}
}