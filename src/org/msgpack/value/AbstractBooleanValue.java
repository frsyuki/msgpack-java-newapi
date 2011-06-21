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

public abstract class AbstractBooleanValue implements BooleanValue {
    public ValueType getType() {
        return ValueType.BOOLEAN;
    }

    public isBoolean() {
        return true;
    }

    public abstract boolean getBoolean();

    public boolean isTrue() {
        return getBoolean();
    }

    public boolean isFalse() {
        return !getBoolean();
    }

    public String toString() {
        if(getBoolean()) {
            return "true";
        } else {
            return "false";
        }
    }

    // TODO hashCode
    // TODO equals
}

