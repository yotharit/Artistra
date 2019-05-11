package com.yotharit.artistra.common.base;

public abstract class BaseMvpPresenter<CV extends BaseMvpContractorView> implements BaseMvpContractorPresenter {
    private CV view;

    protected BaseMvpPresenter(CV view) {
        this.view = view;
        view.setPresenter(this);
    }

    public CV getView() {
        return view;
    }

    @Override
    public abstract void start();

    @Override
    public abstract void stop();
}
