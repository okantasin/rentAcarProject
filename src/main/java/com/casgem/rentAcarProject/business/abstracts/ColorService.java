package com.casgem.rentAcarProject.business.abstracts;

import com.casgem.rentAcarProject.business.requests.colors.CreateColorRequest;
import com.casgem.rentAcarProject.core.utilities.results.Result;

public interface ColorService {

	Result add(CreateColorRequest createColorRequest);
}
