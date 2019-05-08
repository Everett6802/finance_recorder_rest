package com.price.finance_recorder_rest.entrypoints;

import java.util.Date;

public class VIXGetRsp 
{
	private Date tradeDate; // 日期
	private float vix; // 指數
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
