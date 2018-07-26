package xyz.kongzz.datastructure.common.view.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.factory.model.SourceDataBean;

/**
 * 作者:Kong
 * 时间:2018/7/2617:33
 * 描述:这是 RecycleViewAdapter
 */

public class RecycleViewAdapter extends BaseQuickAdapter<SourceDataBean, BaseViewHolder> {

    public RecycleViewAdapter(int layoutResId, @Nullable List<SourceDataBean> data) {
        super(R.layout.item_show_detail, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SourceDataBean item) {
        // TODO
    }
}
