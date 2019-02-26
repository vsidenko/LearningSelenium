package Data;

import org.testng.annotations.DataProvider;

public class LoginCredentials {

    @DataProvider(name = "inputsInvalid")
    public Object[][] getData() {
        return new Object[][]{
                {"v.sidenko", ""},
                {"v.sidenko", "'d'"},
                {"v.sidenko", "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"},
                {"", "Viktor12345678"},
                {"a", "Viktor12345678"},
                {"'''''''''''^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^                                                                         dasdaw223@#@3!#$!!%!", "Viktor12345678"},

        };

    }
    @DataProvider(name = "inputsValid")
    public Object [][] getDataValid(){
        return new Object[][]{
                {"v.sidenko","Vlad1234567"}
        };
    }
}
