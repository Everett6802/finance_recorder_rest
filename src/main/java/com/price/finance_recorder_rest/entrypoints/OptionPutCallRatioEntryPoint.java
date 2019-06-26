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
import com.price.finance_recorder_rest.service.OptionPutCallRatioDTO;
import com.price.finance_recorder_rest.service.OptionPutCallRatioService;


@Path("/option_put_call_ratio")
public class OptionPutCallRatioEntryPoint
{
	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // Input format
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // Output
																								// format
	public OptionPutCallRatioRsp create(OptionPutCallRatioReq req)
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		OptionPutCallRatioDTO dto = new OptionPutCallRatioDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		OptionPutCallRatioService service = new OptionPutCallRatioService();
		service.create(dto);

		OptionPutCallRatioRsp rsp = new OptionPutCallRatioRsp();

		return rsp;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<OptionPutCallRatioGetRsp> read(@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("50") @QueryParam("limit") int limit)
	{
		OptionPutCallRatioDTO dto = new OptionPutCallRatioDTO();
		dto.setStart(start);
		dto.setLimit(limit);

		dto.validateRequiredFields();

		OptionPutCallRatioService service = new OptionPutCallRatioService();
		List<OptionPutCallRatioDTO> dto_get_list = service.read(start, limit);

// Prepare return value
		List<OptionPutCallRatioGetRsp> rsp_list = new ArrayList<OptionPutCallRatioGetRsp>();
		for (OptionPutCallRatioDTO dto_get : dto_get_list)
		{
			OptionPutCallRatioGetRsp rsp = new OptionPutCallRatioGetRsp();
			BeanUtils.copyProperties(dto_get, rsp);
//			rsp.setHref("/users/" + dto.getUserId());
			rsp_list.add(rsp);
		}

		return rsp_list;
	}

	@Secured
	@PUT
	@Consumes(MediaType.APPLICATION_JSON) // Input format
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // Output format
	public OptionPutCallRatioRsp update(OptionPutCallRatioReq req)
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		OptionPutCallRatioDTO dto = new OptionPutCallRatioDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		OptionPutCallRatioService service = new OptionPutCallRatioService();
		service.update(dto);

		OptionPutCallRatioRsp rsp = new OptionPutCallRatioRsp();

		return rsp;
	}

	@Secured
	@DELETE
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public OptionPutCallRatioRsp delete(/*OptionPutCallRatioReq req*/)
	{
//		if (req == null)
//			throw new FinanceRecorderMissingRequiredFieldException("Got null request");
//		OptionPutCallRatioDTO dto = new OptionPutCallRatioDTO();

		OptionPutCallRatioService service = new OptionPutCallRatioService();
		service.delete();

		OptionPutCallRatioRsp rsp = new OptionPutCallRatioRsp();

		return rsp;
	}

	@GET
    @Path("/sql/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_sql_metadata()
	{
		OptionPutCallRatioService service = new OptionPutCallRatioService();
		String metadata = service.read_sql_metadata();
		return metadata;
	}

	@GET
    @Path("/csv/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_csv_metadata(@DefaultValue("") @QueryParam("dataset_folderpath") String dataset_folderpath)
	{
		OptionPutCallRatioDTO dto = new OptionPutCallRatioDTO();
		if (!dataset_folderpath.isEmpty())
			dto.setDatasetFolderpath(dataset_folderpath);
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		dto.validateRequiredFields();

		OptionPutCallRatioService service = new OptionPutCallRatioService();
		String metadata = service.read_csv_metadata(dto);
		return metadata;
	}
}
