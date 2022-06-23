package com.mapfintech.intern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private MapStructMapper mapstructMapper;
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        super();
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        //this method returns all clients from database
        return clientService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        //this method creates a client with given data
        clientDto.setClientStatus(1); //sets clientStatus to 1 when client is created
        clientDto.setClientUserCreated(1); //sets userCreated to 1 when client is created
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        clientDto.setClientDateCreated(timestamp); //current timestamp
        clientService.createClient(mapstructMapper.clientDtoToClient(clientDto));
        return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
    }

    @PutMapping("/{key}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable(value = "key") String key, @RequestBody ClientDto clientDto) {
        //this method updates a client with a key (id or username) and given data
        clientDto.setClientStatus(2); //sets clientStatus to 2 when client is updated
        clientDto.setClientUserUpdated(1); //sets userUpdated to 1 when client is created
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        clientDto.setClientDateUpdated(timestamp); //current timestamp
        Client client = mapstructMapper.clientDtoToClient(clientDto);
        clientDto = mapstructMapper.clientToClientDto(clientService.updateClient(key, client));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientDto);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity<ClientDto> deleteClient(@PathVariable(value = "key") String key) {
        //this method deletes a client with a key (id or username)
        clientService.deleteClient(key);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @GetMapping("/{key}")
    public ResponseEntity<ClientDto> getClient(@PathVariable(value = "key") String key) {
        //this method returns a client with a key (id or username)
        return new ResponseEntity<>(mapstructMapper.clientToClientDto(clientService.getClient(key)), HttpStatus.OK);
    }

}
