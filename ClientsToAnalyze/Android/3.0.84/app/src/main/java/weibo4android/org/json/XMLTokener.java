package weibo4android.org.json;

import com.sec.spp.push.Config;
import java.util.HashMap;

/* loaded from: classes.dex */
public class XMLTokener extends JSONTokener {
    public static final HashMap entity = new HashMap(8);

    static {
        entity.put("amp", XML.AMP);
        entity.put("apos", XML.APOS);
        entity.put("gt", XML.f13763GT);
        entity.put("lt", XML.f13764LT);
        entity.put("quot", XML.QUOT);
    }

    public XMLTokener(String str) {
        super(str);
    }

    public String nextCDATA() throws JSONException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            if (next == 0) {
                throw syntaxError("Unclosed CDATA");
            }
            stringBuffer.append(next);
            int length = stringBuffer.length() - 3;
            if (length >= 0 && stringBuffer.charAt(length) == ']' && stringBuffer.charAt(length + 1) == ']' && stringBuffer.charAt(length + 2) == '>') {
                stringBuffer.setLength(length);
                return stringBuffer.toString();
            }
        }
    }

    public Object nextContent() {
        char next;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        if (next == 0) {
            return null;
        }
        if (next == '<') {
            return XML.f13764LT;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (next != '<' && next != 0) {
            if (next == '&') {
                stringBuffer.append(nextEntity(next));
            } else {
                stringBuffer.append(next);
            }
            next = next();
        }
        back();
        return stringBuffer.toString().trim();
    }

    public Object nextEntity(char c) throws JSONException {
        char next;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            next = next();
            if (!Character.isLetterOrDigit(next) && next != '#') {
                break;
            }
            stringBuffer.append(Character.toLowerCase(next));
        }
        if (next != ';') {
            throw syntaxError("Missing ';' in XML entity: &" + ((Object) stringBuffer));
        }
        String string = stringBuffer.toString();
        Object obj = entity.get(string);
        return obj != null ? obj : c + string + Config.KEYVALUE_SPLIT;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object nextMeta() throws JSONException {
        char next;
        char next2;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        switch (next) {
            case 0:
                throw syntaxError("Misshaped meta tag");
            case '!':
                return XML.BANG;
            case '\"':
            case '\'':
                do {
                    next2 = next();
                    if (next2 == 0) {
                        throw syntaxError("Unterminated string");
                    }
                } while (next2 != next);
                return Boolean.TRUE;
            case '/':
                return XML.SLASH;
            case '<':
                return XML.f13764LT;
            case '=':
                return XML.f13762EQ;
            case '>':
                return XML.f13763GT;
            case '?':
                return XML.QUEST;
            default:
                while (true) {
                    char next3 = next();
                    if (Character.isWhitespace(next3)) {
                        return Boolean.TRUE;
                    }
                    switch (next3) {
                        case 0:
                        case '!':
                        case '\"':
                        case '\'':
                        case '/':
                        case '<':
                        case '=':
                        case '>':
                        case '?':
                            back();
                            return Boolean.TRUE;
                    }
                }
        }
    }

    public Object nextToken() throws JSONException {
        char next;
        do {
            next = next();
        } while (Character.isWhitespace(next));
        switch (next) {
            case 0:
                throw syntaxError("Misshaped element");
            case '!':
                return XML.BANG;
            case '\"':
            case '\'':
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    char next2 = next();
                    if (next2 == 0) {
                        throw syntaxError("Unterminated string");
                    }
                    if (next2 == next) {
                        return stringBuffer.toString();
                    }
                    if (next2 == '&') {
                        stringBuffer.append(nextEntity(next2));
                    } else {
                        stringBuffer.append(next2);
                    }
                }
            case '/':
                return XML.SLASH;
            case '<':
                throw syntaxError("Misplaced '<'");
            case '=':
                return XML.f13762EQ;
            case '>':
                return XML.f13763GT;
            case '?':
                return XML.QUEST;
            default:
                StringBuffer stringBuffer2 = new StringBuffer();
                while (true) {
                    stringBuffer2.append(next);
                    next = next();
                    if (Character.isWhitespace(next)) {
                        return stringBuffer2.toString();
                    }
                    switch (next) {
                        case 0:
                            return stringBuffer2.toString();
                        case '!':
                        case '/':
                        case '=':
                        case '>':
                        case '?':
                        case '[':
                        case ']':
                            back();
                            return stringBuffer2.toString();
                        case '\"':
                        case '\'':
                        case '<':
                            throw syntaxError("Bad character in a name");
                    }
                }
        }
    }

    public boolean skipPast(String str) {
        boolean z;
        int length = str.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            char next = next();
            if (next == 0) {
                return false;
            }
            cArr[i] = next;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z = true;
                    break;
                }
                if (cArr[i3] != str.charAt(i4)) {
                    z = false;
                    break;
                }
                i3++;
                if (i3 >= length) {
                    i3 -= length;
                }
                i4++;
            }
            if (z) {
                return true;
            }
            char next2 = next();
            if (next2 == 0) {
                return false;
            }
            cArr[i2] = next2;
            i2++;
            if (i2 >= length) {
                i2 -= length;
            }
        }
    }
}
