package com.osayijoy.week7_facebookclone.controllers;

import com.osayijoy.week7_facebookclone.models.Comment;
import com.osayijoy.week7_facebookclone.models.LikesForComment;
import com.osayijoy.week7_facebookclone.models.User;
import com.osayijoy.week7_facebookclone.services.CommentService;
import com.osayijoy.week7_facebookclone.services.LikesForCommentService;
import com.osayijoy.week7_facebookclone.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    LikesForCommentService likeForCommentService;

    @GetMapping("/editComment/{id}")
    public String editCommentPage(@PathVariable("id") Long id, HttpSession httpSession, Model model){
        User user = (User) httpSession.getAttribute("user");
        if (user == null) return "redirect/home";
        Comment comment = commentService.getCommentById(id);
        model.addAttribute("comment", comment);
        return "edit_comment";
    }

    @PostMapping("/create_comment/{id}")
    public String newComment(@PathVariable(value = "id") long id, HttpSession httpSession, @Validated Comment comment){
        System.err.println(comment);
        User user = (User)httpSession.getAttribute("user");
        if (user == null)
            return "home";
        comment.setUser(user);
        comment.setPost(postService.getPostById(id));
        commentService.createComment(comment);
        return "redirect:/home";
    }

    @PostMapping("/updateComment/{id}")
    public String updateComment(@PathVariable("id") Long id, HttpSession httpSession, Comment commentToUpdate){
        User user = (User) httpSession.getAttribute("user");
        if (user == null) return "home";
        commentService.updateComment(commentToUpdate, id);
        return "redirect:/home";
    }

    @PostMapping("/deleteComment/{id}")
    public String deleteComment(@PathVariable("id") Long id, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");
        if(user == null) return "home";
        Comment comment = commentService.getCommentById(id);
        commentService.deleteComment(comment);
        return "redirect:/home";
    }

    @PostMapping("/likeComment/{id}")
    public String likeComment(@PathVariable("id") Long id, HttpSession httpSession, LikesForComment like){
        User user = (User) httpSession.getAttribute("user");
        if (user == null) return "home";
        like.setUser(user);
        like.setComment(commentService.getCommentById(id));
        LikesForComment liked = likeForCommentService.getLikes(like);
        if(likeForCommentService.getLikes(like) != null) likeForCommentService.deleteLike(liked);
        else likeForCommentService.addLike(like);
        return "redirect:/home";

    }

}
