package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x4A)
@OpCode(code = 0x46, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x56, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x4E, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x5E, mode = AddressingMode.ABSOLUTE_X)
public class LogicalShiftRight extends Instruction {
    public LogicalShiftRight(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "LSR";
    }
}
