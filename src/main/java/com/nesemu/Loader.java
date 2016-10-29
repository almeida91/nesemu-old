package com.nesemu;

import com.nesemu.exceptions.WrongFormatException;

import java.io.IOException;

/**
 * Created by igor on 18/10/16.
 */
public abstract class Loader {
    public abstract void readFile() throws IOException, WrongFormatException;
}
