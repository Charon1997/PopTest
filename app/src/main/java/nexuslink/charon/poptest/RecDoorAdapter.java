package nexuslink.charon.poptest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * 项目名称：PopTest
 * 类描述：
 * 创建人：Charon
 * 创建时间：2017/8/15 9:48
 * 修改人：Charon
 * 修改时间：2017/8/15 9:48
 * 修改备注：
 */

public class RecDoorAdapter extends RecyclerView.Adapter {
    private List<ItemBean> list;
    private Context mContext;
    private static final String TAG = RecDoorAdapter.class.getSimpleName();
    private IMainView mainView;

    public RecDoorAdapter( Context mContext,List<ItemBean> list ,IMainView mainView) {
        this.mContext = mContext;
        this.list = list;
        this.mainView = mainView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder)holder).mIv.setImageResource(list.get(position).getImg());
        ((MyViewHolder)holder).mTv.setText(list.get(position).getIntroduce());
        ((MyViewHolder)holder).mRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView myView =  ((MyViewHolder)holder).mIv;
                int location[] = new int[2];
                myView.getLocationOnScreen(location);
                int x = location[0];
                int y = location[1];
                mainView.translationImg(x,y,list.get(position).getImg(),mContext);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIv;
        private TextView mTv;
        private RelativeLayout mRl;
        public MyViewHolder(View itemView) {
            super(itemView);
            mRl = (RelativeLayout) itemView.findViewById(R.id.pop_item_relative);
            mIv = (ImageView) itemView.findViewById(R.id.pop_item_img);
            mTv = (TextView) itemView.findViewById(R.id.pop_item_text);
        }
    }
}
