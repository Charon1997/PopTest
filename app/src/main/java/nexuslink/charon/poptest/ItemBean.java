package nexuslink.charon.poptest;

/**
 * 项目名称：PopTest
 * 类描述：
 * 创建人：Charon
 * 创建时间：2017/8/15 9:49
 * 修改人：Charon
 * 修改时间：2017/8/15 9:49
 * 修改备注：
 */

public class ItemBean {
    private int img;
    private String introduce;

    public ItemBean(int img, String introduce) {
        this.img = img;
        this.introduce = introduce;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
