package com.example.ev_mapbox.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/ev_mapbox/util/Constants;", "", "()V", "API_KEY_ERROR", "", "MOCK_BASE_URL", "MOCK_RESOURCE_PATH", "OPEN_MAP_BASE_URL", "OPEN_MAP_QUERY", "REQUEST_CODE_LOCATION_PERMISSION", "", "SPAN_COUNT", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.ev_mapbox.util.Constants INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MOCK_RESOURCE_PATH = "testing";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPEN_MAP_QUERY = "?key=22dcf268-f3e1-4cf4-a152-111d68e9502d/output=json&maxresults=10&compact=true&verbose=false&longitude=-1.360406976465403&latitude=51.954015044041914\")";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String OPEN_MAP_BASE_URL = "https://api.openchargemap.io/v3/poi/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String MOCK_BASE_URL = "https://6b35121d-3f3b-4a18-8860-0d6e4191aa5e.mock.pstmn.io/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_KEY_ERROR = "You must specify an API Key, either in an X-API-Key header or key= query string parameter.";
    public static final int SPAN_COUNT = 1;
    public static final int REQUEST_CODE_LOCATION_PERMISSION = 0;
    
    private Constants() {
        super();
    }
}