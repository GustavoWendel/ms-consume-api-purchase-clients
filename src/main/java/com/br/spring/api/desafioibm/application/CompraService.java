package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.infra.clients.CompraClient;
import com.br.spring.api.desafioibm.response.CompraHandle;
import com.br.spring.api.desafioibm.response.CompraResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompraService {

    private final CompraClient compraClient;

    public List<CompraResponse> buscarComprasPorValorTotalAsc() {
        var compras = compraClient.getCompras();
        compras.sort(Comparator.comparing(CompraResponse::getValorTotal));
        return compras;
    }

    public Optional<CompraResponse> getCompraByAno(int ano) {
        var compras = compraClient.getCompras();
        Comparator<CompraResponse> ascPreco = (CompraResponse p1, CompraResponse p2) ->
                (int) (p1.getValorTotal().compareTo(p2.getValorTotal()));

        return compras.stream()
                .filter(data -> data.getData().getYear() == ano)
                .max(ascPreco);
    }

    public List<CompraHandle> getCompraMaiorPorCliente() {
        // Chamada do Mock
        var compras = compraClient.getCompras();

        //Mapeando compras por cliente
        Map<String, List<CompraResponse>> mapResponse = compras
                .stream()
                .collect(Collectors.groupingBy(CompraResponse::getCliente));

        List<CompraHandle> listaHandle = new ArrayList<>();

        for (Map.Entry<String, List<CompraResponse>> entry : mapResponse.entrySet()) {
            listaHandle.add(new CompraHandle(entry.getKey(), entry.getValue()));
        }

        listaHandle.sort(Comparator.comparing(CompraHandle::getTotalCompras)
                .thenComparing(CompraHandle::mediaCompras).reversed());

        listaHandle.subList(1, 3).forEach(CompraHandle::getCliente);
        return listaHandle;
    }

}
