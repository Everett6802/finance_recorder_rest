package com.price.finance_recorder_rest.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.price.finance_recorder_rest.common.CmnDef;
import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;

public class RevenueDTO implements Serializable 
{
	private static final long serialVersionUID = -6767328983730835689L;
// IN
	private String datasetFolderpath;
	private int start;
	private int limit;
// OUT
	private Date tradeDate; // 日期
	private float monthlyRevenue; // 單月營收
	private float monthlyMomGrowth; // 單月月增率
	private float monthlyYoyGrowth; // 單月年增率
	private float cumulativeRevenue; // 累計營收
	private float cumulativeYoyGrowth; // 累計年增率
	private float earngins; // 盈餘
	private float earnginsPerShare; // 每股盈餘（元）

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
		setMonthlyRevenue((float)field_list.get(1));
		setMonthlyMomGrowth((float)field_list.get(2));
		setMonthlyYoyGrowth((float)field_list.get(3));
		setCumulativeRevenue((float)field_list.get(4));
		setCumulativeYoyGrowth((float)field_list.get(5));
		setEarngins((float)field_list.get(6));
		setEarnginsPerShare((float)field_list.get(7));
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
