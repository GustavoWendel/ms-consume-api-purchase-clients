package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.infra.clients.ClienteFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClienteFeignClient feignClient;



}
