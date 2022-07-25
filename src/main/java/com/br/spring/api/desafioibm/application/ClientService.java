package com.br.spring.api.desafioibm.application;

import com.br.spring.api.desafioibm.infra.clients.ClientFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientFeignClient feignClient;



}
