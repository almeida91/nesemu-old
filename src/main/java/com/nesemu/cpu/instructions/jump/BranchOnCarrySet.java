package com.nesemu.cpu.instructions.jump;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xB0, mode = AddressingMode.RELATIVE, crossBoundaryPenalty = true)
public class BranchOnCarrySet extends Instruction {

    public BranchOnCarrySet(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        if (getCpu().isCarryFlag()) {
            getCpu().setPC(address);
        }
    }

    @Override
    public String getMnemonic() {
        return "BCS";
    }
}
