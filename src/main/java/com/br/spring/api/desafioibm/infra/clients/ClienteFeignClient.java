package com.br.spring.api.desafioibm.infra.clients;

import com.br.spring.api.desafioibm.response.ClienteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "clientes", url = "http://www.mocky.io/v2/598b16291100004705515ec5")
public interface ClienteFeignClient {

    @GetMapping
    List<ClienteResponse> getClient();
}
