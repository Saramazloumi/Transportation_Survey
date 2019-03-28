package model;

import java.io.Serializable;

public class Client implements Serializable {

    private int clientNumber,KmNumber, transportType, counter;

    public Client(int clientNumber, int kmNumber, int transportType, int counter) {
        this.clientNumber = clientNumber;
        KmNumber = kmNumber;
        this.transportType = transportType;
        this.counter = counter;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public int getKmNumber() {
        return KmNumber;
    }

    public void setKmNumber(int kmNumber) {
        KmNumber = kmNumber;
    }

    public int getTransportType() {
        return transportType;
    }

    public void setTransportType(int transportType) {
        this.transportType = transportType;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {

        String transport = null;

        switch (transport){

            case "Bus":
                transportType =1;
                break;

                case "Metro":
                    transportType = 2;
                    break;
            case "Private Transport":
                transportType = 3;
                break;

            case "Taxi":
                transportType = 4;
                break;
        }

        return clientNumber + KmNumber + transport + counter;
    }
}
