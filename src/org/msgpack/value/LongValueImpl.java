//
// MessagePack for Java
//
// Copyright (C) 2009-2010 FURUHASHI Sadayuki
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package org.msgpack.object;

import java.math.BigInteger;
import java.io.IOException;
import org.msgpack.*;

class LongValueImpl extends IntegerType {
	private long value;

	LongValueImpl(long value) {
		this.value = value;
	}

	public byte getByte() {
		if(value > (long)Byte.MAX_VALUE) {
			throw new MessageCastException();  // TODO message
		}
		return (byte)value;
	}

	public short getShort() {
		if(value > (long)Short.MAX_VALUE) {
			throw new MessageCastException();  // TODO message
		}
		return (short)value;
	}

	public int getInt() {
		if(value > (long)Integer.MAX_VALUE) {
			throw new MessageCastException();  // TODO message
		}
		return (int)value;
	}

	public long getLong() {
		return value;
	}

	public BigInteger getBigInteger() {
		return BigInteger.valueOf(value);
	}

	public byte byteValue() {
		return (byte)value;
	}

	public short shortValue() {
		return (short)value;
	}

	public int intValue() {
		return (int)value;
	}

	public long longValue() {
		return (long)value;
	}

	public BigInteger bigIntegerValue() {
		return BigInteger.valueOf(value);
	}

	public float floatValue() {
		return (float)value;
	}

	public double doubleValue() {
		return (double)value;
	}

	public void messagePack(Packer pk) throws IOException {
		pk.packLong(value);
	}

    // TODO equals
    // TODO compareTo

	public int hashCode() {
		return (int)(value^(value>>>32));
	}

	public Object clone() {
		return new LongValueImpl(value);
	}
}

