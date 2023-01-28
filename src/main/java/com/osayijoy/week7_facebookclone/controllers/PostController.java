package com.osayijoy.week7_facebookclone.controllers;

import com.osayijoy.week7_facebookclone.models.*;
import com.osayijoy.week7_facebookclone.services.CommentService;
import com.osayijoy.week7_facebookclone.services.LikesForPostService;
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
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
    @Autowired
    LikesForPostService likesForPostService;


    @GetMapping("/home")
    public String getPosts(HttpSession httpSession, Model model){
        User homeUser = (User) httpSession.getAttribute("user");
        if (homeUser == null) return "redirect:/";
        Post post = postService.getPostById(homeUser.getId());
        model.addAttribute("post", new Post());
        model.addAttribute("allPost", postService.getAllPost());
        model.addAttribute("user", homeUser);
        model.addAttribute("comment", new Comment());
        model.addAttribute("deletePost", new Post());
        model.addAttribute("editPost", post);
        model.addAttribute("likePost", new LikesForPost());
        model.addAttribute("likeComment", new LikesForComment());
        return "home";
    }

    @GetMapping("/edit/{id}")
    public String editPostPage(@PathVariable("id") Long id, HttpSession httpSession, Model model){
        User user = (User) httpSession.getAttribute("user");
        if(user==null)return "redirect/home";
        Post post = postService.getPostById(id);
        model.addAttribute("thisPost", post);
        return "edit_post";
    }


    @PostMapping("/post")
    public String newPost(HttpSession httpSession, @Validated Post post){
        User user = (User)httpSession.getAttribute("user");
        if (user == null) return "signUpAndLogin";
        postService.createPost(post, user);
        return "redirect:/home";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(HttpSession httpSession, @PathVariable("id") Long id){
        User user = (User) httpSession.getAttribute("user");
        if(user == null) return "home";
        Post post = postService.getPostById(id);
        postService.deletePost(post);
        return "redirect:/home";
    }

    @PostMapping("/update/{id}")
    public String editPost(HttpSession httpSession, @PathVariable("id") Long id, Post postToUpdate){
        User user = (User) httpSession.getAttribute("user");
        if(user == null) return "home";
        postService.updatePost(postToUpdate, id);
        return "redirect:/home";

    }

    @PostMapping("/likePost/{id}")
    public String likePost(@PathVariable("id") Long id, HttpSession httpSession, LikesForPost like){
        User user = (User) httpSession.getAttribute("user");
        if (user == null) return "home";
        like.setUser(user);
        like.setPost(postService.getPostById(id));
        LikesForPost liked = likesForPostService.getLikes(like);
        if (likesForPostService.getLikes(like) != null) likesForPostService.deleteLike(liked);
        else likesForPostService.addLike(like);
        return "redirect:/home";
    }


}
