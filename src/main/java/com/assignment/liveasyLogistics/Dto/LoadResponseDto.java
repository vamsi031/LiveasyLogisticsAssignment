package com.assignment.liveasyLogistics.Dto;

public class LoadResponseDto {
    int loadId;
    String response;

    public LoadResponseDto() {
    }

    public LoadResponseDto(int loadId, String response) {
        this.loadId = loadId;
        this.response = response;
    }

    public int getLoadId() {
        return loadId;
    }

    public void setLoadId(int loadId) {
        this.loadId = loadId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
