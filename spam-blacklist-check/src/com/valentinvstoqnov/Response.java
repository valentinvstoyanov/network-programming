package com.valentinvstoqnov;

public class Response {
    private Boolean isInBlackList;
    String ipAddress;
    private String[] hostAddresses;

    public Response(String ipAddress, String[] hostAddresses) {
        this.hostAddresses = hostAddresses;
        this.ipAddress = ipAddress;
        isInBlackList = true;
    }

    public Response(String ipAddress) {
        this.ipAddress = ipAddress;
        isInBlackList = false;
        hostAddresses = null;
    }

    public Boolean getIsInBlackList() {
        return isInBlackList;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String[] getHostAddresses() {
        return hostAddresses;
    }

    private String getCode(String a) {
        switch (a) {
            case "127.0.0.2":
                return "'" + a + " - SBL - Spamhaus SBL Data'";
            case "127.0.0.3":
                return "'" + a + " - SBL - Spamhaus SBL CSS Data'";
            case "127.0.0.4":
                return "'" + a + " - XBL - CBL Data'";
            case "127.0.0.9":
                return "'" + a + " - SBL - Spamhaus DROP/EDROP Data'";
            case "127.0.0.10":
                return "'" + a + " - PBL - ISP Maintained'";
            case "127.0.0.11":
                return "'" + a + " - PBL - Spamhaus Maintained'";
            default:
                throw new IllegalArgumentException(a + "unknown.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("The IP address: ");
        sb.append(ipAddress);

        if (!isInBlackList) {
            sb.append(" is NOT found in the Spamhaus blacklists.");
            return sb.toString();
        }

        sb.append(" is found in the following Spamhaus public IP zone: ");

        if (hostAddresses.length == 1) {
            sb.append(getCode(hostAddresses[0]));
            return sb.toString();
        }

        sb.append('\n');
        for (String host: hostAddresses) {
            sb.append(getCode(host));
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
