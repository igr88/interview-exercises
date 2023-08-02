package dev.me.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PaymentProcessor {
    private static final Map<String, Account> accounts = new HashMap<>();

    static class Account {
        private String accountNumber;
        private String name;
        private Integer limit;
        private Integer balance;

        public Account(String accountNumber, String name, Integer limit) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.limit = limit;
            this.balance = 0;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getName() {
            return name;
        }

        public Integer getLimit() {
            return limit;
        }

        public Integer getBalance() {
            return balance;
        }

        public void setBalance(Integer balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "Add 12345 Gabriel $1000",
                "Add 98763 Luke $1200",
                "Charge Luke $100",
                "Charge Gabriel $1001",
                "Credit Luke $90",
        };

        System.out.println(process(inputs));
    }

    public static String process(String[] inputs) {
        for (String input : inputs) {
            String[] tokens = input.split("\s");
            String operation = tokens[0];

            switch (operation) {
                case "Add":
                    processAddAccount(tokens);
                    break;
                case "Charge":
                    processChargeAccount(tokens);
                    break;
                case "Credit":
                    processCreditAccount(tokens);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported operation");
            }
        }
        return generateReport();
    }

    private static String generateReport() {
        return accounts.values().stream()
                .map(account -> account.getName() + " " + account.getAccountNumber() + " " + toHumanReadableAmount(account.getBalance()))
                .collect(Collectors.joining("\n"));
    }

    private static void processAddAccount(String[] params) {
        // "Add 12345 Gabriel $1000",
        String accountNumber = params[1];
        String name = params[2];
        Integer limit = toAmount(params[3]);
        addAccount(accountNumber, name, limit);
    }

    private static void processChargeAccount(String[] params) {
        // "Charge Luke $100",
        String name = params[1];
        Integer amount = toAmount(params[2]);
        chargeAccount(name, amount);
    }

    private static void addAccount(String accountNumber, String name, Integer limit) {
        accounts.computeIfAbsent(name, s -> new Account(accountNumber, name, limit));
    }

    private static void chargeAccount(String name, Integer amount) {
        accounts.computeIfPresent(name, (s, account) -> {
           Integer currentBalance = account.getBalance();
           if ( currentBalance + amount <= account.getLimit()) {
               account.setBalance(currentBalance + amount);
           }
           return account;
        });
    }

    private static void processCreditAccount(String[] params) {
        // "Credit Luke $90"
        String name = params[1];
        Integer amount = toAmount(params[2]);
        creditAccount(name, amount);
    }

    private static void creditAccount(String name, Integer amount) {
        accounts.computeIfPresent(name, (s, account) -> {
            Integer newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            return account;
        });
    }

    private static Integer toAmount(String string) {
        // asumes input is $100
        return Integer.parseInt(string.substring(1));
    }

    private static String toHumanReadableAmount(Integer amount) {
        return "$" + amount;
    }
}
