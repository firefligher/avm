package android.database.sqlite;

import android.database.Cursor;

public final class SQLiteDatabase extends SQLiteClosable {
    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query);
    }
}
