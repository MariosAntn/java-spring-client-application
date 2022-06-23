package com.mapfintech.intern;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Random;

@Entity
@Table(name = "client")
public class Client {
    //UUID
    private int clientId;
    private String clientUserName;
    private String clientName;
    private String clientSurname;
    private String clientCompany;
    private String clientLEI;
    private String clientEmail;
    private int clientPhone;
    private int clientDemoFlag;
    private int clientStatus;
    private Timestamp clientDateCreated;
    private Timestamp clientDateUpdated;
    private int clientUserCreated;
    private int clientUserUpdated;

    @Id
    private int id; //id is generated through the empty constructor

    public Client() {
        //this empty constructor generates the id
        Random generator = new Random();
        this.id = generator.nextInt(99999);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientUserName() {
        return clientUserName;
    }

    public void setClientUserName(String clientUserName) {
        this.clientUserName = clientUserName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public String getClientLEI() {
        return clientLEI;
    }

    public void setClientLEI(String clientLEI) {
        this.clientLEI = clientLEI;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(int clientPhone) {
        this.clientPhone = clientPhone;
    }

    public int getClientDemoFlag() {
        return clientDemoFlag;
    }

    public void setClientDemoFlag(int clientDemoFlag) {
        this.clientDemoFlag = clientDemoFlag;
    }

    public int getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(int clientStatus) {
        this.clientStatus = clientStatus;
    }

    public Timestamp getClientDateCreated() {
        return clientDateCreated;
    }

    public void setClientDateCreated(Timestamp clientDateCreated) {
        this.clientDateCreated = clientDateCreated;
    }

    public Timestamp getClientDateUpdated() {
        return clientDateUpdated;
    }

    public void setClientDateUpdated(Timestamp clientDateUpdated) {
        this.clientDateUpdated = clientDateUpdated;
    }

    public int getClientUserCreated() {
        return clientUserCreated;
    }

    public void setClientUserCreated(int clientUserCreated) {
        this.clientUserCreated = clientUserCreated;
    }

    public int getClientUserUpdated() {
        return clientUserUpdated;
    }

    public void setClientUserUpdated(int clientUserUpdated) {
        this.clientUserUpdated = clientUserUpdated;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", clientUserName='" + clientUserName + '\'' + ", clientName='" + clientName + '\'' + ", clientSurname='" + clientSurname + '\'' + ", clientCompany='" + clientCompany + '\'' + ", clientLEI='" + clientLEI + '\'' + ", clientEmail='" + clientEmail + '\'' + ", clientPhone=" + clientPhone + ", clientDemoFlag='" + clientDemoFlag + '\'' + ", clientStatus='" + clientStatus + '\'' + ", clientDateCreated='" + clientDateCreated + '\'' + ", clientDateUpdated='" + clientDateUpdated + '\'' + ", clientUserCreated='" + clientUserCreated + '\'' + ", clientUserUpdated='" + clientUserUpdated + '\'' + '}';
    }
}
