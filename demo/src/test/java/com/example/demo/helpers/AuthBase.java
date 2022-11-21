package com.example.demo.helpers;


import com.example.demo.ApplicationManager;
import com.example.demo.Tests.TestBase;
import com.example.demo.config.Settings;
import com.example.demo.models.AccountData;
import org.junit.Before;

import java.util.NoSuchElementException;
import java.util.Objects;

public class AuthBase extends TestBase {
    protected static final AccountData user = new AccountData(
            Settings.getLogin(),
            Settings.getPassword()
//            Settings.getPath()
    );

    @Before
    public void setUpTest() throws InterruptedException {
//        super.setUpTest();
//        app.getNavigation().getSiteUrl();
//        app.getAuth().Login(user);
//        app.getNavigation().getProfileUrl();

        try {
            super.setUpTest();
            System.out.println(app.getDriver().getCurrentUrl());
            if (!app.getAuth().findUsername()){
                app.getNavigation().getSiteUrl();
                app.getAuth().Login(user);
            }
            else if (app.getAuth().getCurrentUsername(user.username)) {
                app.getAuth().logout();
            }
//            if (Objects.equals(app.getDriver().findUsername()) {
//                app.getNavigation().getSiteUrl();
//                app.getAuth().Login(user);
//            }
        } catch (NoSuchElementException exception) {
            return;
        }
    }
}