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

final class ConverterStack {
    /* TODO
    private int top;
    private byte[] types;
    private int[] counts;
    private Value[][] objects;

    private static final byte ARRAY = 0;
    private static final byte MAP = 1;

    public ValueUnpackerStack() {
        this.top = -1;
        // TODO
    }

    public void pushArray(Value[] array) {
        top++;
        types[top] = ARRAY;
        counts[top] = array.count;
        objects[top] = array;
    }

    public void pushMap(Value[] map) {
        top++;
        types[top] = MAP;
        counts[top] = map.length;
        objects[top] = map;
    }

    public Value getElement() {
        Value[] arr = objects[top];
        int count = counts[top];
        if(count == 0) {
            return null;
        }
        return arr[arr.length - count + 1];
    }

    public void nextElement() {
        counts[top]--;
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
    */
}

