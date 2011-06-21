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

public final class ValueFactory {
    public static NilValue nilValue() {
        return NilValue.getInstance();
    }

    public static BooleanValue booleanValue(boolean v) {
        if(v) {
            return TrueValue.getInstance();
        } else {
            return FalseValue.getInstance();
        }
    }

    public static IntegerValue integerValue(byte v) {
        return null;  // TODO
    }

    public static IntegerValue integerValue(short v) {
        return null;  // TODO
    }

    public static IntegerValue integerValue(int v) {
        return null;  // TODO
    }

    public static IntegerValue integerValue(long v) {
        return null;  // TODO
    }

    public static IntegerValue integerValue(BigInteger v) {
        return null;  // TODO
    }

    public static FloatValue floatValue(float v) {
        return null;  // TODO
    }

    public static FloatValue floatValue(double v) {
        return null;  // TODO
    }

    public static RawValue rawValue(byte[] b) {
        return null;  // TODO
    }

    public static RawValue rawValue(byte[] b, int off, int len) {
        return null;  // TODO
    }

    public static ArrayValue arrayValue(Value[] array) {
    }

    public static MapValue mapValue(Value[] kvs) {
    }

    public static Value get(Object obj) {
        return null;  // TODO new Unconverter().pack(obj).get()[0];
    }

    private ValueFactory() { }
}

