package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Sequence;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class PDXDictionary extends PDXClass implements Dictionary {

    /* renamed from: a */
    private static final LogFactory.Log f167a = LogFactory.getLog(PDXDictionary.class);

    /* renamed from: b */
    private Hashtable f168b;

    public PDXDictionary() {
        super(NMASResource.PDX_DATA_TYPE_DICT);
        this.f168b = new Hashtable();
    }

    public PDXDictionary(byte[] bArr) {
        super(NMASResource.PDX_DATA_TYPE_DICT);
        this.f168b = new Hashtable();
        m37a(bArr);
    }

    public PDXDictionary(byte[] bArr, boolean z) {
        super(NMASResource.PDX_DATA_TYPE_DICT);
        this.f168b = new Hashtable();
        if (bArr.length > 0) {
            if ((bArr[0] & 255) != 224) {
                f167a.error("PDXDictionary() Expected a dictionary. ");
                return;
            }
            int length = getLength(bArr, 1);
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, bArr.length - length, bArr2, 0, bArr2.length);
            m37a(bArr2);
        }
    }

    /* renamed from: a */
    private void m37a(byte[] bArr) {
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i3 == 22) {
                int length = getLength(bArr, i2);
                int lengthSize = i2 + getLengthSize(length);
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, lengthSize, bArr2, 0, bArr2.length);
                int i4 = length + lengthSize;
                String str = new String(bArr2);
                int i5 = i4 + 1;
                int i6 = bArr[i4] & 255;
                int length2 = getLength(bArr, i5);
                int lengthSize2 = i5 + getLengthSize(length2);
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr, lengthSize2, bArr3, 0, bArr3.length);
                i = length2 + lengthSize2;
                switch (i6) {
                    case 4:
                        this.f168b.put(str, new PDXByteString(bArr3));
                        break;
                    case 5:
                        this.f168b.put(str, new PDXNull());
                        break;
                    case 16:
                        this.f168b.put(str, new PDXSequence(bArr3));
                        break;
                    case 22:
                        this.f168b.put(str, new PDXAsciiString(bArr3));
                        break;
                    case 192:
                        this.f168b.put(str, new PDXInteger(bArr3));
                        break;
                    case 193:
                        this.f168b.put(str, new PDXUTF8String(bArr3));
                        break;
                    case 224:
                        this.f168b.put(str, new PDXDictionary(bArr3));
                        break;
                    default:
                        f167a.error("PDXDictionary.setContent() Unknown PDXClass type: " + i6 + ". ");
                        break;
                }
            } else {
                f167a.error("PDXDictionary.setContent() Expected an ASCII string but got " + i3 + ". ");
                return;
            }
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public void addAsciiString(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("key or value is null.");
        }
        this.f168b.put(str, new PDXAsciiString(str2));
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public void addByteString(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            throw new IllegalArgumentException("key or value is null.");
        }
        this.f168b.put(str, new PDXByteString(bArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public void addDictionary(String str, Dictionary dictionary) {
        if (str == null || dictionary == 0) {
            throw new IllegalArgumentException("key or value is null.");
        }
        if (((PDXClass) dictionary).getType() != 224) {
            f167a.error("PDXDictionary.addDictionary() value is not a valid dictionary.");
            throw new IllegalArgumentException("value is not a valid dictionary. ");
        }
        this.f168b.put(str, dictionary);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public void addInteger(String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("key or value is null.");
        }
        this.f168b.put(str, new PDXInteger(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public void addSequence(String str, Sequence sequence) {
        if (str == null || sequence == 0) {
            throw new IllegalArgumentException("key or value is null.");
        }
        if (((PDXClass) sequence).getType() != 16) {
            f167a.error("PDXDictionary.addSequence() value is not a valid sequence.");
            throw new IllegalArgumentException("value is not a valid sequence. ");
        }
        this.f168b.put(str, sequence);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public void addUTF8String(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("key or value is null.");
        }
        this.f168b.put(str, new PDXUTF8String(str2));
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public boolean containsKey(String str) {
        if (str == null) {
            throw new NullPointerException("PDXDictionary.containsKey key is null");
        }
        return this.f168b.containsKey(str);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public String getAsciiString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        PDXClass pDXClass = (PDXClass) this.f168b.get(str);
        if (pDXClass == null) {
            f167a.error("PDXDictionary.getAsciiString() " + str + " does not exist. ");
            throw new RuntimeException(Dictionary.KEY_DOES_NOT_EXIST);
        }
        if (pDXClass.getType() == 22) {
            return ((PDXAsciiString) pDXClass).getValue();
        }
        f167a.error("PDXDictionary.getAsciiString() " + str + " is not a PDXAsciiString. ");
        throw new RuntimeException(Dictionary.KEY_IS_OF_WRONG_TYPE);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public byte[] getByteString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        PDXClass pDXClass = (PDXClass) this.f168b.get(str);
        if (pDXClass == null) {
            f167a.error("PDXDictionary.getByteString() " + str + " does not exist. ");
            throw new RuntimeException(Dictionary.KEY_DOES_NOT_EXIST);
        }
        if (pDXClass.getType() == 4) {
            return ((PDXByteString) pDXClass).getValue();
        }
        f167a.error("PDXDictionary.getByteString() " + str + " is not a PDXByteString. ");
        throw new RuntimeException(Dictionary.KEY_IS_OF_WRONG_TYPE);
    }

    protected PDXClass getClass(String str) {
        return (PDXClass) this.f168b.get(str);
    }

    public byte[] getContent() {
        PDXClass pDXClass;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Enumeration enumerationKeys = this.f168b.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            try {
                byteArrayOutputStream.write(new PDXAsciiString(str).toByteArray());
                pDXClass = (PDXClass) this.f168b.get(str);
            } catch (IOException e) {
                f167a.error("PDXDictionary.getContent() " + e.toString() + ". ");
            }
            switch (pDXClass.getType()) {
                case 4:
                    byteArrayOutputStream.write(((PDXByteString) pDXClass).toByteArray());
                    continue;
                case 5:
                    byteArrayOutputStream.write(((PDXNull) pDXClass).toByteArray());
                    continue;
                case 16:
                    byteArrayOutputStream.write(((PDXSequence) pDXClass).toByteArray());
                    continue;
                case 22:
                    byteArrayOutputStream.write(((PDXAsciiString) pDXClass).toByteArray());
                    continue;
                case 192:
                    byteArrayOutputStream.write(((PDXInteger) pDXClass).toByteArray());
                    continue;
                case 193:
                    byteArrayOutputStream.write(((PDXUTF8String) pDXClass).toByteArray());
                    continue;
                case 224:
                    byteArrayOutputStream.write(((PDXDictionary) pDXClass).toByteArray());
                    continue;
                default:
                    continue;
            }
            f167a.error("PDXDictionary.getContent() " + e.toString() + ". ");
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public Dictionary getDictionary(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        PDXClass pDXClass = (PDXClass) this.f168b.get(str);
        if (pDXClass == null) {
            f167a.error("PDXDictionary.getDictionary() " + str + " does not exist. ");
            throw new RuntimeException(Dictionary.KEY_DOES_NOT_EXIST);
        }
        if (pDXClass.getType() == 224) {
            return (PDXDictionary) pDXClass;
        }
        f167a.error("PDXDictionary.getDictionary() " + str + " is not a PDXDictionary. ");
        throw new RuntimeException(Dictionary.KEY_IS_OF_WRONG_TYPE);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public int getInteger(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        PDXClass pDXClass = (PDXClass) this.f168b.get(str);
        if (pDXClass == null) {
            if (f167a.isErrorEnabled()) {
                f167a.error("PDXDictionary.getInteger() " + str + " does not exist. ");
            }
            throw new RuntimeException(Dictionary.KEY_DOES_NOT_EXIST);
        }
        if (pDXClass.getType() == 192) {
            return ((PDXInteger) pDXClass).getValue();
        }
        if (f167a.isErrorEnabled()) {
            f167a.error("PDXDictionary.getInteger() " + str + " is not a PDXInteger. ");
        }
        throw new RuntimeException(Dictionary.KEY_IS_OF_WRONG_TYPE);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public Sequence getSequence(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        PDXClass pDXClass = (PDXClass) this.f168b.get(str);
        if (pDXClass == null) {
            f167a.error("PDXDictionary.getSequence() " + str + " does not exist. ");
            throw new RuntimeException(Dictionary.KEY_DOES_NOT_EXIST);
        }
        if (pDXClass.getType() == 16) {
            return (PDXSequence) pDXClass;
        }
        f167a.error("PDXDictionary.getSequence() " + str + " is not a PDXSequence. ");
        throw new RuntimeException(Dictionary.KEY_IS_OF_WRONG_TYPE);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public short getType(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        return ((PDXClass) this.f168b.get(str)).getType();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public String getUTF8String(String str) {
        if (str == null) {
            throw new IllegalArgumentException("key is null.");
        }
        PDXClass pDXClass = (PDXClass) this.f168b.get(str);
        if (pDXClass == null) {
            f167a.error("PDXDictionary.getUTF8String() " + str + " does not exist. ");
            throw new RuntimeException(Dictionary.KEY_DOES_NOT_EXIST);
        }
        if (pDXClass.getType() == 193) {
            return ((PDXUTF8String) pDXClass).getValue();
        }
        f167a.error("PDXDictionary.getUTF8String() " + str + " is not a PDXUTF8String. ");
        throw new RuntimeException(Dictionary.KEY_IS_OF_WRONG_TYPE);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary
    public Enumeration keys() {
        return this.f168b.keys();
    }

    protected void put(String str, int i, short s) {
        if (s == 192) {
            this.f168b.put(str, new PDXInteger(i));
        } else {
            f167a.error("PDXDictionary.put() type should be INT. ");
        }
    }

    protected void put(String str, String str2, short s) {
        switch (s) {
            case 22:
                this.f168b.put(str, new PDXAsciiString(str2));
                break;
            case 193:
                this.f168b.put(str, new PDXUTF8String(str2));
                break;
        }
    }

    protected void put(String str, byte[] bArr, short s) {
        switch (s) {
            case 4:
                this.f168b.put(str, new PDXByteString(bArr));
                break;
            case 5:
                this.f168b.put(str, new PDXNull());
                break;
            case 16:
                this.f168b.put(str, new PDXSequence(bArr));
                break;
            case 22:
                this.f168b.put(str, new PDXAsciiString(bArr));
                break;
            case 192:
                this.f168b.put(str, new PDXInteger(bArr));
                break;
            case 193:
                this.f168b.put(str, new PDXUTF8String(bArr));
                break;
            case 224:
                this.f168b.put(str, new PDXDictionary(bArr));
                break;
            default:
                f167a.error("PDXDictionary.put() Unknown PDXClass type: " + ((int) s) + ". ");
                break;
        }
    }

    public byte[] toByteArray() {
        return super.toByteArray(getContent());
    }

    public String toString() {
        return toString(0);
    }

    protected String toString(int i) {
        String str;
        String str2;
        String str3 = "";
        int i2 = 0;
        while (true) {
            str = str3;
            if (i2 >= i - 1) {
                break;
            }
            str3 = str + "    ";
            i2++;
        }
        String str4 = i > 0 ? str + "    " : "";
        Enumeration enumerationKeys = this.f168b.keys();
        String str5 = i != 0 ? "{ \n" : "";
        while (enumerationKeys.hasMoreElements()) {
            String str6 = (String) enumerationKeys.nextElement();
            PDXClass pDXClass = (PDXClass) this.f168b.get(str6);
            switch (pDXClass.getType()) {
                case 4:
                    str5 = str5 + str4 + str6 + ": <BYTES> \"" + ((PDXByteString) pDXClass).getValue() + "\"\n";
                    continue;
                case 5:
                    str5 = str5 + str4 + str6 + ": <NULL> \n";
                    continue;
                case 16:
                    str2 = str5 + str4 + str6 + ": " + ((PDXSequence) pDXClass).toString(i + 1) + "\n";
                    break;
                case 22:
                    str5 = str5 + str4 + str6 + ": <ASCII> \"" + ((PDXAsciiString) pDXClass).getValue() + "\"\n";
                    continue;
                case 192:
                    str5 = str5 + str4 + str6 + ": <INT> " + ((PDXInteger) pDXClass).getValue() + "\n";
                    continue;
                case 193:
                    str5 = str5 + str4 + str6 + ": <UTF8> \"" + ((PDXUTF8String) pDXClass).getValue() + "\"\n";
                    continue;
                case 224:
                    str5 = str5 + str4 + str6 + ": " + ((PDXDictionary) pDXClass).toString(i + 1) + "\n";
                    continue;
                default:
                    str2 = str5;
                    break;
            }
            str5 = str2;
        }
        return i != 0 ? str5 + str + "} " : str5;
    }
}
