package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xA9, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xA5, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xB5, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0xAD, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0xBD, mode = AddressingMode.ABSOLUTE_X)
@OpCode(code = 0xB9, mode = AddressingMode.ABSOLUTE_Y)
@OpCode(code = 0xA1, mode = AddressingMode.INDIRECT_X)
@OpCode(code = 0xB1, mode = AddressingMode.INDIRECT_Y)
public class LoadAccumulator extends Instruction {
    public LoadAccumulator(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "LDA";
    }
}
