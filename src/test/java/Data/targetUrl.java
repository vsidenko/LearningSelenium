package Data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Log;


public class targetUrl {
    private static String baseUrl = "http://ServiceIsUnderNDA";
    private static String login = "/login";
    private static String dashboard = "/#!/dashboard";
    private static String services_All = "/#!/services/all";
    private static String services_ValidateIPinfo = "/#!/services/ips/";
    private static String services_Parsers = "/#!/services/parsers";
    private static String freelancer_Tasks = "/#!/tasks/assign";
    private static String freelancer_GetTask = "/#!/tasks/get";
    private static String factors_Statistics = "/#!/factors/stat";
    private static String factors_Edit = "/#!/factors/edit";
    private static String user_Profile = "/#!/user/profile";
    private static String admin_UsersAndRoles = "/#!/admin/users";
    private static String admin_RolePermission = "/#!/admin/assign";
    private static String admin_Exceptions = "/#!/admin/exceptions";
    private static String delivery_MakeRelease = "/#!/xml/wizard";
    private static String delivery_Testing = "/#!/xml/testing";
    private static String delivery_Get = "/#!/xml/get";
    private static String research_MarketPlaces = "/#!/research/marketplaces";
    private static String research_TorrIPs = "/#!/research/tor";


    public static String getLogin() {
        return baseUrl + login;
    }

    public static String getDashboard() {
        return baseUrl + dashboard;
    }

    public static String getServices_All() {
        return baseUrl + services_All;
    }

    public static String getServices_ValidateIPinfo() {
        return baseUrl + services_ValidateIPinfo;
    }

    public static String getServices_Parsers() {
        return baseUrl + services_Parsers;
    }

    public static String getFreelancer_Tasks() {
        return baseUrl + freelancer_Tasks;
    }

    public static String getFreelancer_GetTask() {
        return baseUrl + freelancer_GetTask;
    }

    public static String getFactors_Statistics() {
        return baseUrl + factors_Statistics;
    }

    public static String getFactors_Edit() {
        return baseUrl + factors_Edit;
    }

    public static String getUser_Profile() {
        return baseUrl + user_Profile;
    }

    public static String getAdmin_UsersAndRoles() {
        return baseUrl + admin_UsersAndRoles;
    }

    public static String getAdmin_RolePermission() {
        return baseUrl + admin_RolePermission;
    }

    public static String getAdmin_Exceptions() {
        return baseUrl + admin_Exceptions;
    }

    public static String getDelivery_MakeRelease() {
        return baseUrl + delivery_MakeRelease;
    }

    public static String getDelivery_Testing() {
        return baseUrl + delivery_Testing;
    }

    public static String getDelivery_Get() {
        return baseUrl + delivery_Get;
    }

    public static String getResearch_MarketPlaces() {
        return baseUrl + research_MarketPlaces;
    }

    public static String getResearch_TorrIPs() {
        return baseUrl + research_TorrIPs;
    }


}
