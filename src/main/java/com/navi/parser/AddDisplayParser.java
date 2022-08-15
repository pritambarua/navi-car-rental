package com.navi.parser;

import com.navi.executor.CommandParserExecutor;
import com.navi.model.Store;

import java.util.List;

public class AddDisplayParser extends CommandParserExecutor {

    public AddDisplayParser(Store store) {
        super(store);
    }

    @Override
    public String evaluate(List<String> args) {
        String branchName = args.get(0);
        String startTime = args.get(1);
        String endTime = args.get(2);

        return store.displayVehicles(branchName, startTime, endTime);
    }
}