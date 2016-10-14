package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xC6, mode = AddressingMode.ZERO_PAGE, cycles = 5)
@OpCode(code = 0xD6, mode = AddressingMode.ZERO_PAGE_X, cycles = 6)
@OpCode(code = 0xCE, mode = AddressingMode.ABSOLUTE, cycles = 3)
@OpCode(code = 0xDE, mode = AddressingMode.ABSOLUTE_X, cycles = 7)
public class Decrement extends Instruction {
    public Decrement(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value = getCpu().readMemory(address) - 1;
        getCpu().writeMemory(address, value);
        setFlags(value, true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "DEC";
    }

}
