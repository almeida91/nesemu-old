package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x86, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x96, mode = AddressingMode.ZERO_PAGE_Y)
@OpCode(code = 0x8E, mode = AddressingMode.ABSOLUTE)
public class StoreX extends Instruction {
    public StoreX(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().writeMemory(address, getCpu().getX());
    }

    @Override
    public String getMnemonic() {
        return "STX";
    }

}
