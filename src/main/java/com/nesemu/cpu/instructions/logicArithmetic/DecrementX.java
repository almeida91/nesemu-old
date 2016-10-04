package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xCA)
public class DecrementX extends Instruction {
    public DecrementX(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setX(getCpu().getX() - 1);
        setFlags(getCpu().getX(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "DEX";
    }
}
