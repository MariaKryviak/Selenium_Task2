package com.kryviak.loginBO;

import com.kryviak.pages.login.LoginEmailPage;
import com.kryviak.pages.login.LoginPassPage;

public class LoginBO {

    public void login(String mail, String pass) {
        new LoginEmailPage().setUserEmailTextField(mail).clickNextButton();
        new LoginPassPage().setUserPasswordTextField(pass).clickNextButton();
    }
}
