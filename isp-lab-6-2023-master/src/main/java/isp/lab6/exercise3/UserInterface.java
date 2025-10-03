package isp.lab6.exercise3;

import java.util.Scanner;

public class UserInterface {
    private LoginSystem loginSyst;
    private OnlineStore store;

    public UserInterface(OnlineStore store, LoginSystem loginSyst) {
        this.store = store;
        this.loginSyst = loginSyst;
    }

    public UserInterface() {
        this.loginSyst = new LoginSystem();
        this.store = new OnlineStore();
    }

    public LoginSystem getLoginSyst() {
        return loginSyst;
    }

    public void setLoginSyst(LoginSystem loginSyst) {
        this.loginSyst = loginSyst;
    }

    public OnlineStore getStore() {
        return store;
    }

    public void setStore(OnlineStore store) {
        this.store = store;
    }



    /* #1a logIn/register   check
       #1b option to logOut check
       #2  shop             notYet
       #3  addToCart        notYet
       #4  Buy              notYet
     */
    public void loadInterface(){
        System.out.println("////////////////////////////////////\n Welcome to Online Store \n Please log in in order to shop");
        boolean success = false;
        char hasAccount;
        boolean logOut=false;
        String username = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have an account? (y/n)");
        hasAccount = scanner.next().charAt(0);

        //loop to prompt user to login/register
        while(!success) {
            if (hasAccount == 'y') {
                System.out.println("Please enter your username :");
                username = scanner.nextLine();
                System.out.println("Please enter your password :");
                String password = scanner.nextLine();
                success = loginSyst.login(username, password);
            }
            else{
                System.out.println("You will now register a new account. :");

                System.out.println("Please enter your username :");
                username = scanner.nextLine();

                System.out.println("Please enter your password :");
                String password = scanner.nextLine();

                loginSyst.register(username, password);
                success = loginSyst.login(username, password);
            }
        }

        //option to logOut
        System.out.println("If at any time you want to logOut, just enter: \"logOut\" and you will be loggedOut");
        while(!logOut) {
            String optionToLogOut =scanner.nextLine();
            if( optionToLogOut.equals("logOut")) {
                logOut = true;
                loginSyst.logout(username);
            }
            //the main body, 2,3,4

        }


    }
}
