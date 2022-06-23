package com.mapfintech.intern;

import org.apache.commons.validator.GenericValidator;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private GenericValidator genericValidator = new GenericValidator();
    Logger LOGGER = Logger.getLogger(InternApplicationController.class.getName());

    public ClientServiceImpl(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(String key) {
        Optional<Client> result;
        if (genericValidator.isInt(key)) {
            result = clientRepository.findByClientId(Integer.parseInt(key));
        } else {
            result = clientRepository.findByClientUserName(key);
        }
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Client createClient(Client client) {
        boolean flag = false;
        Optional<Client> result = clientRepository.findByClientUserName(client.getClientUserName());
        if (result.isPresent()) {
            LOGGER.warning("Username " + client.getClientUserName() + " is already taken");
            flag = true;
        }
        if ((client.getClientUserName().length() < 8 || client.getClientUserName().length() > 16) && genericValidator.isInt(client.getClientUserName())) {
            LOGGER.warning("Username " + client.getClientUserName() + " is not valid");
            flag = true;
        }
        if (!genericValidator.isEmail(client.getClientEmail())) {
            LOGGER.warning("Email " + client.getClientEmail() + " is not valid");
            flag = true;
        }
        if (!genericValidator.isInRange(client.getClientPhone(), 10000000, 99999999)) {
            LOGGER.warning("Phone number " + client.getClientPhone() + " is not valid");
            flag = true;
        }
        if (!flag) {
            Client clientPush = null;
            try {
                clientPush = clientRepository.save(client);
                LOGGER.info("A new client with ClientID: " + client.getClientId() + " and Username: " + client.getClientUserName() + " has been created");
            } catch (Exception e) {
                e.getStackTrace();
            } finally {
                return clientPush;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Client updateClient(String key, Client clientRequest) {
        boolean flag = false;
        Client client;
        if (genericValidator.isInt(key)) {
            client = clientRepository.findByClientId(Integer.parseInt(key))
                    .orElseThrow(() -> new ResourceNotFoundException());
        } else {
            client = clientRepository.findByClientUserName(key)
                    .orElseThrow(() -> new ResourceNotFoundException());
        }
        Optional<Client> result = clientRepository.findByClientUserName(clientRequest.getClientUserName());
        if (result.isPresent() && !client.getClientUserName().equals(clientRequest.getClientUserName())) {
            LOGGER.warning("Username " + clientRequest.getClientUserName() + " is already taken");
            flag = true;
        }
        if (clientRequest.getClientUserName().length() < 8 || clientRequest.getClientUserName().length() > 16 || genericValidator.isInt(clientRequest.getClientUserName())) {
            LOGGER.warning("Username " + clientRequest.getClientUserName() + " is not valid");
            flag = true;
        }
        if (!genericValidator.isEmail(clientRequest.getClientEmail())) {
            LOGGER.warning("Email " + clientRequest.getClientEmail() + " is not valid");
            flag = true;
        }
        if (!genericValidator.isInRange(clientRequest.getClientPhone(), 10000000, 99999999)) {
            LOGGER.warning("Phone number " + clientRequest.getClientPhone() + " is not valid");
            flag = true;
        }
        if (!flag) {
            client.setClientUserName(clientRequest.getClientUserName());
            client.setClientName(clientRequest.getClientName());
            client.setClientSurname(clientRequest.getClientSurname());
            client.setClientCompany(clientRequest.getClientCompany());
            client.setClientLEI(clientRequest.getClientLEI());
            client.setClientEmail(clientRequest.getClientEmail());
            client.setClientPhone(clientRequest.getClientPhone());
            client.setClientStatus(2);
            client.setClientDateUpdated(clientRequest.getClientDateUpdated());
            client.setClientUserUpdated(clientRequest.getClientUserUpdated());
            Client clientPush = null;
            try {
                clientPush = clientRepository.save(client);
                LOGGER.info("Updated client with ClientID: " + client.getClientId() + " and Username: " + client.getClientUserName());
            } catch (Exception e) {
                e.getStackTrace();
            } finally {
                return clientPush;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void deleteClient(String key) {
        Client client;
        if (genericValidator.isInt(key)) {
            client = clientRepository.findByClientId(Integer.parseInt(key))
                    .orElseThrow(() -> new ResourceNotFoundException());
        } else {
            client = clientRepository.findByClientUserName(key)
                    .orElseThrow(() -> new ResourceNotFoundException());
        }
        try {
            clientRepository.delete(client);
            LOGGER.info("Deleted client with ClientID: " + client.getClientId() + " and Username: " + client.getClientUserName());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}