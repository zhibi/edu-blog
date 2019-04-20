package edu.blog.controller;

import com.github.pagehelper.PageInfo;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Blog;
import edu.blog.domain.League;
import edu.blog.domain.Tag;
import edu.blog.dto.BlogDTO;
import edu.blog.service.BlogService;
import edu.blog.service.LeagueService;
import edu.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author 执笔
 * @date 2019/4/20 20:40
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService   blogService;
    @Autowired
    private TagService    tagService;
    @Autowired
    private LeagueService leagueService;


    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model, String title, @RequestParam(defaultValue = "1") int pageNum) {
        // 博客列表
        MybatisCondition condition = new MybatisCondition()
                .like("b.title", title)
                .order("b.id", false)
                .page(pageNum, 20);
        PageInfo<BlogDTO> blogPageInfo = blogService.selectDtoPage(condition);
        // 标签
        condition = new MybatisCondition()
                .order("blog_num", false)
                .page(pageNum, 12);
        List<Tag> tagList = tagService.selectPage(condition).getList();
        // 社团
        condition = new MybatisCondition()
                .order("user_num", false)
                .page(pageNum, 6);
        List<League> leagueList = leagueService.selectPage(condition).getList();
        // 推荐博客
        condition = new MybatisCondition()
                .order("browse_num", false)
                .page(pageNum, 10);
        List<Blog> blogList = blogService.selectPage(condition).getList();

        model.addAttribute("pageInfo", blogPageInfo);
        model.addAttribute("tagList", tagList);
        model.addAttribute("leagueList", leagueList);
        model.addAttribute("blogList", blogList);
        return "index";
    }

/*
    @PostMapping("/search")
    public String search(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) {
        model.addAttribute("page", blogService.listBlog("%" + query + "%", pageable));
        model.addAttribute("query", query);
        return "search";
    }*/

/*    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }*/

/*    @GetMapping("/footer/newblog")
    public String newblogs(Model model) {
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }*/

}

