/** Copyright (2016) Krishna C Tripathi. All rights reserved.
 * 
 * You are not allowed to read/copy/distribute following code without explicit written authorization from Krishna C Tripathi
 * Event after authorization this software is provided "as is" with no explicit or implicit warranties whatsoever 
 */

package org.himalay.lpp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.himalay.msgs.runtime.Created;

import org.himalay.msgs.runtime.*;

@Created(date = "Wed Oct 25 20:31:12 EST 2017")

public class Pressure_ extends LPPDataFactory.LPPData { // Concrete type is Pressure

	// members variables
	// header
	public LPPHeader header;
	// _value
	public int _value;

	public Pressure_() // throws Exception
	{
		init();
	}

	private void init() {
		// Initialize header
		header = new LPPHeader();
		// Initialize _value

	}

	public int readNoHeader(DataInputStream istream) throws IOException {

		preRead();
		int retVal = 0;
		// read _value
		{
			_value = istream.readUnsignedShort();
			retVal += 2;
		}

		postRead();
		return retVal;
	}

	public int read(DataInputStream istream) throws IOException {
		preRead();
		int retVal = 0;

		// read header
		retVal += header.read(istream);
		// read _value
		{
			_value = istream.readUnsignedShort();
			retVal += 2;
		}

		postRead();
		return retVal;
	}

	public int write(DataOutputStream ostream) throws IOException {
		preWrite();
		int retVal = 0;

		{
			/** fix dependent sizes for header **/
		}

		// write header
		if (header != null)
			retVal += header.write(ostream);
		// write _value
		ostream.writeShort(_value);
		retVal += 2;
		postWrite();
		return retVal;
	}

	public int dump(DumpContext dc) throws IOException {
		dc.indent();
		dc.getPs().print("Pressure_\n");
		dc.increaseIndent();
		int retVal = 0;
		// write header
		if (header != null) {
			dc.indent();
			dc.getPs().println("header");
			retVal += header.dump(dc);
		}
		// write _value
		dc.indent();
		dc.getPs().println("_value=" + _value + "(0x" + Integer.toHexString(_value) + ")");
		dc.decreaseIndent();
		return retVal;
	}

	// Getter for header
	// public LPPHeader getHeader()
	// {
	// return header ;
	// }

	// Setter for header
	// public void setHeader(LPPHeader val)
	// {
	// this.header= val;
	// }
	// Getter for _value
	// public int getValue()
	// {
	// return _value ;
	// }

	// Setter for _value
	// public void setValue(int val)
	// {
	// this._value= val;
	// }

	public int getSize() throws IOException {
		DataOutputStream dos = new DataOutputStream(new NullStream());
		return this.write(dos);
	}

	public void setHeader(LPPHeader header) {
		this.header = header;
		this.header.setMessageType(0x73);
	}

	public LPPHeader getHeader() {
		return this.header;
	}

}

// End of code