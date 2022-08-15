package com.navi.executor;

import com.navi.model.Store;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandParserExecutor {
    List<String> params;
    public Store store;
    protected CommandParserExecutor(Store store){
        params = new ArrayList<>();
        this.store = store;
    }

    public abstract String evaluate(List<String> args);
}
