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
import com.price.finance_recorder_rest.service.TPEOpenInterestDTO;
import com.price.finance_recorder_rest.service.TPEOpenInterestService;


@Path("/tpe_open_interest")
public class TPEOpenInterestEntryPoint 
{
	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // Input format
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // Output format
	public TPEOpenInterestRsp create_tpe_open_interest(TPEOpenInterestReq req)
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		TPEOpenInterestDTO dto = new TPEOpenInterestDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		TPEOpenInterestService service = new TPEOpenInterestService();
		service.create(req.getDatasetFolderpath());

		TPEOpenInterestRsp rsp = new TPEOpenInterestRsp();

		return rsp;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<TPEOpenInterestGetRsp> read_tpe_open_interest(@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("20") @QueryParam("limit") int limit)
	{
//		StockExchangeAndVolumeDTO dto = new StockExchangeAndVolumeDTO();
//		dto.setStart(start);
//		dto.setLimit(limit);
//		dto.validateRequiredFields();
		TPEOpenInterestService service = new TPEOpenInterestService();
		List<TPEOpenInterestDTO> dto_list = service.read(start, limit);

// Prepare return value
		List<TPEOpenInterestGetRsp> rsp_list = new ArrayList<TPEOpenInterestGetRsp>();
		for (TPEOpenInterestDTO dto : dto_list)
		{
			TPEOpenInterestGetRsp rsp = new TPEOpenInterestGetRsp();
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
	public TPEOpenInterestRsp update_tpe_open_interest(TPEOpenInterestReq req)
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		TPEOpenInterestDTO dto = new TPEOpenInterestDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		TPEOpenInterestService service = new TPEOpenInterestService();
		service.create(req.getDatasetFolderpath());

		TPEOpenInterestRsp rsp = new TPEOpenInterestRsp();

		return rsp;
	}

	@Secured
	@DELETE
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public TPEOpenInterestRsp delete_tpe_open_interest(/*StockExchangeAndVolumeReq req*/)
	{
//		if (req == null)
//			throw new FinanceRecorderMissingRequiredFieldException("Got null request");
//		StockExchangeAndVolumeDTO dto = new StockExchangeAndVolumeDTO();

		TPEOpenInterestService service = new TPEOpenInterestService();
		service.delete();

		TPEOpenInterestRsp rsp = new TPEOpenInterestRsp();

		return rsp;
	}

	@GET
    @Path("/sql/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_tpe_open_interest_sql_metadata()
	{
		TPEOpenInterestService service = new TPEOpenInterestService();
		String metadata = service.read_sql_metadata();
		return metadata;
	}

	@GET
    @Path("/csv/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_tpe_open_interest_csv_metadata(@DefaultValue("") @QueryParam("dataset_folderpath") String dataset_folderpath)
	{
		TPEOpenInterestDTO dto = new TPEOpenInterestDTO();
		if (!dataset_folderpath.isEmpty())
			dto.setDatasetFolderpath(dataset_folderpath);
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		dto.validateRequiredFields();

		TPEOpenInterestService service = new TPEOpenInterestService();
		String metadata = service.read_csv_metadata(dto);
		return metadata;
	}
}
