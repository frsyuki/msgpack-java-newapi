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

import java.io.InputStream;
import java.io.IOException;

public class StreamUnpacker extends AbstractMessagePackUnpacker {
    private InputStream stream;

    public StreamUnpacker(InputStream stream) {
        super();
        this.stream = stream;
    }

    @Override
    byte readHeadByte() throws IOException {
        return stream.readByte();
    }

    @Override
    boolean readRemain(byte[] b, int off, int len) throws IOException {
        // TODO
        return true;  // always true, otherwise IOException
    }
}

