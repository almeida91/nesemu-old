package com.nesemu.cpu;

import java.util.Arrays;

/**
 * Created by igor on 15/09/16.
 */
public class RAM {
    private final byte[] ram;

    public RAM() {
        ram = new byte[2048];
        Arrays.fill(ram, Byte.valueOf("255"));
    }
}
