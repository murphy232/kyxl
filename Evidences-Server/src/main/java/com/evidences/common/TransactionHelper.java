package com.evidences.common;

public class TransactionHelper {
    @FunctionalInterface
    public interface TransactionOperation {
        boolean isSuccess();
    }

    public static class TransactionExecutor {
        public TransactionExecutor execute(TransactionOperation operation) {
            if (operation.isSuccess()) {
                return this;
            } else {
                throw new RuntimeException();
            }
        }
    }

    public static TransactionExecutor executor() {
        return new TransactionExecutor();
    }
}
