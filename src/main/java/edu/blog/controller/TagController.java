
package edu.blog.controller;

import com.github.pagehelper.PageInfo;
import edu.blog.core.base.controller.BaseController;
import edu.blog.core.mybatis.condition.MybatisCondition;
import edu.blog.domain.Tag;
import edu.blog.dto.BlogDTO;
import edu.blog.mapper.TagMapper;
import edu.blog.service.BlogService;
import edu.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author 执笔
 * @date 2019/4/21 17:35
 */
@Controller
@RequestMapping("tag")
public class TagController extends BaseController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;
    @Autowired
    private TagMapper   tagMapper;

    /**
     * 更多标签
     *
     * @param model
     * @param tagId
     * @param pageNum
     * @return
     */
    @GetMapping("list")
    public String tags(Model model, Integer tagId, @RequestParam(defaultValue = "1") int pageNum) {
        List<Tag> tags = tagMapper.selectAll();
        Tag       tag  = tagMapper.selectByPrimaryKey(tagId);
        MybatisCondition condition = new MybatisCondition()
                .page(pageNum, 20)
                .order("b.id", false);
        if (null != tag) {
            condition.eq("b.tag", tag.getName());
        }
        PageInfo<BlogDTO> pageInfo = blogService.selectDtoPage(condition);
        model.addAttribute("tags", tags);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tagId", tagId);
        return "tags";
    }
}

