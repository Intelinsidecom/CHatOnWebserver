package com.vlingo.sdk.internal.http.custom;

import com.coolots.sso.util.ChatONVAPII;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.CompressUtils;
import com.vlingo.sdk.internal.util.StringUtils;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class MPOutputStream {
    private static final String ivEndLine = "\r\n";
    private String ivBoundary;
    private DataOutputStream ivDout;
    private Logger log = Logger.getLogger(MPOutputStream.class);

    public MPOutputStream(DataOutputStream dout, String boundary) throws IOException {
        this.log.debug("Create MPOoutputStream dout " + dout + " boundary " + boundary);
        if (dout == null) {
            throw new RuntimeException("Output stream is null");
        }
        this.ivDout = dout;
        this.ivBoundary = boundary;
    }

    private void write(String str) throws IOException {
        this.log.debug("Write>>" + str);
        this.ivDout.write(StringUtils.convertStringToBytes(str));
    }

    public void writeBoundary() throws IOException {
        write(String.valueOf(this.ivBoundary) + ivEndLine);
    }

    public void writeHeader(String name, String value) throws IOException {
        write(String.valueOf(name) + ChatONVAPII.USERID_DELEMETER + value + ivEndLine);
    }

    public void writeEndHeader() throws IOException {
        write(ivEndLine);
    }

    public void writeEndFieldValue() throws IOException {
        write(ivEndLine);
    }

    public void writeFieldHeader(String name, String type, String encoding) throws IOException {
        writeHeader("Content-Disposition", "form-data; name=\"" + name + "\"");
        writeHeader("Content-Type", type);
        if (encoding != null) {
            writeHeader("Content-Encoding", encoding);
        }
        writeEndHeader();
    }

    public void writeField(String name, String type, String value) throws IOException {
        writeFieldHeader(name, type, null);
        write(value);
        writeEndFieldValue();
        writeBoundary();
    }

    public void writeDataField(String name, String type, byte[] data) throws Throwable {
        writeDataField(name, type, data, false);
    }

    public void writeDataField(String name, String type, byte[] data, boolean compress) throws Throwable {
        if (compress) {
            writeFieldHeader(name, type, "deflate");
            byte[] compressedBytes = CompressUtils.deflate(data);
            write(compressedBytes, 0, compressedBytes.length);
        } else {
            writeFieldHeader(name, type, null);
            write(data, 0, data.length);
        }
        writeEndFieldValue();
        writeBoundary();
    }

    public void writeFileFieldHeader(String name, String type) throws IOException {
        writeHeader("Content-Disposition", "form-data; name=\"" + name + "\"; filename=\"" + name + "\"");
        writeHeader("Content-Type", type);
        writeHeader("Content-Transfer-Encoding", "binary");
        writeEndHeader();
    }

    public void write(byte[] data, int offset, int length) throws IOException {
        this.log.debug("Write buf offset:" + offset + " len:" + length);
        this.ivDout.write(data, offset, length);
    }

    public void flush() throws IOException {
        this.log.debug("flush");
        this.ivDout.flush();
    }

    public void close() throws IOException {
        this.log.debug("close");
        this.ivDout.close();
    }
}
