/* Copyright (c) 2003,2004, Stefan Haustein, Oberhausen, Rhld., Germany
 * Copyright (c) 2006, James Seigel, Calgary, AB., Canada
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

package org.ksoap2.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ServiceConnectionMidp for J2SE
 */
public class ServiceConnectionMidp implements ServiceConnection 
{
	/**
	 * 
	 */
	private HttpURLConnection connection;

    /**
     * @param url
     * @throws IOException
     */
    public ServiceConnectionMidp(String url) 
    throws IOException
    {
    	URL soapURL = new URL(url);
        connection = (HttpURLConnection)soapURL.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
    }

    /* (non-Javadoc)
     * @see org.ksoap2.transport.ServiceConnection#disconnect()
     */
    public void disconnect() 
    throws IOException 
    {
        connection.disconnect();
    }

    /* (non-Javadoc)
     * @see org.ksoap2.transport.ServiceConnection#setRequestProperty(java.lang.String, java.lang.String)
     */
    public void setRequestProperty(String string, String soapAction) 
    throws IOException 
    {
        connection.setRequestProperty(string, soapAction);
    }

    /* (non-Javadoc)
     * @see org.ksoap2.transport.ServiceConnection#setRequestMethod(java.lang.String)
     */
    public void setRequestMethod(String post) 
    throws IOException 
    {
        connection.setRequestMethod(post);
    }

    /* (non-Javadoc)
     * @see org.ksoap2.transport.ServiceConnection#openOutputStream()
     */
    public OutputStream openOutputStream() 
    throws IOException 
    {
        return connection.getOutputStream();
    }

    /* (non-Javadoc)
     * @see org.ksoap2.transport.ServiceConnection#openInputStream()
     */
    public InputStream openInputStream() throws IOException 
    {
        return connection.getInputStream();
    }

    /* (non-Javadoc)
     * @see org.ksoap2.transport.ServiceConnection#connect()
     */
    public void connect() throws IOException 
    {
        throw new RuntimeException("ServiceConnectionMidp.connect is not available.");
    }

    /* (non-Javadoc)
     * @see org.ksoap2.transport.ServiceConnection#getErrorStream()
     */
    public InputStream getErrorStream() 
    {
        throw new RuntimeException("ServiceConnectionMidp.getErrorStream is not available.");
    }

}
