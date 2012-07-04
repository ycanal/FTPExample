package your.app;

import java.io.File;
import java.util.Map;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.ssl.SslConfigurationFactory;

import er.extensions.appserver.ERXApplication;

public class Application extends ERXApplication {
	public static void main(final String[] argv) {
		ERXApplication.main(argv, Application.class);
	}

	public Application() {
		ERXApplication.log.info("Welcome to " + name() + " !");
		/* ** put your initialization code in here ** */

		FtpServerFactory serverFactory = new FtpServerFactory();

		// setup the default listener
		ListenerFactory listenerFactory = new ListenerFactory();

		// listen to a port > 1024
		listenerFactory.setPort(1250);

		// use ssl
		SslConfigurationFactory scf = new SslConfigurationFactory();
		String keystorePath = "/tmp/keystore.jks";
		scf.setKeystoreFile(new File(keystorePath));
		String keystorePassword = "myPassword";
		scf.setKeystorePassword(keystorePassword);

		// set the SSL configuration for the listener
		listenerFactory.setSslConfiguration(scf.createSslConfiguration());
		listenerFactory.setImplicitSsl(true);

		Listener listener = listenerFactory.createListener();
		serverFactory.addListener("default", listener);

		// setup user manager
		serverFactory.setUserManager(new FTPUserManager());

		// get current FTPLets and add our own
		Map<String, Ftplet> ftpLets = serverFactory.getFtplets();
		ftpLets.put("MyFTPLet", new MyFTPLet());

		// create and start server
		FtpServer server = serverFactory.createServer();
		try {
			server.start();
		} catch (FtpException e) {
			e.printStackTrace();
		}
	}
}
