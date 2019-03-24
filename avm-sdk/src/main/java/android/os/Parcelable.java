package android.os;

public interface Parcelable {
    interface ClassLoaderCreator<T> extends Creator<T> {
        T createFromParcel(Parcel source, ClassLoader loader);
    }

    interface Creator<T> {
        T createFromParcel(Parcel source);
        T[] newArray(int size);
    }

    int CONTENTS_FILE_DESCRIPTOR = 0x00000001;
    int PARCELABLE_WRITE_RETURN_VALUE = 0x00000001;

    int describeContents();
    void writeToParcel(Parcel dest, int flags);
}
