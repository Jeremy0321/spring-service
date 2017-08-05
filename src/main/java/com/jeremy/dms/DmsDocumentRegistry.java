package com.jeremy.dms;

import java.util.List;

import com.jeremy.dms.bean.DmsDocument;

public class DmsDocumentRegistry {

	private List<DmsDocument> documents;
	
	DmsDocumentService dmsDocumentService;
	
	
	
	public DmsDocumentRegistry() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("DmsDocumentRegistry constructor init...");
	}

	void registry(DmsDocument document){
		documents.add(document);
	}

	public DmsDocumentService getDmsDocumentService() {
		return dmsDocumentService;
	}

	public void setDmsDocumentService(DmsDocumentService dmsDocumentService) {
		this.dmsDocumentService = dmsDocumentService;
	}

}
