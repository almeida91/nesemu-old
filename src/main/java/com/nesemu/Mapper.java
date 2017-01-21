package com.nesemu;

/**
 * Created by igor on 24/09/16.
 */
public abstract class Mapper {
    private byte[] rom;
    private byte[] chrRom;
    private byte[] prgRam;

    public abstract void write(int address, int value);

    public abstract int read(int address);
}
