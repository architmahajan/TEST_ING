package com.example.testIng.dto;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppleBagDetails {
    private String id;
    private int quantity;
    private String supplierName;
    private LocalDateTime date;
    private int priceOfBag;
}
