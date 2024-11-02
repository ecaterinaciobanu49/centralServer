package com.centralserver.servercentral.controllers;

import com.centralserver.servercentral.models.*;
import com.centralserver.servercentral.services.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private BankingService bankingService;

    @PostMapping("/customer")
    Customer createNewCustomer(@RequestBody Customer customer) {
        return bankingService.createNewCustomer(customer);
    }

    @GetMapping("/findCustomerBySubjectCode/{subjectCode}")
    Customer getCustomerBySubjectCode(@PathVariable String subjectCode) {
        return bankingService.getCustomerBySubjectCode(subjectCode);
    }

    @PutMapping("editCustomerEmail/{subjectCode}")
    Customer editCustomerEmail(@PathVariable String subjectCode, @RequestBody String newEmail) {
        return bankingService.editCustomerEmail(subjectCode, newEmail);
    }

    @DeleteMapping("/deleteCustomer/{subjectCode}")
    void deleteCustomer(@PathVariable String subjectCode) {
        bankingService.deleteCustomer(subjectCode);
    }

    @PostMapping("/addNewAccount")
    Account addNewAccount(@RequestBody Account account) {
        return bankingService.addNewAccount(account);
    }

    @PostMapping("/getAccountsBySubjectCode/{subjectCode}")
    List<Account> getAllAccountsBySubjectCode(@PathVariable String subjectCode) {
        return bankingService.getAllAccountsBySubjectCode(subjectCode);
    }

    @GetMapping("/getAnAccountByAccountNumber")
    Account getAccountByAccountNumber(@RequestBody String accountNumber) {
        return bankingService.getAccountByAccountNumber(accountNumber);
    }

    @PutMapping("/updateAccountBalance/{accountNumber}")
    Account updateAccountBalance(@PathVariable String accountNumber, @RequestBody Double balance) {
        return bankingService.updateAccountBalance(accountNumber, balance);
    }

    @PutMapping("/closeAccount/{accountNumber}")
    void closeAccount(@PathVariable String accountNumber) {
        bankingService.closeAccount(accountNumber);
    }

    @PostMapping("/addTransaction")
    Transaction addNewTransaction(@RequestBody Transaction transaction) {
        return bankingService.addNewTransaction(transaction);
    }

    @GetMapping("/getAllTransactionByAccountId/{accountId}")
    List<Transaction> getAllTransactionByAccountId(@PathVariable Long accountId) {
        return bankingService.getAllTransactionByAccountId(accountId);
    }

    @GetMapping("/getTransactionByTransactionId/{transactionId}")
    Transaction getTransactionById(@PathVariable Long transactionId) {
        return bankingService.getTransactionById(transactionId);
    }

    @PostMapping("/createNewLoan")
    Loan addNewLoan(@RequestBody Loan loan) {
        return bankingService.addNewLoan(loan);
    }

    @GetMapping("/retrieveLoansForACustomer/{subjectCode}")
    List<Loan> retrieveLoansForACustomer(@PathVariable String subjectCode) {
        return bankingService.retrieveLoansForACustomer(subjectCode);
    }

    @GetMapping("/getLoanById/{loanId}")
    Loan getLoanById(@PathVariable Long loanId) {
        return bankingService.getLoanById(loanId);
    }

    @PutMapping("/updateAmount/{loanId}")
    Loan updateOutstandingAmount(@PathVariable Long loanId, @RequestBody Double balance) {
        return bankingService.updateOutstandingAmount(loanId, balance);
    }

    @PutMapping("/closeLoan/{loanId}")
    void closeLoan(@PathVariable Long loanId) {
        bankingService.closeLoan(loanId);
    }

    @PostMapping("/createNewCard")
    Card addNewCard(@RequestBody Card card) {
        return bankingService.addNewCard(card);
    }

    @GetMapping("/getCardsBySubjectCode/{subjectCode}")
    List<Card> getCardsBySubjectCode(@PathVariable String subjectCode) {
        return bankingService.getCardsBySubjectCode(subjectCode);
    }

    @GetMapping("/cards/{cardId}")
    Card getCardById(@PathVariable Long cardId) {
        return bankingService.getCardById(cardId);
    }

}
