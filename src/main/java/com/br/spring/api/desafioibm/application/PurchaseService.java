package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.infra.clients.PurchaseClient;
import com.br.spring.api.desafioibm.response.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseClient purchaseClient;

    public List<PurchaseResponse> searchPurchaseByFullValueAsc() {
        List<PurchaseResponse> purchases = purchaseClient.getAllPurchases();
        purchases.sort(Comparator.comparing(PurchaseResponse::getValorTotal));
        return purchases;
    }

    public Optional<PurchaseResponse> getPurchaseByYear(int year) {
        List<PurchaseResponse> purchases = purchaseClient.getAllPurchases();
        Comparator<PurchaseResponse> ascPreco = (PurchaseResponse p1, PurchaseResponse p2) ->
                (int) (p1.getValorTotal().compareTo(p2.getValorTotal()));

        return purchases.stream()
                .filter(data -> data.getData().getYear() == year)
                .max(ascPreco);
    }

}
