package twitter4j.internal.http;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class HttpParameter implements Serializable, Comparable {
    private static final String GIF = "image/gif";
    private static final String JPEG = "image/jpeg";
    private static final String OCTET = "application/octet-stream";
    private static final String PNG = "image/png";
    private static final long serialVersionUID = -8708108746980739212L;
    private File file;
    private InputStream fileBody;
    private String name;
    private String value;

    public HttpParameter(String str, String str2) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = str2;
    }

    public HttpParameter(String str, File file) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.file = file;
    }

    public HttpParameter(String str, String str2, InputStream inputStream) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.file = new File(str2);
        this.fileBody = inputStream;
    }

    public HttpParameter(String str, int i) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(i);
    }

    public HttpParameter(String str, long j) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(j);
    }

    public HttpParameter(String str, double d) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(d);
    }

    public HttpParameter(String str, boolean z) {
        this.name = null;
        this.value = null;
        this.file = null;
        this.fileBody = null;
        this.name = str;
        this.value = String.valueOf(z);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public File getFile() {
        return this.file;
    }

    public InputStream getFileBody() {
        return this.fileBody;
    }

    public boolean isFile() {
        return this.file != null;
    }

    public boolean hasFileBody() {
        return this.fileBody != null;
    }

    public String getContentType() {
        if (!isFile()) {
            throw new IllegalStateException("not a file");
        }
        String name = this.file.getName();
        if (-1 == name.lastIndexOf(".")) {
            return OCTET;
        }
        String lowerCase = name.substring(name.lastIndexOf(".") + 1).toLowerCase();
        if (lowerCase.length() == 3) {
            if ("gif".equals(lowerCase)) {
                return GIF;
            }
            if ("png".equals(lowerCase)) {
                return PNG;
            }
            if ("jpg".equals(lowerCase)) {
                return JPEG;
            }
            return OCTET;
        }
        if (lowerCase.length() == 4 && "jpeg".equals(lowerCase)) {
            return JPEG;
        }
        return OCTET;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpParameter)) {
            return false;
        }
        HttpParameter httpParameter = (HttpParameter) obj;
        if (this.file == null ? httpParameter.file != null : !this.file.equals(httpParameter.file)) {
            return false;
        }
        if (this.fileBody == null ? httpParameter.fileBody != null : !this.fileBody.equals(httpParameter.fileBody)) {
            return false;
        }
        if (!this.name.equals(httpParameter.name)) {
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(httpParameter.value)) {
                return true;
            }
        } else if (httpParameter.value == null) {
            return true;
        }
        return false;
    }

    public static boolean containsFile(HttpParameter[] httpParameterArr) {
        if (httpParameterArr == null) {
            return false;
        }
        for (HttpParameter httpParameter : httpParameterArr) {
            if (httpParameter.isFile()) {
                return true;
            }
        }
        return false;
    }

    static boolean containsFile(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((HttpParameter) it.next()).isFile()) {
                return true;
            }
        }
        return false;
    }

    public static HttpParameter[] getParameterArray(String str, String str2) {
        return new HttpParameter[]{new HttpParameter(str, str2)};
    }

    public static HttpParameter[] getParameterArray(String str, int i) {
        return getParameterArray(str, String.valueOf(i));
    }

    public static HttpParameter[] getParameterArray(String str, String str2, String str3, String str4) {
        return new HttpParameter[]{new HttpParameter(str, str2), new HttpParameter(str3, str4)};
    }

    public static HttpParameter[] getParameterArray(String str, int i, String str2, int i2) {
        return getParameterArray(str, String.valueOf(i), str2, String.valueOf(i2));
    }

    public int hashCode() {
        return (((this.file != null ? this.file.hashCode() : 0) + (((this.value != null ? this.value.hashCode() : 0) + (this.name.hashCode() * 31)) * 31)) * 31) + (this.fileBody != null ? this.fileBody.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("PostParameter{name='").append(this.name).append('\'').append(", value='").append(this.value).append('\'').append(", file=").append(this.file).append(", fileBody=").append(this.fileBody).append('}').toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        HttpParameter httpParameter = (HttpParameter) obj;
        int iCompareTo = this.name.compareTo(httpParameter.name);
        if (iCompareTo == 0) {
            return this.value.compareTo(httpParameter.value);
        }
        return iCompareTo;
    }

    public static String encodeParameters(HttpParameter[] httpParameterArr) {
        if (httpParameterArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < httpParameterArr.length; i++) {
            if (httpParameterArr[i].isFile()) {
                throw new IllegalArgumentException(new StringBuffer().append("parameter [").append(httpParameterArr[i].name).append("]should be text").toString());
            }
            if (i != 0) {
                stringBuffer.append("&");
            }
            stringBuffer.append(encode(httpParameterArr[i].name)).append("=").append(encode(httpParameterArr[i].value));
        }
        return stringBuffer.toString();
    }

    public static String encode(String str) throws UnsupportedEncodingException {
        String strEncode = null;
        try {
            strEncode = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        StringBuffer stringBuffer = new StringBuffer(strEncode.length());
        int i = 0;
        while (i < strEncode.length()) {
            char cCharAt = strEncode.charAt(i);
            if (cCharAt == '*') {
                stringBuffer.append("%2A");
            } else if (cCharAt == '+') {
                stringBuffer.append("%20");
            } else if (cCharAt == '%' && i + 1 < strEncode.length() && strEncode.charAt(i + 1) == '7' && strEncode.charAt(i + 2) == 'E') {
                stringBuffer.append('~');
                i += 2;
            } else {
                stringBuffer.append(cCharAt);
            }
            i++;
        }
        return stringBuffer.toString();
    }
}
