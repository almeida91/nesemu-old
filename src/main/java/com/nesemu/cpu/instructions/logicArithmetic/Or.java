package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x09, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0x05, mode = AddressingMode.ZERO_PAGE, cycles = 3)
@OpCode(code = 0x15, mode = AddressingMode.ZERO_PAGE_X, cycles = 4)
@OpCode(code = 0x01, mode = AddressingMode.INDIRECT_X, cycles = 6)
@OpCode(code = 0x11, mode = AddressingMode.INDIRECT_Y, cycles = 5, crossBoundaryPenalty = true)
@OpCode(code = 0x0D, mode = AddressingMode.ABSOLUTE, cycles = 4)
@OpCode(code = 0x1D, mode = AddressingMode.ABSOLUTE_X, cycles = 4, crossBoundaryPenalty = true)
@OpCode(code = 0x19, mode = AddressingMode.ABSOLUTE_Y, cycles = 4, crossBoundaryPenalty = true)
public class Or extends Instruction {
    public Or(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setA(getCpu().getA() | getCpu().readMemory(address));
        setFlags(getCpu().getA(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "ORA";
    }
}
