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
import org.msgpack.value.Value;

public class Converter extends Unpacker {
    /* TODO
    private ConverterStack stack;
    private Value topValue;

    private Queue<Value> source;
    private int converted;

    public short readShort() throws IOException {
        Value v = getTopValue();

        Value obj = stack.getElement();
        if(obj == null) {
            // TODO
        }
        short v = obj.getShort();
        stack.nextElement();
        return v;
    }

    public int readArrayBegin() throws IOException {
        Value obj = stack.getElement();
        if(obj == null) {
            // TODO
        }
        if(!obj.isArray()) {
            throw new MessageCastException();
        }
        Value[] array = obj.getArray();
        stack.pushArray(array);
        return array.length;
    }

    public void readArrayEnd(boolean check) throws IOException {
        if(!stack.topIsArray()) {
            throw new MessageCastException();
        }
        if(check && stack.getTopCount() != 0) {
            throw new MessageCastException();
        }
        stack.pop();
    }

    private Value getTopValue() throws IOException {
        if(topValue == null) {
            if(stack.isEmpty() || stack.getTopCount() == 0) {
                return null;  // TODO
            }
            topValue = stack.nextElement();
        }
        return topValue;
    }

    private Value feedValue() throws IOException {
            Value v = source.poll();
            if(v.isArray()) {
                stack.pushArray(v.arrayValue().get());
            } else if(v.isMap()) {
                stack.pushMap(v.mapValue().get());
            } else {
                topValue = v;
                return v;
            }
    }

    // TODO
    */
}

