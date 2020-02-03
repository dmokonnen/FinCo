package project.framework;

public class FinCo {

    private final IAccountManager accountManager;

    public FinCo(IAccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public static void main(String[] args) {

        FinCo finCo = new FinCo(new AccountManager());


    }
}
