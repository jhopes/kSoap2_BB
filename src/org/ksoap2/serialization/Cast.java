package org.ksoap2.serialization;

/**
 * This class contains methods for casting SoapPrimitive values to
 * various primitives types used by the J2ME/JavaME VM.
 * @author Michael Woods, NJSPB 2008-2009
 */
public class Cast 
{
	// PRIVATE; do not instantiate
	private Cast() { }

	/**
	 * Converts a Object/SoapPrimitive value to a boolean. All instances in which the following
	 * holds, will be considered true:
	 *  1) p != null
	 *  2) p.toString() != null && 
	 *  3) ! p.toString().equals("")
	 *  4) ! p.toString().equals("0")
	 *  5) ! p.toString().toLowerCase().equals("false")
	 * 
	 * @param o The Object/SoapPrimitive value to cast.
	 * @return Returns true if p evaluates to a true value as described above, or false
	 * if otherwise.
	 */
	public static boolean asBool(Object o)
	{
		if (o == null || ! (o instanceof SoapPrimitive)) { return false; }
		String _str = ((SoapPrimitive)o).toString();
		if (_str == null) { return false; }
		return ! _str.equals("") || ! _str.equals("0") || ! _str.toLowerCase().equals("false");
	}
	
	/**
	 * Converts a Object/SoapPrimitive value to an int. If p cannot be converted to an int value, 0 will be returned. 
	 * @param o The SoapPrimitive value to cast.
	 * @return Returns the int representation of p if successful, or 0 on failure.
	 */
	public static int asInt(Object o) { return asInt(o, 0); }

	/**
	 * Converts a Object/SoapPrimitive value to an int. If p cannot be converted to an int value, defaultValue will be returned. 
	 * @param o The Object/SoapPrimitive value to cast.
	 * @param defaultValue The default value to return when p cannot be converted to an int.
	 * @return Returns the int representation of p if successful, or defaultValue on failure.
	 */
	public static int asInt(Object o, int defaultValue)
	{
		if (o == null || ! (o instanceof SoapPrimitive)) { return defaultValue; }
		String _str = ((SoapPrimitive)o).toString();
		if (_str == null) { return defaultValue; }
		try {
			return Integer.parseInt(_str);
		} catch (NumberFormatException ignore) { 
			/* ignore */
		}
		return defaultValue;
	}

	/**
	 * Converts a Object/SoapPrimitive value to a float. If p cannot be converted to an float value, 0.0f will be returned. 
	 * @param p The Object/SoapPrimitive value to cast.
	 * @return Returns the float representation of p if successful, or 0.0f on failure.
	 */
	public static float asFloat(Object o) { return asFloat(o, 0.0f); }

	/**
	 * Converts a Object/SoapPrimitive value to a float. If p cannot be converted to an float value, defaultValue will be returned.
	 * @param o The Object/SoapPrimitive value to cast.
	 * @param defaultValue The default value to return when p cannot be converted to an float.
	 * @return Returns the float representation of p if successful, or defaultValue on failure.
	 */
	public static float asFloat(Object o, float defaultValue)
	{
		if (o == null || ! (o instanceof SoapPrimitive)) { return defaultValue; }
		String _str = ((SoapPrimitive)o).toString();
		if (_str == null){ return defaultValue; }
		try {
			return Float.parseFloat(_str);
		} catch (NumberFormatException ignore) { 
			/* ignore */ 
		}
		return defaultValue;
	}
	
	/**
	 * Converts a Object/SoapPrimitive value to a String. If p cannot be converted to an String value, "" will be returned.
	 * @param p The Object/SoapPrimitive value to cast.
	 * @return Returns the String representation of p if successful, or "" on failure.
	 */
	public static String asString(Object o) { return asString(o, ""); }

	/**
	 * Converts a Object/SoapPrimitive value to a String. If p cannot be converted to an String value, defaultValue will be returned.
	 * @param o The Object/SoapPrimitive value to cast.
	 * @return Returns the String representation of p if successful, or defaultValue on failure.
	 */
	public static String asString(Object o, String defaultValue)
	{
		if (o == null || ! (o instanceof SoapPrimitive)) { return defaultValue; }
		String _str = ((SoapPrimitive)o).toString();
		if (_str == null) { return defaultValue; }
		return _str;
	}
}
