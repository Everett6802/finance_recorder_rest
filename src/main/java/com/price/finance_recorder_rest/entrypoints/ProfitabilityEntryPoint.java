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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.BeanUtils;

import com.price.finance_recorder_rest.exceptions.MissingRequiredFieldException;
import com.price.finance_recorder_rest.namebinding.Secured;
import com.price.finance_recorder_rest.service.ProfitabilityDTO;
import com.price.finance_recorder_rest.service.ProfitabilityService;


@Path("/profitability")
public class ProfitabilityEntryPoint 
{
    @Secured
    @POST
    @Path("/{company_number}")
    @Consumes(MediaType.APPLICATION_JSON) // Input format
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} ) // Output format
    public ProfitabilityRsp create(@PathParam("company_number") String company_number, ProfitabilityReq req) 
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		ProfitabilityDTO dto = new ProfitabilityDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		ProfitabilityService service = new ProfitabilityService();
		service.create(company_number, dto);

		ProfitabilityRsp rsp = new ProfitabilityRsp();

		return rsp;
	}

//	@Secured
	@GET
    @Path("/{company_number}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ProfitabilityGetRsp> read(@PathParam("company_number") String company_number, @DefaultValue("0") @QueryParam("start") int start, @DefaultValue("20") @QueryParam("limit") int limit)
	{
		ProfitabilityDTO dto = new ProfitabilityDTO();
		dto.setStart(start);
		dto.setLimit(limit);

		dto.validateRequiredFields();

		ProfitabilityService service = new ProfitabilityService();
		List<ProfitabilityDTO> dto_get_list = service.read(company_number, start, limit);

// Prepare return value
		List<ProfitabilityGetRsp> rsp_list = new ArrayList<ProfitabilityGetRsp>();
		for (ProfitabilityDTO dto_get : dto_get_list)
		{
			ProfitabilityGetRsp rsp = new ProfitabilityGetRsp();
			BeanUtils.copyProperties(dto_get, rsp);
//			rsp.setHref("/users/" + dto.getUserId());
			rsp_list.add(rsp);
		}

		return rsp_list;
	}

    @Secured
    @PUT
    @Path("/{company_number}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ProfitabilityRsp update(@PathParam("company_number") String company_number, ProfitabilityReq req) 
    {    
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		ProfitabilityDTO dto = new ProfitabilityDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		ProfitabilityService service = new ProfitabilityService();
		service.update(company_number, dto);

		ProfitabilityRsp rsp = new ProfitabilityRsp();

		return rsp;
    }

    @Secured
    @DELETE
    @Path("/{company_number}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ProfitabilityRsp delete(@PathParam("company_number") String company_number) 
    {        
		ProfitabilityService service = new ProfitabilityService();
		service.delete(company_number);

		ProfitabilityRsp rsp = new ProfitabilityRsp();

		return rsp;
    }

	@GET
    @Path("/{company_number}/sql/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_sql_metadata(@PathParam("company_number") String company_number)
	{
		ProfitabilityService service = new ProfitabilityService();
		String metadata = service.read_sql_metadata(company_number);
		return metadata;
	}

	@GET
    @Path("/{company_number}/csv/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_csv_metadata(@PathParam("company_number") String company_number, @DefaultValue("") @QueryParam("dataset_folderpath") String dataset_folderpath)
	{
		ProfitabilityDTO dto = new ProfitabilityDTO();
		if (!dataset_folderpath.isEmpty())
			dto.setDatasetFolderpath(dataset_folderpath);
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		dto.validateRequiredFields();

		ProfitabilityService service = new ProfitabilityService();
		String metadata = service.read_csv_metadata(company_number, dto);
		return metadata;
	}
}
