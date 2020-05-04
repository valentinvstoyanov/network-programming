package com.valentinvstoqnov;

public class Request {
    private String ipAddress;
    private String reversedBytesIpAddress;
    private String serviceDomain;

    public Request(String ipAddress, String serviceDomain) {
        this.ipAddress = ipAddress;
        this.serviceDomain = serviceDomain;
        calculateReversedBytesIpAddress();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getReversedBytesIpAddress() {
        return reversedBytesIpAddress;
    }

    public String getServiceDomain() {
        return serviceDomain;
    }

    public String getHostName() {
        return reversedBytesIpAddress + '.' + serviceDomain;
    }

    private void calculateReversedBytesIpAddress() {
        String[] bytes = ipAddress.split("\\.");

        StringBuilder sb = new StringBuilder();
        for (int i = bytes.length - 1; i >= 0; --i) {
            String b = bytes[i];
            sb.append(b);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);

        reversedBytesIpAddress =  sb.toString();
    }
}
