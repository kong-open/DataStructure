package xyz.kongzz.datastructure.common.view.adapter;


import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import xyz.kongzz.datastructure.R;

/**
 * 作者:Kong
 * 时间:2018/7/2617:33
 * 描述:这是 RecycleViewAdapter
 */

public class RecycleViewAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public RecycleViewAdapter(@Nullable List<Integer> data) {
        super(R.layout.item_show_detail, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        helper.setText(R.id.tv_number,String.valueOf(item.intValue()));
    }
}
