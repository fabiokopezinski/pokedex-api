package br.com.pokedex.feature;

import br.com.pokedex.domain.request.LoginRequest;
import br.com.pokedex.domain.response.LoginResponse;

public class LoginScenarioFactory {
    
    public static final LoginRequest LOGIN=loadLogin();
    public static final LoginResponse LOGIN_RESPONSE=loadLoginResponse();

    private static LoginRequest loadLogin() {
        return LoginRequest.builder().email("fabiokopezinski@gmail").password("124578").build();        
    }

    private static LoginResponse loadLoginResponse() {
        return LoginResponse.builder().token("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmYWJpb2tvcGV6aW5za2lAZ21haWwuY29tIiwicm9sZXMiOlsiQURNSU4iXSwiaWF0IjoxNjA5NTk2MzQ4LCJleHAiOjE2MDk2ODI3NDh9.klA_AGzSb_hW6rc-TslLhd0wSsFpW4k7VRNxs6dtgB4").type("Bearer").build();
    }
}
