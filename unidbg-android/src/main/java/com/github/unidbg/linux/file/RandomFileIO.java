package com.github.unidbg.linux.file;

import com.github.unidbg.Emulator;
import com.github.unidbg.arm.backend.Backend;
import com.github.unidbg.file.linux.IOConstants;
import com.github.unidbg.file.linux.StatStructure;
import com.sun.jna.Pointer;

public class RandomFileIO extends DriverFileIO {

    RandomFileIO(Emulator<?> emulator, String path) {
        super(emulator, IOConstants.O_RDONLY, path);
    }

    @Override
    public int read(Backend backend, Pointer buffer, int count) {
        byte[] data = new byte[count];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        buffer.write(0, data, 0, data.length);
        return data.length;
    }

    @Override
    public int fstat(Emulator<?> emulator, StatStructure stat) {
        return 0;
    }
}
