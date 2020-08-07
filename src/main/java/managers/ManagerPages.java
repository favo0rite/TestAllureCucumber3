package managers;

import pages.MortgagePage;
import pages.MortgageReadyHousePage;
import pages.StartPage;

public class ManagerPages {
    private static ManagerPages managerPages;

    StartPage startPage;
    MortgagePage mortgagePage;
    MortgageReadyHousePage mortgageReadyHousePage;

    private ManagerPages() {

    }

    public static ManagerPages getManagerPages() {
        if (managerPages == null) {
            managerPages = new ManagerPages();
        }
        return managerPages;
    }

    public StartPage getStartPage() {
        if(startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public MortgagePage getMortgagePage() {
        if(mortgagePage == null) {
            mortgagePage = new MortgagePage();
        }
        return mortgagePage;
    }

    public MortgageReadyHousePage getMortgageReadyHousePage() {
        if(mortgageReadyHousePage == null) {
            mortgageReadyHousePage = new MortgageReadyHousePage();
        }
        return mortgageReadyHousePage;
    }
}
