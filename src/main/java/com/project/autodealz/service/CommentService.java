package com.project.autodealz.service;

import com.project.autodealz.service.models.CommentServiceModel;

public interface CommentService {

    CommentServiceModel createComment(String carAnnouncementId, String username, CommentServiceModel commentServiceModel);
}
