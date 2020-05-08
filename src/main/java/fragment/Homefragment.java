package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.xiangnmu.HomeAdapter;
import com.example.xiangnmu.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import bean.NewsBean;
import homemvp.LoginPersenter;
import homemvp.LoginView;

public class Homefragment extends Fragment implements LoginView {

    private TabLayout mTab;
    private ViewPager mViewPager;
    private List<NewsBean.DataBean.BannerListBean> bannerlist;
    private List<NewsBean.DataBean.ArticleListBean> list;
    private LoginPersenter persenter;
    private RecyclerView mRecycler;
    private HomeAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.homefragment, container, false);
        persenter = new LoginPersenter(this);

        initView(inflate);

        persenter.getBanner();
        persenter.getData();

        return inflate;
    }

    private void initView(View inflate) {
       // mTab = inflate.findViewById(R.id.tab);
       // mViewPager = inflate.findViewById(R.id.viewpager);
        mRecycler = inflate.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        bannerlist = new ArrayList<>();
        list = new ArrayList<>();

        adapter = new HomeAdapter(getActivity());
    }

    @Override
    public void showToast(String str) {

    }

    @Override
    public void setBanner(List<NewsBean.DataBean.BannerListBean> bannerbean) {

        adapter.setBannerlist(bannerlist);

    }

    @Override
    public void setData(List<NewsBean.DataBean.ArticleListBean> data) {

        adapter.setList(data);
    }
}
