package vacations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import vacations.utils.UserInformation;

import java.util.ArrayList;
import java.util.List;

public class UsersListPage extends BasePage {

    private ArrayList<String> userDataFound = new ArrayList<>();

    @FindBy(css = "#content table tbody")
    private WebElement tblEployeeList;


    public UsersListPage(WebDriver driver) {
        super(driver);
    }

    public void searchUser(String leaderName) {
        List<WebElement> tblRows = tblEployeeList.findElements(By.tagName("tr"));
        for (int r = 1; r < tblRows.size(); r++) {
            List<WebElement> tblCells = tblRows.get(r).findElements(By.tagName("td"));
            String cellText = tblCells.get(3).getText();
            if (leaderName.trim().equals(cellText.trim())) {
                for (int c = 0; c < 5; c++) {
                    userDataFound.add(tblCells.get(c).getText());
                }
                break;
            }
        }
    }

    public boolean verifyUserInformationMatches(UserInformation userInfo) {
        boolean validation = true;
        ArrayList<String> userData = new ArrayList<>();
        userData.add(userInfo.getFirstName());
        userData.add(userInfo.getLastName());
        userData.add(userInfo.getIdentification());
        userData.add(userInfo.getLeaderName());

        String[] date = userInfo.getDateIn().split("-");
        String dateStr = date[1] + "/" + date[0] + "/" + date[2];
        userData.add(dateStr);

        for (int i = 0; i < userDataFound.size(); i++) {
            if (!userDataFound.get(i).equals(userData.get(i))) {
                validation = false;
            }
        }
        return validation;
    }
}
