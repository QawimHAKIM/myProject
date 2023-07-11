package tek.capstone.bdd.framework.utilities;

import net.datafaker.Faker;

public class DataGenerator {

	public static String data(String input) {
		Faker faker = new Faker();
		String output = "";

		if (input.equals("firstName")) {
			output = faker.name().firstName();
			output = output.replaceAll("[^a-zA-Z]", "");
		} else if (input.equals("lastName")) {
			output = faker.name().lastName();
			output = output.replaceAll("[^a-zA-Z]", "");
		} else if (input.equals("email")) {
			output = faker.name().firstName() + "." + faker.name().lastName() + "@tekschool.us";
		} else if (input.equals("phoneNumber")) {
			output = faker.phoneNumber().cellPhone();
		} else if (input.equals("fullName")) {
			output = faker.name().fullName();
			output = output.replaceAll("[^a-zA-Z]", "");
		} else if (input.equals("streetAddress")) {
			output = faker.address().streetAddress();
		} else if (input.equals("city")) {
			output = faker.address().city();
		} else if (input.equals("state")) {
			output = faker.address().state();
		} else if (input.equals("zipCode")) {
			output = faker.address().zipCode();
		} else if (input.equals("cardNumber")) {
			output = faker.number().digits(16);
		} else if (input.equals("expirationMonth")) {
			output = "" + faker.number().numberBetween(1, 12);
		} else if (input.equals("expirationYear")) {
			output = "" + faker.number().numberBetween(2024, 2035);
		} else if (input.equals("securityCode")) {
			output = faker.number().digits(3);
		} else {
			output = faker.expression("");
		}
		return output;
	}

	public static String getCredentials(String input) {

		String email = "test123@yahoo.com";
		String res = "";
		String password = "Test@1234";
		String newPassword = "Test@123";

		if (input.equals("email")) {
			res = email;
		} else if (input.equals("password") || input.equals("previousPassword")) {
			res = password;

		} else if (input.equals("newPassword") || input.equals("confirmPassword")) {
			res = newPassword;

		}
		return res;

	}
}
