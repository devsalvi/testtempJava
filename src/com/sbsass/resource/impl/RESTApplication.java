package com.sbsass.resource.impl;

import java.util.HashSet;
import java.util.Set;

public class RESTApplication extends javax.ws.rs.core.Application {

private Set<Object> singletons = new HashSet<Object>();

public RESTApplication () {
    singletons.add(new DatabaseManagementReourceImpl());
}

@Override
public Set<Object> getSingletons() {
    return singletons;
}
}