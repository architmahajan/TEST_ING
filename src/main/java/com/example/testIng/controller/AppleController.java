package com.example.testIng.controller;

import com.example.testIng.dto.AppleBagDetails;
import com.example.testIng.service.AppleBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class AppleController {

    @Autowired
    private AppleBagService appleBagService;

    @GetMapping("/api/v1/applebags")
    public List<AppleBagDetails> getAppleBags(@RequestParam(defaultValue = "3") Optional<String> noOfBags) {
        return appleBagService.getAppleBags(Integer.parseInt(noOfBags.get()));
    }

    @PostMapping("/api/v1/applebag/add")
    public AppleBagDetails addAppleBag(@RequestBody AppleBagDetails appleBagDetails) throws IOException {
        return appleBagService.addAppleBag(appleBagDetails);
    }



}
