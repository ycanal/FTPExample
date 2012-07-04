package your.app;

import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.AuthorizationRequest;
import org.apache.ftpserver.ftplet.User;

public class FTPUser implements User {
	private final static String root = "/tmp/FTP/";

	private final String login;

	public FTPUser(final String login) {
		this.login = login;
	}

	@Override
	public AuthorizationRequest authorize(final AuthorizationRequest authRequest) {
		return authRequest;
	}

	@Override
	public List<Authority> getAuthorities() {
		throw new NotImplementedException("getAuthorities()");
	}

	@Override
	public List<Authority> getAuthorities(final Class<? extends Authority> arg0) {
		throw new NotImplementedException("getAuthorities(final Class<? extends Authority> arg0)");
	}

	@Override
	public boolean getEnabled() {
		return true;
	}

	@Override
	public String getHomeDirectory() {
		String path = root + login;
		return path;
	}

	@Override
	public int getMaxIdleTime() {
		return 0;
	}

	@Override
	public String getName() {
		return this.login;
	}

	@Override
	public String getPassword() {
		throw new NotImplementedException("getPassword()");
	}
}
