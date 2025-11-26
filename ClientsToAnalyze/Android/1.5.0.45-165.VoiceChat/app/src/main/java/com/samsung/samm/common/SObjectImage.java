package com.samsung.samm.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.samsung.samm.lib.p003a.C0902p;

/* loaded from: classes.dex */
public class SObjectImage extends SObject {
    public static final byte SAMM_IMAGESTYLE_ANIMATIONICON = 1;
    public static final byte SAMM_IMAGESTYLE_CUSTOM = 100;
    public static final byte SAMM_IMAGESTYLE_NORMAL = 2;
    public static final byte SAMM_IMAGESTYLE_STAMP = 0;

    /* renamed from: a */
    private Bitmap f410a = null;

    /* renamed from: b */
    private String f411b;

    /* renamed from: c */
    private int f412c;

    public SObjectImage() {
        this.mStyle = 2;
        this.f412c = 1;
    }

    public SObjectImage(int i) {
        this.mStyle = 2;
        this.f412c = i;
    }

    @Override // com.samsung.samm.common.SObject
    public boolean setStyle(int i) {
        if (i == 2 || i == 0 || i == 1 || i == 100) {
            this.mStyle = i;
            return true;
        }
        Log.e("SAMMLibrary", "Undefined Image Style : " + i);
        return false;
    }

    public boolean setImageBitmap(Bitmap bitmap) {
        if (this.mStyle != 2) {
            Log.e("SAMMLibrary", "Image Style is not Normal. setStyle as SAMM_IMAGESTYLE_NORMAL.");
            return false;
        }
        if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return false;
        }
        this.f410a = bitmap;
        return true;
    }

    @Deprecated
    public Bitmap getImageBitmap(int i) {
        if (this.f410a != null) {
            return this.f410a;
        }
        if (this.f411b == null) {
            return null;
        }
        if (i < 1) {
            Log.e("SAMMLibrary", "Invalid Constraint Size : " + i);
            return null;
        }
        this.f410a = m152a(this.f411b, i, null);
        return this.f410a;
    }

    public Bitmap getImageBitmap() {
        if (this.f410a != null) {
            return this.f410a;
        }
        if (this.f411b == null) {
            return null;
        }
        if (this.f412c == 3) {
            return m152a(this.f411b, 1, null);
        }
        return m152a(this.f411b, 800, null);
    }

    public Bitmap getImageBitmap(int i, int i2) {
        Bitmap bitmapM152a;
        if (this.f410a != null) {
            return m151a(this.f410a, this.f412c, i, i2);
        }
        if (this.f411b == null) {
            return null;
        }
        if (this.f412c == 3) {
            bitmapM152a = m152a(this.f411b, 1, null);
        } else {
            bitmapM152a = m152a(this.f411b, 800, null);
        }
        return m151a(bitmapM152a, this.f412c, i, i2);
    }

    public boolean setImagePath(String str) {
        if (this.mStyle != 2) {
            Log.e("SAMMLibrary", "Image Style is not Normal. setStyle as SAMM_IMAGESTYLE_NORMAL.");
            return false;
        }
        if (!C0902p.m578b(str)) {
            return false;
        }
        this.f411b = str;
        this.f410a = null;
        return true;
    }

    public String getImagePath() {
        return this.f411b;
    }

    public boolean isValidImage() {
        if (this.f410a != null || this.f411b != null) {
            return this.f410a == null || (this.f410a.getWidth() > 0 && this.f410a.getHeight() > 0);
        }
        Log.e("SAMMLibrary", "Invalid SObjectImage is set!");
        return false;
    }

    /* renamed from: a */
    private Bitmap m152a(String str, int i, BitmapFactory.Options options) {
        if (options == null) {
            if (i == 1) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inDither = false;
                options2.inJustDecodeBounds = false;
                options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options2.inPurgeable = true;
                return BitmapFactory.decodeFile(str, options2);
            }
            return C0902p.m574a(str, i, i);
        }
        return BitmapFactory.decodeFile(str, options);
    }

    /* renamed from: a */
    private Bitmap m151a(Bitmap bitmap, int i, int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            if (i == 0) {
                return C0902p.m573a(bitmap, i2, i3);
            }
            if (i == 1) {
                return C0902p.m573a(bitmap, i2 / 2, i3 / 2);
            }
            if (i == 2) {
                return C0902p.m573a(bitmap, i2 / 4, i3 / 4);
            }
            return bitmap;
        }
        return bitmap;
    }

    @Override // com.samsung.samm.common.SObject
    public SObject copyObject() {
        SObjectImage sObjectImage = new SObjectImage(this.f412c);
        copyObjectGeneral(sObjectImage);
        if (this.f410a != null) {
            sObjectImage.setImageBitmap(this.f410a);
        } else if (this.f411b != null) {
            sObjectImage.setImagePath(this.f411b);
        }
        return sObjectImage;
    }

    @Override // com.samsung.samm.common.SObject
    public boolean changeObject(SObject sObject) {
        if (!super.changeObjectGeneral(sObject)) {
            return false;
        }
        setImageBitmap(((SObjectImage) sObject).getImageBitmap());
        return true;
    }

    @Override // com.samsung.samm.common.SObject
    public String getObjectInfo() {
        return "Path : " + getImagePath();
    }
}
