package nexuslink.charon.poptest.ui.activity;

import android.content.Context;

/**
 * 项目名称：PopTest
 * 类描述：
 * 创建人：Charon
 * 创建时间：2017/8/15 17:57
 * 修改人：Charon
 * 修改时间：2017/8/15 17:57
 * 修改备注：
 */

public interface IMainView {
    void translationImg(int x, int y, int resource, Context mContext);

    void chooseMode(int position);
}
