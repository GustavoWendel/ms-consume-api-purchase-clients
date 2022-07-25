package com.br.spring.api.desafioibm.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = false)
public class ItemResponse {
    private @JsonProperty("produto") String produto;

    private @JsonProperty("variedade") String variedade;

    private @JsonProperty("pais") String pais;

    private @JsonProperty("categoria") String categoria;

    private @JsonProperty("safra") String safra;

    private @JsonProperty("preco") BigDecimal preco;
}
