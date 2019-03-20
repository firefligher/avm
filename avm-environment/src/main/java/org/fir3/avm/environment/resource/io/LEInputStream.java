package org.fir3.avm.environment.resource.io;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class LEInputStream extends BaseInputStream<DataInputStream> {
    private final ByteBuffer swapBuffer;

    public LEInputStream(InputStream src) {
        super(new DataInputStream(src));

        this.swapBuffer = ByteBuffer.allocate(4);
        this.swapBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public short readUint8() throws IOException {
        int val = this.read();

        // Check, if the end of the stream has been reached

        if (val == -1) {
            throw new EOFException();
        }

        return (short) val;
    }

    public int readUint16() throws IOException {
        return this.readBuffer(2).getShort() & 0xFFFF;
    }

    public long readUint32() throws IOException {
        return this.readBuffer(4).getInt() & 0xFFFFFFFFL;
    }

    private ByteBuffer readBuffer(int numBytes) throws IOException {
        // Read the specified number of bytes from the source stream

        byte[] bytes = new byte[numBytes];
        this.source.readFully(bytes);

        // Reset the swapBuffer, insert the specified number of bytes and flip the buffer to make the inserted data
        // available for read operations.

        this.swapBuffer.clear();
        this.swapBuffer.put(bytes);
        this.swapBuffer.flip();

        return this.swapBuffer;
    }
}
