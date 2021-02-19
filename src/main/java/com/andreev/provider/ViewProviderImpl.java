package com.andreev.provider;

public class ViewProviderImpl implements ViewProvider {

    @Override
    public void provideView(String result) {
        System.out.println(result);
    }
}
