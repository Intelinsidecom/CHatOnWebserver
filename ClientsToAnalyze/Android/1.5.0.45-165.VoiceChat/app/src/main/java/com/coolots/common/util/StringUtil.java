package com.coolots.common.util;

import com.google.protobuf.CodedOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class StringUtil {
    public static final String LOG_DELIMITER = " / ";

    private StringUtil() {
    }

    public static String leftPadStr(String src, int cnt, String padStr) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp = src.trim();
        for (int i = 0; i < cnt - temp.length(); i++) {
            stringBuilder.append(padStr);
        }
        return ((Object) stringBuilder) + temp;
    }

    public static String addComma(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(Long.parseLong(str));
    }

    public static int nvl(String str, int defaultValue) {
        return (str == null || str.length() == 0) ? defaultValue : Integer.parseInt(str);
    }

    public static String nullString(String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        return str.trim();
    }

    public static String nullString(String str, String defaultValue) {
        return (str == null || str.trim().equals("")) ? defaultValue : str.trim();
    }

    public static String getEcodeKR(String str) {
        try {
            return new String(str.getBytes("8859_1"), "EUC-KR");
        } catch (Exception e) {
            return str;
        }
    }

    public static String cutString(String str, int cutLength) {
        char[] oldchars = str.toCharArray();
        int oldLength = oldchars.length;
        int newLength = cutLength;
        for (int a = 0; a < oldLength && a < newLength; a++) {
            if (oldchars[a] > 127) {
                newLength--;
            }
        }
        if (oldLength > newLength) {
            char[] newchars = new char[newLength];
            System.arraycopy(oldchars, 0, newchars, 0, newLength);
            return String.valueOf(new String(newchars)) + "..";
        }
        return str;
    }

    public static String parseNumberStr(String number) {
        return parseNumberStr(number, Locale.KOREA);
    }

    public static String parseNumberStr(String number, Locale locale) {
        return NumberFormat.getCurrencyInstance(locale).format(Double.parseDouble(number));
    }

    public static boolean isNum(String str) {
        for (char temp : str.toCharArray()) {
            if (!Character.isDigit(temp)) {
                return false;
            }
        }
        return true;
    }

    public static String numberStringDelete(String str) {
        String tempStr = str;
        for (int i = 0; i < 10; i++) {
            tempStr = tempStr.replaceAll(Integer.toString(i), "");
        }
        return tempStr;
    }

    public static String bytes2HexString(byte[] buf) {
        StringBuilder strbuf = new StringBuilder(buf.length * 2);
        for (int i = 0; i < buf.length; i++) {
            if ((buf[i] & 255) < 16) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString(buf[i] & 255, 16));
        }
        return strbuf.toString();
    }

    public static String bytes2HexString(byte buf) {
        StringBuilder strbuf = new StringBuilder(2);
        if ((buf & 255) < 16) {
            strbuf.append("0");
        }
        strbuf.append(Long.toString(buf & 255, 16));
        return strbuf.toString();
    }

    public static byte[] hexString2Bytes(String str) {
        byte[] btRet = new byte[str.length() / 2];
        if (str.length() % 2 > 0) {
            throw new IndexOutOfBoundsException("Source string length must be even");
        }
        for (int i = 0; i < btRet.length; i++) {
            char chOne = str.charAt(i * 2);
            btRet[i] = (byte) (Character.digit(chOne, 16) * 16);
            char chOne2 = str.charAt((i * 2) + 1);
            btRet[i] = (byte) (btRet[i] + ((byte) Character.digit(chOne2, 16)));
        }
        return btRet;
    }

    public static String int2HexString(int intValue) {
        String hex1 = Integer.toHexString(intValue);
        int length = hex1.length();
        if (length != 8) {
            StringBuilder hex2 = new StringBuilder(8);
            for (int i = 0; i < 8 - length; i++) {
                hex2.append('0');
            }
            hex2.append(hex1);
            return hex2.toString();
        }
        return hex1;
    }

    public static String convertPhoneNumber(String str) {
        String result = str.replaceAll("-", "");
        if (isNum(result) && result.length() <= 11 && result.length() >= 10) {
            if (result.length() == 10) {
                return String.valueOf(result.substring(0, 3)) + "-" + result.substring(3, 6) + "-" + result.substring(6, 10);
            }
            return String.valueOf(result.substring(0, 3)) + "-" + result.substring(3, 7) + "-" + result.substring(7, 11);
        }
        return null;
    }

    public static String getAlphabetFromNumber(int number, int digit) {
        StringBuilder resultStringBuilder = new StringBuilder();
        int tempNumber = number;
        while (tempNumber > 0) {
            int remainder = (tempNumber % 26) + 65;
            tempNumber /= 26;
            resultStringBuilder.insert(0, (char) remainder);
        }
        int digitDiff = digit - resultStringBuilder.length();
        if (digitDiff > 0) {
            for (int i = 0; i < digitDiff; i++) {
                resultStringBuilder.insert(0, 'A');
            }
            String result = resultStringBuilder.toString();
            return result;
        }
        if (digitDiff >= 0) {
            return null;
        }
        String result2 = resultStringBuilder.toString().substring(Math.abs(digitDiff));
        return result2;
    }

    public static int getNumberFromAlphabet(String alphabet) {
        int returnValue = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            returnValue += (alphabet.charAt(alphabet.length() - (i + 1)) - 'A') * ((int) Math.pow(26.0d, i));
        }
        return returnValue;
    }

    public static int compareVersion(String compareVersion, String basisVersion, String regex) throws NumberFormatException {
        String[] compareVersions = compareVersion.split(regex);
        String[] basisVersions = basisVersion.split(regex);
        int compareLength = basisVersions.length;
        if (compareVersions.length < basisVersions.length) {
            compareLength = compareVersions.length;
        }
        for (int i = 0; i < compareLength; i++) {
            int compareVersionValue = Integer.parseInt(compareVersions[i]);
            int basisVersionValue = Integer.parseInt(basisVersions[i]);
            if (compareVersionValue > basisVersionValue) {
                return 1;
            }
            if (compareVersionValue < basisVersionValue) {
                return -1;
            }
        }
        if (compareVersions.length <= basisVersions.length || Integer.parseInt(compareVersions[compareLength]) <= 0) {
            return (compareVersions.length >= basisVersions.length || Integer.parseInt(basisVersions[compareLength]) <= 0) ? 0 : -1;
        }
        return 1;
    }

    public static Object checkNullObject(Object checkObject, Class<?> toClass) throws IllegalAccessException, InstantiationException {
        if (checkObject == null) {
            try {
                Object returnObject = toClass.newInstance();
                return returnObject;
            } catch (Exception e) {
                return null;
            }
        }
        return checkObject;
    }

    public static Object checkNullObject(Object checkObject, Class<?> toClass, Class<?>[] clsArr, Object[] initargs) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (checkObject == null) {
            try {
                Constructor<?> contructor = toClass.getConstructor(clsArr);
                Object returnObject = contructor.newInstance(initargs);
                return returnObject;
            } catch (Exception e) {
                return null;
            }
        }
        return checkObject;
    }

    public static byte[] unicodeToByte(String unicode) {
        byte[] unicodeBytes = new byte[unicode.length() * 2];
        for (int i = 0; i < unicode.length(); i++) {
            int tempUniCode = unicode.charAt(i) & 65535;
            unicodeBytes[i * 2] = (byte) (tempUniCode / 256);
            unicodeBytes[(i * 2) + 1] = (byte) (tempUniCode % 256);
        }
        return unicodeBytes;
    }

    public static String unicodeToHexString(String unicode) {
        StringBuilder uniCodeString = new StringBuilder();
        for (int i = 0; i < unicode.length(); i++) {
            int tempUniCode = unicode.charAt(i) & 65535;
            if (tempUniCode < 4096 && tempUniCode >= 256) {
                uniCodeString.append("0");
            } else if (tempUniCode < 256 && tempUniCode >= 16) {
                uniCodeString.append("00");
            } else if (tempUniCode < 16) {
                uniCodeString.append("000");
            }
            uniCodeString.append(Integer.toHexString(tempUniCode).toUpperCase());
        }
        return uniCodeString.toString();
    }

    public static String byteToUnicode(byte[] unicodeBytes) {
        if (unicodeBytes.length % 2 > 0) {
            throw new IndexOutOfBoundsException("Source string length must be even");
        }
        StringBuilder unicode = new StringBuilder();
        for (int i = 0; i < unicodeBytes.length; i += 2) {
            int unicodeInt = ((unicodeBytes[i] & 255) * 256) + (unicodeBytes[i + 1] & 255);
            unicode.append((char) unicodeInt);
        }
        return unicode.toString();
    }

    public static String hexStringToUnicode(String hexString) {
        if (hexString.length() % 4 > 0) {
            throw new IndexOutOfBoundsException("Source string length must be multiple of 4");
        }
        StringBuilder unicode = new StringBuilder();
        for (int i = 0; i < hexString.length(); i += 4) {
            int unicodeByte = (Character.digit(hexString.charAt(i), 16) * CodedOutputStream.DEFAULT_BUFFER_SIZE) + (Character.digit(hexString.charAt(i + 1), 16) * 256) + (Character.digit(hexString.charAt(i + 2), 16) * 16) + Character.digit(hexString.charAt(i + 3), 16);
            unicode.append((char) unicodeByte);
        }
        return unicode.toString();
    }

    public static byte[] changeEndian(byte[] before) {
        if (before.length % 2 > 0) {
            throw new IndexOutOfBoundsException("Source string length must be even");
        }
        byte[] after = new byte[before.length];
        for (int i = 0; i < before.length; i += 2) {
            after[i] = before[i + 1];
            after[i + 1] = before[i];
        }
        return after;
    }

    public static byte[] deleteEndNullByte(byte[] before) {
        int nullCount = 0;
        for (int i = before.length - 1; i >= 0 && before[i] == 0; i--) {
            nullCount++;
        }
        byte[] after = new byte[before.length - nullCount];
        System.arraycopy(before, 0, after, 0, after.length);
        return after;
    }

    public static byte[] deleteEndNullUnicodeByte(byte[] before) {
        int nullCount = 0;
        for (int i = before.length - 2; i >= 0 && before[i] == 0 && before[i + 1] == 0; i -= 2) {
            nullCount += 2;
        }
        byte[] after = new byte[before.length - nullCount];
        System.arraycopy(before, 0, after, 0, after.length);
        return after;
    }

    public static String getStackTraceString(Throwable throwable) {
        if (throwable == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        String string = stringWriter.toString();
        printWriter.close();
        return string;
    }

    public static String getInternationalCallNo(int countryCode, String phoneNo) {
        return phoneNo.charAt(0) == '0' ? String.valueOf(countryCode) + phoneNo.substring(1) : String.valueOf(countryCode) + phoneNo;
    }

    public static String getUpperCamelCase(String msg) {
        return String.valueOf(msg.substring(0, 1).toUpperCase()) + msg.substring(1);
    }

    public static String getLowerCamelCase(String msg) {
        return String.valueOf(msg.substring(0, 1).toLowerCase()) + msg.substring(1);
    }

    public static String classToString(Object obj) {
        if (obj == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(512);
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field fd : fields) {
                int modifiers = fd.getModifiers();
                if (!Modifier.isFinal(modifiers) || !Modifier.isStatic(modifiers)) {
                    if (Modifier.isPrivate(modifiers)) {
                        fd.setAccessible(true);
                    }
                    stringBuilder.append(fd.getName()).append('[').append(fd.get(obj)).append("] ");
                    if (Modifier.isPrivate(modifiers)) {
                        fd.setAccessible(false);
                    }
                }
            }
        } catch (Exception e) {
        }
        return stringBuilder.toString();
    }

    public static String toBinaryString(int intVal, boolean byteSeparated) {
        StringBuilder sbBinStr1 = new StringBuilder(48);
        StringBuilder sbBinStr2 = new StringBuilder(64);
        for (int ii = 0; ii < Integer.numberOfLeadingZeros(intVal); ii++) {
            sbBinStr1.append('0');
        }
        sbBinStr1.append(Integer.toBinaryString(intVal));
        if (!byteSeparated) {
            return sbBinStr1.toString();
        }
        sbBinStr2.append(sbBinStr1.substring(0, 8)).append(' ');
        sbBinStr2.append(sbBinStr1.substring(8, 16)).append(' ');
        sbBinStr2.append(sbBinStr1.substring(16, 24)).append(' ');
        sbBinStr2.append(sbBinStr1.substring(24, 32));
        return sbBinStr2.toString();
    }

    public static String removeServiceName(String userId) {
        int lastIndex = userId.lastIndexOf(64);
        return userId.substring(0, lastIndex);
    }

    public static String getNumberInString(String value, int size) {
        StringBuilder numberInString = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) {
                numberInString.append(value.charAt(i));
            }
        }
        int length = numberInString.length();
        if (length == 0 || length > size) {
            return null;
        }
        if (length < size) {
            for (int i2 = 0; i2 < size - length; i2++) {
                numberInString.insert(0, "0");
            }
        }
        return numberInString.toString();
    }
}
