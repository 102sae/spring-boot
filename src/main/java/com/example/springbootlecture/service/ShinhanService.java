package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Enterprise;
import com.example.springbootlecture.domain.request.EnterpriseRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShinhanService {
    private static List<Enterprise> enterprises = new ArrayList<>();
    //생성하기 전에 호출한다. Movie Service가 생성하면서 메소드가 호출.
    @PostConstruct
    public void init() {
        enterprises.addAll(List.of(
                new Enterprise(1, "두산테스나", "매수" ,"23.09.25"),
                new Enterprise(2, "현대위아","매수","23.09.25"),
                new Enterprise(3, "티에스아이","매수","23.09.22")
        ));
    }

    public List<Enterprise> getEnterprise() {
        return enterprises;
    }

    public void createEnterprise(EnterpriseRequest enterpriseRequest) {
        enterprises.add(new Enterprise(enterprises.size()+1, enterpriseRequest.getName(), enterpriseRequest.getOpinion(), enterpriseRequest.getDate()));
    }

}
