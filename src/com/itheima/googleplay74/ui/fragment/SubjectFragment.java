package com.itheima.googleplay74.ui.fragment;

import java.util.ArrayList;

import com.itheima.googleplay74.domain.SubjectInfo;
import com.itheima.googleplay74.http.protocol.SubjectProtocol;
import com.itheima.googleplay74.ui.adapter.MyBaseAdapter;
import com.itheima.googleplay74.ui.holder.BaseHolder;
import com.itheima.googleplay74.ui.holder.SubjectHolder;
import com.itheima.googleplay74.ui.view.MyListView;
import com.itheima.googleplay74.ui.view.LoadingPage.ResultState;
import com.itheima.googleplay74.utils.UIUtils;

import android.view.View;

/**
 * 专题
 * 
 * @author Kevin
 * @date 2015-10-27
 */
public class SubjectFragment extends BaseFragment {

	private ArrayList<SubjectInfo> data;

	@Override
	public View onCreateSuccessView() {
		MyListView view = new MyListView(UIUtils.getContext());
		view.setAdapter(new SubjectAdapter(data));
		return view;
	}

	@Override
	public ResultState onLoad() {
		SubjectProtocol protocol = new SubjectProtocol();
		data = protocol.getData(0);
		return check(data);
	}

	class SubjectAdapter extends MyBaseAdapter<SubjectInfo> {

		public SubjectAdapter(ArrayList<SubjectInfo> data) {
			super(data);
		}

		@Override
		public BaseHolder<SubjectInfo> getHolder(int position) {
			return new SubjectHolder();
		}

		@Override
		public ArrayList<SubjectInfo> onLoadMore() {
			SubjectProtocol protocol = new SubjectProtocol();
			ArrayList<SubjectInfo> moreData = protocol.getData(getListSize());
			return moreData;
		}

	}
}
