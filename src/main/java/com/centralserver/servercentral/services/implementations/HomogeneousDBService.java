package com.centralserver.servercentral.services.implementations;

import com.centralserver.servercentral.models.*;
import com.centralserver.servercentral.services.BankingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomogeneousDBService implements BankingService {
    @Override
    public Customer createNewCustomer(Customer customer) {
        return null;
    }


    @Override
    public Customer getCustomerBySubjectCode(String subjectCode) {
        return null;
    }

    @Override
    public Customer editCustomerEmail(String subjectCode, String newEmail) {
        return null;
    }

    @Override
    public void deleteCustomer(String subjectCode) {

    }

    @Override
    public Account addNewAccount(Account account) {
        return null;
    }

    @Override
    public List<Account> getAllAccountsBySubjectCode(String subjectCode) {
        return null;
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public Account updateAccountBalance(String accountNumber, Double balance) {
        return null;
    }

    @Override
    public void closeAccount(String accountNumber) {

    }

    @Override
    public Transaction addNewTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactionByAccountId(Long accountId) {
        return null;
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        return null;
    }

    @Override
    public Loan addNewLoan(Loan loan) {
        return null;
    }

    @Override
    public List<Loan> retrieveLoansForACustomer(String subjectCode) {
        return null;
    }

    @Override
    public Loan getLoanById(Long loanId) {
        return null;
    }

    @Override
    public Loan updateOutstandingAmount(Long loanId, Double balance) {
        return null;
    }

    @Override
    public void closeLoan(Long loanId) {

    }

    @Override
    public Card addNewCard(Card card) {
        return null;
    }

    @Override
    public List<Card> getCardsBySubjectCode(String subjectCode) {
        return null;
    }

    @Override
    public Card getCardById(Long cardId) {
        return null;
    }
}
