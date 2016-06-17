package com.rush.rainyhills.integration;

import com.rush.rainyhills.TestItemUtil;
import com.rush.rainyhills.core.VolumeCalculator;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Ruslan Khalikov
 * Date: 17.06.2016
 * Time: 20:05
 */
public class VolumeServiceIntegrationTest {
    private static final String VOLUME = "VOLUME";

    private TestItemUtil.TestItem[] items;
    private VolumeCalculator volumeCalculator;
    private Client serviceClient;
    private String baseUrl;

    @Before
    public void init() {
        items = TestItemUtil.createTestItems();
        volumeCalculator = new VolumeCalculator();
        serviceClient = Client.create();
        baseUrl = "http://localhost:8080/rainyhills/";
    }

    @Ignore
    @Test
    public void fullVolumeIntegrationTest() {
        Arrays.stream(items).forEach(
                item -> {
                    System.out.println(item);
                    WebResource webResource = serviceClient.resource(baseUrl + "volume?hills="
                            + Arrays.toString(item.getEmptyHills()).replaceAll(" ", ""));

                    ClientResponse response = webResource.get(ClientResponse.class);
                    if (response.getClientResponseStatus() != ClientResponse.Status.OK) {
                        Assert.fail(response.getClientResponseStatus() + " " + response.getEntity(String.class));
                    }

                    Assert.assertEquals(String.valueOf(item.getVolume()), response.getHeaders().getFirst(VOLUME));
                    System.out.println("Server result = " + response.getHeaders().getFirst(VOLUME));
                }
        );
    }

    @Ignore
    @Test
    public void fullChartIntegrationTest() {
        Arrays.stream(items).forEach(
                item -> {
                    System.out.println(item);
                    WebResource webResource = serviceClient.resource(baseUrl + "chart?hills="
                            + Arrays.toString(item.getEmptyHills()).replaceAll(" ", ""));

                    ClientResponse response = webResource.get(ClientResponse.class);
                    if (response.getClientResponseStatus() != ClientResponse.Status.OK) {
                        Assert.fail(response.getClientResponseStatus() + " " + response.getEntity(String.class));
                    }

                    Assert.assertEquals(String.valueOf(item.getVolume()), response.getHeaders().getFirst(VOLUME));
                    System.out.println("Server result = " + response.getHeaders().getFirst(VOLUME));
                }
        );
    }

    public static void main(String[] args) {
        try {
            System.out.println("Start integration test...");
            VolumeServiceIntegrationTest test = new VolumeServiceIntegrationTest();
            test.init();
            test.fullVolumeIntegrationTest();
            test.fullChartIntegrationTest();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed!!!");
        }
    }
}
