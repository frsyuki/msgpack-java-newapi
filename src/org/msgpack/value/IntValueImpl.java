//
// MessagePack for Java
//
// Copyright (C) 2009-2011 FURUHASHI Sadayuki
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
package org.msgpack.value;

class IntValueImpl extends IntegerValue {
    private int value;

    IntegerValueImpl(int value) {
        this.value = value;
    }

    public byte getByte() {
        if(value > (int)Byte.MAX_VALUE) {
            throw new MessageCastException();  // TODO message
        }
        return (byte)value;
    }

    public short getShort() {
        if(value > (int)Short.MAX_VALUE) {
            throw new MessageCastException();  // TODO message
        }
        return (short)value;
    }

    public int getInt() {
        return value;
    }

    public long getLong() {
        return value;
    }

    public BigInteger getBigInteger() {
        return BigInteger.valueOf((long)value);
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
        return BigInteger.valueOf((long)value);
    }

    public float floatValue() {
        return (float)value;
    }

    public double doubleValue() {
        return (double)value;
    }

    // TODO equals
    // TODO compareTo

	public int hashCode() {
		return value;
	}

	public Object clone() {
		return new IntValueImpl(value);
	}
}

