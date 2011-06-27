package org.msgpack;

import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;

public abstract class API {
    public API() {
        // TODO
    }

    public API(API copy) {
        // TODO
    }

    public abstract byte[] pack(Object o);

    public abstract void pack(OutputStream out, Object o);

    public void pack(Packer p, Object o) {
        // TODO
    }

    public abstract <T> T unpack(InputStream in, T v);

    public abstract <T> T unpack(InputStream in, Class<T> c);

    public abstract <T> T unpack(byte[] b, T v);

    public abstract <T> T unpack(byte[] b, Class<T> c);

    public abstract <T> T unpack(ByteBuffer b, T v);

    public abstract <T> T unpack(ByteBuffer b, Class<T> c);

    public <T> T unpack(Unpacker u, T v) {
        // TODO
        return null;
    }

    public <T> T unpack(Unpacker u, Class<T> c) {
        // TODO
        return null;
    }

    public void register(Class<?> c) {
        // TODO
    }
}

