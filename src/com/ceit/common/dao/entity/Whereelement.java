package com.ceit.common.dao.entity;

/**
 * 实体集查询条件实体
 * @author wujinshui
 *
 */

public class Whereelement implements java.io.Serializable {

	private static final long serialVersionUID = -1406971133492536356L;
	
	private Integer id;
	private Integer rolesysfunctionid; //role_sysfunction的id 
	private String fieldname;			//查询字段sysfieldname的名字
	private String type;				//>= <= like = ...
	private String value;				//查询字段sysfieldname的值ֵ

	// Constructors

	/** default constructor */
	public Whereelement() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRolesysfunctionid() {
		return this.rolesysfunctionid;
	}

	public void setRolesysfunctionid(Integer rolesysfunctionid) {
		this.rolesysfunctionid = rolesysfunctionid;
	}

	public String getFieldname() {
		return this.fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
