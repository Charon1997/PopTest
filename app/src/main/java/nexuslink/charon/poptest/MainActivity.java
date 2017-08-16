package nexuslink.charon.poptest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import static nexuslink.charon.poptest.Constant.DURATION;

public class MainActivity  extends AppCompatActivity implements IMainView,View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    public static int mode;
    private ImageView mIv,animImg;
    private Button mBt;
    private IMainView mainView = this;
    private MPopWindow mPopWindow;
    private int layout[] = {R.layout.activity_main,R.layout.activity_mode2};
    private int door[] = {R.id.main_mode1_door, R.id.main_mode2_door};
    private int animArrayImg[] = {R.id.main_anim_mode1_img,R.id.main_anim_mode2_img};
    private int background[] = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chooseMode(0);
        mPopWindow = new MPopWindow(this,mainView);
    }
    @Override
    public void onClick(View v) {
                mPopWindow.showPopupWindow(LayoutInflater.from(this).inflate(R.layout.activity_main, null));
    }

    @Override
    public void translationImg(int x, int y, final int resource, Context mContext) {
        //x y 为列表的门的xy，resource 资源
        animImg.setVisibility(View.VISIBLE);
        float width = ScreenUtils.getScreenWidth(mContext);
        float height = ScreenUtils.getScreenHeight(mContext);
        switch (mode){
            case 0:
                //比例系数
                width *= 0.7575;
                height *=0.38;
                break;
            case 1:
                width *= 0.44;
                height *=0.48;
                break;
        }

        animImg.setImageResource(resource);
        Log.d(TAG, "translationImg: "+width+"h"+height);

        Log.d(TAG, "onClick:changeImg h "+mIv.getHeight()+"w"+mIv.getWidth());
        Log.d(TAG, "onClick:animImg h "+animImg.getHeight()+"w"+animImg.getWidth());

        float scaleX = (float) (mIv.getWidth() / animImg.getWidth());
        float scaleY = (float) (mIv.getHeight() / animImg.getHeight());

        anim(x,y,width,height,scaleX,scaleY);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animImg.setVisibility(View.GONE);
                mIv.setImageResource(resource);
            }
        },DURATION);

    }

    @Override
    public void chooseMode(final int position) {

        mode = position;
        setContentView(layout[position]);
        mIv = (ImageView) findViewById(door[position]);
        animImg = (ImageView) findViewById(animArrayImg[position]);

        mIv.setOnClickListener(this);
    }

    private void anim(int x, int y, float width, float height, float scaleX, float scaleY) {
        AnimatorSet set = new AnimatorSet();

        ObjectAnimator ob1 = ObjectAnimator.ofFloat(animImg,"translationX",x,width);
        ObjectAnimator ob2 = ObjectAnimator.ofFloat(animImg,"translationY",y,height);
        ObjectAnimator ob3 = ObjectAnimator.ofFloat(animImg,"ScaleX",1.0f,0.0f);
        ObjectAnimator ob4 = ObjectAnimator.ofFloat(animImg,"ScaleY",1.0f,0.0f);
        ObjectAnimator ob5 = ObjectAnimator.ofFloat(animImg, "ScaleX", 0.0f, scaleX);
        ObjectAnimator ob6 = ObjectAnimator.ofFloat(animImg, "ScaleY", 0.0f, scaleY);
        set.playTogether(ob1,ob2,ob3,ob4);
        set.play(ob5).after(ob4).with(ob6);
        set.setDuration(DURATION/2);
        set.setInterpolator(new AccelerateInterpolator());
        set.start();
    }
}
