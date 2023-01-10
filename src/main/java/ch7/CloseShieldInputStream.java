package ch7;

import java.io.IOException;
import java.io.InputStream;

public class CloseShieldInputStream extends InputStream {

    private InputStream wrappedInputStream;

    public CloseShieldInputStream(InputStream wrappedInputStream) {
        this.wrappedInputStream = wrappedInputStream;
    }

    @Override
    public int read() throws IOException {
        return wrappedInputStream.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return wrappedInputStream.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return wrappedInputStream.read(b, off, len);
    }

    @Override
    public void close() throws IOException {
    }
}
