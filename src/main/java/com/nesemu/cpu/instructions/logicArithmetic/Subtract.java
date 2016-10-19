package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xE9, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xE5, mode = AddressingMode.ZERO_PAGE, cycles = 3)
@OpCode(code = 0xF5, mode = AddressingMode.ZERO_PAGE_X, cycles = 4)
@OpCode(code = 0xE1, mode = AddressingMode.INDIRECT_X, cycles = 6)
@OpCode(code = 0xF1, mode = AddressingMode.INDIRECT_Y, cycles = 5, crossBoundaryPenalty = true)
@OpCode(code = 0xED, mode = AddressingMode.ABSOLUTE, cycles = 4)
@OpCode(code = 0xFD, mode = AddressingMode.ABSOLUTE_X, cycles = 4, crossBoundaryPenalty = true)
@OpCode(code = 0xF9, mode = AddressingMode.ABSOLUTE_Y, cycles = 4, crossBoundaryPenalty = true)
public class Subtract extends Instruction {
    public Subtract(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value = getCpu().getA() - getCpu().readMemory(address);
        value -= (getCpu().isCarryFlag() ? 0 : 1);

        getCpu().setA(value);

        setFlags(value);
        getCpu().setCarryFlag(!getCpu().isCarryFlag());
    }

    @Override
    public String getMnemonic() {
        return "SBC";
    }
}
