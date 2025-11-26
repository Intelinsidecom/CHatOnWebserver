package com.sec.chaton.multimedia.doc;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.sec.chaton.util.C3250y;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: FileExplorerFragment.java */
/* renamed from: com.sec.chaton.multimedia.doc.d */
/* loaded from: classes.dex */
class AsyncTaskC1797d extends AsyncTask<String, Integer, ArrayList<C1799f>> implements Comparator<C1799f> {

    /* renamed from: a */
    final /* synthetic */ FileExplorerFragment f6669a;

    /* renamed from: b */
    private HashMap<String, C1802i> f6670b;

    private AsyncTaskC1797d(FileExplorerFragment fileExplorerFragment) {
        this.f6669a = fileExplorerFragment;
    }

    /* synthetic */ AsyncTaskC1797d(FileExplorerFragment fileExplorerFragment, C1796c c1796c) {
        this(fileExplorerFragment);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.f6669a.f6649g.isShowing()) {
            this.f6669a.f6649g.show();
        }
        this.f6670b = new HashMap<>();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayList<C1799f> doInBackground(String... strArr) {
        File[] fileArrListFiles;
        String str = strArr[0];
        ArrayList<C1799f> arrayList = new ArrayList<>();
        if (C3250y.f11734b) {
            C3250y.m11450b("fullPath: " + str, FileExplorerFragment.f6643a);
        }
        File file = new File(str);
        m7407b(str);
        m7406a(str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                EnumC1794a enumC1794aM7390a = this.f6669a.m7390a(file2);
                if (enumC1794aM7390a != EnumC1794a.UNKNOWN) {
                    C1799f c1799f = new C1799f();
                    c1799f.m7414a(enumC1794aM7390a);
                    c1799f.m7416a(file2.getName());
                    c1799f.m7413a(file2.length());
                    c1799f.m7418b(file2.lastModified());
                    c1799f.m7419b(file2.getAbsolutePath());
                    arrayList.add(c1799f);
                }
            }
            Iterator<C1799f> it = arrayList.iterator();
            while (it.hasNext()) {
                C1799f next = it.next();
                if (next.m7412a() == EnumC1794a.IMAGE || next.m7412a() == EnumC1794a.VIDEO) {
                    if (this.f6670b.containsKey(next.m7422e())) {
                        next.m7415a(this.f6670b.get(next.m7422e()));
                    }
                }
            }
        }
        Collections.sort(arrayList, this);
        return arrayList;
    }

    /* renamed from: a */
    private void m7406a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/");
        String strNextToken = null;
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String strM7404a = TextUtils.isEmpty(strNextToken) ? null : m7404a(uri, new String[]{"_data", "bucket_id"}, "bucket_display_name = '" + strNextToken + "'", str);
        if (!TextUtils.isEmpty(strM7404a)) {
            m7405a(uri, new String[]{"_data", "_id"}, "bucket_id = '" + strM7404a + "'");
        }
    }

    /* renamed from: b */
    private void m7407b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/");
        String strNextToken = null;
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String strM7404a = TextUtils.isEmpty(strNextToken) ? null : m7404a(uri, new String[]{"_data", "bucket_id"}, "bucket_display_name = '" + strNextToken + "'", str);
        if (!TextUtils.isEmpty(strM7404a)) {
            m7405a(uri, new String[]{"_data", "_id", "orientation"}, "bucket_id = '" + strM7404a + "'");
        }
    }

    /* renamed from: a */
    private void m7405a(Uri uri, String[] strArr, String str) {
        Cursor cursorQuery;
        if (strArr != null && strArr.length >= 2 && this.f6669a.f6652j != null && (cursorQuery = this.f6669a.f6652j.getContentResolver().query(uri, strArr, str, null, null)) != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
                long j = cursorQuery.getLong(cursorQuery.getColumnIndex(strArr[1]));
                int i = -1;
                if (strArr.length > 2) {
                    i = cursorQuery.getInt(cursorQuery.getColumnIndex(strArr[2]));
                }
                if (C3250y.f11734b) {
                    C3250y.m11450b("data : " + string + ", id: " + j, FileExplorerFragment.f6643a);
                }
                this.f6670b.put(string, new C1802i(j, i));
            }
            cursorQuery.close();
        }
    }

    /* renamed from: a */
    private String m7404a(Uri uri, String[] strArr, String str, String str2) {
        Cursor cursorQuery;
        String strSubstring;
        String string = null;
        if (strArr != null && strArr.length >= 2 && this.f6669a.f6652j != null && (cursorQuery = this.f6669a.f6652j.getContentResolver().query(uri, strArr, str, null, null)) != null) {
            while (true) {
                if (!cursorQuery.moveToNext()) {
                    break;
                }
                String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
                if (TextUtils.isEmpty(string2)) {
                    strSubstring = null;
                } else {
                    try {
                        strSubstring = string2.substring(0, string2.lastIndexOf("/"));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        strSubstring = null;
                    }
                }
                if (str2.equals(strSubstring)) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[1]));
                    break;
                }
            }
            cursorQuery.close();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ArrayList<C1799f> arrayList) {
        this.f6669a.f6649g.hide();
        this.f6669a.f6644b.clear();
        this.f6669a.f6644b.addAll(arrayList);
        this.f6669a.f6645c.notifyDataSetChanged();
        this.f6669a.f6651i.setSelection(0);
        super.onPostExecute(arrayList);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C1799f c1799f, C1799f c1799f2) {
        if (!(c1799f.m7412a() == EnumC1794a.DIRECTORY && c1799f2.m7412a() == EnumC1794a.DIRECTORY) && (c1799f.m7412a() == EnumC1794a.DIRECTORY || c1799f2.m7412a() == EnumC1794a.DIRECTORY)) {
            return c1799f.m7412a() == EnumC1794a.DIRECTORY ? -1 : 1;
        }
        return c1799f.m7417b().compareTo(c1799f2.m7417b());
    }
}
