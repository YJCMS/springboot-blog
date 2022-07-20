package project.stevenote.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.stevenote.repository.Memo;
import project.stevenote.repository.MemoRepository;
import project.stevenote.service.MemoService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemoController {
    private final MemoService memoService;

    @RequestMapping("/")
    public String list(Model model) {
        List<Memo> memoList = this.memoService.getList();
        model.addAttribute("memoList", memoList);
        return "index";
    }

    @GetMapping("/posting")
    public String memoPosting() {
        return "posting";
    }

    @PostMapping("/posting")
    public String memoCreate(@RequestParam String subject,
                             @RequestParam String content,
                             @RequestParam MultipartFile file) throws Exception {
        this.memoService.posting(subject, content, file);
        return "redirect:/";
    }
}
