package com.adobe.aem.guides.demo.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

//API for testing: https://jsonplaceholder.typicode.com/posts

@Component(service = { Servlet.class }, property = { "sling.servlet.method = GET",
		"sling.servlet.paths=/bin/helloworld" })

public class ExternalApiServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        // External API endpoint (Dummy API)
        String apiUrl = "https://jsonplaceholder.typicode.com/posts";

        // Create an HTTP client to send the GET request
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(apiUrl);
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
                // Get the response body and convert it to a string
                String responseBody = EntityUtils.toString(httpResponse.getEntity());
                response.setContentType("application/json");
                response.getWriter().write(responseBody);  // Send the API response as JSON
            }
        } catch (IOException e) {
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"message\": \"Error fetching data from external service.\"}");
        }
    }
}