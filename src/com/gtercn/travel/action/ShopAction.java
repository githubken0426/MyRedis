package com.gtercn.travel.action;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.gtercn.travel.bean.Shop;
import com.gtercn.travel.redis.RedisTemplateCacheUtil;
import com.gtercn.travel.service.ShopService;
import com.gtercn.travel.utils.CachedKeys;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ShopAction {
	@Autowired
	private ShopService shopService;
	@Autowired
    protected RedisTemplate<Serializable, Serializable> redisTemplate;
	@Autowired
	private RedisTemplateCacheUtil<Shop> redisTemplateCacheUtil;
	/**
	 * Redis
	 * 
	 * 加入缓存
	 * @return
	 * 2017-4-18 下午02:15:15
	 */
	public String redisTemplateAddList(){
		Map<String,Object> map =new HashMap<String,Object>();
		ActionContext context = ActionContext.getContext();
		try {
			List<Shop> list = shopService.shopList(map);
//			shopService.redisTemplateSaveList(list);
			redisTemplateCacheUtil.setCacheList(CachedKeys.SHOP_KEYS_LIST, list);
			context.put("shopList",list);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return "shop_list";
	}
	
	/**
	 * 缓存的数据
	 * @return
	 * 2017-4-18 下午02:13:55
	 */
	public String redisTemplateGetList(){
		ActionContext context = ActionContext.getContext();
		try {
//			List<Shop> result=shopService.redisTemplateGetList(CachedKeys.SHOP_KEYS_LIST);
			List<Shop> result = redisTemplateCacheUtil.getCacheList(CachedKeys.SHOP_KEYS_LIST);
			context.put("shopList",result);
		} catch (Exception e) {
			e.printStackTrace();
			return Action.ERROR;
		}
		return "cache_list";
	}
	
}
