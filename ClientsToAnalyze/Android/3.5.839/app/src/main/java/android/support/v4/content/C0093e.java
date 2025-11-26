package android.support.v4.content;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FileProvider.java */
/* renamed from: android.support.v4.content.e */
/* loaded from: classes.dex */
class C0093e implements InterfaceC0092d {

    /* renamed from: a */
    private final String f305a;

    /* renamed from: b */
    private final HashMap<String, File> f306b = new HashMap<>();

    public C0093e(String str) {
        this.f305a = str;
    }

    /* renamed from: a */
    public void m339a(String str, File file) throws IOException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        try {
            this.f306b.put(str, file.getCanonicalFile());
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
        }
    }

    @Override // android.support.v4.content.InterfaceC0092d
    /* renamed from: a */
    public Uri mo337a(File file) throws IOException {
        String strSubstring;
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry<String, File> entry = null;
            for (Map.Entry<String, File> entry2 : this.f306b.entrySet()) {
                String path = entry2.getValue().getPath();
                if (!canonicalPath.startsWith(path) || (entry != null && path.length() <= entry.getValue().getPath().length())) {
                    entry2 = entry;
                }
                entry = entry2;
            }
            if (entry == null) {
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            }
            String path2 = entry.getValue().getPath();
            if (path2.endsWith("/")) {
                strSubstring = canonicalPath.substring(path2.length());
            } else {
                strSubstring = canonicalPath.substring(path2.length() + 1);
            }
            return new Uri.Builder().scheme("content").authority(this.f305a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(strSubstring, "/")).build();
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }

    @Override // android.support.v4.content.InterfaceC0092d
    /* renamed from: a */
    public File mo338a(Uri uri) throws IOException {
        String encodedPath = uri.getEncodedPath();
        int iIndexOf = encodedPath.indexOf(47, 1);
        String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
        String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
        File file = this.f306b.get(strDecode);
        if (file == null) {
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
        File file2 = new File(file, strDecode2);
        try {
            File canonicalFile = file2.getCanonicalFile();
            if (!canonicalFile.getPath().startsWith(file.getPath())) {
                throw new SecurityException("Resolved path jumped beyond configured root");
            }
            return canonicalFile;
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
        }
    }
}
