package com.price.finance_recorder_rest.service;

import java.util.ArrayList;
import java.util.List;

import com.price.finance_recorder_rest.common.CmnDef;

public class DividendService 
{
	public void create(String company_number, DividendDTO dto)
	{
		FinanceServiceDelegator.create_table(CmnDef.FinanceMethod.FinanceMethod_Dividend, company_number, dto.getDatasetFolderpath()/*, new MySQLDAO()*/);
	}

	public List<DividendDTO> read(String company_number, int start, int limit)
	{
		List<?> field_array_list = FinanceServiceDelegator.read_table(CmnDef.FinanceMethod.FinanceMethod_Dividend, company_number, start, limit/*, new MySQLDAO()*/);
		List<DividendDTO> dto_list = new ArrayList<DividendDTO>();
		for (Object field_array : field_array_list)
		{
			DividendDTO dto = new DividendDTO();
			dto.fillin_field((ArrayList<Object>)field_array);
			dto_list.add(dto);
		}
		return dto_list;
	}

	public void update(String company_number, DividendDTO dto)
	{
		FinanceServiceDelegator.update_table(CmnDef.FinanceMethod.FinanceMethod_Dividend, company_number, dto.getDatasetFolderpath()/*, new MySQLDAO()*/);
	}

	public void delete(String company_number)
	{
		FinanceServiceDelegator.delete_table(CmnDef.FinanceMethod.FinanceMethod_Dividend, company_number/*, new MySQLDAO()*/);
	}

	public String read_sql_metadata(String company_number)
	{
		return FinanceServiceDelegator.read_table_metadata(CmnDef.FinanceMethod.FinanceMethod_Dividend, company_number);
	}

	public String read_csv_metadata(String company_number, DividendDTO dto)
	{
		return FinanceServiceDelegator.read_file_metadata(CmnDef.FinanceMethod.FinanceMethod_Dividend, company_number, dto.getDatasetFolderpath());
	}
}
