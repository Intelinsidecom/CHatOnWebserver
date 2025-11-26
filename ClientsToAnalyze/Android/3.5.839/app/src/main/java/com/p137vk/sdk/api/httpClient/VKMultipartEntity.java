package com.p137vk.sdk.api.httpClient;

import android.hardware.motion.MotionRecognitionManager;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicHeader;

/* loaded from: classes.dex */
public class VKMultipartEntity extends AbstractHttpEntity {
    private static final String VK_BOUNDARY = "Boundary(======VK_SDK_%d======)";
    private String mBoundary = String.format(Locale.US, VK_BOUNDARY, Integer.valueOf(new Random().nextInt()));
    private File[] mFiles;

    public VKMultipartEntity(File[] fileArr) {
        this.mFiles = fileArr;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        long length = 0;
        for (int i = 0; i < this.mFiles.length; i++) {
            length = length + this.mFiles[i].length() + getFileDescription(r3, i).length();
        }
        return length + getBoundaryEnd().length();
    }

    @Override // org.apache.http.entity.AbstractHttpEntity, org.apache.http.HttpEntity
    public Header getContentType() {
        return new BasicHeader("Content-Type", String.format("multipart/form-data; boundary=%s", this.mBoundary));
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    private String getFileDescription(File file, int i) {
        String str = String.format(Locale.US, "file%d", Integer.valueOf(i + 1));
        return String.format("\r\n--%s\r\n", this.mBoundary) + String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s.%s\"\r\n", str, str, MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath())) + String.format("Content-Type: %s\r\n\r\n", getMimeType(file.getAbsolutePath()));
    }

    private String getBoundaryEnd() {
        return String.format("\r\n--%s--\r\n", this.mBoundary);
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        for (int i = 0; i < this.mFiles.length; i++) {
            File file = this.mFiles[i];
            outputStream.write(getFileDescription(file, i).getBytes("UTF-8"));
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[MotionRecognitionManager.EVENT_TILT_TO_UNLOCK];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 != -1) {
                    outputStream.write(bArr, 0, i2);
                }
            }
            fileInputStream.close();
        }
        outputStream.write(getBoundaryEnd().getBytes("UTF-8"));
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return true;
    }

    protected static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl == null) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
    }
}
