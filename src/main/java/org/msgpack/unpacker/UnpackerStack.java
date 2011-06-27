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

import org.msgpack.value.Value;
import org.msgpack.value.ValueFactory;

final class UnpackerStack {
    private int top;
    private byte[] types;
    private int[] counts;
    private Value[][] objects;

    private static final byte ARRAY = 0;
    private static final byte MAP = 1;

    public UnpackerStack() {
        this.top = -1;
        // TODO
    }

    public void pushArray(int count) {
        pushArray(count, null);
    }

    public void pushArray(Value[] object) {
        pushArray(object.length, object);
    }

    public void pushMap(int count) {
        pushMap(count, null);
    }

    public void pushMap(Value[] map) {
        pushMap(map.length / 2, map);
    }

    private void pushArray(int count, Value[] object) {
        top++;
        types[top] = ARRAY;
        counts[top] = count;
        objects[top] = object;
    }

    private void pushMap(int count, Value[] object) {
        top++;
        types[top] = MAP;
        counts[top] = count*2;
        objects[top] = object;
    }

    public boolean advance(Value obj) {
        Value[] arr = objects[top];
        int count = counts[top];

        if(arr != null) {
            arr[arr.length - count] = obj;
        }
        count--;

        if(count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Value popValue() {
        Value[] arr = objects[top];
        Value v;
        if(arr == null) {
            // TODO
            v = ValueFactory.nilValue();
        } else {
            byte type = bytes[top];
            if(type == ARRAY) {
                v = ValueFactory.arrayValue(arr, true);
            } else {
                v = ValueFactory.mapValue(arr, true);
            }
        }
        top--;
        return v;
    }

    public void pop() {
        top--;
    }

    public int getTopCount() {
        return counts[top];
    }

    public int getDepth() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

