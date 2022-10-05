package lesson9.utils;

public class Checker {
   int companyNamesValidatedCount = 0;


    public boolean checkCompanyName(String companyName) {

        if (companyNamesValidatedCount > 10) {
            return false;
        }

        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
