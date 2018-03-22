package com.mycp.jclft.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.mycp.jclft.R;
import com.mycp.jclft.activity.LastOpenActivity;
import com.mycp.jclft.activity.SportActivity;
import com.mycp.jclft.base.BaseFragment;
import com.mycp.jclft.loader.GlideImageLoader;
import com.paradoxie.autoscrolltextview.VerticalTextview;
import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 * Created by leo on 2018/3/11.
 */

public class Home1Fragment extends BaseFragment implements View.OnClickListener {
    private ArrayList<Integer> BannerList = new ArrayList<>();
    private RelativeLayout mSsqRl;
    private RelativeLayout mDltRl;
    private RelativeLayout mPl3Rl;
    private RelativeLayout mPl5Rl;
    private RelativeLayout mQxcRl;
    private RelativeLayout mQlcRl;
    private RelativeLayout mZqRl;
    private RelativeLayout mLqRl;
    private ArrayList<String> mNotify = new ArrayList<>();
    private RelativeLayout mRx9Rl;
    private RelativeLayout mSfcRl;
    private RelativeLayout mZqdcRl;
    private RelativeLayout m3DRl;
    private VerticalTextview mNotifyTv;

    @Override
    protected void initView(View view) {
        Banner banner = (Banner) view.findViewById(R.id.banner);
        BannerList.add(R.drawable.banner10);
        BannerList.add(R.drawable.banner8);
        BannerList.add(R.drawable.banner3);
        banner.setImages(BannerList)
                .setImageLoader(new GlideImageLoader())
                .start();

        mSsqRl = (RelativeLayout) view.findViewById(R.id.rl_ssq);
        mDltRl = (RelativeLayout) view.findViewById(R.id.rl_dlt);
        m3DRl = (RelativeLayout) view.findViewById(R.id.rl_3d);
        mPl3Rl = (RelativeLayout) view.findViewById(R.id.rl_pl3);
        mPl5Rl = (RelativeLayout) view.findViewById(R.id.rl_pl5);
        mQxcRl = (RelativeLayout) view.findViewById(R.id.rl_qxc);
        mQlcRl = (RelativeLayout) view.findViewById(R.id.rl_qlc);
        mZqRl = (RelativeLayout) view.findViewById(R.id.rl_jczq);
        mLqRl = (RelativeLayout) view.findViewById(R.id.rl_jclq);

        mRx9Rl = (RelativeLayout) view.findViewById(R.id.rl_rx9);
        mSfcRl = (RelativeLayout) view.findViewById(R.id.rl_sfc);
        mZqdcRl = (RelativeLayout) view.findViewById(R.id.rl_zqdc);
        mNotifyTv = (VerticalTextview) view.findViewById(R.id.tv_notification);

        m3DRl.setOnClickListener(this);
        mSsqRl.setOnClickListener(this);
        mDltRl.setOnClickListener(this);
        mPl3Rl.setOnClickListener(this);
        mPl5Rl.setOnClickListener(this);
        mQxcRl.setOnClickListener(this);
        mQlcRl.setOnClickListener(this);
        mZqRl.setOnClickListener(this);
        mLqRl.setOnClickListener(this);
        mSfcRl.setOnClickListener(this);
        mZqdcRl.setOnClickListener(this);
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home1;
    }

    @Override
    protected void initData() {
        mNotify.add("周六064比赛取消");
        mNotify.add("美职篮新赛季战火重燃");
        mNotify.add("周日053比赛取消");
        mNotify.add("周六028比赛取消");
        mNotifyTv.setTextList(mNotify);//加入显示内容,集合类型
        mNotifyTv.setText(14, 5, getResources().getColor(R.color.common_60));//设置属性,具体跟踪源码
        mNotifyTv.setTextStillTime(4000);//设置停留时长间隔
        mNotifyTv.setAnimTime(300);//设置进入和退出的时间间隔
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_ssq:
                jumpToLastOpenActivity("双色球", "ssq");
                break;
            case R.id.rl_dlt:
                jumpToLastOpenActivity("大乐透", "dlt");
                break;
            case R.id.rl_3d:
                jumpToLastOpenActivity("3D", "fc3d");
                break;
            case R.id.rl_pl3:
                jumpToLastOpenActivity("排列3", "pl3");
                break;
            case R.id.rl_pl5:
                jumpToLastOpenActivity("排列5", "pl5");
                break;
            case R.id.rl_qxc:
                jumpToLastOpenActivity("七星彩", "qxc");
                break;
            case R.id.rl_qlc:
                jumpToLastOpenActivity("七乐彩", "qlc");
                break;
            case R.id.rl_sfc:
                jumpToLastOpenActivity("胜负彩", "zcsfc");
                break;
            case R.id.rl_rx9:
                jumpToLastOpenActivity("任选9", "rx9");
                break;
            case R.id.rl_jczq:
                Intent intent = new Intent(getActivity(), SportActivity.class);
                intent.putExtra("name", "竞猜足球");
                getActivity().startActivity(intent);
                break;
            case R.id.rl_jclq:
                Intent intent1 = new Intent(getActivity(), SportActivity.class);
                intent1.putExtra("name", "竞猜篮球");
                getActivity().startActivity(intent1);
                break;
            case R.id.rl_zqdc:
                Intent intent2 = new Intent(getActivity(), SportActivity.class);
                intent2.putExtra("name", "足球单场");
                getActivity().startActivity(intent2);
                break;
            default:
                break;
        }
    }

    private void jumpToLastOpenActivity(String name, String code) {
        if (getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        Intent intent = new Intent(getActivity(), LastOpenActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("code", code);
        getActivity().startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        mNotifyTv.startAutoScroll();
    }

    @Override
    public void onPause() {
        super.onPause();
        mNotifyTv.stopAutoScroll();
    }
}
