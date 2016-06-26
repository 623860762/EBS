package com.ceit.common.dao.entity;

/**
 * 排序条件实体
 * @author wujinshui
 */

public class Orderby  implements java.io.Serializable {

	private static final long serialVersionUID = 8269942530942910999L;
	
	private Integer id;
    private String name; 
    private String type; //desc or asc
    private Integer rolesysfunctionid;
    private Integer dispindex;


   /** default constructor */
   public Orderby() {
   }
   
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

   public String getType() {
       return this.type;
   }
   
   public void setType(String type) {
       this.type = type;
   }

	public Integer getRolesysfunctionid() {
		return rolesysfunctionid;
	}

	public void setRolesysfunctionid(Integer rolesysfunctionid) {
		this.rolesysfunctionid = rolesysfunctionid;
	}

	public Integer getDispindex() {
		return dispindex;
	}

	public void setDispindex(Integer dispindex) {
		this.dispindex = dispindex;
	}
	

}