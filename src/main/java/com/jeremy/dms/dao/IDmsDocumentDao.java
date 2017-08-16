package com.jeremy.dms.dao;

import com.jeremy.dms.bean.DmsDocument;

public interface IDmsDocumentDao {

	public int insert(DmsDocument dmsDocument);
	
	public int updateById(DmsDocument dmsDocument);
	
	public int deleteById(int id);
	
	public DmsDocument selectById(int id);
	
}
