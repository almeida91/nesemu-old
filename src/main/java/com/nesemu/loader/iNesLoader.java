package com.nesemu.loader;

import com.nesemu.exception.WrongFormatException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by igor on 16/09/16.
 */
public class iNesLoader {
    private BufferedInputStream inputStream;

    private byte[] rom;
    private byte[] chrRom;
    private byte[] prgRam;

    public iNesLoader(String filename) throws FileNotFoundException {
        inputStream = new BufferedInputStream(new FileInputStream(filename));
    }

    public void readHeader() throws IOException, WrongFormatException {
        byte[] header = new byte[16];

        inputStream.read(header);

        if (new String(Arrays.copyOfRange(header, 0, 3)).equals("NES")) {
            throw new WrongFormatException();
        }

        rom = new byte[16384 * Byte.toUnsignedInt(header[4])]; // em blocos de 16kb
        chrRom = new byte[8192 * Byte.toUnsignedInt(header[5])];
        prgRam = new byte[8192 * Byte.toUnsignedInt(header[8])];

        parseFlags6(Byte.toUnsignedInt(header[4]));
        parseFlags7(Byte.toUnsignedInt(header[7]));
        parseFlags9(Byte.toUnsignedInt(header[9]));
    }

    private void parseFlags9(int flags) {

    }

    private void parseFlags7(int flags) {

    }

    private void parseFlags6(int flags) {

    }
}
