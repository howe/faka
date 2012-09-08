package com.esup.faka.bean;

import org.nutz.dao.entity.annotation.*;

import com.esup.faka.tool.DESPlus;

/**
* 发卡平台系统库存表
*/
@Table("es_card_stocks")
@PK({"id"})
public class Stocks {

	/**
	 * ID
	 */
	@Column("id")
	private Integer id;
	/**
	 * 卡号
	 */
	@Column("cardNO")
	private String cardNo;
	/**
	 * 密码
	 */
	@Column("cardPWD")
	private String cardPwd;
	/**
	 * 激活或充值网址
	 */
	@Column("cardURL")
	private String cardUrl;
	/**
	 * 充值时限
	 */
	@Column("expiration")
	private String expiration;
	/**
	 * 卡的状态（0未售出，1已售出）
	 */
	@Column("status")
	private String status;
	/**
	 * 发卡平台订单表（es_card_order）ID
	 */
	@Column("orderId")
	private Integer orderId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardPwd() throws Exception {
		DESPlus des = new DESPlus();
		return des.decrypt(cardPwd);
	}
	public void setCardPwd(String cardPwd) throws Exception {
		DESPlus des = new DESPlus();
		this.cardPwd = des.encrypt(cardPwd);
	}
	public String getCardUrl() {
		return cardUrl;
	}
	public void setCardUrl(String cardUrl) {
		this.cardUrl = cardUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	
}