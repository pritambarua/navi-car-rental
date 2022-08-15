package com.navi.parser;



import com.navi.executor.CommandParserExecutor;
import com.navi.model.Store;

import java.util.List;

public class AddBranchParser extends CommandParserExecutor {
    public AddBranchParser(Store store) {
        super(store);
    }
    @Override
    public String evaluate(List<String> args) {
        String branchName = args.get(0);
        String vehicleTypes = args.get(1);
        return store.addBranch(branchName, vehicleTypes) ? "TRUE" : "FALSE";
    }
}