package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://usab-staging.weboapps.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignUp() throws Exception {
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("(//a[contains(text(),'PROCEED')])[2]")).click();
    driver.findElement(By.id("firstName")).clear();
    driver.findElement(By.id("firstName")).sendKeys("Neha");
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys("Agarwal");
    driver.findElement(By.id("organization_email")).clear();
    driver.findElement(By.id("organization_email")).sendKeys("15/09-12@weboapps.com");
    driver.findElement(By.id("organization_password")).clear();
    driver.findElement(By.id("organization_password")).sendKeys("12345678");
    driver.findElement(By.cssSelector("#new_organizations_organization > input[name=\"commit\"]")).click();
    driver.findElement(By.id("organization_name")).clear();
    driver.findElement(By.id("organization_name")).sendKeys("15/09");
    driver.findElement(By.id("organizations_organization_category_id_1")).click();
    driver.findElement(By.cssSelector("div.licenseSelect")).click();
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.id("organizations_organization_plan_id_2")).click();
    driver.findElement(By.cssSelector("div.licenseSelect")).click();
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("fgh");
    driver.findElement(By.id("mobile_number")).click();
    driver.findElement(By.id("mobile_number")).sendKeys("1234567890");
    driver.findElement(By.id("postal_code")).clear();
    driver.findElement(By.id("postal_code")).sendKeys("99546");
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("neha2@weboapps.com");
    driver.findElement(By.name("commit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
