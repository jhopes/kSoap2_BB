/* Copyright (c) 2003,2004, Stefan Haustein, Oberhausen, Rhld., Germany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The  above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE. */

package org.ksoap2.serialization;

/**
 * A class that is used to encapsulate primitive types (represented by a string
 * in XML serialization).
 * 
 * Basically, the SoapPrimitive class encapsulates "unknown" primitive types
 * (similar to SoapObject encapsulating unknown complex types). For example, new
 * SoapPrimitive (classMap.xsd, "float", "12.3") allows you to send a float from
 * a MIDP device to a server although MIDP does not support floats. In the other
 * direction, kSOAP will deserialize any primitive type (=no subelements) that
 * are not recognized by the ClassMap to SoapPrimitive, preserving the
 * namespace, name and string value (this is how the stockquote example works).
 */
public class SoapPrimitive 
{
	/**
	 * The SOAP namespace assigned to this object
	 */
	private String namespace;
	
	/**
	 * The name of this object as it appears in the SOAP message body
	 */
	private String name;
	
	/**
	 * The primitive (scalar) value of the SOAP message object represented by this instance.
	 */
	private String value;

	/**
	 * @param namespace The SOAP namespace assigned to this object
	 * @param name The name of this object as it appears in the SOAP message body
	 * @param value The primitive (scalar) value of the SOAP message object.
	 */
	public SoapPrimitive(String namespace, String name, String value) 
	{
		this.namespace = namespace;
		this.name = name;
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) 
	{
		if ( ! (o instanceof SoapPrimitive)) { return false;}
		SoapPrimitive p = (SoapPrimitive) o;
		return	name.equals(p.name) && 
					namespace.equals(p.namespace) && 
						(value == null ? 
			(p.value == null) : 
			value.equals(p.value));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() { return name.hashCode() ^ namespace.hashCode(); }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() { return value; }

	/**
	 * @return The SOAP namespace assigned to this object.
	 */
	public String getNamespace() { return namespace; }
	
	/**
	 * @return The name of this object as it appears in the SOAP message body.
	 */
	public String getName() { return name; }

	/**
	 * @return The primitive (scalar) value of the SOAP message object.
	 */
	public String getValue() { return value; }
	
	/**
	 * @return Returns the value of this object as a boolean primitive.
	 */
	public boolean asBool() { return Cast.asBool(this); }
	
	/**
	 * @return Returns the value of this object as a int primitive.
	 */
	public int asInt() { return Cast.asInt(this); }
	
	/**
	 * @return Returns the value of this object as a float primitive.
	 */
	public float asFloat() { return Cast.asFloat(this); }
	
	/**
	 * @return Returns the value of this object as a String instance.
	 */
	public String asString() { return toString(); }
}
