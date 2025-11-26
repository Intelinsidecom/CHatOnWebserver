package com.sec.chaton.trunk;

import android.content.Context;
import android.database.Cursor;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.control.MessageControl;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.trunk.network.FileDownloadManager;
import com.sec.chaton.trunk.network.FileDownloadTask;
import com.sec.chaton.trunk.util.TrunkUtil;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatOnGraphics;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TrunkAdapter extends CursorAdapter {
    private static final String TAG = TrunkAdapter.class.getSimpleName();
    private Context mContext;
    private Handler mDownloadHandler;
    private String mInboxNo;
    private Map mMapper;
    private OnContentClickListener mOnContentClickListener;
    private TrunkMessageControl.OrderingType mOrderingType;

    class OnClickItemListener implements View.OnClickListener {
        private TrunkUtil.ContentType contentType;
        private String downloadUrl;
        private String itemId;
        private DatabaseConstant.TrunkItemTable.ItemType itemType;
        private View view;

        public OnClickItemListener(View view, String str, DatabaseConstant.TrunkItemTable.ItemType itemType, String str2, TrunkUtil.ContentType contentType) {
            this.view = view;
            this.itemId = str;
            this.itemType = itemType;
            this.downloadUrl = str2;
            this.contentType = contentType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrunkAdapter.this.mOnContentClickListener.OnContentItemClickListener(this.view, this.itemId, this.itemType, this.downloadUrl, this.contentType);
        }
    }

    class OnClickLoadMoreListener implements View.OnClickListener {
        private String itemId;
        private DatabaseConstant.TrunkItemTable.ItemType itemType;
        private View view;

        public OnClickLoadMoreListener(View view, String str, DatabaseConstant.TrunkItemTable.ItemType itemType) {
            this.view = view;
            this.itemId = str;
            this.itemType = itemType;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrunkAdapter.this.mOnContentClickListener.OnContentItemClickListener(this.view, this.itemId, this.itemType, null, null);
        }
    }

    class Views {
        private TrunkUtil.ContentType contentType;
        private ImageView imageView;
        private ProgressBar progressBar;

        private Views() {
        }

        public TrunkUtil.ContentType getContentType() {
            return this.contentType;
        }

        public ImageView getImageView() {
            return this.imageView;
        }

        public ProgressBar getProgressBar() {
            return this.progressBar;
        }

        public void setContentType(TrunkUtil.ContentType contentType) {
            this.contentType = contentType;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public void setProgressBar(ProgressBar progressBar) {
            this.progressBar = progressBar;
        }
    }

    public TrunkAdapter(Context context, Cursor cursor, int i, TrunkMessageControl.OrderingType orderingType, String str) {
        super(context, cursor, false);
        this.mDownloadHandler = new Handler() { // from class: com.sec.chaton.trunk.TrunkAdapter.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 2:
                        FileDownloadTask.DownloadDoneResult downloadDoneResult = (FileDownloadTask.DownloadDoneResult) message.obj;
                        if (downloadDoneResult != null && downloadDoneResult.getTag() != null) {
                            String downloadUrl = downloadDoneResult.getDownloadUrl();
                            Views views = (Views) downloadDoneResult.getTag();
                            ChatONLogWriter.m3506b("Download complete: " + downloadUrl + ", ImageView: " + views.getImageView(), TrunkAdapter.TAG);
                            MessageControl.m2017a(TrunkAdapter.this.mInboxNo, downloadDoneResult.getDirectory(), downloadDoneResult.getFileName());
                            TrunkAdapter.this.setThumbnailImage(views.getImageView(), views.getContentType(), Uri.parse(downloadUrl));
                            views.getProgressBar().setVisibility(8);
                            break;
                        }
                        break;
                    case 3:
                        ChatONLogWriter.m3506b("Download canceled. " + message.obj, TrunkAdapter.TAG);
                        break;
                    case 4:
                        ChatONLogWriter.m3506b("Download failed", TrunkAdapter.TAG);
                        FileDownloadTask.DownloadFailedResult downloadFailedResult = (FileDownloadTask.DownloadFailedResult) message.obj;
                        if (downloadFailedResult != null && downloadFailedResult.getTag() != null) {
                            Views views2 = (Views) downloadFailedResult.getTag();
                            TrunkAdapter.this.setDefaultThumbnailImage(views2.getImageView(), views2.getContentType());
                            views2.getProgressBar().setVisibility(8);
                            break;
                        }
                        break;
                }
            }
        };
        this.mContext = context;
        this.mOrderingType = orderingType;
        this.mInboxNo = str;
        this.mMapper = new HashMap();
        this.mOnContentClickListener = null;
    }

    private String getDirectory() {
        StringBuilder sb = new StringBuilder();
        sb.append(StorageStateInfoUtil.m3677a() ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(this.mInboxNo);
        return sb.toString();
    }

    private String getThumbnailDirectory() {
        StringBuilder sb = new StringBuilder();
        sb.append(StorageStateInfoUtil.m3677a() ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(this.mInboxNo);
        sb.append(File.separator);
        sb.append(DatabaseConstant.TrunkItemColumns.KEY_THUMBNAIL);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultThumbnailImage(ImageView imageView, TrunkUtil.ContentType contentType) {
        if (contentType == TrunkUtil.ContentType.IMAGE) {
            imageView.setImageResource(C0062R.drawable.image_default);
        }
        if (contentType == TrunkUtil.ContentType.VIDEO) {
            imageView.setImageResource(C0062R.drawable.video_default);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setThumbnailImage(ImageView imageView, TrunkUtil.ContentType contentType, Uri uri) {
        if (contentType == TrunkUtil.ContentType.IMAGE) {
            imageView.setImageBitmap(ChatOnGraphics.m3528a(this.mContext, uri));
        } else if (contentType == TrunkUtil.ContentType.VIDEO) {
            imageView.setImageBitmap(ThumbnailUtils.createVideoThumbnail(uri.toString(), 3));
        }
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imageView = (ImageView) view.findViewById(C0062R.id.trunkThumbnail);
        ProgressBar progressBar = (ProgressBar) view.findViewById(C0062R.id.trunkProgressbar);
        ImageView imageView2 = (ImageView) view.findViewById(C0062R.id.trunkVideoButton);
        TextView textView = (TextView) view.findViewById(C0062R.id.trunkTotalCommentCount);
        View viewFindViewById = view.findViewById(C0062R.id.trunkUnreadCommentBorder);
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        DatabaseConstant.TrunkItemTable.ItemType itemTypeConvert = DatabaseConstant.TrunkItemTable.ItemType.Convert(cursor.getInt(cursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_ITEM_TYPE)));
        if (itemTypeConvert != DatabaseConstant.TrunkItemTable.ItemType.Item) {
            if (itemTypeConvert == DatabaseConstant.TrunkItemTable.ItemType.LoadMore) {
                ChatONLogWriter.m3506b("OrderingType: " + this.mOrderingType, TAG);
                FileDownloadTask fileDownloadTask = (FileDownloadTask) this.mMapper.remove(imageView);
                if (fileDownloadTask != null) {
                    fileDownloadTask.setTag(null);
                    fileDownloadTask.cancel(true);
                }
                if (this.mOrderingType == TrunkMessageControl.OrderingType.Recent) {
                    view.findViewById(C0062R.id.trunkRootLayout).setBackgroundResource(C0062R.drawable.trunk_item_image_no_new_comment_border);
                    imageView.setImageResource(C0062R.drawable.loadmore_selector);
                    progressBar.setVisibility(8);
                    imageView2.setVisibility(8);
                    viewFindViewById.setVisibility(8);
                    textView.setVisibility(8);
                    imageView.setOnClickListener(new OnClickLoadMoreListener(view, string, DatabaseConstant.TrunkItemTable.ItemType.LoadMore));
                    return;
                }
                return;
            }
            return;
        }
        imageView.setImageDrawable(null);
        progressBar.setVisibility(8);
        imageView2.setVisibility(8);
        textView.setVisibility(0);
        int i = cursor.getInt(cursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_TOTAL_COMMENT_COUNT));
        String string2 = cursor.getString(cursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_THUMBNAIL));
        int i2 = cursor.getInt(cursor.getColumnIndex("unread_comment_count"));
        TrunkUtil.ContentType contentTypeGetContentType = TrunkUtil.GetContentType(cursor.getString(cursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_CONTENT_TYPE)));
        String string3 = cursor.getString(cursor.getColumnIndex(DatabaseConstant.TrunkItemColumns.KEY_DOWN_URL));
        if (i2 > 0) {
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(8);
        }
        TrunkUtil.SetCountToBubble(textView, i);
        String directory = contentTypeGetContentType == TrunkUtil.ContentType.VIDEO ? getDirectory() : getThumbnailDirectory();
        try {
            String strExtractFileNameFromUrl = TrunkUtil.ExtractFileNameFromUrl(string2);
            if (contentTypeGetContentType == TrunkUtil.ContentType.VIDEO) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            FileDownloadTask fileDownloadTask2 = (FileDownloadTask) this.mMapper.remove(imageView);
            if (fileDownloadTask2 != null) {
                fileDownloadTask2.setTag(null);
                fileDownloadTask2.cancel(true);
            }
            FileDownloadManager fileDownloadManager = FileDownloadManager.getInstance();
            Uri uriCache = fileDownloadManager.cache(directory, strExtractFileNameFromUrl);
            if (uriCache != null) {
                ChatONLogWriter.m3506b("Finded cached data.", TAG);
                setThumbnailImage(imageView, contentTypeGetContentType, uriCache);
            } else if (contentTypeGetContentType == TrunkUtil.ContentType.IMAGE) {
                ChatONLogWriter.m3506b("Can't find cache data. Execting download.", TAG);
                Views views = new Views();
                views.setContentType(contentTypeGetContentType);
                views.setImageView(imageView);
                views.setProgressBar(progressBar);
                this.mMapper.put(imageView, fileDownloadManager.download(this.mDownloadHandler, string2, directory, strExtractFileNameFromUrl, views));
                progressBar.setVisibility(0);
            } else if (contentTypeGetContentType == TrunkUtil.ContentType.VIDEO) {
                ChatONLogWriter.m3506b("Can't find cache data. Show default image for video.", TAG);
                imageView.setImageResource(C0062R.drawable.video_default);
            }
            imageView.setOnClickListener(new OnClickItemListener(view, string, DatabaseConstant.TrunkItemTable.ItemType.Item, string3, contentTypeGetContentType));
        } catch (MalformedURLException e) {
            ChatONLogWriter.m3499a("TrunkAdapter.ExtractFileNameFromUrl", TAG);
            ChatONLogWriter.m3501a(e, TAG);
        }
    }

    public TrunkMessageControl.OrderingType getOrderingType() {
        return this.mOrderingType;
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(C0062R.layout.item_trunk, viewGroup, false);
    }

    public void setOnContentClickListener(OnContentClickListener onContentClickListener) {
        this.mOnContentClickListener = onContentClickListener;
    }

    public void setOrderingType(TrunkMessageControl.OrderingType orderingType) {
        this.mOrderingType = orderingType;
    }
}
