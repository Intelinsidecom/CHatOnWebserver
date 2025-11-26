package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class ProtoBufFieldInfo {
    private Class<?> cls;
    private String fieldName;
    private int fieldNumber;
    private Class<?> listCls;
    private boolean required;

    public ProtoBufFieldInfo(String fieldName, int fieldNumber, boolean required, Class<?> cls) {
        this.fieldName = null;
        this.fieldNumber = -1;
        this.required = false;
        this.cls = null;
        this.listCls = null;
        this.fieldName = fieldName;
        this.fieldNumber = fieldNumber;
        this.required = required;
        this.cls = cls;
    }

    public ProtoBufFieldInfo(String fieldName, int fieldNumber, boolean required, Class<?> cls, Class<?> listCls) {
        this.fieldName = null;
        this.fieldNumber = -1;
        this.required = false;
        this.cls = null;
        this.listCls = null;
        this.fieldName = fieldName;
        this.fieldNumber = fieldNumber;
        this.required = required;
        this.cls = cls;
        this.listCls = listCls;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getFieldNumber() {
        return this.fieldNumber;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Class<?> getCls() {
        return this.cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public Class<?> getListCls() {
        return this.listCls;
    }

    public void setListCls(Class<?> listCls) {
        this.listCls = listCls;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("fieldName:").append(this.fieldName);
        stringBuffer.append(", fieldNumber:").append(this.fieldNumber);
        stringBuffer.append(", required:").append(this.required);
        stringBuffer.append(", cls:").append(this.cls);
        stringBuffer.append(", listCls:").append(this.listCls);
        return stringBuffer.toString();
    }
}
