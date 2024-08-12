package service.client;

import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public Client addClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client updateClient(Client client) {
        if(clientRepository.existsById(client.getIdClient())) {
            this.clientRepository.save(client);
        }
        return client;
    }

    @Override
    public Client deleteClient(Long id) {
        if(clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        }
        return this.getClient(id);
    }
}
