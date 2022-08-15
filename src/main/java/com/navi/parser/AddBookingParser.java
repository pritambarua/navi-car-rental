package com.navi.parser;

import com.navi.executor.CommandParserExecutor;
import com.navi.model.Store;

import java.util.List;

public class AddBookingParser extends CommandParserExecutor {

    public AddBookingParser(Store store) {
        super(store);
    }

    @Override
    public String evaluate(List<String> args) {
        String branchName = args.get(0);
        String vehicleType = args.get(1);
        String startTime = args.get(2);
        String endTime = args.get(3);

        return String.valueOf(store.bookVehicle(branchName, vehicleType, startTime, endTime));
    }
}