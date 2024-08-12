package service.client;

import model.Client;

import java.util.List;

public interface IClientService {
    public List<Client> getClients();
    public Client getClient(Long id);
    public Client addClient(Client client);
    public Client updateClient(Client client);
    public Client deleteClient(Long id);
}
