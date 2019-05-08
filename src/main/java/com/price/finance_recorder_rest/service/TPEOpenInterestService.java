package com.price.finance_recorder_rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.price.finance_recorder_rest.common.CmnDef;

public class TPEOpenInterestService 
{
	public void create(String dataset_folderpath)
	{
		FinanceServiceDelegator.create_table(CmnDef.FinanceMethod.FinanceMethod_TfeOpenInterest, dataset_folderpath/*, new MySQLDAO()*/);
	}

	public List<TPEOpenInterestDTO> read(int start, int limit)
	{
		List<?> entity_list = FinanceServiceDelegator.read_table(CmnDef.FinanceMethod.FinanceMethod_TfeOpenInterest, start, limit/*, new MySQLDAO()*/);
		List<TPEOpenInterestDTO> dto_list = new ArrayList<TPEOpenInterestDTO>();
		for (Object entity : entity_list)
		{
			TPEOpenInterestDTO dto = new TPEOpenInterestDTO();
			BeanUtils.copyProperties(entity, dto);
			dto_list.add(dto);
		}
		return dto_list;
	}

	public void update(String dataset_folderpath)
	{
		FinanceServiceDelegator.update_table(CmnDef.FinanceMethod.FinanceMethod_TfeOpenInterest, dataset_folderpath/*, new MySQLDAO()*/);
	}

	public void delete()
	{
		FinanceServiceDelegator.delete_table(CmnDef.FinanceMethod.FinanceMethod_TfeOpenInterest/*, new MySQLDAO()*/);
	}

	public String read_sql_metadata()
	{
		return FinanceServiceDelegator.read_table_metadata(CmnDef.FinanceMethod.FinanceMethod_TfeOpenInterest, null);
	}

	public String read_csv_metadata(TPEOpenInterestDTO dto)
	{
		return FinanceServiceDelegator.read_file_metadata(CmnDef.FinanceMethod.FinanceMethod_TfeOpenInterest, null, dto.getDatasetFolderpath());
	}
}
