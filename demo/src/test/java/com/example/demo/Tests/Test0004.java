package com.example.demo.Tests;

import com.example.demo.ApplicationManager;
import com.example.demo.generators.Generator;
import com.example.demo.helpers.AuthBase;
import com.example.demo.models.AccountData;
import com.example.demo.models.jaxb.Users;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Objects;

@RunWith(Theories.class)
public class Test0004 extends TestBase {

    @DataPoints
    public static List<AccountData> usersFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(Generator.DIRECTORY + "/invalid_users.xml"));
            return users.getUsers();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    @Theory
    public void test2(AccountData user) throws InterruptedException {
//        app.getAuth().logout();
        if (Objects.equals(app.getDriver().getCurrentUrl(), "http://web.bossnote.ru/index/")){
            app.getAuth().logout();
        }
        app.getNavigation().getSiteUrl();
//        app.getAuth().deleteUsername();
        app.getAuth().Login(user);
        Assert.assertFalse(app.getAuth().findUsername());
//        Assert.assertFalse(applicationManager.getLoginHelper().isAuthorized());
//        Assert.assertTrue(applicationManager.getLoginHelper().isNotAuthorized());
    }
}