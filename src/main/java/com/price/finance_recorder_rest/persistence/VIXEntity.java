package com.price.finance_recorder_rest.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VIXEntity implements Serializable 
{
	private static final long serialVersionUID = 6459057468305393558L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

//	@Temporal(TemporalType.DATE)
	@Column(name = "trade_date", updatable = false, nullable = false)
	private Date tradeDate; // 日期

	@Column(name = "vix", nullable = false)
	private float vix; // 指數

	@Column(name = "change_ratio", nullable = false)
	private float change_ratio; // 漲跌比例

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public float getVix() {
		return vix;
	}

	public void setVix(float vix) {
		this.vix = vix;
	}

	public float getChange_ratio() {
		return change_ratio;
	}

	public void setChange_ratio(float change_ratio) {
		this.change_ratio = change_ratio;
	}
}
