package com.gtercn.travel.service;

import java.util.List;
import java.util.Map;

import com.gtercn.travel.bean.Shop;

public interface ShopService {
	
	public List<Shop> shopList(Map<String,Object> map);
	public Integer getTotalCount();
	Shop queryByPrimaryKey(String id);
	
	/**
	 * RedisTemplate就是spring对redis的一个封装而已
	 * 添加
	 * @param map
	 * @return
	 * 2017-4-17 下午05:31:00
	 */
	public boolean redisTemplateSave(Shop shop);
	/**
	 * 添加list
	 * @param list
	 * 2017-4-18 上午10:49:17
	 */
	public void redisTemplateSaveList(List<Shop> list);
	
	public List<Shop> redisTemplateGetList(String keys);
	
	public void redisTemplateDelete(List<String> keys);
	
	public void redisTemplateUpdate(Shop shop);
}
