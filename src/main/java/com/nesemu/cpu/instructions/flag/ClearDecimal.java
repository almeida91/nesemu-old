package com.nesemu.cpu.instructions.flag;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xD8)
public class ClearDecimal extends Instruction {
    public ClearDecimal(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setDecimalFlag(false);
    }

    @Override
    public String getMnemonic() {
        return "CLD";
    }
}
