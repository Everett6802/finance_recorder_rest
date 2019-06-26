package com.price.finance_recorder_rest.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.price.finance_recorder_rest.common.CmnDef;
import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;

public class CashflowStatementDTO implements Serializable 
{
	private static final long serialVersionUID = -2067693416931014370L;
// IN
	private String datasetFolderpath;
	private int start;
	private int limit;
// OUT
	private Date tradeDate; // 日期
	private float incomeBeforeTax; // 稅前純益
	private float cashFlowFromOperatingActivities; // 營業活動現金流量
	private float cashFlowFromInvestingActivities; // 投資活動現金流量
	private float cashFlowFromFinancingActivities; // 理財活動現金流量
	private float netCashFlow; // 淨現金流量
	private float cashBalancesEndOfPeriod; // 期末現金及約當現金
	private float freeCashFlow; // 自由現金流量


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
		setIncomeBeforeTax((float)field_list.get(1));
		setCashFlowFromOperatingActivities((float)field_list.get(2));
		setCashFlowFromInvestingActivities((float)field_list.get(3));
		setCashFlowFromFinancingActivities((float)field_list.get(4));
		setNetCashFlow((float)field_list.get(5));
		setCashBalancesEndOfPeriod((float)field_list.get(6));
		setFreeCashFlow((float)field_list.get(7));
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
	public float getIncomeBeforeTax() {
		return incomeBeforeTax;
	}
	public void setIncomeBeforeTax(float incomeBeforeTax) {
		this.incomeBeforeTax = incomeBeforeTax;
	}
	public float getCashFlowFromOperatingActivities() {
		return cashFlowFromOperatingActivities;
	}
	public void setCashFlowFromOperatingActivities(float cashFlowFromOperatingActivities) {
		this.cashFlowFromOperatingActivities = cashFlowFromOperatingActivities;
	}
	public float getCashFlowFromInvestingActivities() {
		return cashFlowFromInvestingActivities;
	}
	public void setCashFlowFromInvestingActivities(float cashFlowFromInvestingActivities) {
		this.cashFlowFromInvestingActivities = cashFlowFromInvestingActivities;
	}
	public float getCashFlowFromFinancingActivities() {
		return cashFlowFromFinancingActivities;
	}
	public void setCashFlowFromFinancingActivities(float cashFlowFromFinancingActivities) {
		this.cashFlowFromFinancingActivities = cashFlowFromFinancingActivities;
	}
	public float getNetCashFlow() {
		return netCashFlow;
	}
	public void setNetCashFlow(float netCashFlow) {
		this.netCashFlow = netCashFlow;
	}
	public float getCashBalancesEndOfPeriod() {
		return cashBalancesEndOfPeriod;
	}
	public void setCashBalancesEndOfPeriod(float cashBalancesEndOfPeriod) {
		this.cashBalancesEndOfPeriod = cashBalancesEndOfPeriod;
	}
	public float getFreeCashFlow() {
		return freeCashFlow;
	}
	public void setFreeCashFlow(float freeCashFlow) {
		this.freeCashFlow = freeCashFlow;
	}
}
