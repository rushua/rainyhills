package com.rush.rainyhills.service;

import com.rush.rainyhills.chart.VolumeChart;
import com.rush.rainyhills.middleware.IVolumeService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static com.rush.rainyhills.service.VolumeServiceUtil.isArray;
import static com.rush.rainyhills.service.VolumeServiceUtil.isPositive;
import static com.rush.rainyhills.service.VolumeServiceUtil.parse;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:00
 */
@RequestScoped
@Path("/")
public class VolumeServiceREST {
    private static final String VOLUME = "VOLUME";

    @EJB
    private IVolumeService volumeService;

    @Path("/volume")
    @GET
    public Response getVolume(@QueryParam("hills") String hills) {
        try {
            if (isArray(hills)) {
                int[] emptyHills = parse(hills);
                if (isPositive(emptyHills)) {
                    int volume = volumeService.getVolume(emptyHills);
                    return Response.ok(VOLUME + " = " + volume).header(VOLUME, volume).build();
                }
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.serverError().entity("Server error: " + e.getMessage()).build();
        }
    }

    @Path("/chart")
    @GET
    public Response getChart(@QueryParam("hills") String hills) {
        try {
            if (isArray(hills)) {
                int[] emptyHills = parse(hills);
                if (isPositive(emptyHills)) {
                    int[] fullHills = volumeService.getFullHills(emptyHills);
                    VolumeChart volumeChart = new VolumeChart(emptyHills, fullHills);
                    return Response.ok(volumeChart.getSVGDocument()).header(VOLUME, volumeChart.getVolume()).build();
                }
            }
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            return Response.serverError().entity("Server error: " + e.getMessage()).build();
        }
    }
}
