package com.project.autodealz.errors;

public class AnnouncementNotFoundException extends RuntimeException {
    private int status;

    public AnnouncementNotFoundException() {
        this.status = 404;
    }

    public AnnouncementNotFoundException(String message) {
        super(message);
        this.status = 404;
    }

    public int getStatus() {
        return status;
    }
}
