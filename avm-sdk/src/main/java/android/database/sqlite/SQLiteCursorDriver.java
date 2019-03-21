package android.database.sqlite;

import android.database.Cursor;

public interface SQLiteCursorDriver {
    void cursorClosed();

    void cursorDeactivated();

    void cursorRequeried(Cursor cursor);

    Cursor query(SQLiteDatabase.CursorFactory factory, String[] bindArgs);

    void setBindArguments(String[] bindArgs);
}
