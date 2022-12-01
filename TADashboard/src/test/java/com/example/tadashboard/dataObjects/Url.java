package com.example.tadashboard.dataObjects;

public enum Url {
    TA_LOGIN("http://localhost/TADashboard/login.jsp"),
    TA_DATA_PROFILES("http://localhost/TADashboard/profiles.jsp"),
    TA_PANELS("http://localhost/TADashboard/panels.jsp"),
    TA_HELP("http://localhost/TADashboard/help/Topics/Dashboard.html"),
    TA_CREATE_PROFILE("http://localhost/TADashboard/profile.jsp?action=create");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public String toString() {
        return url;
    }
}
