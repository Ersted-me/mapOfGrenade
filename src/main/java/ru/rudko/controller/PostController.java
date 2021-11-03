package ru.rudko.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rudko.model.GameMap;
import ru.rudko.model.Post;
import ru.rudko.service.GameMapService;
import ru.rudko.service.PostService;


@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final GameMapService gameMapService;

    @Autowired
    public PostController(PostService postService,GameMapService gameMapService) {
        this.postService = postService;
        this.gameMapService = gameMapService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("posts", postService.getAll());
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String showIdPost(@PathVariable("id") int id, Model model){
        model.addAttribute("post", postService.getPostById(id));
        return "posts/show";
    }

    @GetMapping("/new")
    public String newPostForm(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("gameMap", new GameMap());

        model.addAttribute("maps", gameMapService.getAll());
        return "posts/new";
    }

    @PostMapping()
    public  String createNewPost(@ModelAttribute("post")Post post,
                                 @ModelAttribute("gameMap")GameMap gameMap)  {
        if(gameMap.getName() != null){
            GameMap newGameMap = gameMapService.getByName(gameMap.getName());
            if(newGameMap == null){
                return "redirect:/posts/new";
            }
            post.setGameMap(newGameMap);
            postService.addPost(post);
        }
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("gameMap", new GameMap());
        model.addAttribute("maps", gameMapService.getAll());
        return "posts/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("post") Post post,
                         @ModelAttribute("gameMap") GameMap gameMap,
                         @PathVariable("id") int id) {
        GameMap newGameMap;
        if(gameMap.getName() != null){
            newGameMap = gameMapService.getByName(gameMap.getName());
            if(newGameMap == null){
                return "redirect:/posts/new";
            }
            post.setGameMap(newGameMap);
            postService.updatePost(post, id);
        }
        return "redirect:/posts/{id}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        postService.deleteById(id);
        return "redirect:/posts";
    }
}

