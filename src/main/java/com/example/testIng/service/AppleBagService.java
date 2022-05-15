package com.example.testIng.service;

import com.example.testIng.dto.AppleBagDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AppleBagService {
    private final List<AppleBagDetails> appleBagsList = new ArrayList<>();

    private final List<String> SUPPLIER_NAMES = Arrays.asList("Royal Gala", "Pink Lady", "Kanzi Apple", "Elstar Apples");
    private final static int MINIMUM_NUMBER_OF_APPLES = 1;
    private final static int MAXIMUM_NUMBER_OF_APPLES = 100;
    private final static int MINIMUM_PRICE_OF_APPLE_BAG = 1;
    private final static int MAXIMUM_PRICE_OF_APPLE_BAG = 50;

    public List<AppleBagDetails>getAppleBags(int noOfBags) {
        return appleBagsList.stream().limit(noOfBags).collect(Collectors.toList());
    }

    public AppleBagDetails addAppleBag(AppleBagDetails appleBagDetails) {
        try {
            checkConstraints(appleBagDetails);
            appleBagDetails.setId(UUID.randomUUID().toString());
            appleBagsList.add(appleBagDetails);
            return appleBagDetails;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    private void checkConstraints(AppleBagDetails appleBagDetails) {
        validateSupplierNames(appleBagDetails.getSupplierName());
        validatePrice(appleBagDetails.getPriceOfBag());
        validateQuantity(appleBagDetails.getQuantity());
    }

    private void validateSupplierNames(String supplierName) {
        if(!SUPPLIER_NAMES.contains(supplierName)) {
            throw new IllegalArgumentException("Invalid Supplier Name");
        }
    }

    private void validatePrice(int priceOfBag) {
        if(priceOfBag < MINIMUM_PRICE_OF_APPLE_BAG || priceOfBag > MAXIMUM_PRICE_OF_APPLE_BAG) {
            throw new IllegalArgumentException("Price of Apple BAg should be in between 1 and 50");
        }
    }

    private void validateQuantity(int quantity) {
        if(quantity < MINIMUM_NUMBER_OF_APPLES || quantity > MAXIMUM_NUMBER_OF_APPLES) {
            throw new IllegalArgumentException("Quantity of Apples in Apple Bag should be in between 1 and 100");
        }
    }
}
