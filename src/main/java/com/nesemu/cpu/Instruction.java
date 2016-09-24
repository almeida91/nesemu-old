package com.nesemu.cpu;

/**
 * Created by igor on 22/09/16.
 */
public abstract class Instruction {
    private CPU cpu;
    private RAM ram;

    public Instruction(CPU cpu) {
        this.cpu = cpu;
    }

    public abstract void run(int opcode, int address);

    public abstract String getMnemonic();

    public int getBaseCycles() {
        return 2;
    }
}
