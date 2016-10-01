package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x6A)
@OpCode(code = 0x66, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x76, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x6E, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x7E, mode = AddressingMode.ABSOLUTE_X)
public class RotateRight extends Instruction {
    public RotateRight(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "ROR";
    }
}
