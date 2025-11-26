package weibo4android.org.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes.dex */
public class JSONTokener {
    private int index;
    private char lastChar;
    private Reader reader;
    private boolean useLastChar;

    public JSONTokener(Reader reader) {
        this.reader = reader.markSupported() ? reader : new BufferedReader(reader);
        this.useLastChar = false;
        this.index = 0;
    }

    public JSONTokener(String str) {
        this(new StringReader(str));
    }

    public void back() throws JSONException {
        if (this.useLastChar || this.index <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.index--;
        this.useLastChar = true;
    }

    public static int dehexchar(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        return -1;
    }

    public boolean more() throws JSONException {
        if (next() == 0) {
            return false;
        }
        back();
        return true;
    }

    public char next() throws JSONException, IOException {
        if (this.useLastChar) {
            this.useLastChar = false;
            if (this.lastChar != 0) {
                this.index++;
            }
            return this.lastChar;
        }
        try {
            int i = this.reader.read();
            if (i <= 0) {
                this.lastChar = (char) 0;
                return (char) 0;
            }
            this.index++;
            this.lastChar = (char) i;
            return this.lastChar;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }

    public char next(char c) throws JSONException, IOException {
        char next = next();
        if (next != c) {
            throw syntaxError("Expected '" + c + "' and instead saw '" + next + "'");
        }
        return next;
    }

    public String next(int i) throws JSONException, IOException {
        int i2 = 0;
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        if (this.useLastChar) {
            this.useLastChar = false;
            cArr[0] = this.lastChar;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int i3 = this.reader.read(cArr, i2, i - i2);
                if (i3 == -1) {
                    break;
                }
                i2 += i3;
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        this.index += i2;
        if (i2 < i) {
            throw syntaxError("Substring bounds error");
        }
        this.lastChar = cArr[i - 1];
        return new String(cArr);
    }

    public char nextClean() throws JSONException, IOException {
        char next;
        do {
            next = next();
            if (next == 0) {
                break;
            }
        } while (next <= ' ');
        return next;
    }

    public String nextString(char c) throws JSONException, IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            switch (next) {
                case 0:
                case '\n':
                case '\r':
                    throw syntaxError("Unterminated string");
                case '\\':
                    char next2 = next();
                    switch (next2) {
                        case 'b':
                            stringBuffer.append('\b');
                            break;
                        case 'f':
                            stringBuffer.append('\f');
                            break;
                        case 'n':
                            stringBuffer.append('\n');
                            break;
                        case 'r':
                            stringBuffer.append('\r');
                            break;
                        case 't':
                            stringBuffer.append('\t');
                            break;
                        case 'u':
                            stringBuffer.append((char) Integer.parseInt(next(4), 16));
                            break;
                        case 'x':
                            stringBuffer.append((char) Integer.parseInt(next(2), 16));
                            break;
                        default:
                            stringBuffer.append(next2);
                            break;
                    }
                default:
                    if (next == c) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append(next);
                    break;
            }
        }
    }

    public String nextTo(char c) throws JSONException, IOException {
        char next;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            next = next();
            if (next == c || next == 0 || next == '\n' || next == '\r') {
                break;
            }
            stringBuffer.append(next);
        }
        if (next != 0) {
            back();
        }
        return stringBuffer.toString().trim();
    }

    public String nextTo(String str) throws JSONException, IOException {
        char next;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            next = next();
            if (str.indexOf(next) >= 0 || next == 0 || next == '\n' || next == '\r') {
                break;
            }
            stringBuffer.append(next);
        }
        if (next != 0) {
            back();
        }
        return stringBuffer.toString().trim();
    }

    public Object nextValue() throws JSONException, IOException {
        char cNextClean = nextClean();
        switch (cNextClean) {
            case '\"':
            case '\'':
                return nextString(cNextClean);
            case '(':
            case '[':
                back();
                return new JSONArray(this);
            case '{':
                back();
                return new JSONObject(this);
            default:
                StringBuffer stringBuffer = new StringBuffer();
                while (cNextClean >= ' ' && ",:]}/\\\"[{;=#".indexOf(cNextClean) < 0) {
                    stringBuffer.append(cNextClean);
                    cNextClean = next();
                }
                back();
                String strTrim = stringBuffer.toString().trim();
                if (strTrim.equals("")) {
                    throw syntaxError("Missing value");
                }
                return JSONObject.stringToValue(strTrim);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r3.reader.reset();
        r3.index = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public char skipTo(char r4) throws weibo4android.org.json.JSONException, java.io.IOException {
        /*
            r3 = this;
            int r1 = r3.index     // Catch: java.io.IOException -> L1e
            java.io.Reader r0 = r3.reader     // Catch: java.io.IOException -> L1e
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.mark(r2)     // Catch: java.io.IOException -> L1e
        La:
            char r0 = r3.next()     // Catch: java.io.IOException -> L1e
            if (r0 != 0) goto L18
            java.io.Reader r2 = r3.reader     // Catch: java.io.IOException -> L1e
            r2.reset()     // Catch: java.io.IOException -> L1e
            r3.index = r1     // Catch: java.io.IOException -> L1e
        L17:
            return r0
        L18:
            if (r0 != r4) goto La
            r3.back()
            goto L17
        L1e:
            r0 = move-exception
            weibo4android.org.json.JSONException r1 = new weibo4android.org.json.JSONException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: weibo4android.org.json.JSONTokener.skipTo(char):char");
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + toString());
    }

    public String toString() {
        return " at character " + this.index;
    }
}
