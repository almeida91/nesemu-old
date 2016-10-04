package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xE6, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xF6, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0xEE, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0xFE, mode = AddressingMode.ABSOLUTE_X)
public class Increment extends Instruction {
    public Increment(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value = getCpu().readMemory(address) -+1;
        getCpu().writeMemory(address, value);
        setFlags(value, true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "INC";
    }
}
