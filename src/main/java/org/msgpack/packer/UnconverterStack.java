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
package org.msgpack.packer;

import java.util.List;

final class UnconverterStack {
    /* TODO
    private int top;
    private byte[] types;
    private int[] counts;
    private Value[][] objects;

    private static final byte ARRAY = 0;
    private static final byte MAP = 1;

    public UnconverterStack() {
        this.top = -1;
        // TODO
    }

    public void pushArray(int count) {
        top++;
        types[top] = ARRAY;
        counts[top] = count;
        objects[top] = new Value[count];
    }

    public void pushMap(int count) {
        top++;
        types[top] = MAP;
        counts[top] = count*2;
        objects[top] = new Value[count*2];
    }

    public Value put(Value obj) {
        if(isEmpty()) {
            return obj;
        }

        Value[] arr = objects[top];
        int count = counts[top];
        arr[arr.length - count] = obj;
        count--;
        if(count != 0) {
            return null;
        }
        byte type = types[top];
        top--;

        if(type == ARRAY) {
            return advance(ValueFactory.arrayValue(arr));
        } else {
            return advance(ValueFactory.mapValue(arr));
        }
    }

    public Value[] getTopObject() {
        return objects[top];
    }

    public int getDepth() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == 1;
    }
    */
}

