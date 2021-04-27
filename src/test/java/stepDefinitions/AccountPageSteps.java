package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> credentials = dataTable.asMaps();
		String email = credentials.get(0).get("username");
		String password =credentials.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		accountsPage = loginPage.doLogin(email,password);
	}
	
	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Page title is : " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionTable) {
		List<String> expectedAccountList = sectionTable.asList();
		System.out.println("expectedAccountList : "+ expectedAccountList);
		List<String> actualdAccountList = accountsPage.getAccountSectionList();
		System.out.println("actualdAccountList : "+ actualdAccountList);
		Assert.assertTrue(expectedAccountList.containsAll(actualdAccountList));
		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer count) {
		Assert.assertTrue( accountsPage.getAccountSectionCount() == count); 
	}
}
