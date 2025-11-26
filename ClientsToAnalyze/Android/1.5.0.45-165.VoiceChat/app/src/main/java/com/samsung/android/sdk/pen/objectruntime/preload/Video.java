package com.samsung.android.sdk.pen.objectruntime.preload;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.objectruntime.preload.VideoIntentFragment;
import com.samsung.android.sdk.pen.objectruntime.preload.WrapperVideoView;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import com.sds.coolots.common.controller.DatabaseHelper;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Video implements SpenObjectRuntimeInterface {
    private static final String EXTRADATASTRING_VIDEOPATH_KEY = "VideoPath";
    private static final String GETEXTRADATASTRING_FUNCTION = "getExtraDataString";
    private static final String SETEXTRADATASTRING_FUNCTION = "setExtraDataString";
    private static final String SETIMAGE_FUNCTION = "setImage";
    private static final String SETRECT_FUNCTION = "setRect";
    private static final String SETRESIZEOPTION_FUNCTION = "setResizeOption";
    private static final String SETROTATABLE_FUNCTION = "setRotatable";
    private static final String SETVISIBILITY_FUNCTION = "setVisibility";
    private static final String SETWFDTCPDISABLE_FUNCTION = "setWFDTcpDisable";
    private static final String TAG = "Video";
    private static final String VIDEOPLAY_IMAGE_NAME = "snote_insert_video_icon_cue";

    /* renamed from: fm */
    private FragmentManager f401fm;
    private Activity mActivity;
    AudioManager.OnAudioFocusChangeListener mAudioLisner;
    AudioManager mAudioManager;
    private VideoIntentFragment mFragment;
    private VideoIntentFragment.OnVideoIntentFragmentListener mFragmentListener;
    private SpenObjectRuntimeInterface.UpdateListener mListener;
    private Object mObject;
    private PointF mPan;
    private float mRatio;
    private RectF mRect;
    private PointF mStartFramePosition;
    private String mVideoFilePath;
    private WrapperVideoView mVideoView;
    private RelativeLayout.LayoutParams mVideoViewLayoutParams;
    private WrapperVideoView.WrapperVideoViewListener mVideoViewListener;
    private ViewGroup mViewGroup;
    private static final Class<?>[] SETIMAGE_FUNCTION_ARG_SIGNATURE = {Bitmap.class};
    private static final Class<?>[] SETRECT_FUNCTION_ARG_SIGNATURE = {RectF.class, Boolean.TYPE};
    private static final Class<?>[] GETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE = {String.class};
    private static final Class<?>[] SETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE = {String.class, String.class};
    private static final Class<?>[] SETROTATABLE_FUNCTION_ARG_SIGNATURE = {Boolean.TYPE};
    private static final Class<?>[] SETVISIBILITY_FUNCTION_ARG_SIGNATURE = {Boolean.TYPE};
    private static final Class<?>[] SETRESIZEOPTION_FUNCTION_ARG_SIGNATURE = {Integer.TYPE};
    private static final Class<?>[] SETWFDTCPDISABLE_FUNCTION_ARG_SIGNATURE = {Boolean.TYPE};
    private static int HASH_KEY_IMAGE_SIZE = 0;
    private static int HASH_KEY_IMAGE_MARGIN = HASH_KEY_IMAGE_SIZE + 1;
    private static int HASH_KEY_PIXEL_1080_1920 = 3000;
    private static int HASH_KEY_PIXEL_2560_1600 = 4160;
    private static int HASH_KEY_PIXEL_720_1280 = 2000;
    private static int HASH_KEY_PIXEL_DEFAULT = HASH_KEY_PIXEL_1080_1920;
    private static final HashMap<Integer, HashMap<Integer, Rect>> VIDEOPLAY_IMAGE_UX_TABLE = new HashMap<>();

    static {
        Rect size = new Rect(0, 0, 22, 22);
        Rect margin = new Rect(0, 7, 7, 0);
        HashMap<Integer, Rect> info = new HashMap<>();
        info.put(Integer.valueOf(HASH_KEY_IMAGE_SIZE), size);
        info.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN), margin);
        VIDEOPLAY_IMAGE_UX_TABLE.put(Integer.valueOf(HASH_KEY_PIXEL_1080_1920), info);
        Rect size2 = new Rect(0, 0, 33, 33);
        Rect margin2 = new Rect(0, 10, 10, 0);
        HashMap<Integer, Rect> info2 = new HashMap<>();
        info2.put(Integer.valueOf(HASH_KEY_IMAGE_SIZE), size2);
        info2.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN), margin2);
        VIDEOPLAY_IMAGE_UX_TABLE.put(Integer.valueOf(HASH_KEY_PIXEL_2560_1600), info2);
        Rect size3 = new Rect(0, 0, 22, 22);
        Rect margin3 = new Rect(0, 7, 7, 0);
        HashMap<Integer, Rect> info3 = new HashMap<>();
        info3.put(Integer.valueOf(HASH_KEY_IMAGE_SIZE), size3);
        info3.put(Integer.valueOf(HASH_KEY_IMAGE_MARGIN), margin3);
        VIDEOPLAY_IMAGE_UX_TABLE.put(Integer.valueOf(HASH_KEY_PIXEL_720_1280), info3);
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onLoad(Context context) {
        this.mActivity = (Activity) context;
        this.f401fm = this.mActivity.getFragmentManager();
        this.mAudioManager = (AudioManager) this.mActivity.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.mAudioLisner = new AudioManager.OnAudioFocusChangeListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.Video.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int focusChange) {
                if (focusChange == -1) {
                    Video.this.mVideoView.pause();
                }
            }
        };
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void start(Object objectBase, RectF rectF, PointF arg2, float arg3, PointF arg4, ViewGroup viewGroup) {
        if (objectBase == null || viewGroup == null || rectF == null || arg4 == null) {
            throw new IllegalArgumentException("Argument is null. ObjectBase = " + objectBase + " Rect = " + rectF + " ViewGroup = " + viewGroup + " startFramePosition = " + arg4);
        }
        this.mObject = objectBase;
        this.mViewGroup = viewGroup;
        this.mPan = arg2;
        this.mRatio = arg3;
        this.mStartFramePosition = arg4;
        Object[] args = {EXTRADATASTRING_VIDEOPATH_KEY};
        this.mVideoFilePath = (String) mInvoke(this.mObject, GETEXTRADATASTRING_FUNCTION, GETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE, args);
        setRect(rectF);
        if (this.mVideoFilePath == null) {
            this.mFragment = new VideoIntentFragment();
            this.mFragmentListener = new VideoIntentFragment.OnVideoIntentFragmentListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.Video.2
                @Override // com.samsung.android.sdk.pen.objectruntime.preload.VideoIntentFragment.OnVideoIntentFragmentListener
                public void onResult(Intent data) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
                    if (data == null) {
                        Log.v(Video.TAG, "Video file was not selected.");
                        Video.this.cancel(0);
                        return;
                    }
                    Uri uri = data.getData();
                    if (uri == null) {
                        Log.v(Video.TAG, "The extra data of video file is null.");
                        uri = (Uri) data.getParcelableExtra("android.intent.extra.STREAM");
                    }
                    Cursor videoCursor = Video.this.mActivity.getContentResolver().query(uri, new String[]{DatabaseHelper.KEY_ROWID, "_data"}, null, null, null);
                    if (videoCursor != null) {
                        videoCursor.moveToFirst();
                        if (videoCursor.getCount() != 0) {
                            Video.this.mVideoFilePath = videoCursor.getString(videoCursor.getColumnIndex("_data"));
                            videoCursor.close();
                            Bitmap srcBitmap = ThumbnailUtils.createVideoThumbnail(Video.this.mVideoFilePath, 1);
                            if (srcBitmap == null) {
                                Log.v(Video.TAG, "The bitmap of video is null");
                                Video.this.cancel(0);
                                return;
                            }
                            RectF noneRatioRect = new RectF();
                            Video.this.mRect = Video.this.getRatioRect(srcBitmap.getWidth(), srcBitmap.getHeight(), noneRatioRect);
                            Object[] args2 = {Video.this.convertAbsolute(Video.this.mRect), true};
                            Video.this.mInvoke(Video.this.mObject, Video.SETRECT_FUNCTION, Video.SETRECT_FUNCTION_ARG_SIGNATURE, args2);
                            Bitmap bitmap = Video.this.createPlayVideoBitmap(srcBitmap, noneRatioRect);
                            if (bitmap == null) {
                                Log.v(Video.TAG, "PlayVideo merge process is failed");
                                Video.this.cancel(0);
                                return;
                            }
                            Object[] args3 = {bitmap};
                            Video.this.mInvoke(Video.this.mObject, Video.SETIMAGE_FUNCTION, Video.SETIMAGE_FUNCTION_ARG_SIGNATURE, args3);
                            Object[] args4 = {Video.EXTRADATASTRING_VIDEOPATH_KEY, Video.this.mVideoFilePath};
                            Video.this.mInvoke(Video.this.mObject, Video.SETEXTRADATASTRING_FUNCTION, Video.SETEXTRADATASTRING_FUNCTION_ARG_SIGNATURE, args4);
                            Object[] args5 = {false};
                            Video.this.mInvoke(Video.this.mObject, Video.SETROTATABLE_FUNCTION, Video.SETROTATABLE_FUNCTION_ARG_SIGNATURE, args5);
                            Object[] args6 = {1};
                            Video.this.mInvoke(Video.this.mObject, Video.SETRESIZEOPTION_FUNCTION, Video.SETRESIZEOPTION_FUNCTION_ARG_SIGNATURE, args6);
                            Video.this.mListener.onObjectUpdated(Video.this.mRect, Video.this.mObject);
                            Video.this.complete();
                            return;
                        }
                        Log.v(Video.TAG, "The extra data of video file is empty.");
                        videoCursor.close();
                        Video.this.cancel(0);
                        return;
                    }
                    Log.v(Video.TAG, "The extra data of video file query is failed.");
                    Video.this.cancel(0);
                }

                @Override // com.samsung.android.sdk.pen.objectruntime.preload.VideoIntentFragment.OnVideoIntentFragmentListener
                public void onDestroy() {
                    Video.this.cancel(0);
                }
            };
            this.mFragment.setVideoIntentFragmentListener(this.mFragmentListener);
            this.f401fm.beginTransaction().add(this.mFragment, "PlayVideo").commit();
            return;
        }
        if (!startVideoPlay()) {
            Log.v(TAG, "StartVideoPlay is failed.");
            cancel(1);
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void stop(boolean cancel) {
        cleanResource();
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void setRect(RectF rect) {
        if (rect == null || this.mViewGroup == null) {
            Log.v(TAG, "rect = " + rect + " or viewGroup = " + this.mViewGroup + " This SOR started yet.");
            return;
        }
        this.mRect = rect;
        this.mVideoViewLayoutParams = new RelativeLayout.LayoutParams((int) this.mRect.width(), (int) this.mRect.height());
        this.mVideoViewLayoutParams.setMargins((int) this.mRect.left, (int) this.mRect.top, 0, 0);
        if (this.mVideoView != null) {
            this.mVideoView.setLayoutParams(this.mVideoViewLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object mInvoke(Object instance, String runner, Class<?>[] clsArr, Object... args) {
        try {
            return instance.getClass().getMethod(runner, clsArr).invoke(instance, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getRatioRect(int w, int h, RectF outNoneRatioRect) {
        float height;
        float width;
        float ratio = w / h;
        if (this.mRect.width() < this.mRect.height()) {
            if (w > h) {
                width = this.mRect.width() * 0.6666667f;
                height = width / ratio;
            } else {
                height = this.mRect.width() * 0.6666667f;
                width = height * ratio;
            }
        } else if (w > h) {
            width = this.mRect.height() * 0.6666667f;
            height = width / ratio;
        } else {
            height = this.mRect.height() * 0.6666667f;
            width = height * ratio;
        }
        int centerX = this.mViewGroup.getWidth() / 2;
        int centerY = this.mViewGroup.getHeight() / 2;
        outNoneRatioRect.left = centerX - (width / 2.0f);
        outNoneRatioRect.top = centerY - (height / 2.0f);
        outNoneRatioRect.right = outNoneRatioRect.left + width;
        outNoneRatioRect.bottom = outNoneRatioRect.top + height;
        float ratioWidth = width * this.mRatio;
        float ratioHeight = height * this.mRatio;
        RectF r = new RectF();
        r.left = centerX - (ratioWidth / 2.0f);
        r.top = centerY - (ratioHeight / 2.0f);
        r.right = r.left + ratioWidth;
        r.bottom = r.top + ratioHeight;
        return r;
    }

    private boolean startVideoPlay() {
        this.mVideoView = new WrapperVideoView(this.mActivity);
        if (this.mVideoView == null) {
            Log.v(TAG, "VideoView is null.");
            return false;
        }
        this.mVideoViewListener = new WrapperVideoView.WrapperVideoViewListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.Video.3
            @Override // com.samsung.android.sdk.pen.objectruntime.preload.WrapperVideoView.WrapperVideoViewListener
            public void onStart() {
                Object[] args = {false};
                Video.this.mInvoke(Video.this.mObject, Video.SETVISIBILITY_FUNCTION, Video.SETVISIBILITY_FUNCTION_ARG_SIGNATURE, args);
                Video.this.mListener.onObjectUpdated(Video.this.mRect, Video.this.mObject);
            }
        };
        this.mVideoView.setListener(this.mVideoViewListener);
        Object[] args = {true};
        this.mVideoView.requestFocusFromTouch();
        mInvoke(this.mVideoView, SETWFDTCPDISABLE_FUNCTION, SETWFDTCPDISABLE_FUNCTION_ARG_SIGNATURE, args);
        this.mVideoView.setVideoPath(Uri.encode(this.mVideoFilePath));
        this.mVideoView.setLayoutParams(this.mVideoViewLayoutParams);
        this.mVideoView.setZOrderMediaOverlay(true);
        this.mVideoView.setBackgroundColor(0);
        this.mViewGroup.addView(this.mVideoView);
        this.mAudioManager.requestAudioFocus(this.mAudioLisner, 3, 1);
        this.mVideoView.start();
        this.mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.Video.4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mp) {
                Video.this.complete();
            }
        });
        this.mVideoView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.objectruntime.preload.Video.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View arg0, MotionEvent arg1) {
                if (arg1.getAction() == 0) {
                    if (!Video.this.mVideoView.isPlaying() || !Video.this.mVideoView.canPause()) {
                        Video.this.mVideoView.start();
                        Video.this.mAudioManager.requestAudioFocus(Video.this.mAudioLisner, 3, 1);
                    } else {
                        Video.this.mVideoView.pause();
                    }
                }
                return true;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap createPlayVideoBitmap(Bitmap srcBitmap, RectF noneRatioRect) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        PackageManager pm = this.mActivity.getPackageManager();
        if (pm == null) {
            Log.v(TAG, "PackageManager is null.");
            return null;
        }
        try {
            Resources res = pm.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            DisplayMetrics dm = res.getDisplayMetrics();
            if (dm == null) {
                Log.v(TAG, "DisplayMetrics Get is failed");
                return null;
            }
            int id = res.getIdentifier(VIDEOPLAY_IMAGE_NAME, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            if (id == 0) {
                Log.v(TAG, "Resource is not founded");
                return null;
            }
            try {
                InputStream stream = res.openRawResource(id);
                Bitmap resourceBitmap = SpenScreenCodecDecoder.decodeStream(stream);
                if (resourceBitmap == null) {
                    Log.v(TAG, "The bitmap of resource is null.");
                    return null;
                }
                Bitmap workBitmap = Bitmap.createBitmap((int) noneRatioRect.width(), (int) noneRatioRect.height(), Bitmap.Config.ARGB_8888);
                if (workBitmap == null) {
                    Log.v(TAG, "The workBitmap of result is null. out fo memory");
                    resourceBitmap.recycle();
                    return null;
                }
                Canvas canvas = new Canvas(workBitmap);
                Rect src = new Rect();
                src.set(0, 0, srcBitmap.getWidth(), srcBitmap.getHeight());
                Rect dst = new Rect();
                dst.set(0, 0, workBitmap.getWidth(), workBitmap.getHeight());
                Paint paint = new Paint(7);
                canvas.drawBitmap(srcBitmap, src, dst, paint);
                src.set(0, 0, resourceBitmap.getWidth(), resourceBitmap.getHeight());
                int key = dm.widthPixels + dm.heightPixels;
                if (!VIDEOPLAY_IMAGE_UX_TABLE.containsKey(Integer.valueOf(key))) {
                    key = HASH_KEY_PIXEL_DEFAULT;
                }
                Rect margin = VIDEOPLAY_IMAGE_UX_TABLE.get(Integer.valueOf(key)).get(Integer.valueOf(HASH_KEY_IMAGE_MARGIN));
                Rect size = VIDEOPLAY_IMAGE_UX_TABLE.get(Integer.valueOf(key)).get(Integer.valueOf(HASH_KEY_IMAGE_SIZE));
                dst.left = (workBitmap.getWidth() - getIntValueAppliedDensity(size.width(), dm.density)) - getIntValueAppliedDensity(margin.right, dm.density);
                dst.top = getIntValueAppliedDensity(margin.top, dm.density);
                dst.right = dst.left + getIntValueAppliedDensity(size.width(), dm.density);
                dst.bottom = dst.top + getIntValueAppliedDensity(size.height(), dm.density);
                canvas.drawBitmap(resourceBitmap, src, dst, paint);
                resourceBitmap.recycle();
                return workBitmap;
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public boolean setListener(SpenObjectRuntimeInterface.UpdateListener listener) {
        if (listener == null) {
            Log.v(TAG, "argument listener is null.");
            return false;
        }
        this.mListener = listener;
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void getProperty(Bundle arg0) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void onUnload() {
        this.mActivity = null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public void setProperty(Bundle arg0) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface
    public int getNativeHandle() {
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public void onTouchEvent(MotionEvent event) {
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public boolean unlock(String arg0) {
        return true;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface
    public String getPrivateKeyHint() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface
    public int getType() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF convertAbsolute(RectF relativeRect) {
        RectF dstRect = new RectF();
        dstRect.left = ((relativeRect.left - this.mStartFramePosition.x) / this.mRatio) + this.mPan.x;
        dstRect.right = ((relativeRect.right - this.mStartFramePosition.x) / this.mRatio) + this.mPan.x;
        dstRect.top = ((relativeRect.top - this.mStartFramePosition.y) / this.mRatio) + this.mPan.y;
        dstRect.bottom = ((relativeRect.bottom - this.mStartFramePosition.y) / this.mRatio) + this.mPan.y;
        return dstRect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancel(int action) {
        cleanResource();
        this.mListener.onCanceled(action, this.mObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void complete() {
        cleanResource();
        this.mListener.onCompleted(this.mObject);
    }

    private void cleanResource() {
        Object[] args = {true};
        mInvoke(this.mObject, SETVISIBILITY_FUNCTION, SETVISIBILITY_FUNCTION_ARG_SIGNATURE, args);
        this.mListener.onObjectUpdated(this.mRect, this.mObject);
        this.mAudioManager.abandonAudioFocus(this.mAudioLisner);
        if (this.mVideoView != null) {
            this.mViewGroup.removeView(this.mVideoView);
            this.mVideoView = null;
        }
        if (this.mFragment != null) {
            this.mFragment.setVideoIntentFragmentListener(null);
            if (this.f401fm.findFragmentById(this.mFragment.getId()) != null) {
                this.f401fm.beginTransaction().remove(this.mFragment).commitAllowingStateLoss();
            }
            this.mFragment = null;
        }
    }

    private int getIntValueAppliedDensity(float paramFloat, float density) {
        return Math.round(paramFloat * density);
    }
}
