package br.com.fiap.trabalhofinalmicroservices.service;

import br.com.fiap.trabalhofinalmicroservices.exception.InvalidTransactionException;
import br.com.fiap.trabalhofinalmicroservices.model.Statistic;
import br.com.fiap.trabalhofinalmicroservices.model.Transaction;
import br.com.fiap.trabalhofinalmicroservices.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    private boolean isHigherThanSixtySeconds(final Long timestamp) { return (System.currentTimeMillis() - timestamp) > TimeUnit.SECONDS.toMillis(60); }
    private boolean isLowerThanSixtySeconds(final Long timestamp) { return (System.currentTimeMillis() - timestamp) <= TimeUnit.SECONDS.toMillis(60); }

    public void save(final Transaction transaction) {
        if (isHigherThanSixtySeconds(transaction.getTimestamp())) { throw new InvalidTransactionException(); }
        transactionRepository.save(transaction);
    }

    public Statistic getStatitics() {
        final Statistic statistic = new Statistic();

        final List<Transaction> transactions = transactionRepository.getAll().stream()
                .filter(f -> isLowerThanSixtySeconds(f.getTimestamp()))
                .collect(Collectors.toList());

        final Double sum = transactions.stream().mapToDouble(Transaction::getAmount).sum();
        final Double avg = transactions.stream().mapToDouble(Transaction::getAmount).average().orElse(0.0);
        final Double max = transactions.stream().mapToDouble(Transaction::getAmount).max().orElse(0.0);
        final Double min = transactions.stream().mapToDouble(Transaction::getAmount).min().orElse(0.0);
        final Long count = transactions.stream().count();

        return new Statistic(sum, avg, max, min, count);
    }
}