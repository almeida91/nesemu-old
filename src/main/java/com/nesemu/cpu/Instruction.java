package com.nesemu.cpu;

/**
 * Created by igor on 22/09/16.
 */
public abstract class Instruction {
    private CPU cpu;

    public Instruction(CPU cpu) {
        this.cpu = cpu;
    }

    public abstract void run(int opcode, int address);

    public abstract String getMnemonic();

    public CPU getCpu() {
        return cpu;
    }

    protected void setFlags(int value, boolean negative, boolean zero, boolean carry, boolean overflow) {
        if (carry) {
            getCpu().setCarryFlag((value & 0x100) != 0);
        }

        // TODO: considerar se o valor vai vir com um uint ou um byte
        if (negative) {
            getCpu().setNegativeFlag((value & 0x80) != 0);
        }

        if (zero) {
            getCpu().setZeroFlag(value == 0);
        }

        if (overflow) {
            getCpu().setOverflowFlag((((getCpu().getA() ^ value) & 0x80) == 0) && (((getCpu().getA() ^ value) & 0x80) != 0));
        }
    }

    protected void setFlags(int value) {
        setFlags(value, true, true, true, true);
    }
}
