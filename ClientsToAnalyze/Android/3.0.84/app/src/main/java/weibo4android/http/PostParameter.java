package weibo4android.http;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PostParameter implements Serializable, Comparable {
    private static final String GIF = "image/gif";
    private static final String JPEG = "image/jpeg";
    private static final String OCTET = "application/octet-stream";
    private static final String PNG = "image/png";
    private static final long serialVersionUID = -8708108746980739212L;
    private File file;
    String name;
    String value;

    public PostParameter(String str, String str2) {
        this.file = null;
        this.name = str;
        this.value = str2;
    }

    public PostParameter(String str, double d) {
        this.file = null;
        this.name = str;
        this.value = String.valueOf(d);
    }

    public PostParameter(String str, int i) {
        this.file = null;
        this.name = str;
        this.value = String.valueOf(i);
    }

    public PostParameter(String str, File file) {
        this.file = null;
        this.name = str;
        this.file = file;
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

    public boolean isFile() {
        return this.file != null;
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

    public static boolean containsFile(PostParameter[] postParameterArr) {
        if (postParameterArr == null) {
            return false;
        }
        for (PostParameter postParameter : postParameterArr) {
            if (postParameter.isFile()) {
                return true;
            }
        }
        return false;
    }

    static boolean containsFile(List<PostParameter> list) {
        Iterator<PostParameter> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().isFile()) {
                return true;
            }
        }
        return false;
    }

    public static PostParameter[] getParameterArray(String str, String str2) {
        return new PostParameter[]{new PostParameter(str, str2)};
    }

    public static PostParameter[] getParameterArray(String str, int i) {
        return getParameterArray(str, String.valueOf(i));
    }

    public static PostParameter[] getParameterArray(String str, String str2, String str3, String str4) {
        return new PostParameter[]{new PostParameter(str, str2), new PostParameter(str3, str4)};
    }

    public static PostParameter[] getParameterArray(String str, int i, String str2, int i2) {
        return getParameterArray(str, String.valueOf(i), str2, String.valueOf(i2));
    }

    public int hashCode() {
        return (this.file != null ? this.file.hashCode() : 0) + (((this.name.hashCode() * 31) + this.value.hashCode()) * 31);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostParameter)) {
            return false;
        }
        PostParameter postParameter = (PostParameter) obj;
        if (this.file != null) {
            if (!this.file.equals(postParameter.file)) {
                return false;
            }
        } else if (postParameter.file != null) {
            return false;
        }
        return this.name.equals(postParameter.name) && this.value.equals(postParameter.value);
    }

    public String toString() {
        return "PostParameter{name='" + this.name + "', value='" + this.value + "', file=" + this.file + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        PostParameter postParameter = (PostParameter) obj;
        int iCompareTo = this.name.compareTo(postParameter.name);
        if (iCompareTo == 0) {
            return this.value.compareTo(postParameter.value);
        }
        return iCompareTo;
    }

    public static String encodeParameters(PostParameter[] postParameterArr) {
        if (postParameterArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < postParameterArr.length; i++) {
            if (postParameterArr[i].isFile()) {
                throw new IllegalArgumentException("parameter [" + postParameterArr[i].name + "]should be text");
            }
            if (i != 0) {
                stringBuffer.append("&");
            }
            try {
                stringBuffer.append(URLEncoder.encode(postParameterArr[i].name, "UTF-8")).append("=").append(URLEncoder.encode(postParameterArr[i].value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        return stringBuffer.toString();
    }
}
