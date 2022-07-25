package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.infra.clients.CompraClient;
import com.br.spring.api.desafioibm.response.CompraResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraClient purchaseClient;

    public List<CompraResponse> buscarComprasPorValorTotalAsc() {
        List<CompraResponse> compras = purchaseClient.getAllPurchases();
        compras.sort(Comparator.comparing(CompraResponse::getValorTotal));
        return compras;
    }

    public Optional<CompraResponse> getCompraByAno(int ano) {
        List<CompraResponse> purchases = purchaseClient.getAllPurchases();
        Comparator<CompraResponse> ascPreco = (CompraResponse p1, CompraResponse p2) ->
                (int) (p1.getValorTotal().compareTo(p2.getValorTotal()));

        return purchases.stream()
                .filter(data -> data.getData().getYear() == ano)
                .max(ascPreco);
    }

}
