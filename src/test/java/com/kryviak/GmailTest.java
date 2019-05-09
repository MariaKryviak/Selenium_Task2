package com.kryviak;

import com.kryviak.config.DriverManager;
import com.kryviak.loginBO.LoginBO;
import com.kryviak.mailboxBO.MailboxBO;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class GmailTest {

    @Test
    private void searchSomeWordInGoogle() {
        new LoginBO().login("testmy12341234", "1234test1234My");
        new MailboxBO().sentLetter("kryviakmaria@gmail.com", "Hello", "How are you?");

        Assert.assertEquals("Hello", new MailboxBO().checkIfLetterIsSend());
    }

    @AfterTest
    private void closeBrowser() {
        DriverManager.getInstance().closeWebDriver();
    }
}
