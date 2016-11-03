package com.nesemu;

import java.nio.ByteBuffer;

/**
 * Created by igor on 11/10/16.
 */
public class Util {
    public static int getSignedByte(int value) {
        byte[] buffer = ByteBuffer.allocate(4).putInt(value).array();
        return buffer[3]; // BIG ENDIAN!
    }

    public static int getUnsignedByte(byte value) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0, 0, 0, value}); // BIG ENDIAN!
        return buffer.getInt();
    }
}
