package project.stevenote.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.stevenote.repository.Memo;
import project.stevenote.repository.MemoRepository;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    public List<Memo> getList() {
        return this.memoRepository.findAll();
    }

    public void posting(String subject, String content, MultipartFile file) throws Exception {

        String projectpath = System.getProperty("user.dir")+"/src/main/resources/static/images";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid+"_"+file.getOriginalFilename();
        File saveFile = new File(projectpath, fileName);
        file.transferTo(saveFile);

        Memo m = new Memo();
        m.setSubject(subject);
        m.setContent(content);
        m.setFileName(fileName);
        m.setFilePath("/images/"+fileName);
        m.setCreateDate(LocalDateTime.now());
        this.memoRepository.save(m);
    }
}
