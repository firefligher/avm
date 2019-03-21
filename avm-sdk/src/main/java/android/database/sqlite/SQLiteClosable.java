package android.database.sqlite;

import lombok.extern.java.Log;

import java.io.Closeable;

@Log
public abstract class SQLiteClosable implements Closeable {
    @Override
    public void close() {
        log.warning("Unimplemented method: android.database.sqlite.SQLiteCloseable.close()");
    }
}
