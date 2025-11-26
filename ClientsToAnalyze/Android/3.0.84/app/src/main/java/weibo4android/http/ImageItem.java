package weibo4android.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ImageItem {
    private String ImageType;
    private byte[] content;
    private String name;

    public ImageItem(String str, byte[] bArr) {
        String imageType = getImageType(bArr);
        if (imageType != null && (imageType.equalsIgnoreCase("image/gif") || imageType.equalsIgnoreCase("image/png") || imageType.equalsIgnoreCase("image/jpeg"))) {
            this.content = bArr;
            this.name = str;
            this.ImageType = imageType;
            return;
        }
        throw new IllegalStateException("Unsupported image type, Only Suport JPG ,GIF,PNG!");
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getName() {
        return this.name;
    }

    public String getImageType() {
        return this.ImageType;
    }

    public static String getImageType(File file) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        String imageType = null;
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            imageType = getImageType(fileInputStream);
                        } catch (IOException e) {
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return imageType;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        fileInputStream = null;
                    } catch (Throwable th3) {
                        fileInputStream = null;
                        th = th3;
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                }
            } catch (IOException e4) {
            }
        }
        return imageType;
    }

    public static String getImageType(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[8];
            inputStream.read(bArr);
            return getImageType(bArr);
        } catch (IOException e) {
            return null;
        }
    }

    public static String getImageType(byte[] bArr) {
        if (isJPEG(bArr)) {
            return "image/jpeg";
        }
        if (isGIF(bArr)) {
            return "image/gif";
        }
        if (isPNG(bArr)) {
            return "image/png";
        }
        if (isBMP(bArr)) {
            return "application/x-bmp";
        }
        return null;
    }

    private static boolean isJPEG(byte[] bArr) {
        if (bArr.length < 2) {
            return false;
        }
        return bArr[0] == -1 && bArr[1] == -40;
    }

    private static boolean isGIF(byte[] bArr) {
        if (bArr.length < 6) {
            return false;
        }
        return bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (bArr[4] == 55 || bArr[4] == 57) && bArr[5] == 97;
    }

    private static boolean isPNG(byte[] bArr) {
        if (bArr.length < 8) {
            return false;
        }
        return bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    private static boolean isBMP(byte[] bArr) {
        if (bArr.length < 2) {
            return false;
        }
        return bArr[0] == 66 && bArr[1] == 77;
    }
}
