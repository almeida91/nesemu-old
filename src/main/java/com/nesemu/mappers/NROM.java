package com.nesemu.mappers;

import com.nesemu.Mapper;
import com.nesemu.MapperCode;

/**
 * Created by igor on 15/11/16.
 */
@MapperCode(code = 0)
public class NROM extends Mapper {
    private byte[] rom;
    private byte[] ram;

    @Override
    public void write(int address, int value) {

    }

    @Override
    public int read(int address) {
        if (address >= 0xC000)
            return rom[address - 0xC000];
        if (address >= 0x8000)
            return rom[address - 0x8000];
        if (address >= 0x6000)
            return ram[address & 0x1FFF];

        return 0;
    }
}
