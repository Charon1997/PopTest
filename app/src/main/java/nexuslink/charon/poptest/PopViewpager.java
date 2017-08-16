package nexuslink.charon.poptest;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 项目名称：PopTest
 * 类描述：
 * 创建人：Charon
 * 创建时间：2017/8/15 0:50
 * 修改人：Charon
 * 修改时间：2017/8/15 0:50
 * 修改备注：
 */

public class PopViewpager extends PagerAdapter {
    private List<View> list_view;
    private String[] titles = {"款式","颜色","风格"};

    public PopViewpager(List<View> list_view) {
        this.list_view = list_view;
    }

    @Override
    public int getCount() {
        return list_view.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list_view.get(position),0);
        return list_view.get(position );
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
        view = null;
    }
}
