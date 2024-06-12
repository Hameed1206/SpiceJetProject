package base_package;

import org.testng.annotations.BeforeMethod;

import helper_package.UtilityClass;

public class BaseClass extends UtilityClass{

	@BeforeMethod(groups="smoke")
	public static void startUp() {
		launch();
	}
}
