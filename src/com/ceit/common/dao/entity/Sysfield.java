package com.ceit.common.dao.entity;

/**
 * 查询数据表属性值实体
 * @author wujinshui
 *
 */

public class Sysfield implements java.io.Serializable {

	private static final long serialVersionUID = -5122693330646156514L;
	// Fields

	private Integer id;        //流水号
	private Integer tableid;    //表ID
	private String name;       //名称
	private String fieldname;  //字段名称
	private String type;       //类型
	private String isnull;     //能否为空
	private Integer length;    //长度
	private String defaults;   //默认值
	private String isprimary;  //是否为主键
	private String memo;       //备注ע

	// Constructors

	/** default constructor */
	public Sysfield() {
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getIsnull() {
		return this.isnull;
	}

	public void setIsnull(String isnull) {
		this.isnull = isnull;
	}

	public Integer getLength() {
		return this.length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getDefaults() {
		return this.defaults;
	}

	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}

	public String getIsprimary() {
		return this.isprimary;
	}

	public void setIsprimary(String isprimary) {
		this.isprimary = isprimary;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getTableid() {
		return tableid;
	}

	public void setTableid(Integer tableid) {
		this.tableid = tableid;
	}

}