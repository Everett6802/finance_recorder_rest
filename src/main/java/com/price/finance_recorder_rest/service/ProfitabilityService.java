package com.price.finance_recorder_rest.service;

import java.util.ArrayList;
import java.util.List;

import com.price.finance_recorder_rest.common.CmnDef;

public class ProfitabilityService 
{
	public void create(String company_number, ProfitabilityDTO dto)
	{
		FinanceServiceDelegator.create_table(CmnDef.FinanceMethod.FinanceMethod_Profitability, company_number, dto.getDatasetFolderpath()/*, new MySQLDAO()*/);
	}

	public List<ProfitabilityDTO> read(String company_number, int start, int limit)
	{
		List<?> field_array_list = FinanceServiceDelegator.read_table(CmnDef.FinanceMethod.FinanceMethod_Profitability, company_number, start, limit/*, new MySQLDAO()*/);
		List<ProfitabilityDTO> dto_list = new ArrayList<ProfitabilityDTO>();
		for (Object field_array : field_array_list)
		{
			ProfitabilityDTO dto = new ProfitabilityDTO();
			dto.fillin_field((ArrayList<Object>)field_array);
			dto_list.add(dto);
		}
		return dto_list;
	}

	public void update(String company_number, ProfitabilityDTO dto)
	{
		FinanceServiceDelegator.update_table(CmnDef.FinanceMethod.FinanceMethod_Profitability, company_number, dto.getDatasetFolderpath()/*, new MySQLDAO()*/);
	}

	public void delete(String company_number)
	{
		FinanceServiceDelegator.delete_table(CmnDef.FinanceMethod.FinanceMethod_Profitability, company_number/*, new MySQLDAO()*/);
	}

	public String read_sql_metadata(String company_number)
	{
		return FinanceServiceDelegator.read_table_metadata(CmnDef.FinanceMethod.FinanceMethod_Profitability, company_number);
	}

	public String read_csv_metadata(String company_number, ProfitabilityDTO dto)
	{
		return FinanceServiceDelegator.read_file_metadata(CmnDef.FinanceMethod.FinanceMethod_Profitability, company_number, dto.getDatasetFolderpath());
	}
}
