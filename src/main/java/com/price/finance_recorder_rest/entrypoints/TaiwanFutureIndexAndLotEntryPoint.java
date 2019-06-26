package com.price.finance_recorder_rest.entrypoints;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;

import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;
import com.price.finance_recorder_rest.namebinding.Secured;
import com.price.finance_recorder_rest.service.TaiwanFutureIndexAndLotDTO;
import com.price.finance_recorder_rest.service.TaiwanFutureIndexAndLotService;


@Path("/taiwan_future_index_and_lot")
public class TaiwanFutureIndexAndLotEntryPoint 
{
	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // Input format
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // Output format
	public TaiwanFutureIndexAndLotRsp create(TaiwanFutureIndexAndLotReq req)
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		TaiwanFutureIndexAndLotDTO dto = new TaiwanFutureIndexAndLotDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		TaiwanFutureIndexAndLotService service = new TaiwanFutureIndexAndLotService();
		service.create(req.getDatasetFolderpath());

		TaiwanFutureIndexAndLotRsp rsp = new TaiwanFutureIndexAndLotRsp();

		return rsp;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<TaiwanFutureIndexAndLotGetRsp> read(@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("20") @QueryParam("limit") int limit)
	{
//		StockExchangeAndVolumeDTO dto = new StockExchangeAndVolumeDTO();
//		dto.setStart(start);
//		dto.setLimit(limit);
//		dto.validateRequiredFields();
		TaiwanFutureIndexAndLotService service = new TaiwanFutureIndexAndLotService();
		List<TaiwanFutureIndexAndLotDTO> dto_list = service.read(start, limit);

// Prepare return value
		List<TaiwanFutureIndexAndLotGetRsp> rsp_list = new ArrayList<TaiwanFutureIndexAndLotGetRsp>();
		for (TaiwanFutureIndexAndLotDTO dto : dto_list)
		{
			TaiwanFutureIndexAndLotGetRsp rsp = new TaiwanFutureIndexAndLotGetRsp();
			BeanUtils.copyProperties(dto, rsp);
//			rsp.setHref("/users/" + dto.getUserId());
			rsp_list.add(rsp);
		}

		return rsp_list;
	}

	@Secured
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // Input format
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // Output format
	public TaiwanFutureIndexAndLotRsp update(TaiwanFutureIndexAndLotReq req)
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		TaiwanFutureIndexAndLotDTO dto = new TaiwanFutureIndexAndLotDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		TaiwanFutureIndexAndLotService service = new TaiwanFutureIndexAndLotService();
		service.create(req.getDatasetFolderpath());

		TaiwanFutureIndexAndLotRsp rsp = new TaiwanFutureIndexAndLotRsp();

		return rsp;
	}

	@Secured
	@DELETE
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TaiwanFutureIndexAndLotRsp delete(/*StockExchangeAndVolumeReq req*/)
	{
//		if (req == null)
//			throw new FinanceRecorderMissingRequiredFieldException("Got null request");
//		StockExchangeAndVolumeDTO dto = new StockExchangeAndVolumeDTO();

		TaiwanFutureIndexAndLotService service = new TaiwanFutureIndexAndLotService();
		service.delete();

		TaiwanFutureIndexAndLotRsp rsp = new TaiwanFutureIndexAndLotRsp();

		return rsp;
	}

	@GET
    @Path("/sql/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_sql_metadata()
	{
		TaiwanFutureIndexAndLotService service = new TaiwanFutureIndexAndLotService();
		String metadata = service.read_sql_metadata();
		return metadata;
	}

	@GET
    @Path("/csv/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_csv_metadata(@DefaultValue("") @QueryParam("dataset_folderpath") String dataset_folderpath)
	{
		TaiwanFutureIndexAndLotDTO dto = new TaiwanFutureIndexAndLotDTO();
		if (!dataset_folderpath.isEmpty())
			dto.setDatasetFolderpath(dataset_folderpath);
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		dto.validateRequiredFields();

		TaiwanFutureIndexAndLotService service = new TaiwanFutureIndexAndLotService();
		String metadata = service.read_csv_metadata(dto);
		return metadata;
	}
}
