package com.springMVC.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMVC.dao.ItemsMapper;
import com.springMVC.pojo.Items;

/**
 * 查询商品信息
 * @author 郑ZL
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	//查询商品列表
	public List<Items> selectItemsList() {
		//选择selectByExampleWithBLOBs是为了查询到大的字符串如text类型
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	
	//以id查询
	public Items selectItemById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}
	
	//修改
	public void updateItemsById(Items items) {
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
