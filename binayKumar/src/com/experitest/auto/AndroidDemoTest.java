package com.experitest.auto;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidDemoTest extends BaseTest {

	protected AndroidDriver<AndroidElement> driver = null;

	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception {
		init(deviceQuery, "AndroidDemoTest");
		client.install("cloud:com.experitest.ExperiBank/.LoginActivity:1.0", false, false);
		client.launch("com.experitest.ExperiBank/.LoginActivity", false, true);
		//GateApp
		client.install("cloud:com.jabm.scuarex/.MainActivity:1.2", false, false);
		client.launch("com.jabm.scuarex/.MainActivity", false, true);


	}

	@Test
	public void test() {
//		// Enter the test code
		client.elementSendText(in.Repo.zone("Logi.Username"), in.Repo.element("Logi.Username"), 0, "company");
		client.elementSendText(in.Repo.zone("Logi.passwordTextField"), in.Repo.element("Logi.passwordTextField"), 0, "company");
		client.click(in.Repo.zone("Logi.Login"), in.Repo.element("Logi.Login"), 0, 1);
	
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
