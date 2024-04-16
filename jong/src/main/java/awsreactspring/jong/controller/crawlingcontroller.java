package awsreactspring.jong.controller;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import awsreactspring.jong.domain.CrawlingData;
import awsreactspring.jong.service.CrawlingService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class crawlingcontroller {

    private final CrawlingService crawlingService;

    @Autowired
    public crawlingcontroller(CrawlingService crawlingService) {
        this.crawlingService = crawlingService;
    }
    
    @GetMapping("/api/crawling")
    public List<CrawlingData> crawling() {
        
        crawlingService.getCrawling();

        List<CrawlingData> crawlingDatas = crawlingService.findAll();

        return crawlingDatas;
    }
    
    
}
