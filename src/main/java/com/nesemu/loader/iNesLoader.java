package com.nesemu.loader;

import com.nesemu.exception.WrongFormatException;
import com.nesemu.mapper.MirrorType;
import com.nesemu.ppu.TvSystem;

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

    private boolean batteryRam = false;
    private boolean trainer = false;
    private boolean nes2 = false;

    private int mapperNumber = 0;

    private MirrorType mirrorType;
    private TvSystem tvSystem;

    public iNesLoader(String filename) throws FileNotFoundException {
        inputStream = new BufferedInputStream(new FileInputStream(filename));
    }

    public void readFile() throws IOException, WrongFormatException {
        readHeader();

        if (trainer) {
            byte[] trainer = new byte[512];
            inputStream.read(trainer);
            // TODO: faz alguma coisa com ele
        }

        inputStream.read(rom);

        if (chrRom.length > 0)
            inputStream.read(chrRom);

        // TODO: INST-ROM
        // TODO: PROM
    }

    private void readHeader() throws IOException, WrongFormatException {
        byte[] header = new byte[16];

        inputStream.read(header);

        if (!new String(Arrays.copyOfRange(header, 0, 3)).equals("NES")) {
            throw new WrongFormatException();
        }

        rom = new byte[16384 * Byte.toUnsignedInt(header[4])];   // em blocos de 16kb
        chrRom = new byte[8192 * Byte.toUnsignedInt(header[5])]; // blocos de 8kb

        int prgRamSize = 8192 * Byte.toUnsignedInt(header[8]);

        if (prgRamSize == 0)
            prgRamSize = 8192;

        prgRam = new byte[prgRamSize];

        parseFlags6(Byte.toUnsignedInt(header[4]));
        parseFlags7(Byte.toUnsignedInt(header[7]));
        parseFlags9(Byte.toUnsignedInt(header[9]));
    }

    private void parseFlags9(int flags) {
        if ((flags & 1) == 1) {
            tvSystem = TvSystem.NTSC;
        }
        else {
            tvSystem = TvSystem.PAL;
        }
    }

    private void parseFlags7(int flags) {
        // VS Unisystem e PlayChoice-10 não estão inclusas
        nes2 = (flags & 0b1100) >> 2 == 2;
        mapperNumber ^= 0xf0 & flags;
    }

    private void parseFlags6(int flags) {
        int mirroing = flags & 0b1001;

        if (mirroing == 0)
            mirrorType = MirrorType.VERTICAL;
        else if (mirroing == 1)
            mirrorType = MirrorType.HORIZONTAL;
        else if (mirroing >= 0b1000)
            mirrorType = MirrorType.FOUR_SCREEN;

        batteryRam = (flags & 0b10) != 0;
        trainer = (flags & 0b100) != 0;

        mapperNumber ^= flags >> 4;
    }
}
