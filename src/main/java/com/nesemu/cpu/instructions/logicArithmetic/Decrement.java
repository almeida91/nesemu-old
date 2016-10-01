package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xC6, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xD6, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0xCE, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0xDE, mode = AddressingMode.ABSOLUTE_X)
public class Decrement extends Instruction {
    public Decrement(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "DEC";
    }
}
