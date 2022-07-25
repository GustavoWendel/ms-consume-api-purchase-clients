package com.br.spring.api.desafioibm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClientResponse {
    private Long id;

    private String name;

    private String cpf;

}
