package com.example.franchise.Controller;

import com.example.franchise.DTO.FranchiseDto;
import com.example.franchise.DTO.RequstDto.FranchiseCreateRequest;
import com.example.franchise.service.FranchiseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class FreanchiseController {

    private static final Logger log = Logger.getLogger(FreanchiseController.class.getName());
    private final FranchiseService franchiseService;

    public FreanchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @PostMapping("/api/create/franchise")
    public FranchiseDto create(@RequestBody FranchiseCreateRequest franchiseCreateRequest) {
        log.info("create");
        return franchiseService.create(franchiseCreateRequest.createFranchise());
    }

}
