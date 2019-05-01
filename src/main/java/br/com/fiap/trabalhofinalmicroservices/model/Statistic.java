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
public class Statistic {
    @ApiModelProperty(notes = "Sum of Transactions Values")
    private Double sum;

    @ApiModelProperty(notes = "Average Transaction Values")
    private Double avg;

    @ApiModelProperty(notes = "Maximum Value of a Transaction")
    private Double max;

    @ApiModelProperty(notes = "Minimum Value of a Transaction")
    private Double min;

    @ApiModelProperty(notes = "Total Number of Transactions")
    private Long count;
}