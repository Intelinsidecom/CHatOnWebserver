package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class SpenPenPresetListAdapter extends BaseAdapter {
    protected static List<SpenPenPresetInfo> mList;
    private final Paint mBitmapPaint;
    protected Context mContext;
    protected String mCustom_imagepath;
    protected OnClickPresetItemListener mOnClickPresetItemListener;
    protected float mOnePT;
    protected ArrayList<SpenPenPluginInfo> mPenPluginInfoList;
    private SpenPenPluginManager mPenPluginManager;
    private final RectF mRect;
    protected float mScale;
    protected Resources mSdkResources;
    protected SPenTextUtil mStringUtil;
    protected int mCurrentSeleted = -1;
    int mSecondViewEnter = -1;
    protected View.OnClickListener mSelectPresetItem = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View paramView) {
            int i = ((Integer) paramView.getTag()).intValue();
            paramView.clearFocus();
            if (SpenPenPresetListAdapter.this.mOnClickPresetItemListener != null) {
                SpenPenPresetListAdapter.this.mOnClickPresetItemListener.selectPresetItem(i);
            }
        }
    };
    protected View.OnTouchListener mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View paramView, MotionEvent event) {
            if (event.getAction() == 0) {
                int i = ((Integer) paramView.getTag()).intValue();
                paramView.clearFocus();
                paramView.playSoundEffect(0);
                if (SpenPenPresetListAdapter.this.mOnClickPresetItemListener != null) {
                    SpenPenPresetListAdapter.this.mOnClickPresetItemListener.selectPresetItem(i);
                    return true;
                }
                return true;
            }
            return true;
        }
    };
    protected View.OnLongClickListener mSelectLongPresetItem = new View.OnLongClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View paramView) {
            int i = ((Integer) paramView.getTag()).intValue();
            if (SpenPenPresetListAdapter.this.mOnClickPresetItemListener != null) {
                SpenPenPresetListAdapter.this.mOnClickPresetItemListener.selectPresetItem(i);
                return true;
            }
            return true;
        }
    };
    protected View.OnClickListener mDeletePresetItem = new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.4
        @Override // android.view.View.OnClickListener
        public void onClick(View paramView) {
            int i = ((Integer) paramView.getTag()).intValue();
            if (SpenPenPresetListAdapter.this.mOnClickPresetItemListener != null) {
                SpenPenPresetListAdapter.this.mOnClickPresetItemListener.deletePresetItem(i);
            }
        }
    };
    protected View.OnFocusChangeListener mFocusItemListener = new View.OnFocusChangeListener() { // from class: com.samsung.android.sdk.pen.settingui.SpenPenPresetListAdapter.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View paramView, boolean hasFocus) {
            int i = ((Integer) paramView.getTag()).intValue();
            if (hasFocus) {
                SpenPenPresetListAdapter.this.mOnClickPresetItemListener.setScrollPresetGridToIndex(i);
            }
        }
    };

    public interface OnClickPresetItemListener {
        void deletePresetItem(int i);

        void selectPresetItem(int i);

        void setScrollPresetGridToIndex(int i);
    }

    public SpenPenPresetListAdapter(Context paramContext, int paramInt, List<SpenPenPresetInfo> presetInfoList, String custom_imagepath, ArrayList<SpenPenPluginInfo> penPluginInfoList, float ratio) {
        this.mOnePT = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mScale = 1.0f;
        this.mCustom_imagepath = "";
        this.mScale = ratio;
        this.mContext = paramContext;
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        this.mOnePT = localDisplayMetrics.density * ratio;
        this.mStringUtil = new SPenTextUtil(this.mContext);
        mList = new ArrayList(presetInfoList);
        this.mCustom_imagepath = custom_imagepath;
        this.mPenPluginInfoList = penPluginInfoList;
        this.mBitmapPaint = new Paint(4);
        this.mRect = new RectF();
        try {
            this.mSdkResources = this.mContext.getPackageManager().getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        this.mContext = null;
        if (mList != null) {
            mList.clear();
            mList = null;
        }
        this.mOnClickPresetItemListener = null;
        if (this.mPenPluginInfoList != null) {
            this.mPenPluginInfoList.clear();
            this.mPenPluginInfoList = null;
        }
        this.mCustom_imagepath = null;
    }

    public void OnClickPresetItemListener(OnClickPresetItemListener paramOnClickPresetItemListener) {
        this.mOnClickPresetItemListener = paramOnClickPresetItemListener;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) throws Resources.NotFoundException {
        if (convertView == null) {
            convertView = new SpenPresetListItem(this.mContext, this.mCustom_imagepath, this.mScale).getPenPresetListRow();
        }
        if (position == this.mSecondViewEnter) {
            convertView.setVisibility(4);
        } else {
            convertView.setVisibility(0);
        }
        ImageButton previewButton = (ImageButton) convertView.findViewById(12070501);
        previewButton.setClickable(true);
        previewButton.setFocusable(true);
        previewButton.setTag(Integer.valueOf(position));
        previewButton.setOnClickListener(this.mSelectPresetItem);
        previewButton.setOnTouchListener(this.mOnTouchListener);
        previewButton.setOnLongClickListener(this.mSelectLongPresetItem);
        previewButton.setOnFocusChangeListener(this.mFocusItemListener);
        ImageButton deleteButton = (ImageButton) convertView.findViewById(SpenPresetListItem.IB_PEN_PRESET_DELETE_ID);
        deleteButton.setClickable(true);
        deleteButton.setFocusable(true);
        deleteButton.setTag(Integer.valueOf(position));
        deleteButton.setOnClickListener(this.mDeletePresetItem);
        deleteButton.setOnFocusChangeListener(this.mFocusItemListener);
        if (position == this.mCurrentSeleted) {
            previewButton.setSelected(true);
            if (!SpenSettingPenLayout.mIsSwichTab) {
                previewButton.requestFocus();
            }
        } else {
            previewButton.setSelected(false);
        }
        if (this.mStringUtil.setString("string_delete_preset") != null) {
            deleteButton.setContentDescription(this.mStringUtil.setString("string_delete_preset").replace("%d", ""));
        }
        if (mList != null) {
            SpenPenPresetInfo presetInfo_temp = mList.get(position);
            ((ImageView) convertView.findViewById(12070601)).setImageDrawable(bitmapResize(position));
            if (!presetInfo_temp.getFlag()) {
                presetPreview(presetInfo_temp);
                presetInfo_temp.setFlag(true);
            }
            RelativeLayout penAlphaPreview = (RelativeLayout) convertView.findViewById(12070701);
            if (presetInfo_temp.getPenName().equals(SpenPenManager.SPEN_MAGIC_PEN)) {
                penAlphaPreview.setVisibility(0);
                int penAlpha = (presetInfo_temp.getColor() >> 24) & 255;
                penAlphaPreview.setAlpha((float) (penAlpha / 255.0d));
                float alphaWidth = (float) (2.7d + (((presetInfo_temp.getPenSize() - 18.0f) * 6.3f) / 42.0f));
                RelativeLayout.LayoutParams penPreviewLayoutParams02 = new RelativeLayout.LayoutParams((int) (this.mOnePT * 30.0f), (int) (this.mOnePT * alphaWidth));
                penPreviewLayoutParams02.leftMargin = (int) (this.mOnePT * 19.0f);
                penPreviewLayoutParams02.topMargin = (int) (this.mOnePT * (32.5d - (alphaWidth / 2.0f)));
                penAlphaPreview.setLayoutParams(penPreviewLayoutParams02);
            } else {
                penAlphaPreview.setVisibility(8);
            }
            previewButton.setImageBitmap(presetInfo_temp.getBitmap());
            String strPreset = this.mStringUtil.setString("string_pen_preset");
            if (strPreset != null) {
                previewButton.setContentDescription(String.format(this.mStringUtil.setString("string_pen_preset"), Integer.valueOf(position + 1)));
            }
        }
        return convertView;
    }

    private Drawable bitmapResize(int index) {
        int resID = this.mSdkResources.getIdentifier(mList.get(index).getPresetImageName(), "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
        if (resID == 0) {
            return null;
        }
        return resizeImage(resID, 65, 65);
    }

    public Drawable resizeImage(int resId, int iconWidth, int iconHeight) throws Resources.NotFoundException, IOException {
        InputStream stream = this.mSdkResources.openRawResource(resId);
        Bitmap BitmapOrg = SpenScreenCodecDecoder.decodeStream(stream);
        if (BitmapOrg == null) {
            return null;
        }
        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        int newWidth = (int) (this.mOnePT * iconWidth);
        int newHeight = (int) (this.mOnePT * iconHeight);
        float scaleWidth = newWidth / width;
        float scaleHeight = newHeight / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width, height, matrix, true);
        return new BitmapDrawable(this.mSdkResources, resizedBitmap);
    }

    public void setPenPlugin(SpenPenPluginManager penPluginManager) {
        this.mPenPluginManager = penPluginManager;
        this.mPenPluginInfoList = this.mPenPluginManager.getPenPluginInfoList();
    }

    protected void presetPreview(SpenPenPresetInfo presetInfo) {
        Bitmap localBitmap;
        if (presetInfo != null && this.mPenPluginManager != null && this.mPenPluginInfoList != null && (localBitmap = presetInfo.getBitmap()) != null) {
            localBitmap.eraseColor(0);
            Canvas localCanvas = new Canvas(localBitmap);
            int penPluginIndex = this.mPenPluginManager.getPenPluginIndexByPenName(presetInfo.getPenName());
            if (penPluginIndex != -1) {
                if (this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() == null) {
                    this.mPenPluginManager.loadPenPlugin(this.mContext, presetInfo.getPenName());
                    if (this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject() == null) {
                        return;
                    }
                }
                this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setBitmap(localBitmap);
                this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setSize(presetInfo.getPenSize());
                this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setColor(presetInfo.getColor());
                if (presetInfo.getPenName().equals("com.samsung.android.sdk.pen.pen.preload.Beautify")) {
                    this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().setAdvancedSetting(presetInfo.getAdvancedSetting());
                }
                localBitmap.eraseColor(0);
                long time = System.currentTimeMillis();
                MotionEvent event = MotionEvent.obtain(time, time, 0, this.mOnePT * 22.0f, 33.0f * this.mOnePT, 0.5f, presetInfo.getPenSize(), 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().draw(event, this.mRect);
                event.recycle();
                long currentTime = time + 5;
                MotionEvent event2 = MotionEvent.obtain(time, currentTime, 2, ((22.0f + 43.0f) / 2.0f) * this.mOnePT, 33.0f * this.mOnePT, 0.5f, presetInfo.getPenSize(), 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().draw(event2, this.mRect);
                event2.recycle();
                long currentTime2 = time + 10;
                MotionEvent event3 = MotionEvent.obtain(time, currentTime2, 1, this.mOnePT * 43.0f, 33.0f * this.mOnePT, 0.5f, presetInfo.getPenSize(), 0, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                this.mPenPluginInfoList.get(penPluginIndex).getPenPluginObject().draw(event3, this.mRect);
                event3.recycle();
                localCanvas.drawBitmap(localBitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mBitmapPaint);
            }
        }
    }

    protected String getPresetImage(String presetName) {
        String imgName = null;
        if (this.mPenPluginInfoList != null) {
            Iterator<SpenPenPluginInfo> iterator = this.mPenPluginInfoList.iterator();
            while (true) {
                if (!iterator.hasNext()) {
                    break;
                }
                SpenPenPluginInfo penPluginInfo = iterator.next();
                String selectImage = new String("urlInfo");
                String localSelectImage = penPluginInfo.getPluginInfo().presetIconImageUri;
                if (selectImage.equals(localSelectImage)) {
                    return "pen_preset_brush";
                }
                if (penPluginInfo.getPenName().equals(presetName)) {
                    imgName = penPluginInfo.getPluginInfo().presetIconImageUri;
                    break;
                }
            }
        }
        return imgName;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }
}
