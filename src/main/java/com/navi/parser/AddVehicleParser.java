package com.navi.parser;

import com.navi.executor.CommandParserExecutor;
import com.navi.model.Store;

import java.util.List;

public class AddVehicleParser extends CommandParserExecutor {

    public AddVehicleParser(Store store) {
        super(store);
    }

    @Override
    public String evaluate(List<String> args) {
        String branchName = args.get(0);
        String vehicleType = args.get(1);
        String name = args.get(2);
        String rate = args.get(3);

        return store.addVehicle(branchName, vehicleType, name, rate) ? "TRUE" : "FALSE";
    }
}