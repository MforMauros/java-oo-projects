package gr.aueb.cf.ch18;

import gr.aueb.cf.ch18.dao.AccountDaoImpl;
import gr.aueb.cf.ch18.dto.AccountDTO;
import gr.aueb.cf.ch18.dto.UserDTO;
import gr.aueb.cf.ch18.model.Account;
import gr.aueb.cf.ch18.model.User;
import gr.aueb.cf.ch18.service.AccountServiceImpl;

import java.util.AbstractCollection;

public class Main {
    public static final AccountDaoImpl accountDAOImpl = new AccountDaoImpl();
    public static final AccountServiceImpl accountService = new AccountServiceImpl(accountDAOImpl);

    public static void main(String[] args) throws Exception {
        UserDTO kostas = new UserDTO("Kostas","Petrou","2837492384");
        AccountDTO kostasAccount = new AccountDTO("GR31894718",kostas,5000);

        accountDAOImpl.insert(new Account(kostasAccount.getIban(),new User(kostas.getFirstname(),kostas.getLastname(),kostas.getSsn()), kostasAccount.getBalance()));

        try{
            accountService.deposit(7000,kostasAccount);
            accountService.withdraw(3000,kostas.getSsn());
            accountService.withdraw(20000,kostas.getSsn());
        }catch(Exception e){
            throw new Exception(e.getMessage(),e.getCause());
        }

    }
}
