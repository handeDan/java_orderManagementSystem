import business.UserController;
import core.Helper;
import entity.User;
import view.DashboardUI;
import view.LoginUI;

public class Main {
    public static void main(String[] args) {
        Helper.setTheme();
        LoginUI loginUI = new LoginUI();
//        UserController userController = new UserController();
//        User user = userController.findByLogin("a@a.com", "123123");
//        DashboardUI dashboardUI = new DashboardUI(user);
    }
}