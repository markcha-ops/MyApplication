package com.example.myapplication2.data;

import android.os.StrictMode;

import com.example.myapplication2.data.model.LoggedInUser;
import com.example.myapplication2.requests.login.LoginClient;
import com.example.myapplication2.requests.login.LoginModel;
import com.example.myapplication2.requests.login.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            Call<Token> loginCallback = LoginClient.getApiService().login(LoginModel.builder()
                    .email(username)
                    .password(password)
                    .build());
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Token body = loginCallback.execute().body();
            Token.of(body);

            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}