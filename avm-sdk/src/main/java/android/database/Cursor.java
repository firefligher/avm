package android.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

import java.io.Closeable;
import java.util.List;

public interface Cursor extends Closeable {
    int FIELD_TYPE_NULL     = 0x00000000;
    int FIELD_TYPE_INTEGER  = 0x00000001;
    int FIELD_TYPE_FLOAT    = 0x00000002;
    int FIELD_TYPE_STRING   = 0x00000003;
    int FIELD_TYPE_BLOB     = 0x00000004;

    void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer);

    void deactivate();

    byte[] getBlob(int columnIndex);

    int getColumnCount();

    int getColumnIndex(String columnName);

    int getColumnIndexOrThrow(String columnName);

    String getColumnName(int columnIndex);

    String[] getColumnNames();

    int getCount();

    double getDouble(int columnIndex);

    Bundle getExtras();

    float getFloat(int columnIndex);

    int getInt(int columnIndex);

    long getLong(int columnIndex);

    Uri getNotificationUri();

    int getPosition();

    short getShort(int columnIndex);

    String getString(int columnIndex);

    int getType(int columnIndex);

    boolean getWantsAllOnMoveCalls();

    boolean isAfterLast();

    boolean isBeforeFirst();

    boolean isClosed();

    boolean isFirst();

    boolean isLast();

    boolean isNull(int columnIndex);

    boolean move(int offset);

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveToNext();

    boolean moveToPosition(int position);

    boolean moveToPrevious();

    void registerContentObserver(ContentObserver observer);

    void registerDataSetObserver(DataSetObserver observer);

    boolean requery();

    Bundle respond(Bundle extras);

    void setExtras(Bundle extras);

    void setNotificationUri(ContentResolver cr, Uri uri);

    void setNotificationUris(ContentResolver cr, List<Uri> uris);

    void unregisterContentObserver(ContentObserver observer);

    void unregisterDataSetObserver(DataSetObserver observer);
}
