package br.com.pokedex.feature;

import br.com.pokedex.domain.request.LoginRequest;
import br.com.pokedex.domain.response.LoginResponse;

public class LoginScenarioFactory {
    
    public static final LoginRequest LOGIN=loadLogin();
    public static final LoginResponse LOGIN_RESPONSE=loadLoginResponse();

    private static LoginRequest loadLogin() {
        return new LoginRequest("fabiokopezinski@gmail","124578");
    }

    private static LoginResponse loadLoginResponse() {
        return new LoginResponse("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmYWJpb2tvcGV6aW5za2lAZ21haWwuY29tIiwicm9sZXMiOlsiQURNSU4iXSwiaWF0IjoxNjA5NTk2MzQ4LCJleHAiOjE2MDk2ODI3NDh9.klA_AGzSb_hW6rc-TslLhd0wSsFpW4k7VRNxs6dtgB4", "Bearer");
    }
}
