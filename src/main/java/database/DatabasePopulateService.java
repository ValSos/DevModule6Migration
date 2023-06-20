package database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {

    private static final String WORKERS_FILE = "sql/workers.txt";
    private static final String CLIENT_FILE = "sql/client.txt";
    private static final String PROJECT_FILE = "sql/project.txt";
    private static final String PROJECT_WORKER_FILE = "sql/project_worker.txt";
    private static final String INSERT_WORKER_SQL = "INSERT INTO " +
            "worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
    private static final String INSERT_CLIENT_SQL = "INSERT INTO client (name) VALUES (?)";
    private static final String INSERT_PROJECT_SQL = "INSERT INTO " +
            "project (name, client_id, start_date, finish_date) VALUES (?, ?, ?, ?)";
    private static final String INSERT_PROJECT_WORKER_SQL = "INSERT INTO " +
            "project_worker (project_id , worker_id) VALUES (?, ?)";

    private final Connection connection = Database.getInstance().getConnection();




    public void insertWorkers() throws SQLException, FileNotFoundException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WORKER_SQL);
             BufferedReader reader = new BufferedReader(new FileReader(WORKERS_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] workerData = line.split(", ");

                preparedStatement.setString(1, workerData[0]);
                preparedStatement.setString(2, workerData[1]);
                preparedStatement.setString(3, workerData[2]);
                preparedStatement.setInt(4, Integer.parseInt(workerData[3]));

                preparedStatement.executeUpdate();
            }
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertClient() throws SQLException, FileNotFoundException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL);
             BufferedReader reader = new BufferedReader(new FileReader(CLIENT_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                preparedStatement.setString(1, line);
                preparedStatement.executeUpdate();
            }
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProject() throws SQLException, FileNotFoundException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_SQL);
             BufferedReader reader = new BufferedReader(new FileReader(PROJECT_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] projectData = line.split(", ");

                preparedStatement.setString(1, projectData[0]);
                preparedStatement.setInt(2, Integer.parseInt(projectData[1]));
                preparedStatement.setString(3, projectData[2]);
                preparedStatement.setString(4, projectData[3]);

                preparedStatement.executeUpdate();
            }
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProjectWorker() throws SQLException, FileNotFoundException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT_WORKER_SQL);
             BufferedReader reader = new BufferedReader(new FileReader(PROJECT_WORKER_FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] projectWorkerData = line.split(",");

                preparedStatement.setInt(1, Integer.parseInt(projectWorkerData[0]));
                preparedStatement.setInt(2, Integer.parseInt(projectWorkerData[1]));

                preparedStatement.executeUpdate();
            }
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
