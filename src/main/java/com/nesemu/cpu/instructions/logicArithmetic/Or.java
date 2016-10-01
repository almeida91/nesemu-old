package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x09, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0x05, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x15, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x01, mode = AddressingMode.INDIRECT_X)
@OpCode(code = 0x11, mode = AddressingMode.INDIRECT_Y)
@OpCode(code = 0x0D, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x1D, mode = AddressingMode.ABSOLUTE_X)
@OpCode(code = 0x19, mode = AddressingMode.ABSOLUTE_Y)
public class Or extends Instruction {
    public Or(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setA(getCpu().getA() | getCpu().readMemory(address));

        // TODO: ora bit flags
    }

    @Override
    public String getMnemonic() {
        return "ORA";
    }
}
