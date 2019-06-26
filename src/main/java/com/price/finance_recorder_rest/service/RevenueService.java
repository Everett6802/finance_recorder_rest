package com.price.finance_recorder_rest.service;

import java.util.ArrayList;
import java.util.List;

import com.price.finance_recorder_rest.common.CmnDef;

public class RevenueService 
{
	public void create(String company_number, RevenueDTO dto)
	{
		FinanceServiceDelegator.create_table(CmnDef.FinanceMethod.FinanceMethod_Revenue, company_number, dto.getDatasetFolderpath()/*, new MySQLDAO()*/);
	}

	public List<RevenueDTO> read(String company_number, int start, int limit)
	{
		List<?> field_array_list = FinanceServiceDelegator.read_table(CmnDef.FinanceMethod.FinanceMethod_Revenue, company_number, start, limit/*, new MySQLDAO()*/);
		List<RevenueDTO> dto_list = new ArrayList<RevenueDTO>();
		for (Object field_array : field_array_list)
		{
			RevenueDTO dto = new RevenueDTO();
			dto.fillin_field((ArrayList<Object>)field_array);
			dto_list.add(dto);
		}
		return dto_list;
	}

	public void update(String company_number, RevenueDTO dto)
	{
		FinanceServiceDelegator.update_table(CmnDef.FinanceMethod.FinanceMethod_Revenue, company_number, dto.getDatasetFolderpath()/*, new MySQLDAO()*/);
	}

	public void delete(String company_number)
	{
		FinanceServiceDelegator.delete_table(CmnDef.FinanceMethod.FinanceMethod_Revenue, company_number/*, new MySQLDAO()*/);
	}

	public String read_sql_metadata(String company_number)
	{
		return FinanceServiceDelegator.read_table_metadata(CmnDef.FinanceMethod.FinanceMethod_Revenue, company_number);
	}

	public String read_csv_metadata(String company_number, RevenueDTO dto)
	{
		return FinanceServiceDelegator.read_file_metadata(CmnDef.FinanceMethod.FinanceMethod_Revenue, company_number, dto.getDatasetFolderpath());
	}
}
