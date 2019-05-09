package com.kryviak.mailboxBO;

import com.kryviak.pages.mailbox.MailboxPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailboxBO {
    public void sendLetter(String email, String subject, String message) {
        MailboxPage mailboxPage = new MailboxPage();
        mailboxPage.clickCreateNewLetterButton();
        mailboxPage.setEmailToTextField(email);
        mailboxPage.setSubjectToTextField(subject);
        mailboxPage.setMessageToTextField(message);
        mailboxPage.clickSenDMessageButton();
        mailboxPage.clickSenTMessageLink();
    }

    public boolean assertMessageSent(String msgTitle) {
        List<WebElement> mailTitlesList = new MailboxPage().getMessageTitles();
        boolean isMessageSent = false;
        for (WebElement element: mailTitlesList) {
            if (element.getText().equals(msgTitle)) {
                isMessageSent = true;
                break;
            }
        }
        return isMessageSent;
    }
}
