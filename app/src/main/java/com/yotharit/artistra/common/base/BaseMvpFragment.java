package com.yotharit.artistra.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseMvpFragment<CP extends BaseMvpContractorPresenter> extends Fragment implements BaseMvpContractorView<CP> {
    private CP presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return LayoutInflater.from(container.getContext()).inflate(getLayoutView(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createPresenter();
        bindView(view);
        setupView();

        if (savedInstanceState == null) {
            restoreArgument(getArguments());

            initialize();
        } else {
            restoreView(savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null)
            restoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(outState);
    }

    public abstract int getLayoutView();

    protected abstract void createPresenter();

    public abstract void bindView(View view);

    public abstract void setupView();

    public abstract void restoreArgument(Bundle bundle);

    public abstract void initialize();

    public abstract void restoreInstanceState(Bundle savedInstanceState);

    public abstract void restoreView(Bundle savedInstanceState);

    public abstract void saveInstanceState(Bundle outState);

    public CP getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(CP presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void showDialog(String message) {
        // TODO: 7/26/2018 ควรใส่ code dialog ไว้ตรงนี้
    }
}