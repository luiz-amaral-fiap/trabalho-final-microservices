package br.com.fiap.trabalhofinalmicroservices.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Transaction {
    @ApiModelProperty(notes = "Transaction Amount")
    private Double amount;

    @ApiModelProperty(notes = "Transaction Time")
    private Long timestamp;
}
