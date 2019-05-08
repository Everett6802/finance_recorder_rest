package com.price.finance_recorder_rest.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TPEOpenInterestEntity implements Serializable 
{
	private static final long serialVersionUID = 5873575094724915155L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

//	@Temporal(TemporalType.DATE)
	@Column(name = "trade_date", updatable = false, nullable = false)
	private Date tradeDate; // 日期

	@Column(name = "top_five", nullable = false)
	private int topFive; // 前五大

	@Column(name = "top_ten", nullable = false)
	private int topTen; // 前十大

	@Column(name = "top_five_specific_institutional_investors", nullable = false)
	private int topFiveSpecificInstitutionalInvestors; // 前五特法

	@Column(name = "top_ten_specific_institutional_investors", nullable = false)
	private int topTenSpecificInstitutionalInvestors; // 前十特法

	@Column(name = "foreign_investor", nullable = false)
	private int foreignInvestor; // 外資

	@Column(name = "investment_trust", nullable = false)
	private int investmentTrust; // 投信

	@Column(name = "dealer", nullable = false)
	private int dealer; // 自營商

	@Column(name = "close", nullable = false)
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
