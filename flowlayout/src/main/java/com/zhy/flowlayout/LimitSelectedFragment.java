package com.zhy.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.CommonTagFlowLayout;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

/**
 * Created by zhy on 15/9/10.
 */
public class LimitSelectedFragment extends Fragment {


    private CommonTagFlowLayout mFlowLayout;
    private TagAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final LayoutInflater mInflater = LayoutInflater.from(getActivity());
        mFlowLayout = (CommonTagFlowLayout) view.findViewById(R.id.id_flowlayout);
        mFlowLayout.setMaxLine(3);
        final ArrayList<String> mList = new ArrayList();
        mList.add("Android");
        mList.add("FlowLayout");
        mList.add("IOS");
        mList.add("WINDOWS");
        mList.add("AppCompatActivity");
        mList.add("TagFlowLayout");
        mList.add("MainActivity");
        mList.add("Bundle");
        mList.add("savedInstanceState");
        mList.add("onCreate");
        mList.add("dddddddddddddddddddddddddddddddddddddddfffffffffffffffffffffffffffffff");
        adapter = new TagAdapter<String>(mList) {

            @Override
            public View getView(FlowLayout parent, final int position, final String s) {
                FrameLayout tv = (FrameLayout) mInflater.inflate(R.layout.item_tv,
                        mFlowLayout, false);
                TextView textView = (TextView) tv.findViewById(R.id.tv);
                ImageView imageView = (ImageView) tv.findViewById(R.id.img);
                textView.setText(s);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mList.remove(position);
                        mFlowLayout.setMaxLine(10);
                        adapter.refreshTags(mList);
                        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
                    }
                });
                return tv;
            }
        };
        mFlowLayout.setAdapter(adapter);
    }
}
