package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x84, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x94, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x8C, mode = AddressingMode.ABSOLUTE)
public class StoreY extends Instruction {
    public StoreY(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {

    }

    @Override
    public String getMnemonic() {
        return "STY";
    }
}