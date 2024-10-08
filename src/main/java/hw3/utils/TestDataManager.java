package hw3.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:TestData.properties"})
public interface TestDataManager extends Config {

    @Key("taskToSearch.name")
    String taskToSearchName();

    @Key("taskToSearch.version")
    String taskToSearchVersion();

    @Key("taskToSearch.status")
    String taskToSearchStatus();


}
