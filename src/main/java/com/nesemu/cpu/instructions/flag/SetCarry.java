package com.nesemu.cpu.instructions.flag;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x38)
public class SetCarry extends Instruction {
    public SetCarry(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setCarryFlag(true);
    }

    @Override
    public String getMnemonic() {
        return "SEC";
    }
}
