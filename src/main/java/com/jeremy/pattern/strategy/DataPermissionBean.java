package com.jeremy.pattern.strategy;

import java.util.List;

public class DataPermissionBean {

	List<Integer> orgIds;
	
	List<Integer> productIds;
	
	List<Integer> channelIds;

	public List<Integer> getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(List<Integer> orgIds) {
		this.orgIds = orgIds;
	}

	public List<Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}

	public List<Integer> getChannelIds() {
		return channelIds;
	}

	public void setChannelIds(List<Integer> channelIds) {
		this.channelIds = channelIds;
	}
	
	
}
