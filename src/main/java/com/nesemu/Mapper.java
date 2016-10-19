package com.nesemu;

/**
 * Created by igor on 24/09/16.
 */
public abstract class Mapper {
    public abstract void write(int address, int value);

    public abstract int read(int address);
}
