package com.price.finance_recorder_rest.common;

import com.price.finance_recorder_rest.common.CmnDef.FinanceMethod;

public class CmnDBDef 
{
// taiwan_weighted_index_and_volume; 臺股指數及成交量
	public static final String[] TAIWAN_WEIGHTED_INDEX_AND_VOLUME_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"trade_volume", // 成交股數
		"turnover_in_value", // 成交金額
		"number_of_transactions", // 成交筆數
		"taiex", // 發行量加權股價指數
		"net_change", // 漲跌點數
	};
	public static final String[] TAIWAN_WEIGHTED_INDEX_AND_VOLUME_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"BIGINT", // 成交股數
		"BIGINT", // 成交金額
		"BIGINT", // 成交筆數
		"FLOAT", // 發行量加權股價指數
		"FLOAT", // 漲跌價差
	};

// taiwan_future_index_and_lot; 臺股期貨指數(近月)及成交口數
	public static final String[] TAIWAN_FUTURE_INDEX_AND_LOT_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"open", // 開盤價
		"high", // 最高價
		"low", // 最低價
		"close", // 最後成交價
		"net_change", // 漲跌價
		"net_change%", // 漲跌%
		"volume_after_hours_trading", // 盤後交易時段成交量
		"volume_general_hours_trading", // 一般交易時段成交量
		"total_volume", // 合計成交量
		"settlement_price", // 結算價
		"open_interest", // 未沖銷契約量
		"best_buying_price", // 最後最佳買價
		"best_selling_price", // 最後最佳賣價
		"price_ceiling", // 歷史最高價
		"price_floor", // 歷史最低價
	};
	public static final String[] TAIWAN_FUTURE_INDEX_AND_LOT_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"INT", // 開盤價
		"INT", // 最高價
		"INT", // 最低價
		"INT", // 最後成交價
		"INT", // 漲跌價
		"FLOAT", // 漲跌%
		"INT", // 盤後交易時段成交量
		"INT", // 一般交易時段成交量
		"INT", // 合計成交量
		"INT", // 結算價
		"INT", // 未沖銷契約量
		"INT", // 最後最佳買價
		"INT", // 最後最佳賣價
		"INT", // 歷史最高價
		"INT", // 歷史最低價
	};

// option_put_call_ratio; 臺指選擇權賣權買權比
	public static final String[] OPTION_PUT_CALL_RATIO_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"put_trading_volume", // 賣權成交量
		"call_trading_volume", // 買權成交量
		"put_call_trading_volume_ratio", // 買賣權成交量比率%
		"put_open_interest", // 賣權未平倉量
		"call_open_interest", // 買權未平倉量
		"put_call_open_interest_ratio", // 買賣權未平倉量比率%
	};
	public static final String[] OPTION_PUT_CALL_RATIO_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"INT", // 賣權成交量
		"INT", // 買權成交量
		"FLOAT", // 買賣權成交量比率%
		"INT", // 賣權未平倉量
		"INT", // 買權未平倉量
		"FLOAT", // 買賣權未平倉量比率%
	};

// tfe_open_interest; 台指期未平倉(大額近月、法人所有月)
	public static final String[] TFE_OPEN_INTEREST_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"top_five", // 前五大
		"top_ten", // 前十大
		"top_five_specific_institutional_investors", // 前五特法
		"top_ten_specific_institutional_investors", // 前十特法
		"foreign_investor", // 外資
		"investment_trust", // 投信
		"dealer", // 自營商
		"close", // 收盤
	};
	public static final String[] TFE_OPEN_INTEREST_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"INT", // 前五大
		"INT", // 前十大
		"INT", // 前五特法
		"INT", // 前十特法
		"INT", // 外資
		"INT", // 投信
		"INT", // 自營商
		"INT", // 收盤
	};

// vix; VIX波動率
	public static final String[] VIX_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"vix", // 指數
		"change_ratio", // 漲跌比例
	};
	public static final String[] VIX_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"FLOAT", // 指數
		"FLOAT", // 漲跌比例
	};

// revenue; 營收盈餘
	public static final String[] REVENUE_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"monthly_revenue", // 單月營收
		"monthly_mon_growth", // 單月月增率
		"monthly_yoy_growth", // 單月年增率
		"cumulative_revenue", // 累計營收
		"cumulative_yoy_growth", // 累計年增率
		"earngins", // 盈餘
		"earngins_per_share", // 每股盈餘（元）
	};
	public static final String[] REVENUE_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"FLOAT", // 單月營收
		"FLOAT", // 單月月增率
		"FLOAT", // 單月年增率
		"FLOAT", // 累計營收
		"FLOAT", // 累計年增率
		"FLOAT", // 盈餘
		"FLOAT", // 每股盈餘（元）
	};

// profitability; 獲利能力
	public static final String[] PROFITABILILTY_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"gross_profit_margin", // 毛利率
		"operating_profit_margin", // 營業利益率
		"pretax_income_margin", // 稅前純益率
		"net_profit_margin", // 稅後純益率
		"return_on_equity", // 稅後股東權益報酬率
		"return_on_assets", // 稅後資產報酬率
		"turnover_per_share", // 每股營業額
		"net_asset_value_of_each_share", // 公告每股淨值
		"earnings_per_share", // 每股稅後盈餘
	};
	public static final String[] PROFITABILILTY_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"FLOAT", // 毛利率
		"FLOAT", // 營業利益率
		"FLOAT", // 稅前純益率
		"FLOAT", // 稅後純益率
		"FLOAT", // 稅後股東權益報酬率
		"FLOAT", // 稅後資產報酬率
		"FLOAT", // 每股營業額
		"FLOAT", // 公告每股淨值
		"FLOAT", // 每股稅後盈餘
	};

// cashflow_statement; 現金流量表
	public static final String[] CASHFLOW_STATEMENT_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"income_before_tax", // 稅前純益
		"cash_flow_from_operating_activities", // 營業活動現金流量
		"cash_flow_from_investing_activities", // 投資活動現金流量
		"cash_flow_from_financing_activities", // 理財活動現金流量
		"net_cash_flow", // 淨現金流量
		"cash_balances_end_of_period", // 期末現金及約當現金
		"free_cash_flow", // 自由現金流量
	};
	public static final String[] CASHFLOW_STATEMENT_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"FLOAT", // 稅前純益
		"FLOAT", // 營業活動現金流量
		"FLOAT", // 投資活動現金流量
		"FLOAT", // 理財活動現金流量
		"FLOAT", // 淨現金流量
		"FLOAT", // 期末現金及約當現金
		"FLOAT", // 自由現金流量
	};

// dividend; 股利政策
	public static final String[] DIVIDEND_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"cash_dividend", // 現金股利
		"stock_dividend_from_retained_earnings", // 盈餘配股
		"stock_dividend_from_capital_reserve", // 公積配股
		"stock dividend", // 股票股利合計
		"dividend", // 股利合計
	};
	public static final String[] DIVIDEND_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"FLOAT", // 現金股利
		"FLOAT", // 盈餘配股
		"FLOAT", // 公積配股
		"FLOAT", // 股票股利合計
		"FLOAT", // 股利合計
	};

// institutional_investor_net_buy_sell; 三大法人買賣超
	public static final String[] INSTITUTIONAL_INVESTOR_NET_BUY_SELL_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"close", // 成交
		"net_change", // 漲跌
		"net_change%", // 漲跌(%)
		"volume", // 成交量(張)
		"foreign_investor_buy", // 外資 (張):買進
		"foreign_investor_sell", // 外資 (張):賣出
		"foreign_investor_net_buy_and_sell", // 外資 (張):買賣超
		"foreign_investor_share_holding", // 外資 (張):持有張數
		"foreign_investor_share_holding_ratio", // 外資 (張):持股比率
		"investment_trust_buy", // 投信 (張):買進
		"investment_trust_sell", // 投信 (張):賣出
		"investment_trust_net_buy_and_sell", // 投信 (張):買賣超
		"dealer_buy", // 自營商 (張):買進
		"dealer_sell", // 自營商 (張):賣出
		"dealer_net_buy_and_sell", // 自營商 (張):買賣超
		"institutional_investor_buy", // 法人合計 (張):買進
		"institutional_investor_sell", // 法人合計 (張):賣出
		"institutional_investor_net_buy_and_sell", // 法人合計 (張):買賣超
	};
	public static final String[] INSTITUTIONAL_INVESTOR_NET_BUY_SELL_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"FLOAT", // 成交
		"FLOAT", // 漲跌
		"FLOAT", // 漲跌(%)
		"INT", // 成交量(張)
		"INT", // 外資 (張):買進
		"INT", // 外資 (張):賣出
		"INT", // 外資 (張):買賣超
		"INT", // 外資 (張):持有張數
		"FLOAT", // 外資 (張):持股比率
		"INT", // 投信 (張):買進
		"INT", // 投信 (張):賣出
		"INT", // 投信 (張):買賣超
		"INT", // 自營商 (張):買進
		"INT", // 自營商 (張):賣出
		"INT", // 自營商 (張):買賣超
		"INT", // 法人合計 (張):買進
		"INT", // 法人合計 (張):賣出
		"INT", // 法人合計 (張):買賣超
	};

// stock_price_and_volume; 個股股價及成交量
	public static final String[] STOCK_PRICE_AND_VOLUME_TABLE_FIELD_NAME_DEFINITION = new String[] 
	{
		"trade_date", // 日期
		"trade_volume", // 成交股數
		"turnover_in_value", // 成交金額
		"open", // 開盤價
		"high", // 最高價
		"low", // 最低價
		"close", // 收盤價
		"net_change", // 漲跌價差
		"number_of_transactions", // 成交筆數
	};
	public static final String[] STOCK_PRICE_AND_VOLUME_TABLE_FIELD_TYPE_DEFINITION = new String[] 
	{
		"DATE NOT NULL PRIMARY KEY", // 日期
		"BIGINT", // 成交股數
		"BIGINT", // 成交金額
		"FLOAT", // 開盤價
		"FLOAT", // 最高價
		"FLOAT", // 最低價
		"FLOAT", // 收盤價
		"FLOAT", // 漲跌價差
		"BIGINT", // 成交筆數
	};
	
	public static String[] get_table_field_name_definition(FinanceMethod finance_method)
	{
		switch (finance_method)
		{
		case FinanceMethod_TaiwanWeightedIndexAndVolume:
			return TAIWAN_WEIGHTED_INDEX_AND_VOLUME_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_TaiwanFutureIndexAndLot:
			return TAIWAN_FUTURE_INDEX_AND_LOT_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_OptionPutCallRatio:
			return OPTION_PUT_CALL_RATIO_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_TfeOpenInterest:
			return TFE_OPEN_INTEREST_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_VIX:
			return VIX_TABLE_FIELD_NAME_DEFINITION;
//Market End
///////////////////////////////////////////////////////////////////
//Stock Start
		case FinanceMethod_Revenue:
			return REVENUE_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_Profitability:
			return PROFITABILILTY_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_CashflowStatement:
			return CASHFLOW_STATEMENT_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_Dividend:
			return DIVIDEND_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_InstitutionalInvestorNetBuySell:
			return INSTITUTIONAL_INVESTOR_NET_BUY_SELL_TABLE_FIELD_NAME_DEFINITION;
		case FinanceMethod_StockPriceAndVolume :
			return STOCK_PRICE_AND_VOLUME_TABLE_FIELD_NAME_DEFINITION;
		default :
		{
// FinanceMethod can NOT exploit ordinal() as the index to access the array
			throw new IllegalStateException(String.format("Unknown finance method: %d", finance_method.value()));
		}
		}
	}

	public static String[] get_table_field_type_definition(FinanceMethod finance_method)
	{
		switch (finance_method)
		{
		case FinanceMethod_TaiwanWeightedIndexAndVolume:
			return TAIWAN_WEIGHTED_INDEX_AND_VOLUME_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_TaiwanFutureIndexAndLot:
			return TAIWAN_FUTURE_INDEX_AND_LOT_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_OptionPutCallRatio:
			return OPTION_PUT_CALL_RATIO_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_TfeOpenInterest:
			return TFE_OPEN_INTEREST_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_VIX:
			return VIX_TABLE_FIELD_TYPE_DEFINITION;
//Market End
///////////////////////////////////////////////////////////////////
//Stock Start
		case FinanceMethod_Revenue:
			return REVENUE_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_Profitability:
			return PROFITABILILTY_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_CashflowStatement:
			return CASHFLOW_STATEMENT_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_Dividend:
			return DIVIDEND_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_InstitutionalInvestorNetBuySell:
			return INSTITUTIONAL_INVESTOR_NET_BUY_SELL_TABLE_FIELD_TYPE_DEFINITION;
		case FinanceMethod_StockPriceAndVolume:
			return STOCK_PRICE_AND_VOLUME_TABLE_FIELD_TYPE_DEFINITION;
		default :
		{
// FinanceMethod can NOT exploit ordinal() as the index to access the array
			throw new IllegalStateException(String.format("Unknown finance method: %d", finance_method.value()));
		}
		}
	}
}
