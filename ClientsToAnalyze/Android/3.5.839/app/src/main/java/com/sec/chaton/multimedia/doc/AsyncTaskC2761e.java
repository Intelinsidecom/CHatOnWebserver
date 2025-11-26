package com.sec.chaton.multimedia.doc;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.sec.chaton.util.C4904y;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/* compiled from: FileExplorerFragment.java */
/* renamed from: com.sec.chaton.multimedia.doc.e */
/* loaded from: classes.dex */
class AsyncTaskC2761e extends AsyncTask<String, Integer, ArrayList<C2763g>> implements Comparator<C2763g> {

    /* renamed from: a */
    final /* synthetic */ FileExplorerFragment f9961a;

    /* renamed from: b */
    private HashMap<String, C2766j> f9962b;

    private AsyncTaskC2761e(FileExplorerFragment fileExplorerFragment) {
        this.f9961a = fileExplorerFragment;
    }

    /* synthetic */ AsyncTaskC2761e(FileExplorerFragment fileExplorerFragment, C2760d c2760d) {
        this(fileExplorerFragment);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        if (!this.f9961a.f9938g.isShowing()) {
            this.f9961a.f9938g.show();
        }
        this.f9962b = new HashMap<>();
        super.onPreExecute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ArrayList<C2763g> doInBackground(String... strArr) {
        File[] fileArrListFiles;
        String str = strArr[0];
        ArrayList<C2763g> arrayList = new ArrayList<>();
        if (C4904y.f17872b) {
            C4904y.m18639b("fullPath: " + str, FileExplorerFragment.f9932a);
        }
        File file = new File(str);
        m11601b(str);
        m11600a(str);
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                EnumC2758b enumC2758bM11584a = this.f9961a.m11584a(file2);
                if (enumC2758bM11584a != EnumC2758b.UNKNOWN) {
                    C2763g c2763g = new C2763g();
                    c2763g.m11608a(enumC2758bM11584a);
                    c2763g.m11610a(file2.getName());
                    c2763g.m11607a(file2.length());
                    c2763g.m11612b(file2.lastModified());
                    c2763g.m11613b(file2.getAbsolutePath());
                    arrayList.add(c2763g);
                }
            }
            Iterator<C2763g> it = arrayList.iterator();
            while (it.hasNext()) {
                C2763g next = it.next();
                if (next.m11606a() == EnumC2758b.IMAGE || next.m11606a() == EnumC2758b.VIDEO) {
                    if (this.f9962b.containsKey(next.m11616e())) {
                        next.m11609a(this.f9962b.get(next.m11616e()));
                    }
                }
            }
        }
        Collections.sort(arrayList, this);
        return arrayList;
    }

    /* renamed from: a */
    private void m11600a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/");
        String strNextToken = null;
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String strM11598a = TextUtils.isEmpty(strNextToken) ? null : m11598a(uri, new String[]{"_data", "bucket_id"}, "bucket_display_name = '" + strNextToken + "'", str);
        if (!TextUtils.isEmpty(strM11598a)) {
            m11599a(uri, new String[]{"_data", "_id"}, "bucket_id = '" + strM11598a + "'");
        }
    }

    /* renamed from: b */
    private void m11601b(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/");
        String strNextToken = null;
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String strM11598a = TextUtils.isEmpty(strNextToken) ? null : m11598a(uri, new String[]{"_data", "bucket_id"}, "bucket_display_name = '" + strNextToken + "'", str);
        if (!TextUtils.isEmpty(strM11598a)) {
            m11599a(uri, new String[]{"_data", "_id", "orientation"}, "bucket_id = '" + strM11598a + "'");
        }
    }

    /* renamed from: a */
    private void m11599a(Uri uri, String[] strArr, String str) {
        Cursor cursorQuery;
        if (strArr != null && strArr.length >= 2 && this.f9961a.f9941j != null && (cursorQuery = this.f9961a.f9941j.getContentResolver().query(uri, strArr, str, null, null)) != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(strArr[0]));
                long j = cursorQuery.getLong(cursorQuery.getColumnIndex(strArr[1]));
                int i = -1;
                if (strArr.length > 2) {
                    i = cursorQuery.getInt(cursorQuery.getColumnIndex(strArr[2]));
                }
                if (C4904y.f17872b) {
                    C4904y.m18639b("data : " + string + ", id: " + j, FileExplorerFragment.f9932a);
                }
                this.f9962b.put(string, new C2766j(j, i));
            }
            cursorQuery.close();
        }
    }

    /* renamed from: a */
    private String m11598a(Uri uri, String[] strArr, String str, String str2) {
        Cursor cursorQuery;
        String strSubstring;
        String string = null;
        if (strArr != null && strArr.length >= 2 && this.f9961a.f9941j != null && (cursorQuery = this.f9961a.f9941j.getContentResolver().query(uri, strArr, str, null, null)) != null) {
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
    public void onPostExecute(ArrayList<C2763g> arrayList) {
        this.f9961a.f9938g.hide();
        this.f9961a.f9933b.clear();
        this.f9961a.f9933b.addAll(arrayList);
        this.f9961a.f9934c.notifyDataSetChanged();
        this.f9961a.f9940i.setSelection(0);
        super.onPostExecute(arrayList);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(C2763g c2763g, C2763g c2763g2) {
        if (!(c2763g.m11606a() == EnumC2758b.DIRECTORY && c2763g2.m11606a() == EnumC2758b.DIRECTORY) && (c2763g.m11606a() == EnumC2758b.DIRECTORY || c2763g2.m11606a() == EnumC2758b.DIRECTORY)) {
            return c2763g.m11606a() == EnumC2758b.DIRECTORY ? -1 : 1;
        }
        return c2763g.m11611b().compareTo(c2763g2.m11611b());
    }
}
