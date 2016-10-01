package com.nesemu.cpu.instructions.flag;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xB8)
public class ClearOverflow extends Instruction {
    public ClearOverflow(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setOverflowFlag(false);
    }

    @Override
    public String getMnemonic() {
        return "CLV";
    }
}
