package com.esup.faka.bean;

import org.nutz.dao.entity.annotation.*;

/**
* 发卡平台系统订单表
*/
@Table("es_card_order")
@PK({"id"})
public class Order {

	/**
	 * ID
	 */
	@Id
	@Column("id")
	private Integer id;
	/**
	 * 订单编号（淘宝或拍拍订单号）
	 */
	@Column("orderNO")
	private String orderNo;
	/**
	 * 支付交易号（支付宝交易号、财付通订单号）
	 */
	@Column("paymentNO")
	private String paymentNo;
	/**
	 * 订单生成时间
	 */
	@Column("orderTime")
	private java.util.Date orderTime;
	/**
	 * 发卡平台库存表（es_card_stocks）ID
	 */
	@Column("stockId")
	private Integer stockId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo.replace("-", "");
	}
	public String getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo.replace("-", "");
	}
	public java.util.Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(java.util.Date orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	
}