package com.mapfintech.intern;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface MapStructMapper {
    ClientDto clientToClientDto(Client client);
    Client clientDtoToClient(ClientDto clientDto);
}
