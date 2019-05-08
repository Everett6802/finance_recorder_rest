package com.price.finance_recorder_rest.service;

import java.io.Serializable;
import java.util.Date;

import com.price.finance_recorder_rest.common.CmnDef;
import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;

public class VIXDTO implements Serializable 
{
	private static final long serialVersionUID = -7691913412504500181L;
// IN
	private String datasetFolderpath;
	private int start;
	private int limit;
// OUT
	private Date tradeDate; // 日期
	private float vix; // 指數
	private float change_ratio; // 漲跌比例

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
