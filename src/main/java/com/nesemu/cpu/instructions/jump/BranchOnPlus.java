package com.nesemu.cpu.instructions.jump;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x10, mode = AddressingMode.RELATIVE)
public class BranchOnPlus extends Instruction {
    public BranchOnPlus(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        if (!getCpu().isNegativeFlag()) {
            getCpu().setPC(address);
        }
    }

    @Override
    public String getMnemonic() {
        return "BPL";
    }
}
