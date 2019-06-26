package com.price.finance_recorder_rest.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.price.finance_recorder_rest.common.CmnDef;
import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;

public class InstitutionalInvestorNetBuySellDTO implements Serializable 
{
	private static final long serialVersionUID = -3589545262634171060L;
// IN
	private String datasetFolderpath;
	private int start;
	private int limit;
// OUT
	private Date tradeDate; // 日期
	private float close; // 成交
	private float netChange; // 漲跌
	private float netChangeRatio; // 漲跌(%)
	private int volume; // 成交量(張)
	private int foreignInvestorBuy; // 外資 (張):買進
	private int foreignInvestorSell; // 外資 (張):賣出
	private int foreignInvestorNetBuyAndSell; // 外資 (張):買賣超
	private int foreignInvestorShareHolding; // 外資 (張):持有張數
	private float foreignInvestorShareHoldingRatio; // 外資 (張):持股比率
	private int investmentTrustBuy; // 投信 (張):買進
	private int investmentTrustSell; // 投信 (張):賣出
	private int investmentTrustNetBuyAndSell; // 投信 (張):買賣超
	private int dealerBuy; // 自營商 (張):買進
	private int dealerSell; // 自營商 (張):賣出
	private int dealerNetBuyAndSell; // 自營商 (張):買賣超
	private int institutionalInvestorBuy; // 法人合計 (張):買進
	private int institutionalInvestorSell; // 法人合計 (張):賣出
	private int institutionalInvestorNetBuyAndSell; // 法人合計 (張):買賣超


	public void validateRequiredFields() throws MissingRequiredFieldException
	{
		if (datasetFolderpath == null)
			datasetFolderpath = CmnDef.FINANCE_DATASET_FOLDER_PATH;
		if (start == 0)
			start = CmnDef.FINANCE_DATA_START_INDEX;
		if (limit == 0)
			limit = CmnDef.FINANCE_DATA_LIMIT;
	}

	void fillin_field(ArrayList<Object> field_list)
	{
//		String[] field_name_list = CmnDBDef.get_table_field_name_definition(CmnDef.FinanceMethod.FinanceMethod_StockPriceAndVolume);
		String trade_date_str = (String)field_list.get(0);
		try 
		{
			Date trade_date = new SimpleDateFormat("yyyy-MM-dd").parse(trade_date_str);
			setTradeDate(trade_date);
		} 
		catch (ParseException e) 
		{
			String errmsg = String.format("Fail to parse the trade date time in DTO[%s]", CmnDef.FINANCE_METHOD_DESCRIPTION_LIST[CmnDef.FinanceMethod.FinanceMethod_StockPriceAndVolume.value()]);
			throw new IllegalArgumentException(errmsg);
		}
		setClose((float)field_list.get(1));
		setNetChange((float)field_list.get(2));
		setNetChangeRatio((float)field_list.get(3));
		setVolume((int)field_list.get(4));
		setForeignInvestorBuy((int)field_list.get(5));
		setForeignInvestorSell((int)field_list.get(6));
		setForeignInvestorNetBuyAndSell((int)field_list.get(7));
		setForeignInvestorShareHolding((int)field_list.get(8));
		setForeignInvestorShareHoldingRatio((float)field_list.get(9));
		setInvestmentTrustBuy((int)field_list.get(10));
		setInvestmentTrustSell((int)field_list.get(11));
		setInvestmentTrustNetBuyAndSell((int)field_list.get(12));
		setDealerBuy((int)field_list.get(13));
		setDealerSell((int)field_list.get(14));
		setDealerNetBuyAndSell((int)field_list.get(15));
		setInstitutionalInvestorBuy((int)field_list.get(16));
		setInstitutionalInvestorSell((int)field_list.get(17));
		setInstitutionalInvestorNetBuyAndSell((int)field_list.get(18));
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

	public float getClose() {
		return close;
	}

	public void setClose(float close) {
		this.close = close;
	}

	public float getNetChange() {
		return netChange;
	}

	public void setNetChange(float netChange) {
		this.netChange = netChange;
	}

	public float getNetChangeRatio() {
		return netChangeRatio;
	}

	public void setNetChangeRatio(float netChangeRatio) {
		this.netChangeRatio = netChangeRatio;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getForeignInvestorBuy() {
		return foreignInvestorBuy;
	}

	public void setForeignInvestorBuy(int foreignInvestorBuy) {
		this.foreignInvestorBuy = foreignInvestorBuy;
	}

	public int getForeignInvestorSell() {
		return foreignInvestorSell;
	}

	public void setForeignInvestorSell(int foreignInvestorSell) {
		this.foreignInvestorSell = foreignInvestorSell;
	}

	public int getForeignInvestorNetBuyAndSell() {
		return foreignInvestorNetBuyAndSell;
	}

	public void setForeignInvestorNetBuyAndSell(int foreignInvestorNetBuyAndSell) {
		this.foreignInvestorNetBuyAndSell = foreignInvestorNetBuyAndSell;
	}

	public int getForeignInvestorShareHolding() {
		return foreignInvestorShareHolding;
	}

	public void setForeignInvestorShareHolding(int foreignInvestorShareHolding) {
		this.foreignInvestorShareHolding = foreignInvestorShareHolding;
	}

	public float getForeignInvestorShareHoldingRatio() {
		return foreignInvestorShareHoldingRatio;
	}

	public void setForeignInvestorShareHoldingRatio(float foreignInvestorShareHoldingRatio) {
		this.foreignInvestorShareHoldingRatio = foreignInvestorShareHoldingRatio;
	}

	public int getInvestmentTrustBuy() {
		return investmentTrustBuy;
	}

	public void setInvestmentTrustBuy(int investmentTrustBuy) {
		this.investmentTrustBuy = investmentTrustBuy;
	}

	public int getInvestmentTrustSell() {
		return investmentTrustSell;
	}

	public void setInvestmentTrustSell(int investmentTrustSell) {
		this.investmentTrustSell = investmentTrustSell;
	}

	public int getInvestmentTrustNetBuyAndSell() {
		return investmentTrustNetBuyAndSell;
	}

	public void setInvestmentTrustNetBuyAndSell(int investmentTrustNetBuyAndSell) {
		this.investmentTrustNetBuyAndSell = investmentTrustNetBuyAndSell;
	}

	public int getDealerBuy() {
		return dealerBuy;
	}

	public void setDealerBuy(int dealerBuy) {
		this.dealerBuy = dealerBuy;
	}

	public int getDealerSell() {
		return dealerSell;
	}

	public void setDealerSell(int dealerSell) {
		this.dealerSell = dealerSell;
	}

	public int getDealerNetBuyAndSell() {
		return dealerNetBuyAndSell;
	}

	public void setDealerNetBuyAndSell(int dealerNetBuyAndSell) {
		this.dealerNetBuyAndSell = dealerNetBuyAndSell;
	}

	public int getInstitutionalInvestorBuy() {
		return institutionalInvestorBuy;
	}

	public void setInstitutionalInvestorBuy(int institutionalInvestorBuy) {
		this.institutionalInvestorBuy = institutionalInvestorBuy;
	}

	public int getInstitutionalInvestorSell() {
		return institutionalInvestorSell;
	}

	public void setInstitutionalInvestorSell(int institutionalInvestorSell) {
		this.institutionalInvestorSell = institutionalInvestorSell;
	}

	public int getInstitutionalInvestorNetBuyAndSell() {
		return institutionalInvestorNetBuyAndSell;
	}

	public void setInstitutionalInvestorNetBuyAndSell(int institutionalInvestorNetBuyAndSell) {
		this.institutionalInvestorNetBuyAndSell = institutionalInvestorNetBuyAndSell;
	}
}
