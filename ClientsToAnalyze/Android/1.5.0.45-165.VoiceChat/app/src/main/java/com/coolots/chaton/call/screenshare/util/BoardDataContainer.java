package com.coolots.chaton.call.screenshare.util;

import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BoardDataContainer implements DisposeInterface {
    private ArrayList<BoardData> mBoardDataList = new ArrayList<>();
    private int mPage;

    public int getPage() {
        return this.mPage;
    }

    public void setPage(int page) {
        this.mPage = page;
        this.mBoardDataList = new ArrayList<>();
    }

    public ArrayList<BoardData> getBoardData() {
        return this.mBoardDataList;
    }

    public void addData(int type, byte[] data) {
        BoardData boardData = new BoardData(type, data);
        this.mBoardDataList.add(boardData);
    }

    public void removeBoardData() {
        if (this.mBoardDataList != null && this.mBoardDataList.size() > 0) {
            this.mBoardDataList.clear();
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mBoardDataList != null) {
            this.mBoardDataList.clear();
            this.mBoardDataList = null;
        }
    }
}
