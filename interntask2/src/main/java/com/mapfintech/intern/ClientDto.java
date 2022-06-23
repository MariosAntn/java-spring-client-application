package com.mapfintech.intern;

import java.sql.Timestamp;

public class ClientDto {
    private static int clientId = 0; //static clientId initialized at 0 for incrementation
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

    public ClientDto() {
        //this empty constructor increments clientId
        clientId++;
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
}
