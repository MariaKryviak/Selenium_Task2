package com.kryviak.pages.mailbox;

import com.kryviak.config.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailboxPage {
    private static Logger logger = LogManager.getLogger(MailboxPage.class);
    private WebDriver webDriver = DriverManager.getInstance().getWebDriver();

    private By clickCreateNewLetterButtonLocator = By.xpath("//div[@role='button'and@tabindex='0'and@gh='cm']");
    private By emailToTextFieldLocator = By.xpath("//textarea[1]");
    private By subjectToTextFieldLocator = By.xpath("//input[@name='subjectbox']");
    private By messageToTextFieldLocator = By.xpath("//div[@role='textbox']");
    private By clickSentMessageButtonLocator = By.xpath("//div[@role='button'and@tabindex='1'and@data-tooltip-delay='800']");
    private By clickSendMessageButtonLocator = By.xpath("//a[@target='_top'and@title='Sent']");
    private By clickToViewMessageDetailButtonLocator = By.xpath("//tbody/tr[@draggable='true'][2]");
    private By checkIfMessageIsSendButtonLocator = By.xpath("//h2[text()='Hello']");

    public void clickCreateNewLetterButton() {
        DriverManager.getInstance().waitForElementVisible(clickCreateNewLetterButtonLocator);
        webDriver.findElement(clickCreateNewLetterButtonLocator).click();
       logger.info("Click to the 'Compose' button on your email page");
    }

    public void setEmailToTextField(String emailTo) {
        DriverManager.getInstance().waitForElementVisible(emailToTextFieldLocator);
        webDriver.findElement(emailToTextFieldLocator).sendKeys(emailTo);
        logger.info("You sent a letter to: " + emailTo);
    }

    public void setSubjectToTextField(String subjectTo) {
        DriverManager.getInstance().waitForElementVisible(subjectToTextFieldLocator);
        webDriver.findElement(subjectToTextFieldLocator).sendKeys(subjectTo);
        logger.info("Subject is: " + subjectTo);
    }

    public void setMessageToTextField(String messageTo) {
        DriverManager.getInstance().waitForElementVisible(messageToTextFieldLocator);
        webDriver.findElement(messageToTextFieldLocator).sendKeys(messageTo);
        logger.info("Message is: " + messageTo);
    }

    public void clickSenDMessageButton() {
        DriverManager.getInstance().waitForElementVisible(clickSentMessageButtonLocator);
        webDriver.findElement(clickSentMessageButtonLocator).click();
        logger.info("Click to the 'Send' button to sent the message");
    }

    public void clickSenTMessageButton() {
        DriverManager.getInstance().waitForElementVisible(clickSendMessageButtonLocator);
        webDriver.findElement(clickSendMessageButtonLocator).click();
        logger.info("Click to the 'Sent' button to view all send message");
    }

    public void clickToViewMessageDetail() {
        DriverManager.getInstance().waitForElementVisible(clickToViewMessageDetailButtonLocator);
        webDriver.findElement(clickToViewMessageDetailButtonLocator).click();
        logger.info("Click to some message button to view detail");
    }

    public String checkIfMessageIsSend() {
        DriverManager.getInstance().waitForElementVisible(checkIfMessageIsSendButtonLocator);
        String message = webDriver.findElement(checkIfMessageIsSendButtonLocator).getText();
        logger.info("Check if the message was sent");
        return message;
    }
}
