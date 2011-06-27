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
package org.msgpack.unpacker;

import java.io.IOException;
import java.io.EOFException;

abstract class AbstractMessagePackUnpacker extends Unpacker {
//    private UnpackerStack stack;
//    private int nextDepth;
//
//    private final class State {
//        int remain;
//        byte headByte;
//        byte[] castBuffer;
//        byte[] raw;
//        ByteBuffer castByteBuffer;
//
//        byte getHeadByte() {
//            // TODO
//        }
//
//        ByteBuffer readCastBufferForce(int size) throws IOException {
//            if(!readCastBuffer(size)) {
//                throw new EOFException();
//            }
//            return castByteBuffer;
//        }
//
//        boolean readCastBuffer(int size) throws IOException {
//            // TODO
//        }
//
//        ByteBuffer getCastByteBuffer() {
//            return castByteBuffer;
//        }
//    }
//
//    // remain == -2:               read headByte
//    // remain == -1:               set remain
//    // remain == 0:                retry cast
//    // remain > 0 && raw != null:  read raw and retry cast
//    // remain > 0 && raw == null:  read castBuffer and retry cast
//    private int remain;
//
//    private byte headByte;
//    private byte[] raw;
//    private byte[] castBuffer;
//    private ByteBuffer castByteBuffer;
//
//    public AbstractMessagePackUnpacker() {
//        this.stack = new UnpackerStack();
//        this.nextDepth = Integer.MAX_VALUE;
//        this.remain = -1;
//        this.headByte = 0;  // TODO
//        this.castBuffer = new byte[8];
//        this.castByteBuffer = ByteBuffer.wrap(castBuffer);
//    }
//
//    public Value read() throws IOException {
//        int targetDepth = stack.getDepth();
//        if(targetDepth < nextDepth) {
//            nextDepth = targetDepth;
//        } else {
//            targetDepth = nextDepth;
//        }
//
//        Value v;
//        try {
//            v = readImpl(targetDepth);
//            if(v == null) {
//                return null;
//            }
//        } catch (EOFException e) {
//            return null;
//        }
//
//        nextDepth = Integer.MAX_VALUE;
//        return v;
//    }
//
//    private Value readImpl(int targetDepth) throws IOException {
//        Value obj = null;
//        int count = 0;
//        Value[] array = null;
//
//        while(true) {
//        _next_object: {
//            _put: {
//
//                byte b;
//                if(remain == -2) {
//                    b = headByte = readHeadByte();
//                    remain = -1;
//                } else if(raw != null) {
//                    if(!readRawBodyCont()) {
//                        return null;
//                    }
//                    obj = ValueFactory.rawValue(raw, true);
//                    raw = null;
//                    break _put;
//                } else {
//                    if(remain > 0 && !readCastBufferCont()) {
//                        return null;
//                    }
//                    b = headByte;
//                }
//
//                if((b & 0x80) == 0) {  // Positive Fixnum
//                    //System.out.println("positive fixnum "+b);
//                    obj = ValueFactory.integerValue(b);
//                    break _put;
//                }
//
//                if((b & 0xe0) == 0xe0) {  // Negative Fixnum
//                    //System.out.println("negative fixnum "+b);
//                    obj = ValueFactory.integerValue(b);
//                    break _put;
//                }
//
//                if((b & 0xe0) == 0xa0) {  // FixRaw
//                    int size = b & 0x1f;
//                    if(size == 0) {
//                        obj = ValueFactory.rawValue();
//                        break _put;
//                    }
//                    if(!readRawBody(size)) {
//                        return null;
//                    }
//                    obj = ValueFactory.rawValue(raw, true);
//                    raw = null;
//                    break _put;
//                    //cs = ACS_RAW_VALUE;
//                    //break _fixed_trail_again;
//                }
//
//                if((b & 0xf0) == 0x90) {  // FixArray
//                    count = b & 0x0f;
//                    //System.out.println("fixarray count:"+count);
//                    if(count == 0) {
//                        obj = ValueFactory.arrayValue();
//                        break _put;
//                    }
//                    stack.pushArray(new Value[count]);
//                    break _next_object;
//                }
//
//                if((b & 0xf0) == 0x80) {  // FixMap
//                    count = b & 0x0f;
//                    //System.out.println("fixmap count:"+count/2);
//                    if(count == 0) {
//                        obj = ValueFactory.mapValue();
//                        break _put;
//                    }
//                    stack.pushMap(new Value[count*2]);
//                    break _next_object;
//                }
//
//                switch(b & 0xff) {
//                case 0xc0:  // nil
//                    obj = ValueFactory.nilValue();
//                    break _put;
//                case 0xc2:  // false
//                    obj = ValueFactory.booleanValue(false);
//                    break _put;
//                case 0xc3:  // true
//                    obj = ValueFactory.booleanValue(true);
//                    break _put;
//                case 0xca:  // float
//                    if(!readCastBuffer(4)) { return null; }
//                    obj = ValueFactory.floatValue(castByteBuffer.getFloat(0));
//                    break _put;
//                case 0xcb:  // double
//                    if(!readCastBuffer(8)) { return null; }
//                    obj = ValueFactory.floatValue(castByteBuffer.getDouble(0));
//                    break _put;
//                case 0xcc:  // unsigned int  8
//                    if(!readCastBuffer(1)) { return null; }
//                    obj = ValueFactory.integerValue(castByteBuffer.getByte(0) & 0xff);
//                    break _put;
//                case 0xcd:  // unsigned int 16
//                    obj = readUint16Body();
//                    break _put;
//                case 0xce:  // unsigned int 32
//                    obj = readUint32Body();
//                    break _put;
//                case 0xcf:  // unsigned int 64
//                    obj = readUint64Body();
//                    break _put;
//                case 0xd0:  // signed int  8
//                    obj = readInt8Body();
//                    break _put;
//                case 0xd1:  // signed int 16
//                    obj = readInt16Body();
//                    break _put;
//                case 0xd2:  // signed int 32
//                    obj = readInt32Body();
//                    break _put;
//                case 0xd3:  // signed int 64
//                    obj = readInt64Body();
//                    break _put;
//                    //this.remain = 1 << (b & 0x03);
//                    //cs = b & 0x1f;
//                    //System.out.println("a trail "+trail+"  cs:"+cs);
//                    //break _fixed_trail_again;
//                case 0xda:  // raw 16
//                    if(!readRawBody(readSize16Body())) {
//                        return null;
//                    }
//                    obj = ValueFactory.rawValue(raw, true);
//                    raw = null;
//                    break _put;
//                case 0xdb:  // raw 32
//                    if(!readRawBody(readSize32Body())) {
//                        return null;
//                    }
//                    obj = ValueFactory.rawValue(raw, true);
//                    raw = null;
//                    break _put;
//                case 0xdc:  // array 16
//                    count = readSize16Body();
//                    if(count == 0) {
//                        obj = ValueFactory.arrayValue();
//                        break _put;
//                    }
//                    stack.pushArray(new Value[count]);
//                    break _next_object;
//                case 0xdd:  // array 32
//                    count = readSize32Body();
//                    if(count == 0) {
//                        obj = ValueFactory.arrayValue();
//                        break _put;
//                    }
//                    stack.pushArray(new Value[count]);
//                    break _next_object;
//                case 0xde:  // map 16
//                    count = readSize16Body();
//                    if(count == 0) {
//                        obj = ValueFactory.mapValue();
//                        break _put;
//                    }
//                    stack.pushMap(new Value[count*2]);
//                    break _next_object;
//                case 0xdf:  // map 32
//                    count = readSize32Body();
//                    if(count == 0) {
//                        obj = ValueFactory.mapValue();
//                        break _put;
//                    }
//                    stack.pushMap(new Value[count*2]);
//                    break _next_object;
//                    //this.remain = 2 << (b & 0x01);
//                    //cs = b & 0x1f;
//                    //System.out.println("b trail "+trail+"  cs:"+cs);
//                    //break _fixed_trail_again;
//                default:
//                    //System.out.println("unknown b "+(b&0xff));
//                    // headByte = CS_INVALID
//                    throw new UnpackException("parse error");
//                }
//            } // _put
//
//            if(obj == null) {
//                return null;
//            }
//            remain = -2;
//
//            while(true) {
//                if(stack.isEmpty()) {
//                    return obj;
//                }
//                boolean filled = stack.advance(obj);
//                if(targetDepth == stack.getDepth()) {
//                    return obj;
//                }
//                if(filled) {
//                    obj = stack.popValue();
//                } else {
//                    break;
//                }
//            }
//
//        }  // _next_object
//        }  // while(true)
//    }
//
//    public short readShort() throws IOException {
//        byte b = getHeadByte();
//
//        short result;
//
//        if((b & 0x80) == 0) {
//            // Positive Fixnum
//            result = (short) b;
//        } else if((b & 0xe0) == 0xe0) {
//            // Negative Fixnum
//            result = (short) b;
//        } else {
//            switch(b & 0xff) {
//            case 0xcc:  // unsigned int  8
//                if(!readCastBuffer(1)) { throw new EOFException(""); }
//                result = (short) (castByteBuffer.readByte() & 0xff);
//                break;
//            case 0xcd:  // unsigned int 16
//            case 0xce:  // unsigned int 32
//            case 0xcf:  // unsigned int 64
//            case 0xd0:  // signed int  8
//            case 0xd1:  // signed int 16
//            case 0xd2:  // signed int 32
//            case 0xd3:  // signed int 64
//                // TODO
//            default:
//                throw new MessageCastException();
//            }
//        }
//
//        remain = -2;
//        return result;
//    }
//
//    public byte[] readByteArray() throws IOException {
//        byte b = getHeadByte();
//
//        if((b & 0xe0) == 0xa0) {
//            // FixRaw
//            int size = b & 0x1f;
//            if(!readRawBody(size)) {
//                throw new EOFException();
//            }
//        } else {
//            switch(b & 0xff) {
//            case 0xda:  // raw 16
//                if(!readRawBody(readSize16Body())) {
//                    throw new EOFException();
//                }
//            case 0xdb:  // raw 32
//                if(!readRawBody(readSize32Body())) {
//                    throw new EOFException();
//                }
//            default:
//                throw new MessageCastException();
//            }
//        }
//
//        byte[] result = raw;
//        remain = -2;
//        raw = null;
//
//        return raw;
//    }
//
//    public int readArrayBegin() throws IOException {
//        int b = (int)getHeadByte();
//
//        if(remain == 0) {
//            // ok FixArray
//            //if((b & 0xe0) == 0xa0) {
//            //}
//            // TODO push stack
//            stack.pushArray(count);
//        } else {
//            // ok arrays
//            switch(b & 0xff) {
//            }
//            // TODO push stack
//        }
//    }
//
//    public void readArrayEnd(boolean check) throws IOException {
//        // TODO
//    }
//
//    /*
//    private boolean isPositiveFixnum() {
//        // TODO headByte
//    }
//    */
//
//    private byte getHeadByte() throws IOException {
//        if(remain == -2) {
//            headByte = readHeadByte();
//            remain = -1;
//            return headByte;
//            //setRemain(headByte);
//        } else if(raw != null) {
//            if(!readRawBodyCont()) {
//                throw new EOFException();
//            }
//            return headByte;
//        } else {
//            if(remain > 0 && !readCastBufferCont()) {
//                throw new EOFException();
//            }
//            return headByte;
//        }
//    }
//
//    private boolean readCastBuffer(int size) throws IOException {
//        if(remain <= 0) {
//            return true;
//        }
//        remain = size;
//        int l = readRaw(castBuffer, 0, size);
//        if(l < size) {
//            if(l <= 0) {
//                castByteBuffer.position(0);
//                return false;
//            }
//            castByteBuffer.position(l);
//            remain -= l;
//            return false;
//        } else {
//            remain = 0;
//            return true;
//        }
//    }
//
//    private boolean readCastBufferCont() throws IOException {
//        int off = castByteBuffer.position();
//        int l = readRaw(castBuffer, off, remain);
//        if(l < remain) {
//            if(l <= 0) {
//                return false;
//            }
//            castByteBuffer.position(off+l);
//            remain -= l;
//            return false;
//        }
//        return true;
//    }
//
//    private void setRemain(byte b) {
//        // Positive Fixnum
//        if((b & 0x80) == 0) {
//            remain = 0;
//            return;
//        }
//
//        // ...
//    }
//
//    private boolean readRawBody(int size) throws IOException {
//        if(size == 0) {
//            raw = new byte[0];
//            return true;
//        }
//        remain = size;
//        raw = new byte[size];
//        return readRawBodyCont();
//    }
//
//    /*
//    private Value readRawBody(int size) throws IOException {
//        remain = size;
//        raw = new byte[size];
//        if(readRawBodyCont()) {
//            byte[] b = raw;
//            Value v = ValueFactory.rawValue(b, true);
//            raw = null;
//            return v;
//        }
//    }
//    */
//
//    private boolean readRawBodyCont() throws IOException {
//        int l = readRaw(raw, raw.length - remain, remain);
//        if(remain <= l) {
//            remain = 0;
//            return true;
//        } else {
//            if(l <= 0) {
//                return false;
//            }
//            remain -= l;
//            return false;
//        }
//    }
//
//    private ByteBuffer getCastBuffer(int size) {
//        if(!readCastBuffer(size)) { return null; }
//        return castByteBuffer;
//    }
//
//    private Value readUint8Body() throws IOException {
//        if(!readCastBuffer(1)) { return null; }
//        return ValueFactory.integerValue(castByteBuffer.getByte(0) & 0xff);
//    }
//
//    private Value readUint16Body() throws IOException {
//        if(!readCastBuffer(2)) { return null; }
//        return ValueFactory.integerValue(castByteBuffer.getShort(0) & 0xffff);
//    }
//
//    private Value readUint32Body() throws IOException {
//        if(!readCastBuffer(4)) { return null; }
//        return ValueFactory.integerValue(castByteBuffer.getInt(0) & 0xffffffffL);
//    }
//
//    private Value readUint64Body() throws IOException {
//        if(!readCastBuffer(8)) { return null; }
//        long o = castByteBuffer.getLong(0);
//        if(o < 0) {
//            return ValueFactory.integerValue(new BigInteger(1, castBuffer));
//        } else {
//            return ValueFactory.integerValue(o);
//        }
//    }
//
//    private Value readInt8Body() throws IOException {
//        if(!readCastBuffer(1)) { return null; }
//        return ValueFactory.integerValue(castByteBuffer.getByte(0));
//    }
//
//    private Value readInt16Body() throws IOException {
//        if(!readCastBuffer(2)) { return null; }
//        return ValueFactory.integerValue(castByteBuffer.getShort(0));
//    }
//
//    private Value readInt32Body() throws IOException {
//        if(!readCastBuffer(4)) { return null; }
//        return ValueFactory.integerValue(castByteBuffer.getInt(0));
//    }
//
//    private Value readInt64Body() throws IOException {
//        if(!readCastBuffer(8)) { return null; }
//        return ValueFactory.integerValue(castByteBuffer.getLong(0));
//    }
//
//    private int readSize16Body() throws IOException {
//        if(!readCastBuffer(2)) { return null; }
//        return castByteBuffer.getShort(0) & 0xffff;
//    }
//
//    private int readSize32Body() throws IOException {
//        if(!readCastBuffer(4)) { return null; }
//        int o = castByteBuffer.getInt(0);
//        if(o < 0) {
//            throw new IOException("size too large");
//        }
//        return o;
//    }
//
//    abstract void readHeadByte() throws IOException;
//
//    abstract boolean readFully(byte[] b, int off, int len) throws IOException;
//
//    abstract boolean readRaw(byte[] b, int off, int len) throws IOException;
}

