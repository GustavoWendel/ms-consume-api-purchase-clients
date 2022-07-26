package com.br.spring.api.desafioibm.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraHandle {
    private String cliente;
    private List<CompraResponse> compras;

    public int getTotalCompras(){
        return compras.size();
    }

    public double mediaCompras() {
        return compras.stream()
                .mapToDouble((compra -> compra.getValorTotal().doubleValue()))
                .average()
                .getAsDouble();
    }
}
