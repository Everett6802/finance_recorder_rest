package com.price.finance_recorder_rest.entrypoints;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RevenueGetRsp 
{
	private Date tradeDate; // 日期
	private float monthlyRevenue; // 單月營收
	private float monthlyMomGrowth; // 單月月增率
	private float monthlyYoyGrowth; // 單月年增率
	private float cumulativeRevenue; // 累計營收
	private float cumulativeYoyGrowth; // 累計年增率
	private float earngins; // 盈餘
	private float earnginsPerShare; // 每股盈餘（元）
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public float getMonthlyRevenue() {
		return monthlyRevenue;
	}
	public void setMonthlyRevenue(float monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}
	public float getMonthlyMomGrowth() {
		return monthlyMomGrowth;
	}
	public void setMonthlyMomGrowth(float monthlyMomGrowth) {
		this.monthlyMomGrowth = monthlyMomGrowth;
	}
	public float getMonthlyYoyGrowth() {
		return monthlyYoyGrowth;
	}
	public void setMonthlyYoyGrowth(float monthlyYoyGrowth) {
		this.monthlyYoyGrowth = monthlyYoyGrowth;
	}
	public float getCumulativeRevenue() {
		return cumulativeRevenue;
	}
	public void setCumulativeRevenue(float cumulativeRevenue) {
		this.cumulativeRevenue = cumulativeRevenue;
	}
	public float getCumulativeYoyGrowth() {
		return cumulativeYoyGrowth;
	}
	public void setCumulativeYoyGrowth(float cumulativeYoyGrowth) {
		this.cumulativeYoyGrowth = cumulativeYoyGrowth;
	}
	public float getEarngins() {
		return earngins;
	}
	public void setEarngins(float earngins) {
		this.earngins = earngins;
	}
	public float getEarnginsPerShare() {
		return earnginsPerShare;
	}
	public void setEarnginsPerShare(float earnginsPerShare) {
		this.earnginsPerShare = earnginsPerShare;
	}

}
