package com.centralserver.servercentral.services;

import com.centralserver.servercentral.models.*;

import java.util.List;

public interface BankingServices {
    Customer createNewCustomer(Customer customer);

    Customer getCustomerByLastNameAndFirstName(String lastName, String firstName);

    Customer getCustomerBySubjectCode(String subjectCode);

    Customer editCustomerEmail(String subjectCode, String newEmail);

    void deleteCustomer(String subjectCode);

    Account addNewAccount(Account account);

    List<Account> getAllAccountsBySubjectCode(String subjectCode);

    Account getAccountByAccountNumber(String accountNumber);

    Account updateAccountBalance(String accountNumber, Double balance);

    void closeAccount(String accountNumber);

    Transaction addNewTransaction(Transaction transaction);

    List<Transaction> getAllTransactionByAccountId(Long accountId);

    Transaction getTransactionById(Long transactionId);

    Loan addNewLoan(Loan loan);

    List<Loan> retrieveLoansForACustomer(String subjectCode);

    Loan getLoanById(Long loanId);

    Loan updateOutstandingAmount(Long loanId, Double balance);

    void closeLoan(Long loanId);

    Card addNewCard(Card card);

    List<Card> getCardsBySubjectCode(String subjectCode);

    Card getCardById(Long cardId);
}
