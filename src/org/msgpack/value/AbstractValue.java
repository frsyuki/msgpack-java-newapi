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

import java.util.List;
import java.util.Map;
import java.util.ListIterator;
import java.math.BigInteger;
import org.msgpack.MessageCastException;

public abstract class AbstractValue implements Value {
    /* FIXME not needed
    public boolean isNil() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isInteger() {
        return false;
    }

    public boolean isFloat() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isMap() {
        return false;
    }

    public boolean isRaw() {
        return false;
    }


    public byte byteValue() {
        throw new MessageCastException();
    }

    public short shortValue() {
        throw new MessageCastException();
    }

    public int intValue() {
        throw new MessageCastException();
    }

    public long longValue() {
        throw new MessageCastException();
    }

    public BigInteger bigIntegerValue() {
        throw new MessageCastException();
    }

    public float floatValue() {
        throw new MessageCastException();
    }

    public double doubleValue() {
        throw new MessageCastException();
    }


    public boolean getBoolean() {
        throw new MessageCastException();
    }

    public byte getByte() {
        throw new MessageCastException();
    }

    public short getShort() {
        throw new MessageCastException();
    }

    public int getInt() {
        throw new MessageCastException();
    }

    public long getLong() {
        throw new MessageCastException();
    }

    public BigInteger getBigInteger() {
        throw new MessageCastException();
    }

    public float getFloat() {
        throw new MessageCastException();
    }

    public double getDouble() {
        throw new MessageCastException();
    }

    public byte[] getByteArray() {
        throw new MessageCastException();
    }

    public String getString() {
        throw new MessageCastException();
    }


    public int size() {
        throw new MessageCastException();
    }

    public boolean isEmpty() {
        throw new MessageCastException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }


    public boolean add(Value e) {
        throw new UnsupportedOperationException();
    }

    public boolean remvoe(Object e) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> c) {
        throw new MessageCastException();
    }

    public boolean addAll(Collection<? extends Value> c) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public Value get(int index) {
        throw new MessageCastException();
    }

    public Value set(int index, Value element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, Value element) {
        throw new UnsupportedOperationException();
    }

    public Value remove(int index) {
        throw new UnsupportedOperationException();
    }

    public int indexOf(Object o) {
        throw new MessageCastException();
    }

    public int lastIndexOf(Object o) {
        throw new MessageCastException();
    }

    public ListIterator<Value> listIterator() {
        throw new MessageCastException();
    }

    public ListIterator<E> listIterator(int index) {
        throw new MessageCastException();
    }

    public List<Value> subList(int fromIndex, int toIndex) {
        throw new MessageCastException();
    }


    public boolean containsKey(Object key) {
        throw new MessageCastException();
    }

    public boolean containsValue(Object value) {
        throw new MessageCastException();
    }

    public Value get(Object key) {
        throw new MessageCastException();
    }

    public Value put(Value key, Value value) {
        throw UnsupportedOperationException();
    }

    public Value remove(Object key) {
        throw UnsupportedOperationException();
    }

    public void putAll(Map<? extends Value, ? extends Value> m) {
        throw new UnsupportedOperationException();
    }

    public Set<Value> keySet() {
        throw new MessageCastException();
    }

    public Collection<Value> values() {
        throw new MessageCastException();
    }

    public Set<Map.Entry<Value,Value>> entrySet() {
        throw new MessageCastException();
    }
    */
}


