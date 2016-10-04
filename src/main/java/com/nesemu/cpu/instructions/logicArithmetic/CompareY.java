package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xC0, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xC4, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0xCC, mode = AddressingMode.ABSOLUTE)
public class CompareY extends Instruction implements CompareMixin {
    public CompareY(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        compare(getCpu().getY(), getCpu().readMemory(address));
    }

    @Override
    public String getMnemonic() {
        return "CPY";
    }
}
