package com.zenvia.newhorizon.agendabot;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.calendar.Calendar;

import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class AgendabotApplication {

  private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
  private final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);

  public static void main(String[] args) {
    SpringApplication.run(AgendabotApplication.class, args);
  }

  private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
    String CREDENTIALS_FILE_PATH = "/credentials.json";
    InputStream in = AgendabotApplication.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
    GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

    // Build flow and trigger user authorization request.
    String TOKENS_DIRECTORY_PATH = "tokens";
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
      HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
      .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
      .setAccessType("offline")
      .build();
    return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
  }

  @Bean
  Calendar getCalendar() throws GeneralSecurityException, IOException {
    NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    String APPLICATION_NAME = "MyEvent";
    return new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
      .setApplicationName(APPLICATION_NAME)
      .build();
  }
}

