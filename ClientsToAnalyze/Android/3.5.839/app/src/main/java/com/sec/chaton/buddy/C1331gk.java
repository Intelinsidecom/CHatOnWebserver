package com.sec.chaton.buddy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p131f.C4999c;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5048n;
import com.sec.widget.C5179v;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: BuddyProfileImageHistoryManager.java */
/* renamed from: com.sec.chaton.buddy.gk */
/* loaded from: classes.dex */
public class C1331gk {

    /* renamed from: a */
    private static C1331gk f4883a = null;

    /* renamed from: i */
    private static Paint f4884i;

    /* renamed from: j */
    private static Paint f4885j;

    /* renamed from: b */
    private final Context f4886b;

    /* renamed from: e */
    private InterfaceC1336gp f4889e;

    /* renamed from: c */
    private final String f4887c = "list.txt";

    /* renamed from: d */
    private final String f4888d = "timestamp.txt";

    /* renamed from: f */
    private int f4890f = 0;

    /* renamed from: g */
    private final int f4891g = 5;

    /* renamed from: h */
    private Bitmap[] f4892h = new Bitmap[5];

    /* renamed from: a */
    public static C1331gk m7453a(Context context) {
        if (f4883a == null) {
            f4883a = new C1331gk(context);
        }
        return f4883a;
    }

    private C1331gk(Context context) {
        this.f4886b = context;
    }

    /* renamed from: a */
    public void m7467a(String str) {
        ArrayList<HashMap<String, String>> arrayListM7473d = m7473d(str);
        if (arrayListM7473d.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayListM7473d.size()) {
                    HashMap<String, String> map = arrayListM7473d.get(i2);
                    if (map.containsKey(Spam.ACTIVITY_CANCEL)) {
                        String str2 = map.get(Spam.ACTIVITY_CANCEL);
                        File file = new File(this.f4886b.getCacheDir() + "/" + str + "/" + str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        String str3 = this.f4886b.getCacheDir() + "/profilehistory/" + str + "/";
                        File file2 = new File(str3, "buddy_f_" + str + "_" + str2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        File file3 = new File(str3, "buddy_t_" + str + "_" + str2);
                        if (file3.exists()) {
                            file3.delete();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public void m7470b(String str) {
        String[] list;
        C4904y.m18646e("deleteImage : " + str, "BuddyProfileImageHistoryManager");
        if (str != null) {
            try {
                File file = new File(this.f4886b.getFilesDir(), str + ".jpeg_");
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(this.f4886b.getCacheDir() + "/" + str + "/");
                if (file2.exists() && (list = file2.list()) != null) {
                    for (String str2 : list) {
                        File file3 = new File(this.f4886b.getCacheDir() + "/" + str + "/" + str2);
                        if (file3.exists() && !file3.isDirectory()) {
                            file3.delete();
                        }
                    }
                }
                File file4 = new File(this.f4886b.getCacheDir() + "/profilehistory/" + str + "/");
                if (file4.exists()) {
                    C5048n.m19193a(file4);
                }
            } catch (Exception e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    public void m7468a(String str, String str2) {
        C4904y.m18646e("deleteImageMain : " + str + ", " + str2, "BuddyProfileImageHistoryManager");
        if (str != null && str2 != null) {
            File file = new File(this.f4886b.getCacheDir() + "/" + str + "/", str2);
            if (file.exists()) {
                file.delete();
            }
            String str3 = this.f4886b.getCacheDir() + "/profilehistory/" + str + "/";
            File file2 = new File(str3, "buddy_f_" + str + "_" + str2);
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(str3, "buddy_t_" + str + "_" + str2);
            if (file3.exists()) {
                file3.delete();
            }
        }
    }

    /* renamed from: a */
    public void m7463a(C1337gq c1337gq, C1337gq c1337gq2, C1337gq c1337gq3, C1337gq c1337gq4, ImageView imageView, String str, InterfaceC1336gp interfaceC1336gp) {
        this.f4889e = interfaceC1336gp;
        m7456a(imageView, str);
        if (!m7461b(c1337gq, c1337gq2, c1337gq3, c1337gq4, str)) {
            Bitmap bitmapM7451a = m7451a(this.f4886b, str);
            if (bitmapM7451a != null) {
                c1337gq.m7482a().setImageBitmap(bitmapM7451a);
            } else {
                c1337gq.m7482a().setImageBitmap(m7459b(c1337gq.m7482a().getContext()));
            }
        }
    }

    /* renamed from: a */
    public void m7465a(C1337gq c1337gq, C1337gq c1337gq2, C1337gq c1337gq3, C1337gq c1337gq4, String str, InterfaceC1336gp interfaceC1336gp) {
        this.f4889e = interfaceC1336gp;
        if (!m7461b(c1337gq, c1337gq2, c1337gq3, c1337gq4, str)) {
            Bitmap bitmapM7451a = m7451a(this.f4886b, str);
            if (bitmapM7451a != null) {
                c1337gq.m7482a().setImageBitmap(bitmapM7451a);
            } else {
                this.f4889e.mo7396a();
                c1337gq.m7482a().setImageBitmap(m7459b(c1337gq.m7482a().getContext()));
            }
        }
    }

    /* renamed from: a */
    public void m7464a(C1337gq c1337gq, C1337gq c1337gq2, C1337gq c1337gq3, C1337gq c1337gq4, String str) {
        if (c1337gq.m7485b() != null) {
            c1337gq.m7482a().setImageBitmap(m7459b(c1337gq.m7482a().getContext()));
            c1337gq.m7484a(false);
        }
        if (c1337gq2.m7485b() != null) {
            c1337gq2.m7482a().setVisibility(8);
            c1337gq2.m7484a(false);
        }
        if (c1337gq3.m7485b() != null) {
            c1337gq3.m7482a().setVisibility(8);
            c1337gq3.m7484a(false);
        }
        if (c1337gq4.m7485b() != null) {
            c1337gq4.m7482a().setVisibility(8);
            c1337gq4.m7484a(false);
        }
        m7470b(str);
    }

    /* renamed from: a */
    public void m7466a(C1337gq c1337gq, C1337gq c1337gq2, C1337gq c1337gq3, String str, int i) {
        if (i == 0) {
            if (c1337gq.m7485b() != null) {
                c1337gq.m7482a().setVisibility(8);
                c1337gq.m7484a(false);
            }
            if (c1337gq2.m7485b() != null) {
                c1337gq2.m7482a().setVisibility(8);
                c1337gq2.m7484a(false);
            }
            if (c1337gq3.m7485b() != null) {
                c1337gq3.m7482a().setVisibility(8);
                c1337gq3.m7484a(false);
                return;
            }
            return;
        }
        if (i == 1) {
            if (c1337gq2.m7485b() != null) {
                c1337gq2.m7482a().setVisibility(8);
                c1337gq2.m7484a(false);
            }
            if (c1337gq3.m7485b() != null) {
                c1337gq3.m7482a().setVisibility(8);
                c1337gq3.m7484a(false);
                return;
            }
            return;
        }
        if (i == 2 && c1337gq3.m7485b() != null) {
            c1337gq3.m7482a().setVisibility(8);
            c1337gq3.m7484a(false);
        }
    }

    /* renamed from: b */
    private void m7460b(String str, ArrayList<String> arrayList) {
        File[] fileArrListFiles;
        int length;
        boolean z;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                int iIndexOf = arrayList.get(i).indexOf(":");
                if (iIndexOf > 0) {
                    arrayList2.add(arrayList.get(i).substring(iIndexOf + 1));
                }
            }
            File file = new File(this.f4886b.getCacheDir() + "/" + str + "/");
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null && (length = fileArrListFiles.length) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < arrayList2.size()) {
                            if (!fileArrListFiles[i2].getName().equals(arrayList2.get(i3))) {
                                i3++;
                            } else {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        File file2 = new File(fileArrListFiles[i2].toString());
                        if (file2.exists() && !fileArrListFiles[i2].getName().equals("list.txt") && !fileArrListFiles[i2].getName().equals("timestamp.txt")) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m7469a(String str, ArrayList<String> arrayList) throws Throwable {
        String simpleName;
        String str2 = this.f4886b.getCacheDir() + "/" + str + "/list.txt";
        String str3 = this.f4886b.getCacheDir() + "/" + str + "/";
        File file = new File(str2);
        File file2 = new File(str3);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (!file2.exists()) {
                    file2.mkdir();
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str2));
                int i = 0;
                while (true) {
                    try {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        bufferedWriter2.write(arrayList.get(i2));
                        bufferedWriter2.newLine();
                        i = i2 + 1;
                    } catch (Exception e) {
                        e = e;
                        bufferedWriter = bufferedWriter2;
                        C4904y.m18635a(e, getClass().getSimpleName());
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e2) {
                                e = e2;
                                simpleName = getClass().getSimpleName();
                                C4904y.m18635a(e, simpleName);
                                m7460b(str, arrayList);
                            }
                        }
                        m7460b(str, arrayList);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e3) {
                                C4904y.m18635a(e3, getClass().getSimpleName());
                            }
                        }
                        throw th;
                    }
                }
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e4) {
                        e = e4;
                        simpleName = getClass().getSimpleName();
                        C4904y.m18635a(e, simpleName);
                        m7460b(str, arrayList);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
        m7460b(str, arrayList);
    }

    /* renamed from: b */
    public void m7471b(String str, String str2) throws Throwable {
        String simpleName;
        String str3 = this.f4886b.getCacheDir() + "/" + str + "/timestamp.txt";
        String str4 = this.f4886b.getCacheDir() + "/" + str + "/";
        File file = new File(str3);
        File file2 = new File(str4);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(str3));
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e) {
                            e = e;
                            simpleName = getClass().getSimpleName();
                            C4904y.m18635a(e, simpleName);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    C4904y.m18635a(e, getClass().getSimpleName());
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            e = e3;
                            simpleName = getClass().getSimpleName();
                            C4904y.m18635a(e, simpleName);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            C4904y.m18635a(e4, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* renamed from: c */
    public String m7472c(String str) throws Throwable {
        DataInputStream dataInputStream;
        String line;
        Exception e;
        String simpleName;
        String str2 = this.f4886b.getCacheDir() + "/" + str + "/timestamp.txt";
        DataInputStream dataInputStreamExists = new File(str2).exists();
        try {
            if (dataInputStreamExists != 0) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(str2));
                    try {
                        line = new BufferedReader(new InputStreamReader(dataInputStream)).readLine();
                        if (line == null) {
                            line = null;
                        }
                    } catch (Exception e2) {
                        line = null;
                        e = e2;
                    }
                } catch (Exception e3) {
                    dataInputStream = null;
                    line = null;
                    e = e3;
                } catch (Throwable th) {
                    th = th;
                    dataInputStreamExists = 0;
                    if (dataInputStreamExists != 0) {
                        try {
                            dataInputStreamExists.close();
                        } catch (IOException e4) {
                            C4904y.m18635a(e4, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
                try {
                    dataInputStream.close();
                    dataInputStreamExists = dataInputStream;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                            dataInputStreamExists = dataInputStream;
                        } catch (IOException e5) {
                            e = e5;
                            simpleName = getClass().getSimpleName();
                            C4904y.m18635a(e, simpleName);
                            return line;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    C4904y.m18635a(e, getClass().getSimpleName());
                    dataInputStreamExists = dataInputStream;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                            dataInputStreamExists = dataInputStream;
                        } catch (IOException e7) {
                            e = e7;
                            simpleName = getClass().getSimpleName();
                            C4904y.m18635a(e, simpleName);
                            return line;
                        }
                    }
                    return line;
                }
                return line;
            }
            return Spam.ACTIVITY_CANCEL;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* renamed from: d */
    public ArrayList<HashMap<String, String>> m7473d(String str) throws Throwable {
        DataInputStream dataInputStream;
        String simpleName;
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        String str2 = this.f4886b.getCacheDir() + "/" + str + "/list.txt";
        DataInputStream dataInputStreamExists = new File(str2).exists();
        try {
            if (dataInputStreamExists != 0) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(str2));
                } catch (Exception e) {
                    e = e;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    dataInputStreamExists = 0;
                    if (dataInputStreamExists != 0) {
                        try {
                            dataInputStreamExists.close();
                        } catch (IOException e2) {
                            C4904y.m18635a(e2, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        int iIndexOf = line.indexOf(":");
                        if (iIndexOf > 0) {
                            HashMap<String, String> map = new HashMap<>();
                            map.put(Character.toString(line.charAt(0)), line.substring(iIndexOf + 1));
                            arrayList.add(map);
                        }
                    }
                    dataInputStream.close();
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e3) {
                            e = e3;
                            simpleName = getClass().getSimpleName();
                            C4904y.m18635a(e, simpleName);
                            return arrayList;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    C4904y.m18635a(e, getClass().getSimpleName());
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e5) {
                            e = e5;
                            simpleName = getClass().getSimpleName();
                            C4904y.m18635a(e, simpleName);
                            return arrayList;
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    private boolean m7461b(C1337gq c1337gq, C1337gq c1337gq2, C1337gq c1337gq3, C1337gq c1337gq4, String str) throws Throwable {
        m7454a();
        ArrayList<HashMap<String, String>> arrayListM7473d = m7473d(str);
        int size = arrayListM7473d.size();
        if (arrayListM7473d.size() <= 0) {
            return false;
        }
        int i = 0;
        boolean z = false;
        while (i < arrayListM7473d.size()) {
            HashMap<String, String> map = arrayListM7473d.get(i);
            if (map.containsKey(Spam.ACTIVITY_CANCEL)) {
                String str2 = map.get(Spam.ACTIVITY_CANCEL);
                z = true;
                new AsyncTaskC1332gl(this, new File(this.f4886b.getCacheDir() + "/" + str + "/" + str2), c1337gq, str2, size).execute(new Void[0]);
            } else if (map.containsKey(Spam.ACTIVITY_REPORT)) {
                String str3 = map.get(Spam.ACTIVITY_REPORT);
                new AsyncTaskC1333gm(this, new File(this.f4886b.getCacheDir() + "/" + str + "/" + str3), c1337gq2, str3, size).execute(new Void[0]);
            } else if (map.containsKey(Spam.ACTIVITY_CHECK)) {
                String str4 = map.get(Spam.ACTIVITY_CHECK);
                new AsyncTaskC1334gn(this, new File(this.f4886b.getCacheDir() + "/" + str + "/" + str4), c1337gq3, str4, size).execute(new Void[0]);
            } else if (map.containsKey("3")) {
                String str5 = map.get("3");
                new AsyncTaskC1335go(this, new File(this.f4886b.getCacheDir() + "/" + str + "/" + str5), c1337gq4, str5, size).execute(new Void[0]);
            }
            i++;
            z = z;
        }
        return z;
    }

    /* renamed from: a */
    private void m7454a() {
        this.f4890f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7455a(int i) {
        this.f4890f++;
        if (this.f4890f == i) {
            this.f4889e.mo7396a();
        }
    }

    /* renamed from: a */
    private void m7456a(ImageView imageView, String str) {
        C5007c c5007c = new C5007c();
        File file = new File((this.f4886b.getCacheDir() + "/" + str + "/coverstory/") + "coverstory.jpg");
        if (!file.exists()) {
            C4904y.m18639b("loadCoverStoryImages !tmpFile.exists(). loadDefaultCoverStory()", "BuddyProfileImageHistoryManager");
            m7458a(imageView);
        } else if (imageView != null) {
            new C4999c().m18976a(file).m18977a(c5007c, imageView);
            C4904y.m18639b("loadCoverStoryImages set CoverStory", "BuddyProfileImageHistoryManager");
        } else {
            C4904y.m18639b("loadCoverStoryImages bitmap is null. loadDefaultCoverStory", "BuddyProfileImageHistoryManager");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* renamed from: a */
    private Bitmap m7451a(Context context, String str) throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        String simpleName;
        Bitmap bitmapDecodeStream = null;
        String strM7462e = m7462e(str);
        ?? Exists = new File(context.getFilesDir(), strM7462e).exists();
        try {
            if (Exists != 0) {
                try {
                    fileInputStreamOpenFileInput = context.openFileInput(strM7462e);
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
                        Exists = fileInputStreamOpenFileInput;
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                                Exists = fileInputStreamOpenFileInput;
                            } catch (IOException e) {
                                e = e;
                                simpleName = getClass().getSimpleName();
                                C4904y.m18635a(e, simpleName);
                                return bitmapDecodeStream;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        C4904y.m18635a(e, getClass().getSimpleName());
                        Exists = fileInputStreamOpenFileInput;
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                                Exists = fileInputStreamOpenFileInput;
                            } catch (IOException e3) {
                                e = e3;
                                simpleName = getClass().getSimpleName();
                                C4904y.m18635a(e, simpleName);
                                return bitmapDecodeStream;
                            }
                        }
                        return bitmapDecodeStream;
                    } catch (OutOfMemoryError e4) {
                        e = e4;
                        C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
                        C4904y.m18635a(e, getClass().getSimpleName());
                        Exists = fileInputStreamOpenFileInput;
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                                Exists = fileInputStreamOpenFileInput;
                            } catch (IOException e5) {
                                e = e5;
                                simpleName = getClass().getSimpleName();
                                C4904y.m18635a(e, simpleName);
                                return bitmapDecodeStream;
                            }
                        }
                        return bitmapDecodeStream;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileInputStreamOpenFileInput = null;
                } catch (OutOfMemoryError e7) {
                    e = e7;
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th) {
                    Exists = 0;
                    th = th;
                    if (Exists != 0) {
                        try {
                            Exists.close();
                        } catch (IOException e8) {
                            C4904y.m18635a(e8, getClass().getSimpleName());
                        }
                    }
                    throw th;
                }
            }
            return bitmapDecodeStream;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: e */
    public static String m7462e(String str) {
        return str + ".jpeg_";
    }

    /* renamed from: b */
    private Bitmap m7459b(Context context) {
        if (this.f4892h[0] == null) {
            this.f4892h[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.profile_photo_buddy_default);
        }
        return this.f4892h[0];
    }

    /* renamed from: a */
    public static boolean m7458a(ImageView imageView) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeResource(GlobalApplication.m10283b(), R.drawable.mypage_bg_default));
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        imageView.setImageBitmap(null);
        imageView.setBackgroundDrawable(bitmapDrawable);
        return true;
    }

    /* renamed from: a */
    public static Bitmap m7452a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            float width = (float) (bitmap.getWidth() * 0.026d);
            if (f4884i == null) {
                f4884i = new Paint();
                f4884i.setAntiAlias(true);
                f4884i.setColor(-12434878);
                f4885j = new Paint(f4884i);
                f4885j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectF, width, width, f4884i);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, f4885j);
            bitmap.recycle();
            return bitmapCreateBitmap;
        } catch (Exception e) {
            C4904y.m18635a(e, "BuddyProfileImageHistoryManager");
            return null;
        } catch (OutOfMemoryError e2) {
            C4904y.m18635a(e2, "BuddyProfileImageHistoryManager");
            return null;
        }
    }
}
