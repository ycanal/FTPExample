// DO NOT EDIT.  Make changes to your.app.eo.Product.java instead.
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
public abstract class _Product extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Product";

  // Attribute Keys
  public static final ERXKey<String> DESCRIPTION = new ERXKey<String>("description");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<String> REF = new ERXKey<String>("ref");
  // Relationship Keys

  // Attributes
  public static final String DESCRIPTION_KEY = DESCRIPTION.key();
  public static final String NAME_KEY = NAME.key();
  public static final String REF_KEY = REF.key();
  // Relationships

  private static Logger LOG = Logger.getLogger(_Product.class);

  public your.app.eo.Product localInstanceIn(EOEditingContext editingContext) {
    your.app.eo.Product localInstance = (your.app.eo.Product)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String description() {
    return (String) storedValueForKey(_Product.DESCRIPTION_KEY);
  }

  public void setDescription(String value) {
    if (_Product.LOG.isDebugEnabled()) {
    	_Product.LOG.debug( "updating description from " + description() + " to " + value);
    }
    takeStoredValueForKey(value, _Product.DESCRIPTION_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_Product.NAME_KEY);
  }

  public void setName(String value) {
    if (_Product.LOG.isDebugEnabled()) {
    	_Product.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _Product.NAME_KEY);
  }

  public String ref() {
    return (String) storedValueForKey(_Product.REF_KEY);
  }

  public void setRef(String value) {
    if (_Product.LOG.isDebugEnabled()) {
    	_Product.LOG.debug( "updating ref from " + ref() + " to " + value);
    }
    takeStoredValueForKey(value, _Product.REF_KEY);
  }


  public static your.app.eo.Product createProduct(EOEditingContext editingContext, String description
, String name
, String ref
) {
    your.app.eo.Product eo = (your.app.eo.Product) EOUtilities.createAndInsertInstance(editingContext, _Product.ENTITY_NAME);    
		eo.setDescription(description);
		eo.setName(name);
		eo.setRef(ref);
    return eo;
  }

  public static ERXFetchSpecification<your.app.eo.Product> fetchSpec() {
    return new ERXFetchSpecification<your.app.eo.Product>(_Product.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<your.app.eo.Product> fetchAllProducts(EOEditingContext editingContext) {
    return _Product.fetchAllProducts(editingContext, null);
  }

  public static NSArray<your.app.eo.Product> fetchAllProducts(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Product.fetchProducts(editingContext, null, sortOrderings);
  }

  public static NSArray<your.app.eo.Product> fetchProducts(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<your.app.eo.Product> fetchSpec = new ERXFetchSpecification<your.app.eo.Product>(_Product.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<your.app.eo.Product> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static your.app.eo.Product fetchProduct(EOEditingContext editingContext, String keyName, Object value) {
    return _Product.fetchProduct(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.eo.Product fetchProduct(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<your.app.eo.Product> eoObjects = _Product.fetchProducts(editingContext, qualifier, null);
    your.app.eo.Product eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Product that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.eo.Product fetchRequiredProduct(EOEditingContext editingContext, String keyName, Object value) {
    return _Product.fetchRequiredProduct(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.eo.Product fetchRequiredProduct(EOEditingContext editingContext, EOQualifier qualifier) {
    your.app.eo.Product eoObject = _Product.fetchProduct(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Product that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.eo.Product localInstanceIn(EOEditingContext editingContext, your.app.eo.Product eo) {
    your.app.eo.Product localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
