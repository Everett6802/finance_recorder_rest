package com.price.finance_recorder_rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.price.finance_recorder_rest.common.CmnDef;

public class TaiwanFutureIndexAndLotService 
{
	public void create(String dataset_folderpath)
	{
		FinanceServiceDelegator.create_table(CmnDef.FinanceMethod.FinanceMethod_TaiwanFutureIndexAndLot, dataset_folderpath/*, new MySQLDAO()*/);
	}

	public List<TaiwanFutureIndexAndLotDTO> read(int start, int limit)
	{
		List<?> entity_list = FinanceServiceDelegator.read_table(CmnDef.FinanceMethod.FinanceMethod_TaiwanFutureIndexAndLot, start, limit/*, new MySQLDAO()*/);
		List<TaiwanFutureIndexAndLotDTO> dto_list = new ArrayList<TaiwanFutureIndexAndLotDTO>();
		for (Object entity : entity_list)
		{
			TaiwanFutureIndexAndLotDTO dto = new TaiwanFutureIndexAndLotDTO();
			BeanUtils.copyProperties(entity, dto);
			dto_list.add(dto);
		}
		return dto_list;
	}

	public void update(String dataset_folderpath)
	{
		FinanceServiceDelegator.update_table(CmnDef.FinanceMethod.FinanceMethod_TaiwanFutureIndexAndLot, dataset_folderpath/*, new MySQLDAO()*/);
	}

	public void delete()
	{
		FinanceServiceDelegator.delete_table(CmnDef.FinanceMethod.FinanceMethod_TaiwanFutureIndexAndLot/*, new MySQLDAO()*/);
	}

	public String read_sql_metadata()
	{
		return FinanceServiceDelegator.read_table_metadata(CmnDef.FinanceMethod.FinanceMethod_TaiwanFutureIndexAndLot, null);
	}

	public String read_csv_metadata(TaiwanFutureIndexAndLotDTO dto)
	{
		return FinanceServiceDelegator.read_file_metadata(CmnDef.FinanceMethod.FinanceMethod_TaiwanFutureIndexAndLot, null, dto.getDatasetFolderpath());
	}
}
