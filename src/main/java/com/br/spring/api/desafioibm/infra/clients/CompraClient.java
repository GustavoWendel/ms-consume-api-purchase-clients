package com.br.spring.api.desafioibm.infra.clients;

import com.br.spring.api.desafioibm.infra.config.PurchaseClientConfig;
import com.br.spring.api.desafioibm.response.CompraResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "purchase", url = "https://www.mocky.io/v2/598b16861100004905515ec7", configuration = PurchaseClientConfig.class)
public interface CompraClient {

    @GetMapping
    List<CompraResponse> getAllPurchases();

}
