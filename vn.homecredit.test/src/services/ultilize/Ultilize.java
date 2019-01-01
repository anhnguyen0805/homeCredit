package services.ultilize;

import java.util.regex.Pattern;

import org.openqa.selenium.Keys;

public class Ultilize {

	public Keys getReflectKey(int number) {
		Keys key = null;
		switch (number) {
		case 0:
			key = Keys.NUMPAD0;
			break;
		case 1:
			key = Keys.NUMPAD1;
			break;
		case 2:
			key = Keys.NUMPAD2;
			break;
		case 3:
			key = Keys.NUMPAD3;
			break;
		case 4:
			key = Keys.NUMPAD4;
			break;
		case 5:
			key = Keys.NUMPAD5;
			break;
		case 6:
			key = Keys.NUMPAD6;
			break;
		case 7:
			key = Keys.NUMPAD7;
			break;
		case 8:
			key = Keys.NUMPAD8;
			break;
		case 9:
			key = Keys.NUMPAD9;
			break;
		default:
			break;
		}
		return key;
	}

	public boolean validateEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
}
