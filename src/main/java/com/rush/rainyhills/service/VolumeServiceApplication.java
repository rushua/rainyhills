package com.rush.rainyhills.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ruslan Khalikov
 * Date: 14.06.2016
 * Time: 21:51
 */
@ApplicationPath("/")
public class VolumeServiceApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classSet = new HashSet<>();
        classSet.add(VolumeServiceREST.class);
        return classSet;
    }
}
