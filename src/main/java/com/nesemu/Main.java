

package com.nesemu;

import com.nesemu.exception.WrongFormatException;
import com.nesemu.loader.iNesLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by igor on 15/09/16.
 */
public class Main {
    public static void main(String[] args) throws IOException, WrongFormatException {
        iNesLoader loader = new iNesLoader("/Users/igor/Downloads/nestest.nes");
        loader.readFile();
    }
}
