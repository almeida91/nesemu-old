package com.nesemu.cpu.instructions.flag;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x78)
public class SetInterruput extends Instruction {
    public SetInterruput(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setInterruptFlag(true);
    }

    @Override
    public String getMnemonic() {
        return "SEI";
    }
}
