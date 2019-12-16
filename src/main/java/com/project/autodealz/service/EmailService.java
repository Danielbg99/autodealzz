package com.project.autodealz.service;

public interface EmailService {

    void sendMessage(String to, String subject, String text);
}
