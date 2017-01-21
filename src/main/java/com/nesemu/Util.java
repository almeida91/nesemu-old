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
        return getUnsigned16BitInteger(value, (byte) 0);
    }

    public static int getUnsigned16BitInteger(byte low, byte high) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0, 0, high, low}); // BIG ENDIAN!
        return buffer.getInt();
    }
}
