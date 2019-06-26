package com.price.finance_recorder_rest.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.price.finance_recorder_rest.common.CmnDef;
import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;

public class ProfitabilityDTO implements Serializable 
{
	private static final long serialVersionUID = 6118038017221896041L;
// IN
	private String datasetFolderpath;
	private int start;
	private int limit;
// OUT
	private Date tradeDate; // 日期
	private float grossProfitMargin; // 毛利率
	private float operatingProfitMargin; // 營業利益率
	private float pretaxIncomeMargin; // 稅前純益率
	private float netProfitMargin; // 稅後純益率
	private float returnOnEquity; // 稅後股東權益報酬率
	private float returnOnAssets; // 稅後資產報酬率
	private float turnoverPerShare; // 每股營業額
	private float netAssetValueOfEachShare; // 公告每股淨值
	private float earningsPerShare; // 每股稅後盈餘

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
		setGrossProfitMargin((float)field_list.get(1));
		setOperatingProfitMargin((float)field_list.get(2));
		setPretaxIncomeMargin((float)field_list.get(3));
		setNetProfitMargin((float)field_list.get(4));
		setReturnOnEquity((float)field_list.get(5));
		setReturnOnAssets((float)field_list.get(6));
		setTurnoverPerShare((float)field_list.get(7));
		setNetAssetValueOfEachShare((float)field_list.get(8));
		setEarningsPerShare((float)field_list.get(9));
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

	public float getGrossProfitMargin() {
		return grossProfitMargin;
	}

	public void setGrossProfitMargin(float grossProfitMargin) {
		this.grossProfitMargin = grossProfitMargin;
	}

	public float getOperatingProfitMargin() {
		return operatingProfitMargin;
	}

	public void setOperatingProfitMargin(float operatingProfitMargin) {
		this.operatingProfitMargin = operatingProfitMargin;
	}

	public float getPretaxIncomeMargin() {
		return pretaxIncomeMargin;
	}

	public void setPretaxIncomeMargin(float pretaxIncomeMargin) {
		this.pretaxIncomeMargin = pretaxIncomeMargin;
	}

	public float getNetProfitMargin() {
		return netProfitMargin;
	}

	public void setNetProfitMargin(float netProfitMargin) {
		this.netProfitMargin = netProfitMargin;
	}

	public float getReturnOnEquity() {
		return returnOnEquity;
	}

	public void setReturnOnEquity(float returnOnEquity) {
		this.returnOnEquity = returnOnEquity;
	}

	public float getReturnOnAssets() {
		return returnOnAssets;
	}

	public void setReturnOnAssets(float returnOnAssets) {
		this.returnOnAssets = returnOnAssets;
	}

	public float getTurnoverPerShare() {
		return turnoverPerShare;
	}

	public void setTurnoverPerShare(float turnoverPerShare) {
		this.turnoverPerShare = turnoverPerShare;
	}

	public float getNetAssetValueOfEachShare() {
		return netAssetValueOfEachShare;
	}

	public void setNetAssetValueOfEachShare(float netAssetValueOfEachShare) {
		this.netAssetValueOfEachShare = netAssetValueOfEachShare;
	}

	public float getEarningsPerShare() {
		return earningsPerShare;
	}

	public void setEarningsPerShare(float earningsPerShare) {
		this.earningsPerShare = earningsPerShare;
	}
}
