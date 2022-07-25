package com.br.spring.api.desafioibm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClienteResponse {
    private Long id;

    private String nome;

    private String cpf;

}
