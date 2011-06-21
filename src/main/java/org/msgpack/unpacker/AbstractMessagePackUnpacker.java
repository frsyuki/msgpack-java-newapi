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
    private UnpackerStack stack;
    private int nextDepth;

    private int remain;
    private byte headByte;
    private byte[] castBuffer;

    public AbstractMessagePackUnpacker() {
        this.stack = new UnpackerStack();
        this.nextDepth = Integer.VALUE_MAX;
        this.remain = -1;
        this.headByte = 0;  // TODO
        this.castBuffer = new byte[8];
    }

    public Value read() throws IOException {
        int targetDepth = stack.getDepth();
        if(targetDepth < nextDepth) {
            nextDepth = targetDepth;
        } else {
            targetDepth = nextDepth;
        }

        do {
            try {
                int b = (int)getHeadByte();
                // TODO

            } catch (EOFException e) {
                return null;
            }
        } while(targetDepth < stack.getDepth());

        nextDepth = Integer.VALUE_MAX;
    }

    public short readShort() throws IOException {
        int b = (int)getHeadByte();

        if(remain == 0) {
            // ok Positive Fixnum
            // ok Negative Fixnum
            // TODO type check
            // TODO cast
            //if((b & 0x80) != 0) {
            //}
            throw new IOException("type error");

        } else {
            // ok integers
            switch(b) {
                // TODO type check
                // TODO read remain
                // TODO cast
            }
            throw new IOException("type error");
            //TODO stack.advance();
        }
    }

    public byte[] readByteArray() throws IOException {
        int b = (int)getHeadByte();

        if(remain == 0) {
            // ok FixRaw
            //if((b & 0xe0) == 0xa0) {
            //}
            // TODO set remain

        } else {
            // ok raws
            switch(b & 0xff) {
            }
            //stack.advance();
        }
    }

    public int readArrayBegin() throws IOException {
        int b = (int)getHeadByte();

        if(remain == 0) {
            // ok FixArray
            //if((b & 0xe0) == 0xa0) {
            //}
            // TODO push stack
            stack.pushArray(count);
        } else {
            // ok arrays
            switch(b & 0xff) {
            }
            // TODO push stack
        }
    }

    public void readArrayEnd(boolean check) throws IOException {
        // TODO
    }

    /*
    private boolean isPositiveFixnum() {
        // TODO headByte
    }
    */

    private byte getHeadByte() {
        if(remain == -1) {
            headByte = readHeadByte();
            setRemain(headByte);
        }
        return headByte;
    }

    private void setRemain(byte b) {
        // Positive Fixnum
        if((b & 0x80) == 0) {
            remain = 0;
            return;
        }

        // ...
    }

    abstract void readHeadByte() throws IOException;

    abstract boolean readRemain(byte[] b, int off, int len) throws IOException;
}

