package test.ban.com.test_okhttp.present.impl;

import test.ban.com.test_okhttp.model.IModel;
import test.ban.com.test_okhttp.model.impl.ModelImpl;
import test.ban.com.test_okhttp.present.IPresent;
import test.ban.com.test_okhttp.view.IView;

/**
 * Created by brander on 2017/4/14.
 */
public class PresentImpl implements IPresent {
    private IView view;
    private IModel model;

    public PresentImpl(IView view) {
        this.view = view;
        this.model=new ModelImpl();
    }

    @Override
    public void getMessageFromModel(Object object) {

    }
}
