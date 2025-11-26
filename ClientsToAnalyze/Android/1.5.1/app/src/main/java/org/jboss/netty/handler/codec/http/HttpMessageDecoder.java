package org.jboss.netty.handler.codec.http;

import com.sec.pns.msg.frontend.MsgFrontend;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.util.List;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.TooLongFrameException;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;

/* loaded from: classes.dex */
public abstract class HttpMessageDecoder extends ReplayingDecoder {
    static final /* synthetic */ boolean $assertionsDisabled;
    private long chunkSize;
    private ChannelBuffer content;
    private int headerSize;
    private final int maxChunkSize;
    private final int maxHeaderSize;
    private final int maxInitialLineLength;
    private HttpMessage message;

    public enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_VARIABLE_LENGTH_CONTENT_AS_CHUNKS,
        READ_FIXED_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT_AS_CHUNKS,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNKED_CONTENT_AS_CHUNKS,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER
    }

    static {
        $assertionsDisabled = !HttpMessageDecoder.class.desiredAssertionStatus();
    }

    protected HttpMessageDecoder() {
        this(4096, 8192, 8192);
    }

    protected HttpMessageDecoder(int i, int i2, int i3) {
        super(State.SKIP_CONTROL_CHARS, true);
        if (i <= 0) {
            throw new IllegalArgumentException("maxInitialLineLength must be a positive integer: " + i);
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxHeaderSize must be a positive integer: " + i2);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("maxChunkSize must be a positive integer: " + i3);
        }
        this.maxInitialLineLength = i;
        this.maxHeaderSize = i2;
        this.maxChunkSize = i3;
    }

    private int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    private int findNonWhitespace(String str, int i) {
        int i2 = i;
        while (i2 < str.length() && Character.isWhitespace(str.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    private int findWhitespace(String str, int i) {
        int i2 = i;
        while (i2 < str.length() && !Character.isWhitespace(str.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    private int getChunkSize(String str) {
        String strTrim = str.trim();
        for (int i = 0; i < strTrim.length(); i++) {
            char cCharAt = strTrim.charAt(i);
            if (cCharAt == ';' || Character.isWhitespace(cCharAt) || Character.isISOControl(cCharAt)) {
                strTrim = strTrim.substring(0, i);
                break;
            }
        }
        return Integer.parseInt(strTrim, 16);
    }

    private void readFixedLengthContent(ChannelBuffer channelBuffer) {
        long contentLength = HttpHeaders.getContentLength(this.message, -1L);
        if (!$assertionsDisabled && contentLength > 2147483647L) {
            throw new AssertionError();
        }
        if (this.content == null) {
            this.content = channelBuffer.readBytes((int) contentLength);
        } else {
            this.content.writeBytes(channelBuffer.readBytes((int) contentLength));
        }
    }

    private String readHeader(ChannelBuffer channelBuffer) throws TooLongFrameException {
        int i;
        StringBuilder sb = new StringBuilder(64);
        int i2 = this.headerSize;
        while (true) {
            char c = (char) channelBuffer.readByte();
            i = i2 + 1;
            switch (c) {
                case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                    break;
                case MsgFrontend.NotiElement.SESSION_INFO_FIELD_NUMBER /* 13 */:
                    c = (char) channelBuffer.readByte();
                    i++;
                    if (c == '\n') {
                        break;
                    }
                case 11:
                case '\f':
                default:
                    char c2 = c;
                    int i3 = i;
                    if (i3 >= this.maxHeaderSize) {
                        throw new TooLongFrameException("HTTP header is larger than " + this.maxHeaderSize + " bytes.");
                    }
                    sb.append(c2);
                    i2 = i3;
            }
        }
        this.headerSize = i;
        return sb.toString();
    }

    private State readHeaders(ChannelBuffer channelBuffer) throws TooLongFrameException {
        this.headerSize = 0;
        HttpMessage httpMessage = this.message;
        String header = readHeader(channelBuffer);
        if (header.length() != 0) {
            httpMessage.clearHeaders();
            String str = null;
            String header2 = header;
            String str2 = null;
            do {
                char cCharAt = header2.charAt(0);
                if (str == null || !(cCharAt == ' ' || cCharAt == '\t')) {
                    if (str != null) {
                        httpMessage.addHeader(str, str2);
                    }
                    String[] strArrSplitHeader = splitHeader(header2);
                    str = strArrSplitHeader[0];
                    str2 = strArrSplitHeader[1];
                } else {
                    str2 = str2 + ' ' + header2.trim();
                }
                header2 = readHeader(channelBuffer);
            } while (header2.length() != 0);
            if (str != null) {
                httpMessage.addHeader(str, str2);
            }
        }
        return isContentAlwaysEmpty(httpMessage) ? State.SKIP_CONTROL_CHARS : httpMessage.isChunked() ? State.READ_CHUNK_SIZE : HttpHeaders.getContentLength(httpMessage, -1L) >= 0 ? State.READ_FIXED_LENGTH_CONTENT : State.READ_VARIABLE_LENGTH_CONTENT;
    }

    private String readLine(ChannelBuffer channelBuffer, int i) throws TooLongFrameException {
        StringBuilder sb = new StringBuilder(64);
        int i2 = 0;
        while (true) {
            byte b = channelBuffer.readByte();
            if (b == 13) {
                if (channelBuffer.readByte() == 10) {
                    return sb.toString();
                }
            } else {
                if (b == 10) {
                    return sb.toString();
                }
                if (i2 >= i) {
                    throw new TooLongFrameException("An HTTP line is larger than " + i + " bytes.");
                }
                i2++;
                sb.append((char) b);
            }
        }
    }

    private HttpChunkTrailer readTrailingHeaders(ChannelBuffer channelBuffer) throws TooLongFrameException {
        String str;
        this.headerSize = 0;
        String header = readHeader(channelBuffer);
        String str2 = null;
        if (header.length() == 0) {
            return HttpChunk.LAST_CHUNK;
        }
        DefaultHttpChunkTrailer defaultHttpChunkTrailer = new DefaultHttpChunkTrailer();
        String str3 = header;
        while (true) {
            char cCharAt = str3.charAt(0);
            if (str2 == null || !(cCharAt == ' ' || cCharAt == '\t')) {
                String[] strArrSplitHeader = splitHeader(str3);
                String str4 = strArrSplitHeader[0];
                if (!str4.equalsIgnoreCase("Content-Length") && !str4.equalsIgnoreCase(HttpHeaders.Names.TRANSFER_ENCODING) && !str4.equalsIgnoreCase(HttpHeaders.Names.TRAILER)) {
                    defaultHttpChunkTrailer.addHeader(str4, strArrSplitHeader[1]);
                }
                str = str4;
            } else {
                List headers = defaultHttpChunkTrailer.getHeaders(str2);
                if (headers.size() != 0) {
                    int size = headers.size() - 1;
                    headers.set(size, ((String) headers.get(size)) + str3.trim());
                }
                str = str2;
            }
            String header2 = readHeader(channelBuffer);
            if (header2.length() == 0) {
                return defaultHttpChunkTrailer;
            }
            str3 = header2;
            str2 = str;
        }
    }

    private Object reset() {
        HttpMessage httpMessage = this.message;
        ChannelBuffer channelBuffer = this.content;
        if (channelBuffer != null) {
            httpMessage.setContent(channelBuffer);
            this.content = null;
        }
        this.message = null;
        checkpoint(State.SKIP_CONTROL_CHARS);
        return httpMessage;
    }

    private void skipControlCharacters(ChannelBuffer channelBuffer) {
        while (true) {
            char unsignedByte = (char) channelBuffer.readUnsignedByte();
            if (!Character.isISOControl(unsignedByte) && !Character.isWhitespace(unsignedByte)) {
                channelBuffer.readerIndex(channelBuffer.readerIndex() - 1);
                return;
            }
        }
    }

    private String[] splitHeader(String str) {
        int length = str.length();
        int iFindNonWhitespace = findNonWhitespace(str, 0);
        int i = iFindNonWhitespace;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ':' || Character.isWhitespace(cCharAt)) {
                break;
            }
            i++;
        }
        int i2 = i;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (str.charAt(i2) == ':') {
                i2++;
                break;
            }
            i2++;
        }
        int iFindNonWhitespace2 = findNonWhitespace(str, i2);
        return iFindNonWhitespace2 == length ? new String[]{str.substring(iFindNonWhitespace, i), ""} : new String[]{str.substring(iFindNonWhitespace, i), str.substring(iFindNonWhitespace2, findEndOfString(str))};
    }

    private String[] splitInitialLine(String str) {
        int iFindNonWhitespace = findNonWhitespace(str, 0);
        int iFindWhitespace = findWhitespace(str, iFindNonWhitespace);
        int iFindNonWhitespace2 = findNonWhitespace(str, iFindWhitespace);
        int iFindWhitespace2 = findWhitespace(str, iFindNonWhitespace2);
        int iFindNonWhitespace3 = findNonWhitespace(str, iFindWhitespace2);
        int iFindEndOfString = findEndOfString(str);
        String[] strArr = new String[3];
        strArr[0] = str.substring(iFindNonWhitespace, iFindWhitespace);
        strArr[1] = str.substring(iFindNonWhitespace2, iFindWhitespace2);
        strArr[2] = iFindNonWhitespace3 < iFindEndOfString ? str.substring(iFindNonWhitespace3, iFindEndOfString) : "";
        return strArr;
    }

    protected abstract HttpMessage createMessage(String[] strArr);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jboss.netty.handler.codec.replay.ReplayingDecoder
    public Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, State state) throws TooLongFrameException {
        long j;
        DefaultHttpChunk defaultHttpChunk;
        long j2;
        DefaultHttpChunk defaultHttpChunk2;
        switch (C08001.f4577x5907aa57[state.ordinal()]) {
            case 1:
                readFixedLengthContent(channelBuffer);
                return reset();
            case 2:
                if (this.content == null) {
                    this.content = ChannelBuffers.dynamicBuffer(channel.getConfig().getBufferFactory());
                }
                this.content.writeBytes(channelBuffer.readBytes(channelBuffer.readableBytes()));
                return reset();
            case 3:
                try {
                    skipControlCharacters(channelBuffer);
                    checkpoint(State.READ_INITIAL);
                } finally {
                    checkpoint();
                }
            case 4:
                String[] strArrSplitInitialLine = splitInitialLine(readLine(channelBuffer, this.maxInitialLineLength));
                if (strArrSplitInitialLine.length < 3) {
                    checkpoint(State.SKIP_CONTROL_CHARS);
                    return null;
                }
                this.message = createMessage(strArrSplitInitialLine);
                checkpoint(State.READ_HEADER);
            case 5:
                State headers = readHeaders(channelBuffer);
                checkpoint(headers);
                if (headers == State.READ_CHUNK_SIZE) {
                    this.message.setChunked(true);
                    return this.message;
                }
                if (headers == State.SKIP_CONTROL_CHARS) {
                    this.message.removeHeader(HttpHeaders.Names.TRANSFER_ENCODING);
                    return this.message;
                }
                long contentLength = HttpHeaders.getContentLength(this.message, -1L);
                if (contentLength == 0 || (contentLength == -1 && isDecodingRequest())) {
                    this.content = ChannelBuffers.EMPTY_BUFFER;
                    return reset();
                }
                switch (headers) {
                    case READ_FIXED_LENGTH_CONTENT:
                        if (contentLength > this.maxChunkSize || HttpHeaders.is100ContinueExpected(this.message)) {
                            checkpoint(State.READ_FIXED_LENGTH_CONTENT_AS_CHUNKS);
                            this.message.setChunked(true);
                            this.chunkSize = HttpHeaders.getContentLength(this.message, -1L);
                            return this.message;
                        }
                        return null;
                    case READ_VARIABLE_LENGTH_CONTENT:
                        if (channelBuffer.readableBytes() > this.maxChunkSize || HttpHeaders.is100ContinueExpected(this.message)) {
                            checkpoint(State.READ_VARIABLE_LENGTH_CONTENT_AS_CHUNKS);
                            this.message.setChunked(true);
                            return this.message;
                        }
                        return null;
                    default:
                        throw new IllegalStateException("Unexpected state: " + headers);
                }
            case 6:
                DefaultHttpChunk defaultHttpChunk3 = new DefaultHttpChunk(channelBuffer.readBytes(Math.min(this.maxChunkSize, channelBuffer.readableBytes())));
                if (!channelBuffer.readable()) {
                    reset();
                    if (!defaultHttpChunk3.isLast()) {
                        return new Object[]{defaultHttpChunk3, HttpChunk.LAST_CHUNK};
                    }
                }
                return defaultHttpChunk3;
            case 7:
                long j3 = this.chunkSize;
                if (j3 > this.maxChunkSize) {
                    j2 = j3 - this.maxChunkSize;
                    defaultHttpChunk2 = new DefaultHttpChunk(channelBuffer.readBytes(this.maxChunkSize));
                } else {
                    if (!$assertionsDisabled && j3 > 2147483647L) {
                        throw new AssertionError();
                    }
                    j2 = 0;
                    defaultHttpChunk2 = new DefaultHttpChunk(channelBuffer.readBytes((int) j3));
                }
                this.chunkSize = j2;
                if (j2 != 0) {
                    return defaultHttpChunk2;
                }
                reset();
                return !defaultHttpChunk2.isLast() ? new Object[]{defaultHttpChunk2, HttpChunk.LAST_CHUNK} : defaultHttpChunk2;
            case 8:
                int chunkSize = getChunkSize(readLine(channelBuffer, this.maxInitialLineLength));
                this.chunkSize = chunkSize;
                if (chunkSize == 0) {
                    checkpoint(State.READ_CHUNK_FOOTER);
                    return null;
                }
                if (chunkSize > this.maxChunkSize) {
                    checkpoint(State.READ_CHUNKED_CONTENT_AS_CHUNKS);
                } else {
                    checkpoint(State.READ_CHUNKED_CONTENT);
                }
            case 9:
                if (!$assertionsDisabled && this.chunkSize > 2147483647L) {
                    throw new AssertionError();
                }
                DefaultHttpChunk defaultHttpChunk4 = new DefaultHttpChunk(channelBuffer.readBytes((int) this.chunkSize));
                checkpoint(State.READ_CHUNK_DELIMITER);
                return defaultHttpChunk4;
            case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                long j4 = this.chunkSize;
                if (j4 > this.maxChunkSize) {
                    j = j4 - this.maxChunkSize;
                    defaultHttpChunk = new DefaultHttpChunk(channelBuffer.readBytes(this.maxChunkSize));
                } else {
                    if (!$assertionsDisabled && j4 > 2147483647L) {
                        throw new AssertionError();
                    }
                    j = 0;
                    defaultHttpChunk = new DefaultHttpChunk(channelBuffer.readBytes((int) j4));
                }
                this.chunkSize = j;
                if (j == 0) {
                    checkpoint(State.READ_CHUNK_DELIMITER);
                }
                if (!defaultHttpChunk.isLast()) {
                    return defaultHttpChunk;
                }
                break;
            case 11:
                while (true) {
                    byte b = channelBuffer.readByte();
                    if (b == 13) {
                        if (channelBuffer.readByte() == 10) {
                            checkpoint(State.READ_CHUNK_SIZE);
                            return null;
                        }
                    } else if (b == 10) {
                        checkpoint(State.READ_CHUNK_SIZE);
                        return null;
                    }
                }
            case 12:
                HttpChunkTrailer trailingHeaders = readTrailingHeaders(channelBuffer);
                if (this.maxChunkSize == 0) {
                    return reset();
                }
                reset();
                return trailingHeaders;
            default:
                throw new Error("Shouldn't reach here.");
        }
    }

    protected boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (httpMessage instanceof HttpResponse) {
            int code = ((HttpResponse) httpMessage).getStatus().getCode();
            if (code < 200) {
                return true;
            }
            switch (code) {
                case 204:
                case 205:
                case 304:
                    break;
            }
            return true;
        }
        return false;
    }

    protected abstract boolean isDecodingRequest();
}
