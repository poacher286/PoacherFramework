package com.poacherFramework.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class RestAPIDriver {
    private static HttpClient requestClient;

    /**
     * Function to get the response from request payload based operation CRUD
     * @param requestHeaders
     * @param requestUrl
     * @param requestPaylod
     * @param requestType
     * @return HttpResponse
     * @throws Exception
     */
    public static HttpResponse callRestService(HashMap<String, String> requestHeaders, String requestUrl, String requestPaylod, String requestType) throws Exception {
        StringEntity payload;
        HttpClientBuilder requestBuilder = HttpClientBuilder.create();
        requestClient = requestBuilder.build();
//        HttpClient requestClient= setClientForSelfSignedCertificate();
        HttpUriRequest request;
        switch (requestType.toUpperCase()) {
            case "POST":
                request = new HttpPost(requestUrl);
                if (requestPaylod != null) {
                    payload = new StringEntity(requestPaylod);
                    ((HttpPost) request).setEntity(payload);
                }
                break;
            case "PUT":
                request = new HttpPut(requestUrl);
                if (requestPaylod != null) {
                    payload = new StringEntity(requestPaylod);
                    ((HttpPut) request).setEntity(payload);
                }
                break;
            case "DELETE":
                request = new HttpDelete(requestUrl);
                break;
            case "GET":
            default:
                request = new HttpGet(requestUrl);
        }

        for (String key : requestHeaders.keySet()) {
            request.addHeader(key, requestHeaders.get(key));
        }

        HttpResponse response = requestClient.execute(request);
        return response;
    }

    private static HttpClient setClientForSelfSignedCertificate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        return HttpClients
                .custom()
                .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustSelfSignedStrategy.INSTANCE).build())
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .build();
    }

}
