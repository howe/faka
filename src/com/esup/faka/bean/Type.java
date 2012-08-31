package com.esup.faka.bean;

import org.nutz.dao.entity.annotation.*;

/**
* 
*/
@PK({"id"})
@Table("es_card_type")
public class Type {

	/**
	 * ID
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 物品所属项目名（游戏名称等）
	 */
	@Column("itemName")
	private String itemName;
	/**
	 * 物品类型名（XXX激活码，点卡等）
	 */
	@Column("typeName")
	private String typeName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}