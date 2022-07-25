package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.response.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping(value = "/search")
    public List<PurchaseResponse> searchPurchase() {
        return purchaseService.searchPurchaseByFullValueAsc();
    }

    @GetMapping("{year}")
    public Optional<PurchaseResponse> searchPurchaseByYearAndFullValue(@PathVariable("year") Integer year) {
        return purchaseService.getPurchaseByYear(year);
    }
}
