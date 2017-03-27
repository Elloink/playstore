package com.itheima.googleplay74.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.itheima.googleplay74.R;
import com.itheima.googleplay74.domain.CategoryInfo;
import com.itheima.googleplay74.utils.UIUtils;

/**
 * 分类模块标题holder
 * 
 * @author Kevin
 * @date 2015-11-1
 */
public class TitleHolder extends BaseHolder<CategoryInfo> {

	public TextView tvTitle;

	@Override
	public View initView() {
		View view = UIUtils.inflate(R.layout.list_item_title);
		tvTitle = (TextView) view.findViewById(R.id.tv_title);
		return view;
	}

	@Override
	public void refreshView(CategoryInfo data) {
		tvTitle.setText(data.title);
	}

}
