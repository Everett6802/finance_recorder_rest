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
import com.price.finance_recorder_rest.service.CashflowStatementDTO;
import com.price.finance_recorder_rest.service.CashflowStatementService;


@Path("/cashflow_statement")
public class CashflowStatementEntryPoint 
{
    @Secured
    @POST
    @Path("/{company_number}")
    @Consumes(MediaType.APPLICATION_JSON) // Input format
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} ) // Output format
    public CashflowStatementRsp create(@PathParam("company_number") String company_number, CashflowStatementReq req) 
	{
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		CashflowStatementDTO dto = new CashflowStatementDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		CashflowStatementService service = new CashflowStatementService();
		service.create(company_number, dto);

		CashflowStatementRsp rsp = new CashflowStatementRsp();

		return rsp;
	}

//	@Secured
	@GET
    @Path("/{company_number}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<CashflowStatementGetRsp> read(@PathParam("company_number") String company_number, @DefaultValue("0") @QueryParam("start") int start, @DefaultValue("20") @QueryParam("limit") int limit)
	{
		CashflowStatementDTO dto = new CashflowStatementDTO();
		dto.setStart(start);
		dto.setLimit(limit);

		dto.validateRequiredFields();

		CashflowStatementService service = new CashflowStatementService();
		List<CashflowStatementDTO> dto_get_list = service.read(company_number, start, limit);

// Prepare return value
		List<CashflowStatementGetRsp> rsp_list = new ArrayList<CashflowStatementGetRsp>();
		for (CashflowStatementDTO dto_get : dto_get_list)
		{
			CashflowStatementGetRsp rsp = new CashflowStatementGetRsp();
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
    public CashflowStatementRsp update(@PathParam("company_number") String company_number, CashflowStatementReq req) 
    {    
		if (req == null)
			throw new MissingRequiredFieldException("Got null request");
		CashflowStatementDTO dto = new CashflowStatementDTO();
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		BeanUtils.copyProperties(req, dto);
		dto.validateRequiredFields();

		CashflowStatementService service = new CashflowStatementService();
		service.update(company_number, dto);

		CashflowStatementRsp rsp = new CashflowStatementRsp();

		return rsp;
    }

    @Secured
    @DELETE
    @Path("/{company_number}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public CashflowStatementRsp delete(@PathParam("company_number") String company_number) 
    {        
		CashflowStatementService service = new CashflowStatementService();
		service.delete(company_number);

		CashflowStatementRsp rsp = new CashflowStatementRsp();

		return rsp;
    }

	@GET
    @Path("/{company_number}/sql/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_sql_metadata(@PathParam("company_number") String company_number)
	{
		CashflowStatementService service = new CashflowStatementService();
		String metadata = service.read_sql_metadata(company_number);
		return metadata;
	}

	@GET
    @Path("/{company_number}/csv/metadata")
	@Produces({MediaType.TEXT_PLAIN})
	public String read_csv_metadata(@PathParam("company_number") String company_number, @DefaultValue("") @QueryParam("dataset_folderpath") String dataset_folderpath)
	{
		CashflowStatementDTO dto = new CashflowStatementDTO();
		if (!dataset_folderpath.isEmpty())
			dto.setDatasetFolderpath(dataset_folderpath);
//Bean object, copy from requestObject to userDto
//Only firstName, lastName, email, password variables are copied;
		dto.validateRequiredFields();

		CashflowStatementService service = new CashflowStatementService();
		String metadata = service.read_csv_metadata(company_number, dto);
		return metadata;
	}
}
