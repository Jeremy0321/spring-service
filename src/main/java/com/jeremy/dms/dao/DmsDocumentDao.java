package com.jeremy.dms.dao;

import com.jeremy.dms.bean.DmsDocument;

public class DmsDocumentDao {

	public int insert(DmsDocument dmsDocument){
		System.out.println("insert dms document ...");
		return 1;
	}
	
	public int updateById(DmsDocument dmsDocument){
		System.out.println("update by id ...");
		return 1;
	}
	
	public int deleteById(int id){
		System.out.println("delete by id ...");
		return 1;
	}
	
	public DmsDocument selectById(int id){
		DmsDocument dmsDocument = new DmsDocument();
		dmsDocument.setDocumentName("身份证反面");
		dmsDocument.setRootId(111);
		dmsDocument.setParentId(222);
		System.out.println("select document is :"+dmsDocument);
		return dmsDocument;
	}
}
