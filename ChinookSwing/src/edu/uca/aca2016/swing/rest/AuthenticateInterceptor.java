package edu.uca.aca2016.swing.rest;

import java.io.IOException;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticateInterceptor implements Interceptor {
    private String credentials;

    public AuthenticateInterceptor(String user, String password) {
        this.credentials = Credentials.basic(user, password);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", credentials).build();
        return chain.proceed(authenticatedRequest);
    }
}