package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xC9, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xC5, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xD5, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0xC1, mode = AddressingMode.INDIRECT_X)
@OpCode(code = 0xD1, mode = AddressingMode.INDIRECT_Y)
@OpCode(code = 0xCD, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0xDD, mode = AddressingMode.ABSOLUTE_X)
@OpCode(code = 0xD9, mode = AddressingMode.ABSOLUTE_Y)
public class Compare extends Instruction {
    public Compare(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "CMP";
    }
}
