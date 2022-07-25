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
    private @JsonProperty("product") String product;

    private @JsonProperty("variety") String variety;

    private @JsonProperty("country") String country;

    private @JsonProperty("categoria") String categoria;

    private @JsonProperty("safra") Integer safra;

    private @JsonProperty("preco") BigDecimal preco;
}
