/*
 * oxAuth is available under the MIT License (2008). See http://opensource.org/licenses/MIT for full text.
 *
 * Copyright (c) 2014, Gluu
 */

package org.gluu.oxauth.client;

import org.apache.http.client.CookieStore;

/**
 * @author Yuriy Zabrovarnyy
 * @author Javier Rojas Blum
 * @version December 26, 2016
 */

public class ClientUtils {
    private ClientUtils() {
    }

    public static void showHeader(String header) {
        System.out.println("-------------------------------------------------------");
        System.out.println(header);
        System.out.println("-------------------------------------------------------");
    }

    public static void showClient(BaseClient client) {
        showHeader("REQUEST:");
        System.out.println(client.getRequestAsString());
        System.out.println();

        showHeader("RESPONSE:");
        System.out.println(client.getResponseAsString());
        System.out.println();
    }

    public static void showClientUserAgent(BaseClient client) {
        showHeader("REQUEST:");
        System.out.println(client.getUrl() + "?" + client.getRequest().getQueryString());
        System.out.println();

        if (client.getResponse() != null) {
            showHeader("RESPONSE:");
            System.out.println("HTTP/1.1 302 Found");
            System.out.println("Location: " + client.getResponse().getLocation());
            System.out.println();
        }
    }

    public static void showClient(BaseClient client, CookieStore cookieStore) {
        showClient(client);

        showHeader("COOKIES:");
        System.out.println(cookieStore.getCookies());
        System.out.println();
    }
}
