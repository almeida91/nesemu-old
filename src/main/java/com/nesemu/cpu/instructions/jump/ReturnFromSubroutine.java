package com.nesemu.cpu.instructions.jump;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x60, cycles = 6)
public class ReturnFromSubroutine extends Instruction {
    public ReturnFromSubroutine(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setPC(getCpu().pull16bits() + 1);
    }

    @Override
    public String getMnemonic() {
        return "RTS";
    }

}
