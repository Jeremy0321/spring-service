package com.jeremy.dms.bean;

import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class AbstractBean implements Serializable{

	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		try{
			Class<?> clazz = this.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for(Field f:fields){
				f.setAccessible(true);
				Object obj = f.get(this);
				if(obj != null)
					sb.append(f.getName() + ":" + obj + "|");
			}
		}catch(Exception e){}
		if(sb.toString().length()>0){
			String result = sb.toString().substring(0, sb.toString().length()-1);
			return result;
		}
 		return "";
	}
	
}
