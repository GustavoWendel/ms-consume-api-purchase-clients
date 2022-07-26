package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.infra.clients.ClienteFeignClient;
import com.br.spring.api.desafioibm.response.ClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteFeignClient clientClient;

    @GetMapping(value = "/search")
    public List<ClienteResponse> buscarClientes() {
        return clientClient.getClient();
    }
}
