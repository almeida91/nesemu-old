package com.nesemu.cpu.instructions.jump;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xF0, mode = AddressingMode.RELATIVE, crossBoundaryPenalty = true)
public class BranchOnEqual extends Instruction {
    public BranchOnEqual(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        if (getCpu().isZeroFlag()) {
            getCpu().setPC(address);
        }
    }

    @Override
    public String getMnemonic() {
        return "BEQ";
    }
}
