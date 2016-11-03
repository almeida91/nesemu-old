package com.nesemu.ppu;

import com.nesemu.cpu.CPU;

/**
 * Created by igor on 30/10/16.
 */
public class PPU {
    private int ppuctrl;
    private int ppumask;
    private int ppustatus;
    private int oamaddr;
    private int oamdata;
    private int ppuscroll;
    private int ppuaddr;
    private int ppudata;
    private int oamdma;

    private CPU cpu;

    public int readMemory(int address) {
        switch (address & 0x2007) {
            case 0x2002:
                return getPpustatus();
            case 0x2004:
                return getOamdata();
            case 0x2007:
                return getPpudata();
        }

        // TODO: exception?
        return 0;
    }

    public void writeMemory(int address, int value) {
        if (address == 0x4014) {
            setOamdma(value);
            return;
        }

        switch (address & 0x2007) {
            case 0x2000:
                setPpuctrl(value);
                break;
            case 0x2001:
                setPpumask(value);
                break;
            case 0x2003:
                setOamaddr(value);
                break;
            case 0x2004:
                setOamdata(value);
                break;
            case 0x2005:
                setPpuscroll(value);
                break;
            case 0x2006:
                setPpuaddr(value);
                break;
            case 0x2007:
                setPpudata(value);
                break;
        }
    }

    private void setPpuctrl(int ppuctrl) {
        this.ppuctrl = ppuctrl;
    }

    private void setPpumask(int ppumask) {
        this.ppumask = ppumask;
    }

    private void setOamaddr(int oamaddr) {
        this.oamaddr = oamaddr;
    }

    private void setPpuscroll(int ppuscroll) {
        this.ppuscroll = ppuscroll;
    }

    private void setOamdma(int oamdma) {
        this.oamdma = oamdma;
    }

    private int getPpustatus() {
        return ppustatus;
    }

    public void setPpuaddr(int ppuaddr) {
        this.ppuaddr = ppuaddr;
    }

    private int getOamdata() {
        return oamdata;
    }

    private void setOamdata(int oamdata) {
        this.oamdata = oamdata;
    }

    private int getPpudata() {
        return ppudata;
    }

    private void setPpudata(int ppudata) {
        this.ppudata = ppudata;
    }
}
