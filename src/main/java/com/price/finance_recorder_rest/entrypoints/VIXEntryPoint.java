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
import com.price.finance_recorder_rest.service.VIXDTO;
import com.price.finance_recorder_rest.service.VIXService;


@Path("/vix")
public class VIXEntryPoint 
{
	@Secured
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // Input format
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}) // Output format
	public VIXRsp create_vix(VIXReq req)
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		VIXDTO dto = new VIXDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		VIXService service = new VIXService();
		service.create(req.getDatasetFolderpath());

		VIXRsp rsp = new VIXRsp();

		return rsp;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<VIXGetRsp> read_vix(@DefaultValue("0") @QueryParam("start") int start, @DefaultValue("20") @QueryParam("limit") int limit)
	{
//		StockExchangeAndVolumeDTO dto = new StockExchangeAndVolumeDTO();
//		dto.setStart(start);
//		dto.setLimit(limit);
//		dto.validateRequiredFields();
		VIXService service = new VIXService();
		List<VIXDTO> dto_list = service.read(start, limit);

// Prepare return value
		List<VIXGetRsp> rsp_list = new ArrayList<VIXGetRsp>();
		for (VIXDTO dto : dto_list)
		{
			VIXGetRsp rsp = new VIXGetRsp();
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
	public VIXRsp update_vix(VIXReq req)
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		VIXDTO dto = new VIXDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		VIXService service = new VIXService();
		service.create(req.getDatasetFolderpath());

		VIXRsp rsp = new VIXRsp();

		return rsp;
	}

	@Secured
	@DELETE
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public VIXRsp delete_vix(/*StockExchangeAndVolumeReq req*/)
	{
//		if (req == null)
//			throw new FinanceRecorderMissingRequiredFieldException("Got null request");
//		StockExchangeAndVolumeDTO dto = new StockExchangeAndVolumeDTO();

		VIXService service = new VIXService();
		service.delete();

		VIXRsp rsp = new VIXRsp();

		return rsp;
	}

	@GET
    @Path("/sql/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_vix_sql_metadata()
	{
		VIXService service = new VIXService();
		String metadata = service.read_sql_metadata();
		return metadata;
	}

	@GET
    @Path("/csv/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_vix_csv_metadata(@DefaultValue("") @QueryParam("dataset_folderpath") String dataset_folderpath)
	{
		VIXDTO dto = new VIXDTO();
		if (!dataset_folderpath.isEmpty())
			dto.setDatasetFolderpath(dataset_folderpath);
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		dto.validateRequiredFields();

		VIXService service = new VIXService();
		String metadata = service.read_csv_metadata(dto);
		return metadata;
	}
}
