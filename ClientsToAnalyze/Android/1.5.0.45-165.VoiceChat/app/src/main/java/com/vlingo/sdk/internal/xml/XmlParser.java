package com.vlingo.sdk.internal.xml;

import com.infraware.office.evengine.InterfaceC0507E;
import com.vlingo.sdk.internal.util.ToIntHashtable;
import com.vlingo.sdk.internal.util.ToIntHashtableFactory;
import java.util.Vector;

/* loaded from: classes.dex */
public class XmlParser {
    private static final int STATE_ADVANCE = 4;
    private static final int STATE_ADVANCE_COMMENTS = 6;
    private static final int STATE_BEGIN = 0;
    private static final int STATE_DONE = 5;
    private static final int STATE_IN_CDATA = 3;
    private static final int STATE_IN_ELEMENT = 1;
    private static final int maxEscapeLen = 6;
    private static final ToIntHashtable xmlEscapes = ToIntHashtableFactory.createNewHashtable();
    private int attributeNameEnd;
    private int attributeNameStart;
    private int attributeValueEnd;
    private int attributeValueStart;
    protected int cDataEnd;
    protected int cDataStart;
    private boolean checkCDataSpacing;
    private boolean checkEscapes;
    private boolean currentElementIsBegin;
    private boolean currentElementIsEnd;
    protected int elementEnd;
    protected int elementStart;
    protected int endIndex;
    private XmlHandler handler;
    protected int index;
    private char[] xml;
    private ToIntHashtable xmlAttributes;
    private ToIntHashtable xmlElements;
    private XmlAttributes attributes = null;
    private boolean checkForEscapes_AttributeValues = false;
    private boolean checkForEscapes_CData = false;
    private int cachedElementType = -1;
    private char[] cachedCData = null;
    private XmlAttributes cachedAttributes = null;
    int cStartElementEnd = 0;
    private int currentState = 0;

    static {
        xmlEscapes.put("quot", 34);
        xmlEscapes.put("amp", 38);
        xmlEscapes.put("apos", 39);
        xmlEscapes.put("lt", 60);
        xmlEscapes.put("gt", 62);
        xmlEscapes.put("nbsp", 32);
        xmlEscapes.put("excl", 33);
        xmlEscapes.put("sol", 47);
        xmlEscapes.put("equals", 61);
        xmlEscapes.put("lsqb", 91);
        xmlEscapes.put("rsqb", 93);
        xmlEscapes.put("trade", 8482);
    }

    public XmlParser(char[] xml, int offset, int length, XmlHandler handler, ToIntHashtable xmlElements, ToIntHashtable xmlAttributes, boolean checkEscapes, boolean checkCDataSpacing) {
        this.handler = null;
        this.xmlElements = null;
        this.xmlAttributes = null;
        this.checkEscapes = true;
        this.checkCDataSpacing = false;
        this.xml = xml;
        this.index = offset;
        this.endIndex = (this.index + length) - 1;
        this.handler = handler;
        this.xmlElements = xmlElements;
        this.checkEscapes = checkEscapes;
        this.checkCDataSpacing = checkCDataSpacing;
        this.xmlAttributes = xmlAttributes == null ? ToIntHashtableFactory.createNewHashtable() : xmlAttributes;
    }

    public void parseXml() {
        while (this.currentState != 5) {
            try {
            } catch (Throwable e) {
                e.printStackTrace();
                this.currentState = 5;
            }
            switch (this.currentState) {
                case 0:
                    this.handler.beginDocument();
                    this.currentState = handleBegin();
                    continue;
                case 1:
                    this.currentState = handleElement();
                    continue;
                case 2:
                case 5:
                default:
                    continue;
                case 3:
                    this.currentState = handleCData();
                    continue;
                case 4:
                    this.currentState = advanceIndex();
                    continue;
                case 6:
                    this.currentState = skipComments();
                    continue;
            }
            e.printStackTrace();
            this.currentState = 5;
        }
        this.handler.endDocument();
    }

    private int handleBegin() {
        while (this.index <= this.endIndex) {
            if (this.xml[this.index] == '<') {
                return 1;
            }
            this.index++;
        }
        return 5;
    }

    private int skipComments() {
        int dashCount = 0;
        while (this.index <= this.endIndex) {
            char b = this.xml[this.index];
            switch (b) {
                case '-':
                    dashCount++;
                    break;
                case '>':
                    if (dashCount < 2) {
                        break;
                    } else {
                        return 4;
                    }
                default:
                    dashCount = 0;
                    break;
            }
            this.index++;
        }
        return 5;
    }

    private int advanceIndex() {
        while (this.index <= this.endIndex) {
            char b = this.xml[this.index];
            if (b == '<') {
                return 1;
            }
            if (b == 0) {
                return 5;
            }
            if (b >= ' ') {
                return 3;
            }
            this.index++;
        }
        return 5;
    }

    private int handleElement() {
        this.currentElementIsBegin = true;
        this.currentElementIsEnd = false;
        this.elementStart = -1;
        this.elementEnd = -1;
        while (this.index <= this.endIndex) {
            switch (this.xml[this.index]) {
                case ' ':
                    if (this.elementEnd < 0 && this.elementStart >= 0) {
                        this.elementEnd = this.index;
                        handleAttributes();
                        if (!this.checkForEscapes_AttributeValues) {
                            break;
                        } else {
                            this.checkForEscapes_AttributeValues = false;
                            break;
                        }
                    } else {
                        break;
                    }
                    break;
                case '!':
                    return 6;
                case '\"':
                case '\'':
                case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BRBOOKCLIP_EVENT /* 60 */:
                    break;
                case '/':
                    if (this.elementStart < 0) {
                        this.currentElementIsBegin = false;
                    }
                    this.currentElementIsEnd = true;
                    if (this.elementEnd < 0 && this.elementStart > 0) {
                        this.elementEnd = this.index;
                        break;
                    } else {
                        break;
                    }
                    break;
                case '>':
                    if (this.elementEnd < 0 && this.elementStart >= 0) {
                        this.elementEnd = this.index;
                    }
                    outputElement();
                    this.index++;
                    return 4;
                default:
                    if (this.elementStart >= 0) {
                        break;
                    } else {
                        this.elementStart = this.index;
                        break;
                    }
            }
            this.index++;
        }
        return 5;
    }

    private void resetAttributeIndicies() {
        this.attributeNameStart = -1;
        this.attributeNameEnd = -1;
        this.attributeValueStart = -1;
        this.attributeValueEnd = -1;
    }

    private void addAttribute() {
        if (this.attributeNameStart >= 0 && this.attributeNameEnd >= 0) {
            int nameLen = this.attributeNameEnd - this.attributeNameStart;
            int valueLen = this.attributeValueEnd - this.attributeValueStart;
            if (this.attributeValueStart == -1) {
                valueLen = 0;
                this.attributeValueStart = 0;
                this.attributeValueEnd = 0;
            }
            if (this.attributes == null) {
                this.attributes = new XmlAttributes(this.xmlAttributes);
            }
            byte attributeType = this.attributes.getAttributeType(this.xml, this.attributeNameStart, nameLen);
            String attributeValue = createString(this.xml, this.attributeValueStart, valueLen, this.checkEscapes || this.checkForEscapes_AttributeValues);
            this.attributes.add(attributeType, attributeValue);
        }
    }

    private void handleAttributes() {
        boolean inQuotes = false;
        boolean usingDoubleQuotes = false;
        resetAttributeIndicies();
        while (this.index <= this.endIndex) {
            switch (this.xml[this.index]) {
                case ' ':
                    this.index++;
                case '\"':
                    if (inQuotes && usingDoubleQuotes) {
                        this.attributeValueEnd = this.index;
                        addAttribute();
                        resetAttributeIndicies();
                        inQuotes = false;
                        continue;
                    } else if (!inQuotes || usingDoubleQuotes) {
                        inQuotes = true;
                        usingDoubleQuotes = true;
                    }
                    this.index++;
                case '\'':
                    if (inQuotes && !usingDoubleQuotes && this.attributeValueStart > 0) {
                        this.attributeValueEnd = this.index;
                        addAttribute();
                        resetAttributeIndicies();
                        inQuotes = false;
                        continue;
                    } else if (!inQuotes || !usingDoubleQuotes) {
                        inQuotes = true;
                        usingDoubleQuotes = false;
                    }
                    this.index++;
                case '/':
                case '>':
                    if (!inQuotes) {
                        this.index--;
                        return;
                    }
                    break;
                case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_FLICK_EVENT /* 61 */:
                    if (inQuotes) {
                        continue;
                    } else {
                        this.attributeNameEnd = this.index;
                    }
                    this.index++;
            }
            if (!inQuotes && this.attributeNameStart < 0) {
                this.attributeNameStart = this.index;
            } else if (inQuotes && this.attributeValueStart < 0) {
                this.attributeValueStart = this.index;
            }
            this.index++;
        }
    }

    private int handleCData() {
        int lastSpaceIndex = -1;
        boolean foundOnlyBlanks = true;
        if (this.checkCDataSpacing) {
            while (this.index <= this.endIndex && this.xml[this.index] <= ' ') {
                this.index++;
            }
        }
        int i = this.index;
        this.cDataEnd = i;
        this.cDataStart = i;
        while (this.index <= this.endIndex) {
            char b = this.xml[this.index];
            switch (b) {
                case 0:
                    if (this.checkCDataSpacing && lastSpaceIndex > -1) {
                        this.cDataEnd = lastSpaceIndex;
                    } else {
                        this.cDataEnd = this.index;
                    }
                    if (!this.checkCDataSpacing || !foundOnlyBlanks) {
                        outputChars();
                    }
                    if (!this.checkForEscapes_CData) {
                        return 5;
                    }
                    this.checkForEscapes_CData = false;
                    return 5;
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                    this.xml[this.index] = ' ';
                    break;
                case ' ':
                    break;
                case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BRBOOKCLIP_EVENT /* 60 */:
                    if (this.checkCDataSpacing && lastSpaceIndex > -1) {
                        this.cDataEnd = lastSpaceIndex;
                    } else {
                        this.cDataEnd = this.index;
                    }
                    if (!this.checkCDataSpacing || !foundOnlyBlanks) {
                        outputChars();
                    }
                    if (this.checkForEscapes_CData) {
                        this.checkForEscapes_CData = false;
                    }
                    return 1;
                default:
                    foundOnlyBlanks = false;
                    lastSpaceIndex = -1;
                    continue;
                    this.index++;
            }
            if (lastSpaceIndex == -1) {
                lastSpaceIndex = this.index;
            }
            this.index++;
        }
        return 5;
    }

    private void outputElement() {
        int len = this.elementEnd - this.elementStart;
        if (this.cachedElementType != 255) {
            this.handler.beginElement(this.cachedElementType, this.cachedAttributes, this.cachedCData, this.cStartElementEnd);
            this.cachedElementType = 255;
            this.cachedAttributes = null;
            this.cachedCData = null;
        }
        if (this.elementStart > 0) {
            char[] elementName = new char[len];
            System.arraycopy(this.xml, this.elementStart, elementName, 0, len);
            int elementType = getElementCode(this.xml, this.elementStart, len);
            if (this.currentElementIsEnd) {
                if (this.currentElementIsBegin) {
                    this.handler.beginElement(elementType, this.attributes, null, this.elementEnd);
                }
                this.handler.endElement(elementType, this.elementStart - 2);
            } else if (this.currentElementIsBegin) {
                this.cachedElementType = elementType;
                this.cStartElementEnd = this.index + 1;
                if (this.attributes != null) {
                    this.cachedAttributes = this.attributes;
                }
            }
        }
        this.attributes = null;
    }

    private void outputChars() {
        boolean z = true;
        int len = this.cDataEnd - this.cDataStart;
        if (this.cachedElementType != 255) {
            char[] cArr = this.xml;
            int i = this.cDataStart;
            if (!this.checkEscapes && !this.checkForEscapes_CData) {
                z = false;
            }
            this.cachedCData = createByteArray(cArr, i, len, z, false);
            return;
        }
        char[] cArr2 = this.xml;
        int i2 = this.cDataStart;
        if (!this.checkEscapes && !this.checkForEscapes_CData) {
            z = false;
        }
        char[] cData = createByteArray(cArr2, i2, len, z, false);
        if (cData != null) {
            this.handler.characters(cData);
        }
    }

    public static String createString(char[] data, int offset, int len, boolean checkEscapes) {
        if (checkEscapes) {
            char[] newArray = createByteArray(data, offset, len, checkEscapes, true);
            if (newArray != null) {
                return String.valueOf(newArray);
            }
        }
        return String.valueOf(data, offset, len);
    }

    public static char[] createByteArray(char[] data, int offset, int len, boolean checkEscapes, boolean bailOutIfNoEscapes) {
        Vector<Object> escapes = null;
        if (checkEscapes) {
            int begEscapeIndex = offset;
            while (begEscapeIndex != -1) {
                begEscapeIndex = findBegEscape(data, offset, len, begEscapeIndex);
                if (begEscapeIndex != -1) {
                    int endEscapeIndex = findEndEscape(data, offset, len, begEscapeIndex + 1);
                    if (endEscapeIndex != -1) {
                        escapes = addEscape(escapes, begEscapeIndex, (endEscapeIndex - begEscapeIndex) + 1);
                        begEscapeIndex = endEscapeIndex;
                    } else {
                        begEscapeIndex++;
                    }
                }
            }
            if (escapes != null) {
                return accountForEscapes(escapes, data, offset, len);
            }
            if (bailOutIfNoEscapes) {
                return null;
            }
        }
        char[] newArray = new char[len];
        System.arraycopy(data, offset, newArray, 0, len);
        return newArray;
    }

    private static char[] accountForEscapes(Vector<Object> escapes, char[] data, int relOffset, int len) throws NumberFormatException {
        int newArrayLength = getEscapedArrayLength(escapes, len);
        char[] newArray = new char[newArrayLength];
        int newArrayIndex = 0;
        for (int i = 0; i < escapes.size(); i++) {
            int[] escape = (int[]) escapes.elementAt(i);
            System.arraycopy(data, relOffset, newArray, newArrayIndex, escape[0] - relOffset);
            newArrayIndex += escape[0] - relOffset;
            char escapedByte = getEscapedByte(data, escape[0], escape[1]);
            relOffset = (escape[0] + escape[1]) - 1;
            data[relOffset] = escapedByte;
        }
        if (newArrayIndex < newArrayLength) {
            System.arraycopy(data, relOffset, newArray, newArrayIndex, newArrayLength - newArrayIndex);
        }
        return newArray;
    }

    private static int getEscapedArrayLength(Vector<Object> escapes, int currentLen) {
        for (int i = 0; i < escapes.size(); i++) {
            int[] escape = (int[]) escapes.elementAt(i);
            currentLen -= escape[1] - 1;
        }
        return currentLen;
    }

    private static Vector<Object> addEscape(Vector<Object> escapes, int index, int length) {
        int[] escape = {index, length};
        if (escapes == null) {
            escapes = new Vector<>();
        }
        escapes.addElement(escape);
        return escapes;
    }

    private static int findEndEscape(char[] data, int offset, int len, int start) {
        int end = offset + len;
        int i = start;
        if (start >= end) {
            return -1;
        }
        for (int count = 0; i < end && count < 6; count++) {
            switch (data[i]) {
                case '&':
                    return -1;
                case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MEDIA_LINK /* 59 */:
                    return i;
                default:
                    i++;
            }
        }
        return -1;
    }

    private static int findBegEscape(char[] data, int offset, int len, int start) {
        int end = offset + len;
        if (start >= end) {
            return -1;
        }
        for (int i = start; i < end; i++) {
            if (data[i] == '&') {
                return i;
            }
        }
        return -1;
    }

    private static char getEscapedByte(char[] data, int escapeStart, int escapeLen) throws NumberFormatException {
        String escapeName = String.valueOf(data, escapeStart + 1, escapeLen - 2);
        if (escapeName.startsWith("#")) {
            int escapeInt = Integer.parseInt(escapeName.substring(1));
            char escapedByte = (char) escapeInt;
            return escapedByte;
        }
        if (!xmlEscapes.containsKey(escapeName)) {
            return ' ';
        }
        char escapedByte2 = (char) xmlEscapes.get(escapeName);
        return escapedByte2;
    }

    private int getElementCode(char[] data, int start, int len) {
        String elementName = String.valueOf(data, start, len);
        if (!this.xmlElements.containsKey(elementName)) {
            return 0;
        }
        int elementType = this.xmlElements.get(elementName);
        return elementType;
    }

    public void stopParsing() {
        this.index = this.endIndex + 1;
    }
}
