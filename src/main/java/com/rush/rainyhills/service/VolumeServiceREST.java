package com.rush.rainyhills.service;

import com.rush.rainyhills.chart.VolumeChart;
import com.rush.rainyhills.middleware.IVolumeService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import java.util.Arrays;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 20:00
 */
@RequestScoped
@Path("/")
public class VolumeServiceREST {

    @EJB
    private IVolumeService volumeService;

    @Path("/volume")
    @GET
    public Integer getVolume(@QueryParam("hills") String hills) {
        int[] emptyHills = Arrays.stream(hills.trim().split(",")).mapToInt(Integer::valueOf).toArray();
        return volumeService.getVolume(emptyHills);
    }

    @Path("/chart")
    @GET
    public String getChart(@QueryParam("hills") String hills) {
        int[] emptyHills = Arrays.stream(hills.trim().split(",")).mapToInt(Integer::valueOf).toArray();
        return new VolumeChart(emptyHills, volumeService.getFullHills(emptyHills)).getSVGDocument();
    }
}
