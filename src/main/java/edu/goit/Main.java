package edu.goit;

import edu.goit.entity.Client;
import edu.goit.service.ClientCrudService;
import edu.goit.service.PlanetCrudService;
import edu.goit.util.HibernateUtil;
import org.flywaydb.core.Flyway;

public class Main {


    public static void main(String[] args) {
        final String url = "jdbc:h2:./mydb;TRACE_LEVEL_SYSTEM_OUT=3";
        final String user = "";
        final String password = "";

        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
        flyway.migrate();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        System.out.println(clientCrudService.get(2L));
        Client client = clientCrudService.get(4L).orElseThrow();
        client.setName("Update Name");
        clientCrudService.update(client);
        System.out.println(clientCrudService.get(4L));
        Client newClient = Client.builder().name("New client").build();
        clientCrudService.create(newClient);
        System.out.println(clientCrudService.get(11L));
        clientCrudService.delete(Client.builder().id(6L).build());
        System.out.println(clientCrudService.get(6L));

        System.out.println(planetCrudService.get("SAT"));

        HibernateUtil.getInstance().close();

    }

}