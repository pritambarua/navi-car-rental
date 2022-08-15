package com.navi.factory;



import com.navi.executor.CommandParserExecutor;
import com.navi.model.enums.Command;
import com.navi.parser.AddBookingParser;
import com.navi.parser.AddVehicleParser;
import com.navi.model.Store;
import com.navi.parser.AddBranchParser;
import com.navi.parser.AddDisplayParser;

import java.util.List;

public class CommandFactory {
    private CommandParserExecutor executor;
    private final Store store;

    public CommandFactory(Store store){
        this.store = store;
    }

    public CommandFactory setCommand(String userCommand){
        Command command = Command.valueOf(userCommand);

        switch (command) {
            case BOOK -> executor = new AddBookingParser(store);
            case ADD_BRANCH -> executor = new AddBranchParser(store);
            case ADD_VEHICLE -> executor = new AddVehicleParser(store);
            case DISPLAY_VEHICLES -> executor = new AddDisplayParser(store);
        }

        return this;
    }

    public String evaluate(List<String> args){
        return executor.evaluate(args);
    }
}
