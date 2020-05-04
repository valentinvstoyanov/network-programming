package com.valentinvstoqnov;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.stream.Stream;

public class SpamhausChecker {
    public static final String SERVICE_DOMAIN = "zen.spamhaus.org";

    public Stream<String> check(String[] ips) {
        return Arrays.stream(ips)
                .map((ip) -> new Request(ip, SERVICE_DOMAIN))
                .map(this::perform)
                .map(Response::toString);
    }

    private Response perform(Request req) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName(req.getHostName());
            if (addresses == null) {
                return new Response(req.getIpAddress(), null);
            } else {
                String[] hostAddresses = new String[addresses.length];
                for (int i = 0; i < addresses.length; ++i)
                    hostAddresses[i] = addresses[i].getHostAddress();
                return new Response(req.getIpAddress(), hostAddresses);
            }
        } catch (UnknownHostException e) {
            //e.printStackTrace();
            return new Response(req.getIpAddress());
        }
    }

    public static void main(String[] args) {
        SpamhausChecker checker = new SpamhausChecker();
        checker.check(args).forEach(System.out::println);
    }
}
