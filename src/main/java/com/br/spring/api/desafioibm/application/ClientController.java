package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.infra.clients.ClientFeignClient;
import com.br.spring.api.desafioibm.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientFeignClient clientClient;

    @GetMapping(value = "/search")
    public List<ClientResponse> searchClients() {
        return clientClient.getClient();
    }
}
