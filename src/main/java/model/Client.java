package model;

import lombok.Data;

@Data

public class Client {
    private Long idClient;
    private String name;
    private String lastName;
    private String dni;

    public Client(Long idClient, String name, String lastName, String dni) {
        this.idClient = idClient;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
    }

}
