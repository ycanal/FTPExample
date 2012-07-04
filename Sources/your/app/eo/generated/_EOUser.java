// DO NOT EDIT.  Make changes to your.app.eo.EOUser.java instead.
package your.app.eo.generated;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _EOUser extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "EOUser";

  // Attribute Keys
  public static final ERXKey<String> LOGIN = new ERXKey<String>("login");
  public static final ERXKey<String> PASSWORD = new ERXKey<String>("password");
  // Relationship Keys

  // Attributes
  public static final String LOGIN_KEY = LOGIN.key();
  public static final String PASSWORD_KEY = PASSWORD.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_EOUser.class);

  public your.app.eo.EOUser localInstanceIn(EOEditingContext editingContext) {
    your.app.eo.EOUser localInstance = (your.app.eo.EOUser)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String login() {
    return (String) storedValueForKey(_EOUser.LOGIN_KEY);
  }

  public void setLogin(String value) {
    if (_EOUser.LOG.isDebugEnabled()) {
    	_EOUser.LOG.debug( "updating login from " + login() + " to " + value);
    }
    takeStoredValueForKey(value, _EOUser.LOGIN_KEY);
  }

  public String password() {
    return (String) storedValueForKey(_EOUser.PASSWORD_KEY);
  }

  public void setPassword(String value) {
    if (_EOUser.LOG.isDebugEnabled()) {
    	_EOUser.LOG.debug( "updating password from " + password() + " to " + value);
    }
    takeStoredValueForKey(value, _EOUser.PASSWORD_KEY);
  }


  public static your.app.eo.EOUser createEOUser(EOEditingContext editingContext, String login
, String password
) {
    your.app.eo.EOUser eo = (your.app.eo.EOUser) EOUtilities.createAndInsertInstance(editingContext, _EOUser.ENTITY_NAME);    
		eo.setLogin(login);
		eo.setPassword(password);
    return eo;
  }

  public static ERXFetchSpecification<your.app.eo.EOUser> fetchSpec() {
    return new ERXFetchSpecification<your.app.eo.EOUser>(_EOUser.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<your.app.eo.EOUser> fetchAllEOUsers(EOEditingContext editingContext) {
    return _EOUser.fetchAllEOUsers(editingContext, null);
  }

  public static NSArray<your.app.eo.EOUser> fetchAllEOUsers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOUser.fetchEOUsers(editingContext, null, sortOrderings);
  }

  public static NSArray<your.app.eo.EOUser> fetchEOUsers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<your.app.eo.EOUser> fetchSpec = new ERXFetchSpecification<your.app.eo.EOUser>(_EOUser.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<your.app.eo.EOUser> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static your.app.eo.EOUser fetchEOUser(EOEditingContext editingContext, String keyName, Object value) {
    return _EOUser.fetchEOUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.eo.EOUser fetchEOUser(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<your.app.eo.EOUser> eoObjects = _EOUser.fetchEOUsers(editingContext, qualifier, null);
    your.app.eo.EOUser eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOUser that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.eo.EOUser fetchRequiredEOUser(EOEditingContext editingContext, String keyName, Object value) {
    return _EOUser.fetchRequiredEOUser(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.eo.EOUser fetchRequiredEOUser(EOEditingContext editingContext, EOQualifier qualifier) {
    your.app.eo.EOUser eoObject = _EOUser.fetchEOUser(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOUser that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.eo.EOUser localInstanceIn(EOEditingContext editingContext, your.app.eo.EOUser eo) {
    your.app.eo.EOUser localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
