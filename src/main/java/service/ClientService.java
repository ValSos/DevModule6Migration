package service;

import database.Database;
import entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement readSt;
    private PreparedStatement updateSt;
    private PreparedStatement deleteSt;
    private PreparedStatement selectSt;
    private final Connection connection;

    public ClientService() throws SQLException {
        connection = Database.getInstance().getConnection();
        createSt = connection
                .prepareStatement("INSERT INTO client (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);

        readSt = connection
                .prepareStatement("SELECT id, name FROM client WHERE id = ?");
        updateSt = connection
                .prepareStatement("UPDATE client SET name = ? WHERE id = ?");
        deleteSt = connection
                .prepareStatement("DELETE FROM client WHERE id = ?");
        selectSt = connection.prepareStatement("SELECT * FROM client");

    }

    public long create(String name) throws SQLException {
        if (name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Некоректна довжина ім'я");
        }
        long id;
        createSt.setString(1, name);
        createSt.executeUpdate();

        ResultSet generatedKeys = createSt.getGeneratedKeys();
        generatedKeys.next();
        id = generatedKeys.getLong(1);
        return id;
    }

    public String getById(long id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        readSt.setLong(1, id);

        ResultSet rs = readSt.executeQuery();
        if (!rs.next()) {
            return null;
        } else {
            String name = rs.getString("name");
            return name;
        }
    }

    public void setName(long id, String name) throws SQLException {
        if (name.length() < 2 || name.length() > 1000) {
            throw new IllegalArgumentException("Некоректна довжина ім'я");
        }
        updateSt.setString(1, name);
        updateSt.setLong(2, id);
        updateSt.executeUpdate();
    }

    public void deleteById(long id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException();
        }
        deleteSt.setLong(1, id);
        deleteSt.executeUpdate();
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clientList = new ArrayList<>();
        ResultSet resultSet = selectSt.executeQuery();
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));
            clientList.add(client);
        }
        return clientList;


    }

}
