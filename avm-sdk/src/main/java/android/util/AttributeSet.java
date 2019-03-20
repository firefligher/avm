package android.util;

public interface AttributeSet {
    boolean getAttributeBooleanValue(String namespace, String attribute, boolean defaultValue);

    boolean getAttributeBooleanValue(int index, boolean defaultValue);

    int getAttributeCount();

    float getAttributeFloatValue(int index, float defaultValue);

    float getAttributeFloatValue(String namespace, String attribute, float defaultValue);

    int getAttributeIntValue(String namespace, String attribute, int defaultValue);

    int getAttributeIntValue(int index, int defaultValue);

    int getAttributeListValue(int index, String[] options, int defaultValue);

    int getAttributeListValue(String namespace, String attribute, String[] options, int defaultValue);

    String getAttributeName(int index);

    int getAttributeNameResource(int index);

    String getAttributeNamespace(int index);

    int getAttributeResourceValue(String namespace, String attribute, int defaultValue);

    int getAttributeResourceValue(int index, int defaultValue);

    int getAttributeUnsignedValue(String namespace, String attribute, int defaultValue);

    int getAttributeUnsignedIntValue(int index, int defaultValue);

    String getAttributeValue(int index);

    String getAttributeValue(String namespace, String name);

    String getClassAttribute();

    String getIdAttribute();

    int getIdAttributeResourceValue(int defaultValue);

    String getPositionDescription();

    int getStyleAttribute();
}
