package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x49, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0x45, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x55, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x41, mode = AddressingMode.INDIRECT_X)
@OpCode(code = 0x51, mode = AddressingMode.INDIRECT_Y)
@OpCode(code = 0x4D, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x5D, mode = AddressingMode.ABSOLUTE_X)
@OpCode(code = 0x59, mode = AddressingMode.ABSOLUTE_Y)
public class Xor extends Instruction {
    public Xor(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value = getCpu().getA() ^ getCpu().readMemory(address);
        getCpu().setA(value);
        setFlags(value, true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "EOR";
    }
}
