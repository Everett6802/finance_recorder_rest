package com.price.finance_recorder_rest.service;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.price.finance_recorder_rest.common.CmnDef;
import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;

public class TaiwanFutureIndexAndLotDTO implements Serializable 
{
	private static final long serialVersionUID = -3352941241141069815L;
// IN
	private String datasetFolderpath;
	private int start;
	private int limit;
// OUT
	private Date tradeDate; // 日期
	private int open; // 開盤價
	private int high; // 最高價
	private int low; // 最低價
	private int close; // 最後成交價
	private int netChange; // 漲跌價
	private float netChangeRatio; // 漲跌%
	private int volumeAfterHoursTrading; // 盤後交易時段成交量
	private int volumeGeneralHoursTrading; // 一般交易時段成交量
	private int totalVolume; // 合計成交量
	private int settlementPrice; // 結算價
	private int openInterest; // 未沖銷契約量
	private int bestBuyingPrice; // 最後最佳買價
	private int bestSellingPrice; // 最後最佳賣價
	private int priceCeiling; // 歷史最高價
	private int priceFloor; // 歷史最低價

	public void validateRequiredFields() throws MissingRequiredFieldException
	{
		if (datasetFolderpath == null)
			datasetFolderpath = CmnDef.FINANCE_DATASET_FOLDER_PATH;
		if (start == 0)
			start = CmnDef.FINANCE_DATA_START_INDEX;
		if (limit == 0)
			limit = CmnDef.FINANCE_DATA_LIMIT;
//		if ((userDto.getFirstName() == null) || userDto.getFirstName().isEmpty() || (userDto.getLastName() == null) || userDto.getLastName().isEmpty() || (userDto.getEmail() == null) || userDto
//				.getEmail().isEmpty() || (userDto.getPassword() == null) || userDto.getPassword().isEmpty())
//		{
//			throw new MissingRequiredFieldException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
//		}
	}

	public String getDatasetFolderpath() 
	{
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

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getClose() {
		return close;
	}

	public void setClose(int close) {
		this.close = close;
	}

	public int getNetChange() {
		return netChange;
	}

	public void setNetChange(int netChange) {
		this.netChange = netChange;
	}

	public float getNetChangeRatio() {
		return netChangeRatio;
	}

	public void setNetChangeRatio(float netChangeRatio) {
		this.netChangeRatio = netChangeRatio;
	}

	public int getVolumeAfterHoursTrading() {
		return volumeAfterHoursTrading;
	}

	public void setVolumeAfterHoursTrading(int volumeAfterHoursTrading) {
		this.volumeAfterHoursTrading = volumeAfterHoursTrading;
	}

	public int getVolumeGeneralHoursTrading() {
		return volumeGeneralHoursTrading;
	}

	public void setVolumeGeneralHoursTrading(int volumeGeneralHoursTrading) {
		this.volumeGeneralHoursTrading = volumeGeneralHoursTrading;
	}

	public int getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(int totalVolume) {
		this.totalVolume = totalVolume;
	}

	public int getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(int settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public int getOpenInterest() {
		return openInterest;
	}

	public void setOpenInterest(int openInterest) {
		this.openInterest = openInterest;
	}

	public int getBestBuyingPrice() {
		return bestBuyingPrice;
	}

	public void setBestBuyingPrice(int bestBuyingPrice) {
		this.bestBuyingPrice = bestBuyingPrice;
	}

	public int getBestSellingPrice() {
		return bestSellingPrice;
	}

	public void setBestSellingPrice(int bestSellingPrice) {
		this.bestSellingPrice = bestSellingPrice;
	}

	public int getPriceCeiling() {
		return priceCeiling;
	}

	public void setPriceCeiling(int priceCeiling) {
		this.priceCeiling = priceCeiling;
	}

	public int getPriceFloor() {
		return priceFloor;
	}

	public void setPriceFloor(int priceFloor) {
		this.priceFloor = priceFloor;
	}


}
