package com.price.finance_recorder_rest.entrypoints;

import java.util.Date;

public class TPEOpenInterestGetRsp 
{
	private Date tradeDate; // 日期
	private int topFive; // 前五大
	private int topTen; // 前十大
	private int topFiveSpecificInstitutionalInvestors; // 前五特法
	private int topTenSpecificInstitutionalInvestors; // 前十特法
	private int foreignInvestor; // 外資
	private int investmentTrust; // 投信
	private int dealer; // 自營商
	private int close; // 收盤

	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public int getTopFive() {
		return topFive;
	}
	public void setTopFive(int topFive) {
		this.topFive = topFive;
	}
	public int getTopTen() {
		return topTen;
	}
	public void setTopTen(int topTen) {
		this.topTen = topTen;
	}
	public int getTopFiveSpecificInstitutionalInvestors() {
		return topFiveSpecificInstitutionalInvestors;
	}
	public void setTopFiveSpecificInstitutionalInvestors(int topFiveSpecificInstitutionalInvestors) {
		this.topFiveSpecificInstitutionalInvestors = topFiveSpecificInstitutionalInvestors;
	}
	public int getTopTenSpecificInstitutionalInvestors() {
		return topTenSpecificInstitutionalInvestors;
	}
	public void setTopTenSpecificInstitutionalInvestors(int topTenSpecificInstitutionalInvestors) {
		this.topTenSpecificInstitutionalInvestors = topTenSpecificInstitutionalInvestors;
	}
	public int getForeignInvestor() {
		return foreignInvestor;
	}
	public void setForeignInvestor(int foreignInvestor) {
		this.foreignInvestor = foreignInvestor;
	}
	public int getInvestmentTrust() {
		return investmentTrust;
	}
	public void setInvestmentTrust(int investmentTrust) {
		this.investmentTrust = investmentTrust;
	}
	public int getDealer() {
		return dealer;
	}
	public void setDealer(int dealer) {
		this.dealer = dealer;
	}
	public int getClose() {
		return close;
	}
	public void setClose(int close) {
		this.close = close;
	}
}
