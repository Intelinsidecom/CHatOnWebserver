package com.coolots.p2pmsg.parser;

import com.coolots.common.util.DateTimeUtil;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.pbmeta.ProtoBufFieldInfo;
import com.coolots.p2pmsg.pbmeta.ProtoBufMetaDef;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public final class ProtoBufHandler {
    private ProtoBufHandler() {
    }

    public static byte[] toByteArray(Object clsObj) throws ProtoBufHandlerException {
        byte[] result = new byte[getSerializedSize(clsObj)];
        CodedOutputStream output = CodedOutputStream.newInstance(result);
        writeStream(output, clsObj);
        output.checkNoSpaceLeft();
        return result;
    }

    public static void parseMsgHeader(byte[] btData, MsgHeader msgHeader) throws IllegalAccessException, InstantiationException, IllegalArgumentException, ProtoBufHandlerException {
        fromByteArray(btData, msgHeader);
    }

    public static void parseMsgBody(byte[] btData, MsgBody msgBody) throws IllegalAccessException, InstantiationException, IllegalArgumentException, ProtoBufHandlerException {
        fromByteArray(btData, msgBody);
    }

    public static void fromByteArray(byte[] btData, Object clsObj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, ProtoBufHandlerException {
        try {
            CodedInputStream input = CodedInputStream.newInstance(btData, 0, btData.length);
            parseStream(input, clsObj);
            input.checkLastTagWas(0);
        } catch (InvalidProtocolBufferException ex) {
            throw new ProtoBufHandlerException(ex);
        }
    }

    public static ByteString getStringBytes(String strVal) {
        return ByteString.copyFromUtf8(strVal);
    }

    public static int getSerializedSize(Object clsObj) throws IllegalAccessException, IllegalArgumentException, ProtoBufHandlerException {
        Class<?> cls = clsObj.getClass();
        int size = 0;
        Field[] clsFields = clsObj.getClass().getDeclaredFields();
        List<ProtoBufFieldInfo> fields = ProtoBufMetaDef.getInstance().getProtoBufFields(cls.getName());
        if (fields == null) {
            throw new ProtoBufHandlerException("Protocol buffer metadata undefined : " + cls.getName());
        }
        for (int fieldIdx = 0; fieldIdx < fields.size(); fieldIdx++) {
            try {
                ProtoBufFieldInfo protoBufFieldInfo = fields.get(fieldIdx);
                Field clsField = null;
                for (Field fd : clsFields) {
                    if (fd.getName().equals(protoBufFieldInfo.getFieldName())) {
                        clsField = fd;
                        clsField.setAccessible(true);
                    }
                }
                if (clsField == null) {
                    throw new ProtoBufHandlerException("Protocol buffer metadata attribute not found : " + protoBufFieldInfo.getFieldName() + " in " + cls.getName());
                }
                if (protoBufFieldInfo.getCls() == Integer.TYPE) {
                    int intVal = clsField.getInt(clsObj);
                    size += CodedOutputStream.computeInt32Size(protoBufFieldInfo.getFieldNumber(), intVal);
                } else if (protoBufFieldInfo.getCls() == Integer.class) {
                    Integer intClsVal = (Integer) clsField.get(clsObj);
                    if (intClsVal != null) {
                        size += CodedOutputStream.computeInt32Size(protoBufFieldInfo.getFieldNumber(), intClsVal.intValue());
                    }
                } else if (protoBufFieldInfo.getCls() == Short.TYPE) {
                    short shortVal = clsField.getShort(clsObj);
                    size += CodedOutputStream.computeInt32Size(protoBufFieldInfo.getFieldNumber(), shortVal);
                } else if (protoBufFieldInfo.getCls() == Short.class) {
                    Short shortClsVal = (Short) clsField.get(clsObj);
                    if (shortClsVal != null) {
                        size += CodedOutputStream.computeInt32Size(protoBufFieldInfo.getFieldNumber(), shortClsVal.shortValue());
                    }
                } else if (protoBufFieldInfo.getCls() == Float.TYPE) {
                    float floatVal = clsField.getFloat(clsObj);
                    size += CodedOutputStream.computeFloatSize(protoBufFieldInfo.getFieldNumber(), floatVal);
                } else if (protoBufFieldInfo.getCls() == Float.class) {
                    Float floatClsVal = (Float) clsField.get(clsObj);
                    if (floatClsVal != null) {
                        size += CodedOutputStream.computeFloatSize(protoBufFieldInfo.getFieldNumber(), floatClsVal.floatValue());
                    }
                } else if (protoBufFieldInfo.getCls() == Double.TYPE) {
                    double doubleVal = clsField.getDouble(clsObj);
                    size += CodedOutputStream.computeDoubleSize(protoBufFieldInfo.getFieldNumber(), doubleVal);
                } else if (protoBufFieldInfo.getCls() == Double.class) {
                    Double doubleClsVal = (Double) clsField.get(clsObj);
                    if (doubleClsVal != null) {
                        size += CodedOutputStream.computeDoubleSize(protoBufFieldInfo.getFieldNumber(), doubleClsVal.doubleValue());
                    }
                } else if (protoBufFieldInfo.getCls() == Long.TYPE) {
                    long longVal = clsField.getLong(clsObj);
                    size += CodedOutputStream.computeInt64Size(protoBufFieldInfo.getFieldNumber(), longVal);
                } else if (protoBufFieldInfo.getCls() == Long.class) {
                    Long longClsVal = (Long) clsField.get(clsObj);
                    if (longClsVal != null) {
                        size += CodedOutputStream.computeInt64Size(protoBufFieldInfo.getFieldNumber(), longClsVal.longValue());
                    }
                } else if (protoBufFieldInfo.getCls() == String.class) {
                    String strVal = (String) clsField.get(clsObj);
                    if (strVal != null) {
                        size += CodedOutputStream.computeBytesSize(protoBufFieldInfo.getFieldNumber(), getStringBytes(strVal));
                    }
                } else if (protoBufFieldInfo.getCls() == ByteString.class) {
                    ByteString bytesVal = (ByteString) clsField.get(clsObj);
                    if (bytesVal != null) {
                        size += CodedOutputStream.computeBytesSize(protoBufFieldInfo.getFieldNumber(), bytesVal);
                    }
                } else if (protoBufFieldInfo.getCls() == BigDecimal.class) {
                    BigDecimal bigDecVal = (BigDecimal) clsField.get(clsObj);
                    if (bigDecVal != null) {
                        String strVal2 = bigDecVal.toString();
                        size += CodedOutputStream.computeBytesSize(protoBufFieldInfo.getFieldNumber(), getStringBytes(strVal2));
                    }
                } else if (protoBufFieldInfo.getCls() == Date.class) {
                    Date dateVal = (Date) clsField.get(clsObj);
                    if (dateVal != null) {
                        String strVal3 = DateTimeUtil.changeFormat(dateVal, "yyyy-MM-dd HH:mm:ss");
                        size += CodedOutputStream.computeBytesSize(protoBufFieldInfo.getFieldNumber(), getStringBytes(strVal3));
                    }
                } else if (protoBufFieldInfo.getCls() == Boolean.TYPE) {
                    boolean boolVal = clsField.getBoolean(clsObj);
                    size += CodedOutputStream.computeBoolSize(protoBufFieldInfo.getFieldNumber(), boolVal);
                } else if (protoBufFieldInfo.getCls() == Boolean.class) {
                    Boolean boolClsVal = (Boolean) clsField.get(clsObj);
                    if (boolClsVal != null) {
                        size += CodedOutputStream.computeBoolSize(protoBufFieldInfo.getFieldNumber(), boolClsVal.booleanValue());
                    }
                } else if (protoBufFieldInfo.getCls() == List.class || protoBufFieldInfo.getCls() == ArrayList.class) {
                    List<Object> listVal = (List) clsField.get(clsObj);
                    if (listVal != null) {
                        for (int arrIdx = 0; arrIdx < listVal.size(); arrIdx++) {
                            Object objVal = listVal.get(arrIdx);
                            if (objVal != null) {
                                int objValSize = getSerializedSize(objVal);
                                size += CodedOutputStream.computeTagSize(protoBufFieldInfo.getFieldNumber()) + CodedOutputStream.computeRawVarint32Size(objValSize) + objValSize;
                            }
                        }
                    }
                } else {
                    Object objVal2 = clsField.get(clsObj);
                    if (objVal2 != null) {
                        int objValSize2 = getSerializedSize(objVal2);
                        size += CodedOutputStream.computeTagSize(protoBufFieldInfo.getFieldNumber()) + CodedOutputStream.computeRawVarint32Size(objValSize2) + objValSize2;
                    }
                }
            } catch (IllegalAccessException ex) {
                throw new ProtoBufHandlerException(ex);
            }
        }
        return size;
    }

    public static void writeStream(CodedOutputStream output, Object clsObj) throws IllegalAccessException, IllegalArgumentException, ProtoBufHandlerException {
        Class<?> cls = clsObj.getClass();
        Field[] clsFields = clsObj.getClass().getDeclaredFields();
        List<ProtoBufFieldInfo> fields = ProtoBufMetaDef.getInstance().getProtoBufFields(cls.getName());
        if (fields == null) {
            throw new ProtoBufHandlerException("Protocol buffer metadata undefined : " + cls.getName());
        }
        for (int fieldIdx = 0; fieldIdx < fields.size(); fieldIdx++) {
            try {
                ProtoBufFieldInfo protoBufFieldInfo = fields.get(fieldIdx);
                Field clsField = null;
                for (Field fd : clsFields) {
                    if (fd.getName().equals(protoBufFieldInfo.getFieldName())) {
                        clsField = fd;
                        clsField.setAccessible(true);
                    }
                }
                if (clsField == null) {
                    throw new ProtoBufHandlerException("Protocol buffer metadata attribute not found : " + protoBufFieldInfo.getFieldName() + "in" + cls.getName());
                }
                if (protoBufFieldInfo.getCls() == Integer.TYPE) {
                    int intVal = clsField.getInt(clsObj);
                    output.writeInt32(protoBufFieldInfo.getFieldNumber(), intVal);
                } else if (protoBufFieldInfo.getCls() == Integer.class) {
                    Integer intClsVal = (Integer) clsField.get(clsObj);
                    if (intClsVal != null) {
                        output.writeInt32(protoBufFieldInfo.getFieldNumber(), intClsVal.intValue());
                    }
                } else if (protoBufFieldInfo.getCls() == Short.TYPE) {
                    short shortVal = clsField.getShort(clsObj);
                    output.writeInt32(protoBufFieldInfo.getFieldNumber(), shortVal);
                } else if (protoBufFieldInfo.getCls() == Short.class) {
                    Short shortClsVal = (Short) clsField.get(clsObj);
                    if (shortClsVal != null) {
                        output.writeInt32(protoBufFieldInfo.getFieldNumber(), shortClsVal.shortValue());
                    }
                } else if (protoBufFieldInfo.getCls() == Float.TYPE) {
                    float floatVal = clsField.getFloat(clsObj);
                    output.writeFloat(protoBufFieldInfo.getFieldNumber(), floatVal);
                } else if (protoBufFieldInfo.getCls() == Float.class) {
                    Float floatClsVal = (Float) clsField.get(clsObj);
                    if (floatClsVal != null) {
                        output.writeFloat(protoBufFieldInfo.getFieldNumber(), floatClsVal.floatValue());
                    }
                } else if (protoBufFieldInfo.getCls() == Double.TYPE) {
                    double doubleVal = clsField.getDouble(clsObj);
                    output.writeDouble(protoBufFieldInfo.getFieldNumber(), doubleVal);
                } else if (protoBufFieldInfo.getCls() == Double.class) {
                    Double doubleClsVal = (Double) clsField.get(clsObj);
                    if (doubleClsVal != null) {
                        output.writeDouble(protoBufFieldInfo.getFieldNumber(), doubleClsVal.doubleValue());
                    }
                } else if (protoBufFieldInfo.getCls() == Long.TYPE) {
                    long longVal = clsField.getLong(clsObj);
                    output.writeInt64(protoBufFieldInfo.getFieldNumber(), longVal);
                } else if (protoBufFieldInfo.getCls() == Long.class) {
                    Long longClsVal = (Long) clsField.get(clsObj);
                    if (longClsVal != null) {
                        output.writeInt64(protoBufFieldInfo.getFieldNumber(), longClsVal.longValue());
                    }
                } else if (protoBufFieldInfo.getCls() == String.class) {
                    String strVal = (String) clsField.get(clsObj);
                    if (strVal != null) {
                        output.writeBytes(protoBufFieldInfo.getFieldNumber(), getStringBytes(strVal));
                    }
                } else if (protoBufFieldInfo.getCls() == ByteString.class) {
                    ByteString bytesVal = (ByteString) clsField.get(clsObj);
                    if (bytesVal != null) {
                        output.writeBytes(protoBufFieldInfo.getFieldNumber(), bytesVal);
                    }
                } else if (protoBufFieldInfo.getCls() == BigDecimal.class) {
                    BigDecimal bigDecVal = (BigDecimal) clsField.get(clsObj);
                    if (bigDecVal != null) {
                        String strVal2 = bigDecVal.toString();
                        output.writeBytes(protoBufFieldInfo.getFieldNumber(), getStringBytes(strVal2));
                    }
                } else if (protoBufFieldInfo.getCls() == Date.class) {
                    Date dateVal = (Date) clsField.get(clsObj);
                    if (dateVal != null) {
                        String strVal3 = DateTimeUtil.changeFormat(dateVal, "yyyy-MM-dd HH:mm:ss");
                        output.writeBytes(protoBufFieldInfo.getFieldNumber(), getStringBytes(strVal3));
                    }
                } else if (protoBufFieldInfo.getCls() == Boolean.TYPE) {
                    boolean boolVal = clsField.getBoolean(clsObj);
                    output.writeBool(protoBufFieldInfo.getFieldNumber(), boolVal);
                } else if (protoBufFieldInfo.getCls() == Boolean.class) {
                    Boolean boolClsVal = (Boolean) clsField.get(clsObj);
                    if (boolClsVal != null) {
                        output.writeBool(protoBufFieldInfo.getFieldNumber(), boolClsVal.booleanValue());
                    }
                } else if (protoBufFieldInfo.getCls() == List.class || protoBufFieldInfo.getCls() == ArrayList.class) {
                    List<Object> listVal = (List) clsField.get(clsObj);
                    if (listVal != null) {
                        for (int arrIdx = 0; arrIdx < listVal.size(); arrIdx++) {
                            Object objVal = listVal.get(arrIdx);
                            if (objVal != null) {
                                output.writeTag(protoBufFieldInfo.getFieldNumber(), 2);
                                output.writeRawVarint32(getSerializedSize(objVal));
                                writeStream(output, objVal);
                            }
                        }
                    }
                } else {
                    Object objVal2 = clsField.get(clsObj);
                    if (objVal2 != null) {
                        output.writeTag(protoBufFieldInfo.getFieldNumber(), 2);
                        output.writeRawVarint32(getSerializedSize(objVal2));
                        writeStream(output, objVal2);
                    }
                }
            } catch (IOException ex) {
                throw new ProtoBufHandlerException(ex);
            } catch (IllegalAccessException ex2) {
                throw new ProtoBufHandlerException(ex2);
            }
        }
    }

    public static void parseStream(CodedInputStream input, Object clsObj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, ProtoBufHandlerException {
        Class<?> cls = clsObj.getClass();
        Field[] clsFields = clsObj.getClass().getDeclaredFields();
        List<ProtoBufFieldInfo> fields = ProtoBufMetaDef.getInstance().getProtoBufFields(cls.getName());
        if (fields == null) {
            throw new ProtoBufHandlerException("Protocol buffer metadata undefined : " + cls.getName());
        }
        while (true) {
            try {
                int tag = input.readTag();
                if (tag != 0) {
                    int fieldNumber = (tag & (-8)) >> 3;
                    int wireType = tag & 7;
                    ProtoBufFieldInfo protoBufFieldInfo = null;
                    int ii = 0;
                    while (true) {
                        if (ii < fields.size()) {
                            if (fields.get(ii).getFieldNumber() == fieldNumber) {
                                ProtoBufFieldInfo protoBufFieldInfo2 = fields.get(ii);
                                protoBufFieldInfo = protoBufFieldInfo2;
                            } else {
                                ii++;
                            }
                        }
                    }
                    if (protoBufFieldInfo == null) {
                        input.skipField(tag);
                    } else {
                        Field clsField = null;
                        for (Field fd : clsFields) {
                            if (fd.getName().equals(protoBufFieldInfo.getFieldName())) {
                                clsField = fd;
                                clsField.setAccessible(true);
                            }
                        }
                        if (clsField == null) {
                            throw new ProtoBufHandlerException("Protocol buffer metadata attribute not found : " + protoBufFieldInfo.getFieldName() + "in" + cls.getName());
                        }
                        switch (wireType) {
                            case 0:
                                if (protoBufFieldInfo.getCls() == Integer.TYPE) {
                                    int intVal = input.readInt32();
                                    clsField.setInt(clsObj, intVal);
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Integer.class) {
                                    int intVal2 = input.readInt32();
                                    clsField.set(clsObj, Integer.valueOf(intVal2));
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Short.TYPE) {
                                    short shortVal = (short) input.readInt32();
                                    clsField.setShort(clsObj, shortVal);
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Short.class) {
                                    short shortVal2 = (short) input.readInt32();
                                    clsField.set(clsObj, Short.valueOf(shortVal2));
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Boolean.TYPE) {
                                    boolean boolVal = input.readBool();
                                    clsField.setBoolean(clsObj, boolVal);
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Boolean.class) {
                                    boolean boolVal2 = input.readBool();
                                    clsField.set(clsObj, Boolean.valueOf(boolVal2));
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Long.TYPE) {
                                    long longVal = input.readInt64();
                                    clsField.setLong(clsObj, longVal);
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Long.class) {
                                    long longVal2 = input.readInt64();
                                    clsField.set(clsObj, Long.valueOf(longVal2));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (protoBufFieldInfo.getCls() == Double.TYPE) {
                                    double doubleVal = input.readDouble();
                                    clsField.setDouble(clsObj, doubleVal);
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Double.class) {
                                    double doubleVal2 = input.readDouble();
                                    clsField.set(clsObj, Double.valueOf(doubleVal2));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (protoBufFieldInfo.getCls() == String.class) {
                                    String strVal = input.readBytes().toStringUtf8();
                                    clsField.set(clsObj, strVal);
                                    break;
                                } else if (protoBufFieldInfo.getCls() == ByteString.class) {
                                    ByteString bytesVal = input.readBytes();
                                    clsField.set(clsObj, bytesVal);
                                    break;
                                } else if (protoBufFieldInfo.getCls() == BigDecimal.class) {
                                    String strVal2 = input.readBytes().toStringUtf8();
                                    clsField.set(clsObj, new BigDecimal(strVal2));
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Date.class) {
                                    String strVal3 = input.readBytes().toStringUtf8();
                                    clsField.set(clsObj, DateTimeUtil.changeFormat(strVal3, "yyyy-MM-dd HH:mm:ss"));
                                    break;
                                } else if (protoBufFieldInfo.getCls() == List.class || protoBufFieldInfo.getCls() == ArrayList.class) {
                                    List<Object> listVal = (List) clsField.get(clsObj);
                                    if (listVal == null) {
                                        listVal = new ArrayList<>();
                                        clsField.set(clsObj, listVal);
                                    }
                                    Object objVal = protoBufFieldInfo.getListCls().newInstance();
                                    int length = input.readRawVarint32();
                                    int oldLimit = input.pushLimit(length);
                                    parseStream(input, objVal);
                                    input.checkLastTagWas(0);
                                    input.popLimit(oldLimit);
                                    listVal.add(objVal);
                                    break;
                                } else {
                                    Object objVal2 = protoBufFieldInfo.getCls().newInstance();
                                    int length2 = input.readRawVarint32();
                                    int oldLimit2 = input.pushLimit(length2);
                                    parseStream(input, objVal2);
                                    input.checkLastTagWas(0);
                                    input.popLimit(oldLimit2);
                                    clsField.set(clsObj, objVal2);
                                    break;
                                }
                                break;
                            case 3:
                            case 4:
                                break;
                            case 5:
                                if (protoBufFieldInfo.getCls() == Float.TYPE) {
                                    float floatVal = input.readFloat();
                                    clsField.setFloat(clsObj, floatVal);
                                    break;
                                } else if (protoBufFieldInfo.getCls() == Float.class) {
                                    float floatVal2 = input.readFloat();
                                    clsField.set(clsObj, Float.valueOf(floatVal2));
                                    break;
                                } else {
                                    break;
                                }
                            default:
                                throw new ProtoBufHandlerException("Unsupported wire type : " + wireType);
                        }
                    }
                } else {
                    return;
                }
            } catch (IOException ex) {
                throw new ProtoBufHandlerException(cls.getName(), ex);
            } catch (IllegalAccessException ex2) {
                throw new ProtoBufHandlerException(cls.getName(), ex2);
            } catch (InstantiationException ex3) {
                throw new ProtoBufHandlerException(cls.getName(), ex3);
            } catch (ParseException ex4) {
                throw new ProtoBufHandlerException(cls.getName(), ex4);
            }
        }
    }
}
