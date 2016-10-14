package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xC9, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xC5, mode = AddressingMode.ZERO_PAGE, cycles = 3)
@OpCode(code = 0xD5, mode = AddressingMode.ZERO_PAGE_X, cycles = 4)
@OpCode(code = 0xC1, mode = AddressingMode.INDIRECT_X, cycles = 6)
@OpCode(code = 0xD1, mode = AddressingMode.INDIRECT_Y, cycles = 5, crossBoundaryPenalty = true)
@OpCode(code = 0xCD, mode = AddressingMode.ABSOLUTE, cycles = 4)
@OpCode(code = 0xDD, mode = AddressingMode.ABSOLUTE_X, cycles = 4, crossBoundaryPenalty = true)
@OpCode(code = 0xD9, mode = AddressingMode.ABSOLUTE_Y, cycles = 4, crossBoundaryPenalty = true)
public class Compare extends Instruction implements CompareMixin {
    public Compare(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        compare(getCpu().getA(), getCpu().readMemory(address));
    }

    @Override
    public String getMnemonic() {
        return "CMP";
    }
}
