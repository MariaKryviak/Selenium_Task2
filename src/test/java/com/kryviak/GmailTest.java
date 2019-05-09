package com.kryviak;

import com.kryviak.config.DriverManager;
import com.kryviak.loginBO.LoginBO;
import com.kryviak.mailboxBO.MailboxBO;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GmailTest {

    @Test
    public void searchSomeWordInGoogle() {
        final String MSG_TITLE = "Hello";
        new LoginBO().login("testmy12341234", "1234test1234My");
        MailboxBO mailboxBO = new MailboxBO();
        mailboxBO.sendLetter("kryviakmaria@gmail.com", MSG_TITLE, "How are you?");

        Assert.assertTrue(mailboxBO.assertMessageSent(MSG_TITLE), MSG_TITLE);
    }

    @AfterTest
    private void closeBrowser() {
        DriverManager.getInstance().closeWebDriver();
    }
}
