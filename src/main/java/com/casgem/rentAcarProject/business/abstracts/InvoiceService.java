package com.casgem.rentAcarProject.business.abstracts;

import java.util.List;

import com.casgem.rentAcarProject.business.requests.invoice.CreateInvoiceRequest;
import com.casgem.rentAcarProject.business.requests.invoice.DeleteInvoiceRequest;
import com.casgem.rentAcarProject.business.responses.invoice.GetAllInvoiceResponse;
import com.casgem.rentAcarProject.business.responses.invoice.GetInvoiceResponse;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface InvoiceService {
	
	Result add(CreateInvoiceRequest createInvoiceRequest);
	Result delete(DeleteInvoiceRequest deleteInvoiceRequest);
	DataResult<List<GetAllInvoiceResponse>> getAll();
	DataResult<GetInvoiceResponse> getById();
}
