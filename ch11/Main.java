package gr.aueb.cf.ch11;

import gr.aueb.cf.ch11.model.User;
import gr.aueb.cf.ch11.model.UserCredentials;

public class Main {
    public static void main(String[] args) {

        User nikos = new User(7678283, "Nikos", "Koufopoulos" );
        User artemis = new User(72398938, "Artemis", "Avgeri" );

        UserCredentials nikthegreek = new UserCredentials(7678283, "NiktheGreek", "tyiopajy82" );
        UserCredentials artemisaki = new UserCredentials(72398938, "Artemisaki", "uxje29s2js" );

        System.out.println(nikos.userDataToString());
        System.out.println(artemis.userDataToString());

        System.out.println(nikthegreek.userCredentialsToString());
        System.out.println(artemisaki.userCredentialsToString());
    }

}
