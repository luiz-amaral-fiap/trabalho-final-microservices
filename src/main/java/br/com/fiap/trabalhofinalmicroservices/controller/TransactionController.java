package br.com.fiap.trabalhofinalmicroservices.controller;

import br.com.fiap.trabalhofinalmicroservices.model.Statistic;
import br.com.fiap.trabalhofinalmicroservices.model.Transaction;
import br.com.fiap.trabalhofinalmicroservices.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "Transaction", description = "Transaction Service REST API")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @ApiOperation(httpMethod = "Post", value = "Save New Transaction")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success"),
            @ApiResponse(code = 204, message = "The transaction occurred more than 60 seconds ago")
    })
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Transaction transaction) {
        transactionService.save(transaction);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(httpMethod = "GET", value = "Get Statistics")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transaction Statistics for the Last 60 Seconds", response = Statistic.class)})
    @GetMapping("/statistics")
    public ResponseEntity<Statistic> getStatistics() {
        final Statistic statistics = transactionService.getStatitics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
