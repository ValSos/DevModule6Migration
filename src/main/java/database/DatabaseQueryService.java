package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private static final String FIND_LONGEST_PROJECT = "sql/find_longest_project.sql";
    private static final String FIND_MAX_PROJECTS_CLIENT = "sql/find_max_projects_client.sql";
    private static final String FIND_MAX_SALARY_WORKER = "sql/find_max_salary_worker.sql";
    private static final String FIND_YOUNGEST_ELDEST_WORKERS = "sql/find_youngest_eldest_workers.sql";
    private static final String PRINT_PROJECT_PRICES = "sql/print_project_prices.sql";
    private static final String NAME = "name";
    private static final String SALARY = "salary";
    private static final String PROJECT_COUNT = "project_count";
    private static final String MONTH_COUNT = "month_count";
    private static final String TYPE = "type";
    private static final String BIRTHDAY = "birthday";
    private static final String PRICE = "price";
    private final Connection connection = Database.getInstance().getConnection();

    public List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> maxProjectsClientList = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(FIND_MAX_PROJECTS_CLIENT));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                maxProjectCountClient.setName(resultSet.getString(NAME));
                maxProjectCountClient.setProjectCount(resultSet.getInt(PROJECT_COUNT));
                maxProjectsClientList.add(maxProjectCountClient);
            }
        }
        catch (SQLException | IOException e){
            e.printStackTrace();
        }
        System.out.println(maxProjectsClientList);
        return maxProjectsClientList;
    }

    public List<LongestProject> findLongestProject(){
        List<LongestProject> longestProjectList = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(FIND_LONGEST_PROJECT));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                LongestProject longestProject = new LongestProject();
                longestProject.setName(resultSet.getString(NAME));
                longestProject.setMonthCount(resultSet.getInt(MONTH_COUNT));
                longestProjectList.add(longestProject);
            }
        }
        catch (SQLException | IOException e){
            e.printStackTrace();
        }
        System.out.println(longestProjectList);
        return longestProjectList;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(FIND_MAX_SALARY_WORKER));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                maxSalaryWorker.setName(resultSet.getString(NAME));
                maxSalaryWorker.setSalary(resultSet.getInt(SALARY));
                maxSalaryWorkers.add(maxSalaryWorker);
            }
        }
        catch (SQLException | IOException e){
            e.printStackTrace();
        }
        System.out.println(maxSalaryWorkers);
        return maxSalaryWorkers;
    }

    public List<YoungestEldestWorkers> findYoungestAndEldestWorkers(){
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(FIND_YOUNGEST_ELDEST_WORKERS));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers();
                youngestEldestWorkers.setName(resultSet.getString(NAME));
                youngestEldestWorkers.setBirthday(resultSet.getString(BIRTHDAY));
                youngestEldestWorkers.setType(resultSet.getString(TYPE));
                youngestEldestWorkersList.add(youngestEldestWorkers);
            }
        }
        catch (SQLException | IOException e){
            e.printStackTrace();
        }
        System.out.println(youngestEldestWorkersList);
        return youngestEldestWorkersList;
    }

    public List<ProjectPrices> printProfectPrices(){
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            String sql = Files.readString(Path.of(PRINT_PROJECT_PRICES));
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                ProjectPrices projectPrices = new ProjectPrices();
                projectPrices.setProjectName(resultSet.getString(NAME));
                projectPrices.setPrice(resultSet.getInt(PRICE));
                projectPricesList.add(projectPrices);
            }
        }
        catch (SQLException | IOException e){
            e.printStackTrace();
        }
        System.out.println(projectPricesList);
        return projectPricesList;
    }

}
