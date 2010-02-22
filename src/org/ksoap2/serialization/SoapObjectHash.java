package org.ksoap2.serialization;

import java.util.Hashtable;

public class SoapObjectHash 
implements KvmSerializable 
{
    /**
     * 
     */
	String namespace;
	
	/**
	 * 
	 */
	String name;
	
	/**
	 * Creates a new <code>SoapObject</code> instance.
	 * @param namespace The namespace for the soap object
	 * @param name Tthe name of the soap object
	 */
	public SoapObjectHash(String namespace, String name) 
	{
		this.namespace = namespace;
		this.name = name;
	}

	public Object getProperty(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPropertyCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void getPropertyInfo(int index, Hashtable properties,
			PropertyInfo info) {
		// TODO Auto-generated method stub
		
	}

	public void setProperty(int index, Object value) {
		// TODO Auto-generated method stub
		
	}
}
