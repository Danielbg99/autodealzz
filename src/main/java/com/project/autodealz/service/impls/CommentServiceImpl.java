package com.project.autodealz.service.impls;

import com.project.autodealz.data.entities.Comment;
import com.project.autodealz.data.repository.CommentRepository;
import com.project.autodealz.service.CommentService;
import com.project.autodealz.service.models.CommentServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {


    private final ModelMapper modelMapper;
    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(ModelMapper modelMapper, CommentService commentService, CommentRepository commentRepository) {
        this.modelMapper = modelMapper;
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentServiceModel createComment(CommentServiceModel commentServiceModel) {
        Comment comment = this.modelMapper.map(commentServiceModel, Comment.class);

        return this.modelMapper.map(this.commentRepository.saveAndFlush(comment), CommentServiceModel.class);
    }
}
