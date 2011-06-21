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

final class UnpackerStack {
    private int top;
    private byte[] types;
    private int[] counts;
    private Value[][] objects;

    private static final byte ARRAY_ITEM = 0;
    private static final byte MAP_KEY = 1;
    private static final byte MAP_VALUE = 2;

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
        types[top] = ARRAY_ITEM;
        counts[top] = count;
        objects[top] = object;
    }

    private void pushMap(int count, Value[] object) {
        top++;
        types[top] = MAP_KEY;
        counts[top] = count;
        objects[top] = object;
    }

    public boolean advance(Value obj) {
        byte type = bytes[top];
        Value[] arr = objects[top];
        int count = counts[top];
        if(type == ARRAY_ITEM) {
            if(arr) {
                arr[arr.length - count] = obj;
            }
            count--;
            if(count == 0) {
                return true;
            } else {
                counts[top] = count;
                return false;
            }

        } else if(type == MAP_KEY) {
            if(arr) {
                arr[arr.length - count*2] = obj;
            }
            return null;

        } else {
            if(arr) {
                arr[arr.length - count*2 + 1] = obj;
            }
            count--;
            if(count == 0) {
                return true;
            } else {
                counts[top] = count;
                return false;
            }
        }
    }

    public Value[] getTopObject() {
        return objects[top];
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

