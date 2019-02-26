package Data;

import org.testng.annotations.DataProvider;

public class AllServices {

    @DataProvider(name = "validServiceInfo")
    public Object[][] getData() {
        return new Object[][]{
                {"MyWebdriver","Software","https://google.com","https://accounts.google.com/ServiceLogin","hostinger",
                "22","google.com,mail.google.com","https://google.com/admin","https://policies.google.com/terms?hl=en","Nice service.Works fine.",
                "Social_Network","Adult Content","12/12/2012","Public","123",
                "","London","Germany","Hostinger","Ukraine"}

        };

    }

}
