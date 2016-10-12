package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xBA)
public class TransferSX extends Instruction {
    public TransferSX(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setX(getCpu().getSP());
        setFlags(getCpu().getX(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "TSX";
    }
}
