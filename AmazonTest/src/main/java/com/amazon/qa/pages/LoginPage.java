package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase{

	//define page factory/object repository
	@FindBy(className="nav-line-1")
	WebElement signin;

}
