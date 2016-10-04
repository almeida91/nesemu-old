package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xE0, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xE4, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xEC, mode = AddressingMode.ABSOLUTE)
public class CompareX extends Instruction implements CompareMixin {
    public CompareX(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        compare(getCpu().getX(), getCpu().readMemory(address));
    }

    @Override
    public String getMnemonic() {
        return "CPX";
    }
}
