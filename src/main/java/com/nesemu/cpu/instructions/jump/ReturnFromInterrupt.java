package com.nesemu.cpu.instructions.jump;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x40)
public class ReturnFromInterrupt extends Instruction {
    public ReturnFromInterrupt(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "RTI";
    }

    @Override
    public int getBaseCycles() {
        return 6;
    }
}
