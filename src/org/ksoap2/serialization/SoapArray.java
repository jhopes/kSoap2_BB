package org.ksoap2.serialization;

import java.util.Hashtable;
import java.util.Vector;

/**
 * SoapArray serialization type; adapted from the example at 
 * http://ksoap2.wiki.sourceforge.net/Stadiums+at+the+World+Cup+Example
 * @author Michael Woods, NJSPB 2008-2009
 */
public class SoapArray 
extends Vector 
implements KvmSerializable 
{
	/**
	 * 
	 */
	private String responseName;
	
	/**
	 * 
	 */
	private String responseItemName;

	/**
	 * 
	 */
	private Class responseItemClass;

	/**
	 * @param envelope
	 * @param ns
	 * @param responseName
	 * @param responseItemName
	 * @throws IllegalArgumentException
	 */
	public SoapArray(
		SoapSerializationEnvelope envelope, 
		String ns, 
		String responseName, 
		String responseItemName)
	throws IllegalArgumentException
	{
		this(envelope, ns, responseName, responseItemName, SoapObject.class);
	}
	
	/**
	 * @param envelope
	 * @param namespace
	 * @param responseName
	 * @param responseItemName
	 * @param responseItemClass
	 * @throws IllegalArgumentException Thrown if responseItemClass is not of type KvmSerializable
	 */
	public SoapArray(
		SoapSerializationEnvelope envelope, 
		String ns, 
		String responseName, 
		String responseItemName,
		Class responseItemClass)
	throws IllegalArgumentException
	{
		super();
		/*
		if ( ! KvmSerializable.class.isAssignableFrom(responseItemClass)) {
			throw new IllegalArgumentException("responseItemClass (" + responseItemClass.getName() + ")must be a subtype of interface KvmSerializable");
		}
		*/
		
		this.responseName = responseName;
		this.responseItemName  = responseItemName;
		this.responseItemClass = responseItemClass;

		/*
		 * This assumes a SOAP-Body response of the structure:
		 * <response>
		 *   <response-item>item1</response-item>
		 *   <response-item>item1</response-item>
		 *   ...
		 *   <response-item>item1</response-item>
		 * </response>
		 */

		// Create the top-level <response> wrapper mapping
		SoapObject template = new SoapObject(ns, this.responseName);
		// Create the template used for serializing the sub-<response> <response-item> elements
        PropertyInfo info = new PropertyInfo();
        info.name = this.responseItemName;
        info.type = this.getClass();
        template.addProperty(info, "");
        envelope.addTemplate(template);
		
		// Maps to <response-item> -> java.util.Vector.class
		envelope.addMapping(ns, this.responseItemName, this.getClass());
	}

	/* (non-Javadoc)
	 * @see org.ksoap2.serialization.KvmSerializable#getPropertyInfo(int, java.util.Hashtable, org.ksoap2.serialization.PropertyInfo)
	 */
	public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) 
	{
		info.name = responseItemName;
		info.type = responseItemClass;
	}

	/* (non-Javadoc)
	 * @see org.ksoap2.serialization.KvmSerializable#getProperty(int)
	 */
	public Object getProperty(int index) { return elementAt(index); }
 
	/* (non-Javadoc)
	 * @see org.ksoap2.serialization.KvmSerializable#getPropertyCount()
	 */
	public int getPropertyCount() { return size(); }
 
	/* (non-Javadoc)
	 * @see org.ksoap2.serialization.KvmSerializable#setProperty(int, java.lang.Object)
	 */
	public void setProperty(int index, Object value) { setElementAt(value, index); }
}
