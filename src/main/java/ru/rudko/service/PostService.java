package ru.rudko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rudko.dao.PostDAOImpl;
import ru.rudko.model.Post;

import java.util.List;

@Service
public class PostService {
    private final PostDAOImpl postDAO;


    @Autowired
    public PostService(PostDAOImpl postDAO){
        this.postDAO = postDAO;
    }

    public List<Post> getAll() {
        return postDAO.getAll();
    }

    public Post getPostById(int id) {
        return postDAO.getById(id);
    }

    public void addPost(Post post){
        postDAO.add(post);
    }

    public void updatePost(Post post, int id){
        post.setId(id);
        postDAO.update(post);
    }

    public void deleteById(int id){
        postDAO.delete(getPostById(id));
    }

}
