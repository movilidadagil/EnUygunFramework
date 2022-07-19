package testscenarios;

import framework.DriverSetup;
import org.apache.commons.lang.StringUtils;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageScenariosJupiter {
    LoginPage loginPage = new LoginPage(DriverSetup.getDriver());
    @Ignore
    public void m6() {
        System.out.println("Using @Ignore , this execution is ignored");
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void m7() {
        System.out.println("Using @Test(timeout),it can be used to enforce timeout in JUnit4 test case");
    }

    /*@Test(expected = NoSuchMethodException.class)
    public void m8() {
        System.out.println("Using @Test(expected) ,it will check for specified exception during its execution");

    }*/

    public boolean isPalindrome(String s) {
        return s == null ? false : StringUtils.reverse(s).equals(s);
    }

    @ParameterizedTest(name = "{index} - {0} is a palindrome")
    @ValueSource(strings = { "12321", "pop" })
    void testPalindrome(String word) {
        assertTrue(isPalindrome(word));
    }


}
