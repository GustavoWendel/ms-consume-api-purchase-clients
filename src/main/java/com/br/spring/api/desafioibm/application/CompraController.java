package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.response.CompraResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compras")
public class CompraController {

    private final CompraService compraService;

    @GetMapping(value = "/buscar")
    public List<CompraResponse> buscarCompras() {
        return compraService.buscarComprasPorValorTotalAsc();
    }

    @GetMapping("buscar/{ano}")
    public Optional<CompraResponse> buscarMaiorCompraPorAno(@PathVariable("ano") Integer ano) {
        return compraService.getCompraByAno(ano);
    }
}
