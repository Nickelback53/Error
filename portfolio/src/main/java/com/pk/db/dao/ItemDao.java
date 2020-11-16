package com.pk.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pk.db.domain.Item;

public interface ItemDao {
	//Item ���̺��� ��� �����͸� �������� �޼ҵ�
	@Select("select * from item")
	public List<Item> allItem();
	
	//Item ���̺��� ItemId�� �̿��ؼ� ������ 1���� ã�ƿ��� �޼ҵ�
	@Select("select * from item where itemid = #{itemid}")
	public Item getItem(int itemid);
}