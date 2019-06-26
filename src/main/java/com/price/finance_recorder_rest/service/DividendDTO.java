package com.price.finance_recorder_rest.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.price.finance_recorder_rest.common.CmnDef;
import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;

public class DividendDTO implements Serializable 
{
	private static final long serialVersionUID = -2594896346517136787L;
// IN
	private String datasetFolderpath;
	private int start;
	private int limit;
// OUT
	private Date tradeDate; // 日期
	private float cashDividend; // 現金股利
	private float stockDividendFromRetainedEarnings; // 盈餘配股
	private float stockDividendFromCapitalReserve; // 公積配股
	private float stockDividend; // 股票股利合計
	private float dividend; // 股利合計

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
		setCashDividend((float)field_list.get(1));
		setStockDividendFromRetainedEarnings((float)field_list.get(2));
		setStockDividendFromCapitalReserve((float)field_list.get(3));
		setStockDividend((float)field_list.get(4));
		setDividend((long)field_list.get(8));
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

	public float getCashDividend() {
		return cashDividend;
	}

	public void setCashDividend(float cashDividend) {
		this.cashDividend = cashDividend;
	}

	public float getStockDividendFromRetainedEarnings() {
		return stockDividendFromRetainedEarnings;
	}

	public void setStockDividendFromRetainedEarnings(float stockDividendFromRetainedEarnings) {
		this.stockDividendFromRetainedEarnings = stockDividendFromRetainedEarnings;
	}

	public float getStockDividendFromCapitalReserve() {
		return stockDividendFromCapitalReserve;
	}

	public void setStockDividendFromCapitalReserve(float stockDividendFromCapitalReserve) {
		this.stockDividendFromCapitalReserve = stockDividendFromCapitalReserve;
	}

	public float getStockDividend() {
		return stockDividend;
	}

	public void setStockDividend(float stockDividend) {
		this.stockDividend = stockDividend;
	}

	public float getDividend() {
		return dividend;
	}

	public void setDividend(float dividend) {
		this.dividend = dividend;
	}
}
