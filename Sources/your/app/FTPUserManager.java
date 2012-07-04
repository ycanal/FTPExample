package your.app;

import org.apache.commons.lang.NotImplementedException;
import org.apache.ftpserver.ftplet.Authentication;
import org.apache.ftpserver.ftplet.AuthenticationFailedException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.usermanager.UsernamePasswordAuthentication;

import your.app.eo.EOUser;

public class FTPUserManager implements UserManager {

	@Override
	public User authenticate(final Authentication inAuth) throws AuthenticationFailedException {
		// inAuth is always an UsernamePasswordAuthentication
		UsernamePasswordAuthentication upa = (UsernamePasswordAuthentication)inAuth;
		String login = upa.getUsername();
		String password = upa.getPassword();

		// check user existence and credentials in database
		if(!EOUser.authenticate(login, password))
			throw new AuthenticationFailedException();

		return new FTPUser(login);
	}

	@Override
	public void delete(final String arg0) throws FtpException {
		throw new NotImplementedException("delete(final String)");
	}

	@Override
	public boolean doesExist(final String arg0) throws FtpException {
		throw new NotImplementedException("doesExist(final String)");
	}

	@Override
	public String getAdminName() throws FtpException {
		throw new NotImplementedException("getAdminName()");
	}

	@Override
	public String[] getAllUserNames() throws FtpException {
		throw new NotImplementedException("getAllUserNames()");
	}

	@Override
	public User getUserByName(final String login) throws FtpException {
		return new FTPUser(login);
	}

	@Override
	public boolean isAdmin(final String arg0) throws FtpException {
		throw new NotImplementedException("isAdmin(final String)");
	}

	@Override
	public void save(final User arg0) throws FtpException {
		throw new NotImplementedException("save(final User)");
	}
}
