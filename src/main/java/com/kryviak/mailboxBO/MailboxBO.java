package com.kryviak.mailboxBO;

import com.kryviak.pages.mailbox.MailboxPage;

public class MailboxBO {
    public void sentLetter(String email, String subject, String message) {
        new MailboxPage().clickCreateNewLetterButton();
        new MailboxPage().setEmailToTextField(email);
        new MailboxPage().setSubjectToTextField(subject);
        new MailboxPage().setMessageToTextField(message);
        new MailboxPage().clickSenDMessageButton();
        new MailboxPage().clickSenTMessageButton();
        new MailboxPage().clickToViewMessageDetail();
    }

    public String checkIfLetterIsSend(){
        return new MailboxPage().checkIfMessageIsSend();
    }
}
