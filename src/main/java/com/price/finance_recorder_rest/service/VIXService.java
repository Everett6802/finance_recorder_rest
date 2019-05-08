package com.price.finance_recorder_rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.price.finance_recorder_rest.common.CmnDef;

public class VIXService 
{
	public void create(String dataset_folderpath)
	{
		FinanceServiceDelegator.create_table(CmnDef.FinanceMethod.FinanceMethod_VIX, dataset_folderpath/*, new MySQLDAO()*/);
	}

	public List<VIXDTO> read(int start, int limit)
	{
		List<?> entity_list = FinanceServiceDelegator.read_table(CmnDef.FinanceMethod.FinanceMethod_VIX, start, limit/*, new MySQLDAO()*/);
		List<VIXDTO> dto_list = new ArrayList<VIXDTO>();
		for (Object entity : entity_list)
		{
			VIXDTO dto = new VIXDTO();
			BeanUtils.copyProperties(entity, dto);
			dto_list.add(dto);
		}
		return dto_list;
	}

	public void update(String dataset_folderpath)
	{
		FinanceServiceDelegator.update_table(CmnDef.FinanceMethod.FinanceMethod_VIX, dataset_folderpath/*, new MySQLDAO()*/);
	}

	public void delete()
	{
		FinanceServiceDelegator.delete_table(CmnDef.FinanceMethod.FinanceMethod_VIX/*, new MySQLDAO()*/);
	}

	public String read_sql_metadata()
	{
		return FinanceServiceDelegator.read_table_metadata(CmnDef.FinanceMethod.FinanceMethod_VIX, null);
	}

	public String read_csv_metadata(VIXDTO dto)
	{
		return FinanceServiceDelegator.read_file_metadata(CmnDef.FinanceMethod.FinanceMethod_VIX, null, dto.getDatasetFolderpath());
	}
}
