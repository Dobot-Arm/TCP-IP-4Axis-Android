package cc.dobot.crtcpdemo.message.product.cr;

import android.os.Build;

import com.xuhao.didi.core.pojo.OriginalData;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import cc.dobot.crtcpdemo.message.base.BaseMessage;

public class CRMessageServoJ extends BaseMessage {
    double j1,j2,j3,j4;

    @Override
    public void constructSendData() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.messageContent=("ServoJ("+j1+","+j2+","+j3+","+j4+")").getBytes(StandardCharsets.US_ASCII);
        }else
            this.messageContent=("ServoJ("+j1+","+j2+","+j3+","+j4+")").getBytes( Charset.forName("US-ASCII"));
        this.messageStrContent=("ServoJ("+j1+","+j2+","+j3+","+j4+")");
    }

    @Override
    public void transformReceiveData2Object(OriginalData data) {

        this.messageContent=data.getBodyBytes();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.messageStrContent = new String(data.getBodyBytes(), StandardCharsets.US_ASCII);
        }else
            this.messageStrContent = new String(data.getBodyBytes(),Charset.forName("US-ASCII"));
    }



    public void setPoint(double[] point)
    {
        j1=point[0];
        j2=point[1];
        j3=point[2];
        j4=point[3];

        constructSendData();
    }

    public double[]getPoint(){
        return new double[]{j1,j2,j3,j4};
    }
}
