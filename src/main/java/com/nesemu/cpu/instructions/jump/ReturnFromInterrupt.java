package com.nesemu.cpu.instructions.jump;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x40, cycles = 6)
public class ReturnFromInterrupt extends Instruction {
    public ReturnFromInterrupt(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setP(getCpu().pull());
        getCpu().setPC(getCpu().pull16bits());
    }

    @Override
    public String getMnemonic() {
        return "RTI";
    }

}
