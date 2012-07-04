package your.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.DefaultFtplet;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.FtpletResult;

import your.app.eo.Product;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;

import er.extensions.eof.ERXEC;

public class MyFTPLet extends DefaultFtplet {

	@Override
	public FtpletResult onLogin(final FtpSession session, final FtpRequest request)
			throws FtpException, IOException {

		File userRoot = new File(session.getUser().getHomeDirectory());
		userRoot.mkdirs();

		return super.onLogin(session, request);
	}

	@Override
	public FtpletResult onMkdirStart(final FtpSession session, final FtpRequest request) throws FtpException, IOException {
		session.write(new DefaultFtpReply(FtpReply.REPLY_550_REQUESTED_ACTION_NOT_TAKEN, "You can't create directories on this server."));
		return FtpletResult.SKIP;
	}

	@Override
	public FtpletResult onUploadStart(final FtpSession session, final FtpRequest request) throws FtpException, IOException {
		String fileName = request.getArgument();

		if(!fileName.equals("add") && !fileName.equals("delete")) {
			session.write(new DefaultFtpReply(FtpReply.REPLY_553_REQUESTED_ACTION_NOT_TAKEN_FILE_NAME_NOT_ALLOWED, "Wrong file name \"" + fileName + "\""));
			return FtpletResult.SKIP;
		}

		return super.onUploadStart(session, request);
	}

	@Override
	public FtpletResult onUploadEnd(final FtpSession session, final FtpRequest request) throws FtpException, IOException {
		EOEditingContext ec = ERXEC.newEditingContext();
		ec.lock();
		try {
			String userRoot = session.getUser().getHomeDirectory();
			String currDir = session.getFileSystemView().getWorkingDirectory().getAbsolutePath();
			String fileName = request.getArgument();

			File f = new File(userRoot + currDir + fileName);
			BufferedReader br = new BufferedReader(new FileReader(f));

			if(fileName.equals("add")) {
				String line;
				while((line = br.readLine()) != null) {
					String[] data = line.split(",");
					Product p = Product.createProduct(ec, data[2], data[1], data[0]);
					ec.insertObject(p);
				}
			} else {
				String line;
				while((line = br.readLine()) != null) {
					EOQualifier q = Product.REF.eq(line);
					Product p = Product.fetchProduct(ec, q);
					ec.deleteObject(p);
				}
			}

			ec.saveChanges();
			f.delete();
		} catch(IOException ioe) {
			session.write(new DefaultFtpReply(FtpReply.REPLY_451_REQUESTED_ACTION_ABORTED, "Operation failed."));
			return FtpletResult.SKIP;
		} finally {
			ec.unlock();
			ec.dispose();
		}

		return super.onUploadEnd(session, request);
	}
}
