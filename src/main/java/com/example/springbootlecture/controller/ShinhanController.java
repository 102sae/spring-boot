package com.example.springbootlecture.controller;

import com.example.springbootlecture.domain.entity.Enterprise;
import com.example.springbootlecture.domain.request.EnterpriseRequest;
import com.example.springbootlecture.service.ShinhanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="기업 분석 API ")
@RestController
@RequiredArgsConstructor
public class ShinhanController {
    private final ShinhanService shinhanService;

    @GetMapping("/v1/enterprises")
    public List<Enterprise> getEnterprise(){
        return shinhanService.getEnterprise();
    }

    @PostMapping("/v1/enterprises")
    public void create(@RequestBody EnterpriseRequest enterpriseRequest)
    {
        shinhanService.createEnterprise(enterpriseRequest);
    }


}
