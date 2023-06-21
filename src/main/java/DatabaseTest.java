
import org.flywaydb.core.Flyway;
import service.ClientService;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseTest {
    public static void main(String[] args) throws SQLException {
        final ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        final String JDBC_URL = "jdbcURL";

        Flyway flyway = Flyway
                .configure()
                .dataSource(resourceBundle.getString(JDBC_URL), null, null)
                .load();
        flyway.migrate();

        ClientService clientService = new ClientService();
        clientService.deleteById(1l);
        System.out.println(clientService.listAll());
        System.out.println(clientService.create("Valeriia Sosyedka"));
        System.out.println(clientService.getById(2l));
        clientService.setName(2,"Petro Petrenko");
        System.out.println(clientService.getById(2l));
        System.out.println(clientService.listAll());
        clientService.deleteById(2l);
        System.out.println(clientService.listAll());

    }
}
