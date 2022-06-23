package com.mapfintech.intern;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client createClient(Client client);

    Client updateClient(String key, Client clientRequest);

    void deleteClient(String key);

    Client getClient(String key);
}
