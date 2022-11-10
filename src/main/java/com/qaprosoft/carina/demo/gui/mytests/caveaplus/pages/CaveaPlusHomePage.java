package com.qaprosoft.carina.demo.gui.mytests.caveaplus.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.mytests.caveaplus.components.Menu;
import com.qaprosoft.carina.demo.gui.mytests.caveaplus.components.enums.Languages;
import com.qaprosoft.carina.demo.gui.mytests.caveaplus.components.interfaces.IMenuPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CaveaPlusHomePage extends AbstractPage{

    @FindBy(xpath = "//*[@id='main-navbar']/div[1]/div[1]/a/span")
    private ExtendedWebElement caveaLogo;

    public CaveaPlusHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='right-nav']/li[1]/app-language-switcher/dropdown[1]/div/button")
    private ExtendedWebElement languageBtn;

    @FindBy(xpath = "//a[text() = '%s']")
    private ExtendedWebElement languageList;

    @FindBy(xpath = "//*[@class='container-caveaplus']/app-home-blocks/app-default-block[%s]/section/div[2]/swiper/div[%d]")
    private ExtendedWebElement swiper;

    @FindBy(xpath = "//main-slider/section/div[6]/div")
    private List<ExtendedWebElement> bannerPage;

    @FindBy(xpath = "//*[@class='nav header-menu ng-star-inserted']")
    private Menu menu;

    @FindBy(xpath = "//*[@id='right-nav']/li[2]/a")
    private ExtendedWebElement logInBtn;

    @FindBy(xpath = "//*[@id='right-nav']/li[3]/a")
    private ExtendedWebElement registrationBtn;

    @Override
    public boolean isPageOpened() {
        return caveaLogo.isElementPresent();
    }



    public void changeLanguage(Languages languages){
        languageBtn.click();
        languageList.format(languages.getLanguage()).click();
    }

    public void swipeMovies()  {

        for (int i = 1; i <=13; i++) {;
            for (int j =1; j<=2;j++) {
                swiper.format(i, j).scrollTo();
                pause(1);
                swiper.format(i,j).click();
            }
        }
    }

    public void switchBannerPage(){
        for (int i = 1; i < bannerPage.size(); i++) {
            bannerPage.get(i).click();
        }
    }

    public LogInPage clickLogInBtn(){
        logInBtn.click();
        return new LogInPage(getDriver());
    }

    public RegistrationPage clickRegistrationBtn(){
        registrationBtn.click();
        return new RegistrationPage(getDriver());
    }
    public Menu getMenu() {
        return menu;
    }
}
