package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x88)
public class DecrementY extends Instruction {
    public DecrementY(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setY(getCpu().getY() - 1);
        setFlags(getCpu().getY(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "DEY";
    }
}
