package com.nesemu.cpu.instructions.jump;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x4C, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x6C, mode = AddressingMode.INDIRECT)
public class Jump extends Instruction {
    public Jump(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setPC(address);
    }

    @Override
    public String getMnemonic() {
        return "JMP";
    }
}
