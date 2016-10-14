package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x29, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0x25, mode = AddressingMode.ZERO_PAGE, cycles = 3)
@OpCode(code = 0x35, mode = AddressingMode.ZERO_PAGE_X, cycles = 4)
@OpCode(code = 0x21, mode = AddressingMode.INDIRECT_X, cycles = 6)
@OpCode(code = 0x31, mode = AddressingMode.INDIRECT_Y, cycles = 5, crossBoundaryPenalty = true)
@OpCode(code = 0x2D, mode = AddressingMode.ABSOLUTE, cycles = 4)
@OpCode(code = 0x3D, mode = AddressingMode.ABSOLUTE_X, cycles = 4, crossBoundaryPenalty = true)
@OpCode(code = 0x39, mode = AddressingMode.ABSOLUTE_Y, cycles = 4, crossBoundaryPenalty = true)
public class And extends Instruction {
    public And(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value = getCpu().getA() & getCpu().readMemory(address);
        getCpu().setA(value);
        setFlags(value, true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "AND";
    }
}
