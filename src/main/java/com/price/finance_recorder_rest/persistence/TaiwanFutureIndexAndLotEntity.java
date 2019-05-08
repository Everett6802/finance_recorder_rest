package com.price.finance_recorder_rest.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "taiwan_future_index_and_lot")
public class TaiwanFutureIndexAndLotEntity implements Serializable 
{
	private static final long serialVersionUID = -9185082842697441379L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

//	@Temporal(TemporalType.DATE)
	@Column(name = "trade_date", updatable = false, nullable = false)
	private Date tradeDate; // 日期

	@Column(name = "open", nullable = false)
	private int open; // 開盤價

	@Column(name = "high", nullable = false)
	private int high; // 最高價

	@Column(name = "low", nullable = false)
	private int low; // 最低價

	@Column(name = "close", nullable = false)
	private int close; // 最後成交價

	@Column(name = "net_change", nullable = false)
	private int netChange; // 漲跌價

	@Column(name = "net_change_ratio", nullable = false)
	private float netChangeRatio; // 漲跌%

	@Column(name = "volume_after_hours_trading", nullable = false)
	private int volumeAfterHoursTrading; // 盤後交易時段成交量

	@Column(name = "volume_general_hours_trading", nullable = false)
	private int volumeGeneralHoursTrading; // 一般交易時段成交量

	@Column(name = "total_volume", nullable = false)
	private int totalVolume; // 合計成交量

	@Column(name = "settlement_price", nullable = false)
	private int settlementPrice; // 結算價

	@Column(name = "open_interest", nullable = false)
	private int openInterest; // 未沖銷契約量

	@Column(name = "best_buying_price", nullable = false)
	private int bestBuyingPrice; // 最後最佳買價

	@Column(name = "best_selling_price", nullable = false)
	private int bestSellingPrice; // 最後最佳賣價

	@Column(name = "price_ceiling", nullable = false)
	private int priceCeiling; // 歷史最高價

	@Column(name = "price_floor", nullable = false)
	private int priceFloor; // 歷史最低價

	public Date getTradeDate() 
	{
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) 
	{
		this.tradeDate = tradeDate;
	}
	public int getOpen() 
	{
		return open;
	}
	public void setOpen(int open) 
	{
		this.open = open;
	}
	public int getHigh() 
	{
		return high;
	}
	public void setHigh(int high) 
	{
		this.high = high;
	}
	public int getLow() 
	{
		return low;
	}
	public void setLow(int low) 
	{
		this.low = low;
	}
	public int getClose() 
	{
		return close;
	}
	public void setClose(int close) 
	{
		this.close = close;
	}

	public int getNetChange() 
	{
		return netChange;
	}

	public void setNetChange(int netChange) 
	{
		this.netChange = netChange;
	}

	public float getNetChangeRatio() 
	{
		return netChangeRatio;
	}

	public void setNetChangeRatio(float netChangeRatio) 
	{
		this.netChangeRatio = netChangeRatio;
	}

	public int getVolumeAfterHoursTrading() 
	{
		return volumeAfterHoursTrading;
	}

	public void setVolumeAfterHoursTrading(int volumeAfterHoursTrading) 
	{
		this.volumeAfterHoursTrading = volumeAfterHoursTrading;
	}

	public int getVolumeGeneralHoursTrading()
	{
		return volumeGeneralHoursTrading;
	}

	public void setVolumeGeneralHoursTrading(int volumeGeneralHoursTrading) 
	{
		this.volumeGeneralHoursTrading = volumeGeneralHoursTrading;
	}

	public int getTotalVolume() 
	{
		return totalVolume;
	}

	public void setTotalVolume(int totalVolume) 
	{
		this.totalVolume = totalVolume;
	}

	public int getSettlementPrice() 
	{
		return settlementPrice;
	}

	public void setSettlementPrice(int settlementPrice) 
	{
		this.settlementPrice = settlementPrice;
	}

	public int getOpenInterest() 
	{
		return openInterest;
	}

	public void setOpenInterest(int openInterest) 
	{
		this.openInterest = openInterest;
	}

	public int getBestBuyingPrice() 
	{
		return bestBuyingPrice;
	}

	public void setBestBuyingPrice(int bestBuyingPrice) 
	{
		this.bestBuyingPrice = bestBuyingPrice;
	}

	public int getBestSellingPrice() 
	{
		return bestSellingPrice;
	}

	public void setBestSellingPrice(int bestSellingPrice) 
	{
		this.bestSellingPrice = bestSellingPrice;
	}

	public int getPriceCeiling() 
	{
		return priceCeiling;
	}

	public void setPriceCeiling(int priceCeiling) 
	{
		this.priceCeiling = priceCeiling;
	}

	public int getPriceFloor() 
	{
		return priceFloor;
	}

	public void setPriceFloor(int priceFloor) 
	{
		this.priceFloor = priceFloor;
	}


}
