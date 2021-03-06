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

public class FalseValue extends AbstractBooleanValue {
    private FalseValue() { }

    private static FalseValue instance = new FalseValue();

    static FalseValue getInstance() {
        return instance;
    }

    public boolean getBoolean() {
        return false;
    }

    public BooleanValue asBooleanValue() {
        return this;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof BooleanValue)) {
            return false;
        }

        return ((BooleanValue) o).getBoolean() == false;
    }

    public int hashCode() {
        return 1237;
    }
}

