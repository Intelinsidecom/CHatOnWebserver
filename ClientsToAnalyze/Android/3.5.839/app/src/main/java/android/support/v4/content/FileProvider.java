package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: a */
    private static final String[] f283a = {"_display_name", "_size"};

    /* renamed from: b */
    private static final File f284b = new File("/");

    /* renamed from: c */
    private static HashMap<String, InterfaceC0092d> f285c = new HashMap<>();

    /* renamed from: d */
    private InterfaceC0092d f286d;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.f286d = m314a(context, providerInfo.authority);
    }

    /* renamed from: a */
    public static Uri m313a(Context context, String str, File file) {
        return m314a(context, str).mo337a(file);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileMo338a = this.f286d.mo338a(uri);
        if (strArr == null) {
            strArr = f283a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str3 = strArr[i2];
            if ("_display_name".equals(str3)) {
                strArr3[i3] = "_display_name";
                i = i3 + 1;
                objArr[i3] = fileMo338a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i3] = "_size";
                i = i3 + 1;
                objArr[i3] = Long.valueOf(fileMo338a.length());
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        String[] strArrM317a = m317a(strArr3, i3);
        Object[] objArrM316a = m316a(objArr, i3);
        MatrixCursor matrixCursor = new MatrixCursor(strArrM317a, 1);
        matrixCursor.addRow(objArrM316a);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileMo338a = this.f286d.mo338a(uri);
        int iLastIndexOf = fileMo338a.getName().lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileMo338a.getName().substring(iLastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f286d.mo338a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.f286d.mo338a(uri), m312a(str));
    }

    /* renamed from: a */
    private static InterfaceC0092d m314a(Context context, String str) {
        InterfaceC0092d interfaceC0092dM318b;
        synchronized (f285c) {
            interfaceC0092dM318b = f285c.get(str);
            if (interfaceC0092dM318b == null) {
                try {
                    try {
                        interfaceC0092dM318b = m318b(context, str);
                        f285c.put(str, interfaceC0092dM318b);
                    } catch (XmlPullParserException e) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                    }
                } catch (IOException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return interfaceC0092dM318b;
    }

    /* renamed from: b */
    private static InterfaceC0092d m318b(Context context, String str) throws IOException {
        File fileM315a;
        C0093e c0093e = new C0093e(str);
        XmlResourceParser xmlResourceParserLoadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next != 1) {
                if (next == 2) {
                    String name = xmlResourceParserLoadXmlMetaData.getName();
                    String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                    String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                    if ("root-path".equals(name)) {
                        fileM315a = m315a(f284b, attributeValue2);
                    } else if ("files-path".equals(name)) {
                        fileM315a = m315a(context.getFilesDir(), attributeValue2);
                    } else if ("cache-path".equals(name)) {
                        fileM315a = m315a(context.getCacheDir(), attributeValue2);
                    } else {
                        fileM315a = "external-path".equals(name) ? m315a(Environment.getExternalStorageDirectory(), attributeValue2) : null;
                    }
                    if (fileM315a != null) {
                        c0093e.m339a(attributeValue, fileM315a);
                    }
                }
            } else {
                return c0093e;
            }
        }
    }

    /* renamed from: a */
    private static int m312a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* renamed from: a */
    private static File m315a(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            String str = strArr[i];
            i++;
            file2 = str != null ? new File(file2, str) : file2;
        }
        return file2;
    }

    /* renamed from: a */
    private static String[] m317a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: a */
    private static Object[] m316a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
