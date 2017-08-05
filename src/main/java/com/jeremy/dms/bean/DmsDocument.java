package com.jeremy.dms.bean;

public class DmsDocument extends AbstractBean{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8287808151928260072L;
	
	private Integer id;
	private String documentName;
	private String referenceNo;
	private Integer rootId;
	private Integer parentId;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public Integer getRootId() {
		return rootId;
	}
	public void setRootId(Integer rootId) {
		this.rootId = rootId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public DmsDocument() {
		super();
		System.out.println("DmsDocument constructor init ...");
	}
	
	public void init(){
		System.out.println("DmsDocument init-method ...");
	}
	
	public void destroy(){
		System.out.println("DmsDocument destroy-method ...");
	}
}
