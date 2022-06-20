package com.casgem.rentAcarProject.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casgem.rentAcarProject.business.abstracts.InvoiceService;
import com.casgem.rentAcarProject.business.requests.invoice.CreateInvoiceRequest;
import com.casgem.rentAcarProject.business.requests.invoice.DeleteInvoiceRequest;
import com.casgem.rentAcarProject.business.responses.invoice.GetAllInvoiceResponse;
import com.casgem.rentAcarProject.business.responses.invoice.GetInvoiceResponse;
import com.casgem.rentAcarProject.business.responses.invoices.GetAllInvoicesResponse;
import com.casgem.rentAcarProject.core.utilities.mapping.ModelMapperService;
import com.casgem.rentAcarProject.core.utilities.results.DataResult;
import com.casgem.rentAcarProject.core.utilities.results.Result;
import com.casgem.rentAcarProject.core.utilities.results.SuccessDataResult;
import com.casgem.rentAcarProject.core.utilities.results.SuccessResult;
import com.casgem.rentAcarProject.dataAccess.abstracts.AdditionalFeatureServiceRepository;
import com.casgem.rentAcarProject.dataAccess.abstracts.InvoiceRepository;
import com.casgem.rentAcarProject.dataAccess.abstracts.RentalRepository;
import com.casgem.rentAcarProject.entities.concretes.AdditionalFeatureService;
import com.casgem.rentAcarProject.entities.concretes.Invoice;
import com.casgem.rentAcarProject.entities.concretes.Rental;
@Service
public class InvoiceManager implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private RentalRepository rentalRepository;
	@Autowired
	private AdditionalFeatureServiceRepository additionalFeatureServiceRepository;
	@Autowired
	private ModelMapperService modelMapperService;

	@Override
	public Result add(CreateInvoiceRequest createInvoiceRequest) {
		
		Invoice invoice = this.modelMapperService.forRequest().map(createInvoiceRequest, Invoice.class);

		invoice.setCurrentDate(LocalDate.now());
		invoice.setTotalPrice(calculateTotalPrice(invoice.getRental().getId(), invoice.getAdditionalFeatureService().getId()));
		this.invoiceRepository.save(invoice);
		return new SuccessResult("ınvoice added");
	}

	private double calculateTotalPrice(int rentalId, int additionalFeatureServiceId) {
		Rental rental = this.rentalRepository.findById(rentalId);
		AdditionalFeatureService additionalFeatureService = this.additionalFeatureServiceRepository
				.findById(additionalFeatureServiceId);
		double totalPrice= rental.getTotalPrice()+additionalFeatureService.getTotalPrice();

		return totalPrice;

	}

	@Override
	public Result delete(DeleteInvoiceRequest deleteInvoiceRequest) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DataResult<GetInvoiceResponse> getById() {

		
		
		return null;
	}


	@Override
	public DataResult<List<GetAllInvoiceResponse>> getAll() {

		
		
		
		return null;
	}

}
