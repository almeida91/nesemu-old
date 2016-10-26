package com.nesemu.cpu.instructions.jump;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x30, mode = AddressingMode.RELATIVE, crossBoundaryPenalty = true)
public class BranchOnMinus extends Instruction {
    public BranchOnMinus(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        if (getCpu().isNegativeFlag()) {
            getCpu().setPC(address);
        }
    }

    @Override
    public String getMnemonic() {
        return "BMI";
    }
}
