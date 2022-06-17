package com.casgem.rentAcarProject.business.responses.additionals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllAdditionalItemResponse {
private int id;
private String name;
private double price;
}
