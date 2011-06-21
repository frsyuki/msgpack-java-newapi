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

import org.msgpack.value.Value;
import org.msgpack.value.ValueFactory;

public class Unconverter extends Packer {
    /* TODO
    private List<Value> result;

    public Unconverter() {
        // TODO
    }

    private int top;
    private byte[] types;
    private int[] counts;
    private Value[][] objects;

    private void put(Value v) throws IOException {
        Value complete = stack.put(v);
        if(complete != null) {
            result.add(complete);
        }
    }

    public Value[] getResult() {
        return result.toArray(new Value[result.size()]);
    }

    public void writeNil() throws IOException {
        put(ValueFactory.nilValue());
    }

    // TODO
    */
}

