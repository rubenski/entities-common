package nl.codebase.entities.common.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.codebase.entities.common.FaceterConstants;

import java.util.Arrays;

public class AccountTest {

    private ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        Account account = new Account();
        Grants grants = new Grants();
        grants.setGrants(Arrays.asList(FaceterConstants.GRANT.ADMIN_USER, FaceterConstants.GRANT.COMPANY_USER));
        account.setGrants(grants);
        String s = account.grantsToString();
        account.grantsFromString(s);
        String test = "";
    }
}
