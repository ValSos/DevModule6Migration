package service;

import database.Database;
import entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement readSt;
    private final Connection connection;

    public ClientService() throws SQLException {
        connection = Database.getInstance().getConnection();
        createSt = connection
                .prepareStatement("INSERT INTO client (name) VALUES (?)");

        readSt = connection
                .prepareStatement("SELECT id, name FROM client WHERE id = ?");
    }

    public long create(String name) throws SQLException {
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
            Client result = new Client();
            result.setName(name);
            return name;
        }
    }

}
