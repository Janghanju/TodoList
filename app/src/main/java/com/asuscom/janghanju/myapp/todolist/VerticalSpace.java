package com.asuscom.janghanju.myapp.todolist;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by MacBook on 2018. 1. 18..
 */

public class VerticalSpace extends RecyclerView.ItemDecoration{

    private int verticalSpace ;

    public VerticalSpace(int verticalSpace) {
        this.verticalSpace = verticalSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = verticalSpace;
    }
}
