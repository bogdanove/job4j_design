package ru.job4j.ood.lsp;

public interface ExpirationChecker<T> {

    long getExpirationPercentage(T start, T end);
}
