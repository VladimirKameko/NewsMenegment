package by.home.pvt.controller;

import by.home.pvt.controller.impl.ShowAllNewsController;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();

    private Map<CommandName, Command> commands = new HashMap<>();

    private CommandProvider() {
        commands.put(CommandName.GO_TO_SHOW_ALL_NEWS_PAGE,new ShowAllNewsController());
    }

    public Command getCommand(String name) {
        CommandName commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }

    public static CommandProvider getInstance() {
        return instance;
    }
}
