package com.nevercome.jpetstore.common.log;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;

public class JPetStoreRequest implements Serializable {
    private static final long serialVersionUID = 1;

    private final String protocol;
    private final String serverName;
    private final int serverPort;
    private final String requestURI;
    private final String queryString;
    private final String remoteUser;
    private final long timestamp;

    public JPetStoreRequest(HttpServletRequest request, Date timestamp) {
        protocol = request.getProtocol();
        serverName = request.getServerName();
        serverPort = request.getServerPort();
        requestURI = request.getRequestURI();
        queryString = request.getQueryString();
        remoteUser = request.getRemoteUser();
        this.timestamp = timestamp.getTime();
    }

    public String getProtocol() {
        return protocol;
    }

    public String getServerName() {
        return serverName;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public Date getTimestamp() {
        return new Date(timestamp);
    }

    /**
     * Returns a string representation of the HTTP request being tracked.
     * Example: <b>www.opensymphony.com/some/path.jsp?arg1=foo&arg2=bar</b>
     *
     * @return a string representation of the HTTP request being tracked.
     */
    @Override
    public String toString() {
        return serverName + (serverPort != 80 ? ":" + serverPort : "") + requestURI
                + (queryString != null ? "?" + queryString : "");
    }
}
