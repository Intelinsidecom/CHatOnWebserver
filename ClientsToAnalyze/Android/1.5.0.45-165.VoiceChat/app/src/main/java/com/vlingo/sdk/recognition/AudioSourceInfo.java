package com.vlingo.sdk.recognition;

import com.vlingo.sdk.internal.util.StringUtils;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AudioSourceInfo {
    private String mFilename = null;
    private InputStream mInputStream = null;
    private String mText = null;
    private SourceFormat mFormat = null;
    private SourceType mType = null;

    public enum SourceFormat {
        AMR,
        PCM_16KHZ_16BIT,
        PCM_8KHZ_16BIT,
        PCM_16KHZ_16BIT_BE,
        PCM_8KHZ_16BIT_BE,
        PCM_AUTO,
        PLAIN_TEXT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static SourceFormat[] valuesCustom() {
            SourceFormat[] sourceFormatArrValuesCustom = values();
            int length = sourceFormatArrValuesCustom.length;
            SourceFormat[] sourceFormatArr = new SourceFormat[length];
            System.arraycopy(sourceFormatArrValuesCustom, 0, sourceFormatArr, 0, length);
            return sourceFormatArr;
        }
    }

    public enum SourceType {
        FILE,
        STREAM,
        BUFFER,
        STRING;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static SourceType[] valuesCustom() {
            SourceType[] sourceTypeArrValuesCustom = values();
            int length = sourceTypeArrValuesCustom.length;
            SourceType[] sourceTypeArr = new SourceType[length];
            System.arraycopy(sourceTypeArrValuesCustom, 0, sourceTypeArr, 0, length);
            return sourceTypeArr;
        }
    }

    private AudioSourceInfo() {
    }

    public static final AudioSourceInfo getFileSource(String filename, SourceFormat format) {
        if (StringUtils.isNullOrWhiteSpace(filename)) {
            throw new IllegalArgumentException("filename cannot be null or empty!");
        }
        if (format == null) {
            throw new IllegalArgumentException("format parameter cannot be null!");
        }
        AudioSourceInfo asi = new AudioSourceInfo();
        asi.mType = SourceType.FILE;
        asi.mFormat = format;
        asi.mFilename = filename;
        return asi;
    }

    public static AudioSourceInfo getStreamSource(InputStream inputStream, SourceFormat format) {
        if (inputStream == null) {
            throw new IllegalArgumentException("inputstream parameter cannot be null");
        }
        if (format == null) {
            throw new IllegalArgumentException("format parameter cannot be null!");
        }
        AudioSourceInfo asi = new AudioSourceInfo();
        asi.mType = SourceType.STREAM;
        asi.mInputStream = inputStream;
        asi.mFormat = format;
        return asi;
    }

    public static AudioSourceInfo getDataBufferSource(SourceFormat format) {
        if (format == null) {
            throw new IllegalArgumentException("format parameter cannot be null!");
        }
        AudioSourceInfo asi = new AudioSourceInfo();
        asi.mType = SourceType.BUFFER;
        asi.mFormat = format;
        return asi;
    }

    public static final AudioSourceInfo getStringSource(String text) {
        if (StringUtils.isNullOrWhiteSpace(text)) {
            throw new IllegalArgumentException("text cannot be null or empty!");
        }
        AudioSourceInfo asi = new AudioSourceInfo();
        asi.mType = SourceType.STRING;
        asi.mFormat = SourceFormat.PLAIN_TEXT;
        asi.mText = text;
        return asi;
    }

    public boolean isFile() {
        return this.mType == SourceType.FILE;
    }

    public boolean isStream() {
        return this.mType == SourceType.STREAM;
    }

    public boolean isDataBuffer() {
        return this.mType == SourceType.BUFFER;
    }

    public boolean isString() {
        return this.mType == SourceType.STRING;
    }

    public boolean isAMR() {
        return this.mFormat == SourceFormat.AMR;
    }

    public SourceType getType() {
        return this.mType;
    }

    public SourceFormat getFormat() {
        return this.mFormat;
    }

    public String getFilename() {
        return this.mFilename;
    }

    public InputStream getInputStream() {
        return this.mInputStream;
    }

    public String getText() {
        return this.mText;
    }
}
