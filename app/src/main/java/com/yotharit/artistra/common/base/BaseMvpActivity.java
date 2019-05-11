package com.yotharit.artistra.common.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.akexorcist.localizationactivity.LocalizationActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static com.yotharit.artistra.common.constant.Constant.*;

public abstract class BaseMvpActivity<CP extends BaseMvpContractorPresenter> extends LocalizationActivity implements BaseMvpContractorView<CP> {
    private CP presenter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createPresenter();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (getLayoutView() != 0)
            setContentView(getLayoutView());

        bindView();
        setupView();

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent != null && intent.getExtras() != null) {
                restoreArgument(intent.getExtras());
            }
            initialize();
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(outState);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreInstanceState(savedInstanceState);
        restoreView();
    }

    protected abstract void createPresenter();

    protected abstract int getLayoutView();

    protected abstract void bindView();

    protected abstract void setupView();

    protected abstract void restoreArgument(Bundle extras);

    protected abstract void initialize();

    protected abstract void restoreInstanceState(Bundle savedInstanceState);

    protected abstract void restoreView();

    protected abstract void saveInstanceState(Bundle outState);

    protected CP getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(CP presenter) {
        this.presenter = presenter;
    }

    public void addFragment(@IdRes int containerId, @NonNull Fragment fragment) {
        addFragment(containerId, fragment, ANIM_DEFAULT);
    }

    public void addFragment(@IdRes int containerId, @NonNull Fragment fragment, int anim) {
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction transaction = transaction();

        if (getFragment(tag) != null)
            transaction.show(getFragment(tag));
        else
            transaction.add(containerId, fragment, tag);

        switch (anim) {
            case ANIM_FADE:
                break;
            case ANIM_SLIDE_UP:
                break;
            case ANIM_SLIDE_DOWN:
                break;
            case ANIM_SLIDE_LEFT:
                break;
            case ANIM_SLIDE_RIGHT:
                break;
        }

        transaction.commit();
    }

    public void removeFragment(@NonNull String tag) {
        removeFragment(tag, ANIM_DEFAULT);
    }

    public void removeFragment(@NonNull String tag, int anim) {
        Fragment fragment = getFragment(tag);

        if (fragment != null) {
            FragmentTransaction transaction = transaction();
            transaction.hide(fragment);

            switch (anim) {
                case ANIM_FADE:
                    break;
                case ANIM_SLIDE_UP:
                    break;
                case ANIM_SLIDE_DOWN:
                    break;
                case ANIM_SLIDE_LEFT:
                    break;
                case ANIM_SLIDE_RIGHT:
                    break;
            }

            transaction.commit();
        }
    }

    public void replaceFragment(@IdRes int containerId, @NonNull Fragment fragment) {
        String tag = fragment.getClass().getSimpleName();
        transaction()
                .replace(containerId, fragment, tag)
                .commit();
    }

    private Fragment getFragment(String tag) {
        return getSupportFragmentManager().findFragmentByTag(tag);
    }

    private FragmentTransaction transaction() {
        return getSupportFragmentManager().beginTransaction();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void showDialog(String message) {

    }
}
