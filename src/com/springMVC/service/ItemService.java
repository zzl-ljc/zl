package com.springMVC.service;

import java.util.List;

import com.springMVC.pojo.Items;

public interface ItemService {

	public List<Items> selectItemsList();
	
	public Items selectItemById(Integer id);
	
	public void updateItemsById(Items items);
}
