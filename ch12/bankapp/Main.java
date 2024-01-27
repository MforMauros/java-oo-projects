package gr.aueb.cf.ch12.bankapp;
import gr.aueb.cf.ch12.bankapp.model.JointAccount;
import gr.aueb.cf.ch12.bankapp.model.OverdraftAccount;
public class Main {

    public static void main(String[] args) {
        Account account1 = new Account(1, "GR22312", "Jon", "Boden", "12321432", 2000.0);
        Account account2 = new Account(2, "GR234534", "Julia", "Usitalo", "2343455", 800.0);
        Account account3 = new Account(3, "GR234455", "Mike", "Mavros", "654634345", 40.0);

        // overdraft account
        OverdraftAccount test1 = new OverdraftAccount(account3, 1000.0, 0);
        JointAccount test2 = new JointAccount(account1, account2);

        testOverdraftAccount (test1, account3);
        testJointAccount(test2, account1, account2);
    }

    private static void testOverdraftAccount(OverdraftAccount test1, Account account3) {
        System.out.println(test1.OverdraftConvertToString());
        test1.overdraftWithdraw(250.00, account3.getSsn());
        System.out.println(test1.OverdraftConvertToString());

        test1.overdraftWithdraw(791.00, account3.getSsn());
        System.out.println(test1.OverdraftConvertToString());
    }

    private static void testJointAccount(JointAccount test2, Account primaryAccountHolder, Account secondaryAccountHolder) {
        System.out.println(test2.accountToString());
        test2.withdraw(200.0, primaryAccountHolder.getSsn());
        System.out.println(test2.accountToString());
        test2.withdraw(500.0, secondaryAccountHolder.getSsn());
        System.out.println(test2.accountToString());
        test2.withdraw(3500.0, secondaryAccountHolder.getSsn());
        System.out.println(test2.accountToString());

    }

}
