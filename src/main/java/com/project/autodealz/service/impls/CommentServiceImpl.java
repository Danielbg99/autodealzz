package com.project.autodealz.service.impls;

import com.project.autodealz.data.entities.CarAnnouncement;
import com.project.autodealz.data.entities.Comment;
import com.project.autodealz.data.entities.User;
import com.project.autodealz.data.repository.CommentRepository;
import com.project.autodealz.service.CarAnnouncementService;
import com.project.autodealz.service.CommentService;
import com.project.autodealz.service.UserService;
import com.project.autodealz.service.models.CommentServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {


    private final ModelMapper modelMapper;

    private final CarAnnouncementService carAnnouncementService;

    private final UserService userService;

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(ModelMapper modelMapper, CarAnnouncementService carAnnouncementService, UserService userService, CommentRepository commentRepository) {
        this.modelMapper = modelMapper;
        this.carAnnouncementService = carAnnouncementService;
        this.userService = userService;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentServiceModel createComment(String carAnnouncementId, String username, CommentServiceModel commentServiceModel) {
        Comment comment = this.modelMapper.map(commentServiceModel, Comment.class);

        CarAnnouncement carAnnouncement = ((CarAnnouncementServiceImpl) this.carAnnouncementService)
                .getEntityByIdInternal(carAnnouncementId);

        User user = ((UserServiceImpl) this.userService).getUserByUsernameInternal(username);

        comment.setCarAnnouncement(carAnnouncement);
        comment.setUser(user);

        return this.modelMapper.map(this.commentRepository.saveAndFlush(comment), CommentServiceModel.class);
    }
}
