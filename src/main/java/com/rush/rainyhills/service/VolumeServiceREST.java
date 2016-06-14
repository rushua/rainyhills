package com.rush.rainyhills.service;

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
}
