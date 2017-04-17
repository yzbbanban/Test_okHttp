package test.ban.com.test_okhttp.model.impl;

import android.util.Log;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;
import test.ban.com.test_okhttp.constants.Urls;
import test.ban.com.test_okhttp.model.ICallback;
import test.ban.com.test_okhttp.model.IModel;

/**
 * Created by brander on 2017/4/14.
 */
public class ModelImpl implements IModel {
    private static final String TAG = "ModelImpl";
    @Override
    public void getMessage(final ICallback callback, Object object) {
        HashMap<String, String> params = new HashMap<>();
        params.put("CompNo", "tf003");
        params.put("UserID", "18795980532");
        params.put("UserPwd", "0532");
        params.put("CheckKey", "");
        JSONObject jsonObject = new JSONObject(params);

        OkGo.post(Urls.URL_TEXT_UPLOAD)//
                .tag(this)//
//	.params("param1", "paramValue1")//  这里不要使用params，upJson 与 params 是互斥的，只有 upJson 的数据会被上传
                .upJson(jsonObject.toString())//
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        //上传成功
                        callback.sendMessageSuccess(s);
                    }


                    @Override
                    public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        //这里回调上传进度(该回调在主线程,可以直接更新ui)
                        Log.i(TAG, "Progress: "+progress+"/"+totalSize);
                    }
                });



    }
}
