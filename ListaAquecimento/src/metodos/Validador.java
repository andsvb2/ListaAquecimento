/**
 * @author https://receitasdecodigo.com.br/java/validar-email-em-java
 *
 */

package metodos;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public abstract class Validador {
	
	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

}
