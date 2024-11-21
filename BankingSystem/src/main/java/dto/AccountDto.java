package dto;

import model.AccountType;

public class AccountDto {
    private String accountNumber;
    private AccountType accountType;
    private String currency;
    private double amount;
    private int customerId;

    public AccountDto() {

    }

    public AccountDto(String accountNumber, AccountType accountType, String currency, double amount, int customerId) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.currency = currency;
        this.amount = amount;
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
