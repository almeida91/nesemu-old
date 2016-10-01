package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xA0, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xA4, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xB4, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0xAC, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0xBC, mode = AddressingMode.ABSOLUTE_X)
public class LoadY extends Instruction {
    public LoadY(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "LDY";
    }
}
