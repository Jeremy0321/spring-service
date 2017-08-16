package com.jeremy.pattern.strategy;

import java.util.List;

public interface PermissionStrategy {

	void savePermissionInfo(Integer userId, List<Integer> permissionIds);
	
	List<Integer> getPermissionInfoByUserId(Integer userId);
	
	
}
