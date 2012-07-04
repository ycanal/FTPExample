package your.app.eo;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;

import er.extensions.eof.ERXEC;

public class EOUser extends your.app.eo.generated._EOUser {
	private static final long serialVersionUID = 8786260764064064781L;

	public static EOUser fetchByLogin(final EOEditingContext ec, final String login) {
		EOQualifier loginQualifier = EOUser.LOGIN.eq(login);
		EOUser user = EOUser.fetchEOUser(ec, loginQualifier);

		return user;
	}

	public static boolean authenticate(final String login, final String password) {
		EOEditingContext ec = ERXEC.newEditingContext();
		ec.lock();
		try {
			EOUser user = EOUser.fetchByLogin(ec, login);

			if(user == null || !user.password().equals(password))
				return false;

			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			ec.unlock();
			ec.dispose();
		}
	}
}
