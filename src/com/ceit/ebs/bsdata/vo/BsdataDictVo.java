package  com.ceit.ebs.bsdata.vo;
import com.ceit.ebs.bsdata.entity.BsdataDict;

/**
 * BsdataDict 系统的基础数据数据字典构件
 * @author czg
 * date 2014-8-10
 */

public class BsdataDictVo implements java.io.Serializable {

	// Fields

	private Integer id;        //数据字典ID
	private String name;       //字典名称
	private Integer dispIndex; //排序索引
	private Integer parentId;  //父类节点
	private String remark;     //字典描述
	private String opTime;    //操作时间

	// Constructors

	/** default constructor */
	public BsdataDictVo() {
	}

	/** minimal constructor */
	public BsdataDictVo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public BsdataDictVo(Integer id, String name, Integer dispIndex, Integer parentId,
			String remark, String opTime) {
		this.id = id;
		this.name = name;
		this.dispIndex = dispIndex;
		this.parentId = parentId;
		this.remark = remark;
		this.opTime = opTime;
	}

	
	//po-->vo
	public BsdataDictVo(BsdataDict b){
		this.setId(b.getId());
		this.setName(b.getName());
		this.setDispIndex(b.getDispIndex());
		this.setParentId(b.getParentId());
		this.setRemark(b.getRemark());
		this.setOpTime(b.getOpTime());
	}
		
	//vo-->po
	public BsdataDict adapterToBsdataDict(){
		BsdataDict b=new BsdataDict();
		b.setId(this.getId());
		b.setName(this.getName());
		b.setDispIndex(this.getDispIndex());
		b.setParentId(this.getParentId());
		b.setRemark(this.getRemark());
		b.setOpTime(this.getOpTime());
		return b;
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

	public Integer getDispIndex() {
		return this.dispIndex;
	}

	public void setDispIndex(Integer dispIndex) {
		this.dispIndex = dispIndex;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOpTime() {
		return this.opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

}