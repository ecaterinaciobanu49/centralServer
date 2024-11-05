package com.centralserver.servercentral.services.implementations;

import com.centralserver.servercentral.models.*;
import com.centralserver.servercentral.restservices.RequestSender;
import com.centralserver.servercentral.services.BankingService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class HomogeneousDBService implements BankingService {
    private List<String> ports;
    private volatile int requestN;

    public HomogeneousDBService(List<String> ports) {
        this.ports = ports;
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        
        return RequestSender.createNewCustomer(customer, ports.get(current));
    }

    @Override
    public Customer getCustomerBySubjectCode(String subjectCode) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.getCustomerBySubjectCode(subjectCode, ports.get(current));
    }

    @Override
    public Customer editCustomerEmail(String subjectCode, String newEmail) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.editCustomerEmail(subjectCode, newEmail, ports.get(current));
    }

    @Override
    public void deleteCustomer(String subjectCode) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        boolean deleted = RequestSender.deleteCustomer(subjectCode, ports.get(current));
    }

    @Override
    public Account addNewAccount(Account account) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.addNewAccount(account, ports.get(current));
    }

    @Override
    public List<Account> getAllAccountsBySubjectCode(String subjectCode) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.getAllAccountsBySubjectCode(subjectCode, ports.get(current));
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.getAccountByAccountNumber(accountNumber, ports.get(current));
    }

    @Override
    public Account updateAccountBalance(String accountNumber, Double balance) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.updateAccountBalance(accountNumber, balance, ports.get(current));
    }

    @Override
    public void closeAccount(String accountNumber) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        boolean deleted = RequestSender.closeAccount(accountNumber, ports.get(current));
    }

    @Override
    public Transaction addNewTransaction(Transaction transaction) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.addNewTransaction(transaction, ports.get(current));
    }

    @Override
    public List<Transaction> getAllTransactionByAccountId(Long accountId) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.getAllTransactionByAccountId(accountId, ports.get(current));
    }

    @Override
    public Transaction getTransactionById(Long transactionId) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.getTransactionById(transactionId, ports.get(current));
    }

    @Override
    public Loan addNewLoan(Loan loan) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.addNewLoan(loan, ports.get(current));
    }

    @Override
    public List<Loan> retrieveLoansForACustomer(String subjectCode) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.retrieveLoansForACustomer(subjectCode, ports.get(current));
    }

    @Override
    public Loan getLoanById(Long loanId) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.getLoanById(loanId, ports.get(current));
    }

    @Override
    public Loan updateOutstandingAmount(Long loanId, Double balance) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.updateOutstandingAmount(loanId, balance, ports.get(current));
    }

    @Override
    public void closeLoan(Long loanId) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        boolean deleted = RequestSender.closeLoan(loanId, ports.get(current));
    }

    @Override
    public Card addNewCard(Card card) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.addNewCard(card, ports.get(current));
    }

    @Override
    public List<Card> getCardsBySubjectCode(String subjectCode) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.getCardsBySubjectCode(subjectCode, ports.get(current));
    }

    @Override
    public Card getCardById(Long cardId) {
        int current = 0;

        synchronized (this) {
            current = requestN;

            if (requestN < ports.size() - 1) {
                requestN++;
            } else {
                requestN = 0;
            }
        }
        return RequestSender.getCardById(cardId, ports.get(current));
    }
}
