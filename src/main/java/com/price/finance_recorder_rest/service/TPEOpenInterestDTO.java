package com.price.finance_recorder_rest.service;

import java.io.Serializable;
import java.util.Date;

import com.price.finance_recorder_rest.common.CmnDef;
import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;

public class TPEOpenInterestDTO implements Serializable 
{
	private static final long serialVersionUID = -4687014097535005682L;
// IN
	private String datasetFolderpath;
	private int start;
	private int limit;
// OUT
	private Date tradeDate; // 日期
	private int topFive; // 前五大
	private int topTen; // 前十大
	private int topFiveSpecificInstitutionalInvestors; // 前五特法
	private int topTenSpecificInstitutionalInvestors; // 前十特法
	private int foreignInvestor; // 外資
	private int investmentTrust; // 投信
	private int dealer; // 自營商
	private int close; // 收盤

	public void validateRequiredFields() throws MissingRequiredFieldException
	{
		if (datasetFolderpath == null)
			datasetFolderpath = CmnDef.FINANCE_DATASET_FOLDER_PATH;
		if (start == 0)
			start = CmnDef.FINANCE_DATA_START_INDEX;
		if (limit == 0)
			limit = CmnDef.FINANCE_DATA_LIMIT;
	}

	public String getDatasetFolderpath() {
		return datasetFolderpath;
	}

	public void setDatasetFolderpath(String datasetFolderpath) {
		this.datasetFolderpath = datasetFolderpath;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

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
