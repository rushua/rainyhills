package com.rush.rainyhills.service;

import com.rush.rainyhills.chart.VolumeChart;
import com.rush.rainyhills.middleware.IVolumeService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import java.util.List;

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
    public Integer getVolume(@QueryParam("hill") List<Integer> hillList) {
        return volumeService.getVolume(hillList);
    }

    @Path("/svg")
    @GET
    public String getSVG(@QueryParam("hill") List<Integer> hillList) {
        return new VolumeChart(new int[]{0, 1, 2, 3, 4}, new int[]{5, 4, 3, 2, 1}).getSVGDocument();
    }
}
