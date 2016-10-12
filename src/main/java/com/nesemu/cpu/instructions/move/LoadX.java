package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xA2, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xA6, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xB6, mode = AddressingMode.ZERO_PAGE_Y)
@OpCode(code = 0xAE, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0xAE, mode = AddressingMode.ABSOLUTE_Y)
public class LoadX extends Instruction {
    public LoadX(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setX(getCpu().readMemory(address));
        setFlags(getCpu().getX());
    }

    @Override
    public String getMnemonic() {
        return "LDX";
    }
}
