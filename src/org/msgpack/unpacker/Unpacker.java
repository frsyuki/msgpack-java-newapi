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

public abstract class Unpacker {
    public abstract Value read() throws IOException;

    public void skip() throws IOException {
        read();
    }

    public Iterator<Value> iterator() {
        new UnpackerIterator(this);
    }


    public abstract void readNil() throws IOException;

    public abstract boolean tryReadNil() throws IOException;


    public abstract boolean readBoolean() throws IOException;


    public abstract byte readByte() throws IOException;

    public abstract short readShort() throws IOException;

    public abstract int readInt() throws IOException;

    public abstract long readLong() throws IOException;

    public abstract BigInteger readBigInteger() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract double readDouble() throws IOException;


    public abstract int readByteArrayBegin() throws IOException;

    public abstract void readByteArrayBody(byte[] b, int off, int len) throws IOException;

    public abstract void readByteArrayEnd(int check) throws IOException;

    public void readByteArrayEnd() throws IOException {
        readByteArrayEnd(false);
    }


    public abstract int readArrayBegin() throws IOException;

    public abstract void readArrayEnd(boolean check) throws IOException;

    public void readArrayEnd() throws IOException {
        readArrayEnd(false);
    }


    public abstract int readMapBegin() throws IOException;

    public abstract void readMapEnd(boolean check) throws IOException;

    public void readMapEnd() throws IOException {
        readMapEnd(false);
    }


    public byte[] readByteArray() throws IOException {
        int len = readByteArrayBegin();
        byte[] b = new byte[len];
        readByteArrayBody(b, 0, len);
        readByteArrayEnd();
        return b;
    }

    public int readByteArray(byte[] b, int off, int len) throws IOException {
        int xlen = readByteArrayBegin();
        if(xlen < xlen) {
            len = xlen;
        }
        readByteArrayEnd(b, off, len);
        readByteArrayEnd(false);
        return xlen;
    }

    public String readString() throws IOException {
        // TODO encoding exception
        return new String(readByteArray(), "UTF-8");
    }


    public Value readValue() throws IOException {
        Value v = read();
        if(v == null) {
            throw new EOFException();
        }
        return v;
    }


    public <T> T read(T to) throws IOException {
        // TODO
        return null;
    }

    public <T> T read(Class<T> klass) throws IOException {
        // TODO
        return null;
    }
}

