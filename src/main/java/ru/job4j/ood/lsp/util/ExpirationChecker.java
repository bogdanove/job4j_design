package ru.job4j.ood.lsp.util;

public interface ExpirationChecker<T> {

    long getExpirationPercentage(T start, T end);
}
