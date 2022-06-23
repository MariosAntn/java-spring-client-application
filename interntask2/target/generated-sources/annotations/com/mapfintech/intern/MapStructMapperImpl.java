package com.mapfintech.intern;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-23T11:12:18+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setClientId( client.getClientId() );
        clientDto.setClientUserName( client.getClientUserName() );
        clientDto.setClientName( client.getClientName() );
        clientDto.setClientSurname( client.getClientSurname() );
        clientDto.setClientCompany( client.getClientCompany() );
        clientDto.setClientLEI( client.getClientLEI() );
        clientDto.setClientEmail( client.getClientEmail() );
        clientDto.setClientPhone( client.getClientPhone() );
        clientDto.setClientDemoFlag( client.getClientDemoFlag() );
        clientDto.setClientStatus( client.getClientStatus() );
        clientDto.setClientDateCreated( client.getClientDateCreated() );
        clientDto.setClientDateUpdated( client.getClientDateUpdated() );
        clientDto.setClientUserCreated( client.getClientUserCreated() );
        clientDto.setClientUserUpdated( client.getClientUserUpdated() );

        return clientDto;
    }

    @Override
    public Client clientDtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setClientId( clientDto.getClientId() );
        client.setClientUserName( clientDto.getClientUserName() );
        client.setClientName( clientDto.getClientName() );
        client.setClientSurname( clientDto.getClientSurname() );
        client.setClientCompany( clientDto.getClientCompany() );
        client.setClientLEI( clientDto.getClientLEI() );
        client.setClientEmail( clientDto.getClientEmail() );
        client.setClientPhone( clientDto.getClientPhone() );
        client.setClientDemoFlag( clientDto.getClientDemoFlag() );
        client.setClientStatus( clientDto.getClientStatus() );
        client.setClientDateCreated( clientDto.getClientDateCreated() );
        client.setClientDateUpdated( clientDto.getClientDateUpdated() );
        client.setClientUserCreated( clientDto.getClientUserCreated() );
        client.setClientUserUpdated( clientDto.getClientUserUpdated() );

        return client;
    }
}
