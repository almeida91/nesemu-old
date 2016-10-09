package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xE9, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xE5, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xF5, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0xE1, mode = AddressingMode.INDIRECT_X)
@OpCode(code = 0xF1, mode = AddressingMode.INDIRECT_Y)
@OpCode(code = 0xED, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0xFD, mode = AddressingMode.ABSOLUTE_X)
@OpCode(code = 0xF9, mode = AddressingMode.ABSOLUTE_Y)
public class Subtract extends Instruction {
    public Subtract(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value = getCpu().getA() - getCpu().readMemory(address);
        value -= getCpu().isCarryFlag() ? 1 : 0;

        getCpu().setA(value);

        setFlags(value);
    }

    @Override
    public String getMnemonic() {
        return "SBC";
    }
}
