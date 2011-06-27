package org.msgpack;

import org.msgpack.packer.Packer;
import org.msgpack.unpacker.Unpacker;

public class MessagePack extends API {
    // TODO

    private MessagePack() { }

    public abstract byte[] pack(Object o) {
        // TODO
        return null;
    }

    public abstract void pack(OutputStream out, Object o) {
        // TODO
        return null;
    }

    public abstract <T> T unpack(InputStream in, T v) {
        // TODO
        return null;
    }

    public abstract <T> T unpack(InputStream in, Class<T> c) {
        // TODO
        return null;
    }

    public abstract <T> T unpack(byte[] b, T v) {
        // TODO
        return null;
    }

    public abstract <T> T unpack(byte[] b, Class<T> c) {
        // TODO
        return null;
    }

    public abstract <T> T unpack(ByteBuffer b, T v) {
        // TODO
        return null;
    }

    public abstract <T> T unpack(ByteBuffer b, Class<T> c) {
        // TODO
        return null;
    }
}

