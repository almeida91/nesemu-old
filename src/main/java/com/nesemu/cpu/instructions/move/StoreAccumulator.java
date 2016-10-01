package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x85, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x95, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x8D, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x9D, mode = AddressingMode.ABSOLUTE_X)
@OpCode(code = 0x99, mode = AddressingMode.ABSOLUTE_Y)
@OpCode(code = 0x81, mode = AddressingMode.INDIRECT_X)
@OpCode(code = 0x91, mode = AddressingMode.INDIRECT_Y)
public class StoreAccumulator extends Instruction {
    public StoreAccumulator(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "STA";
    }
}
