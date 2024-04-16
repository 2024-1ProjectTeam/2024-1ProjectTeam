package awsreactspring.jong.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import awsreactspring.jong.domain.CrawlingData;
import awsreactspring.jong.repository.CrawlRepository;
import awsreactspring.jong.repository.SpringDataJpaCrawlRepository;
import jakarta.transaction.Transactional;

@Transactional
public class CrawlingService {

    private final CrawlRepository crawlRepository;


    public CrawlingService(CrawlRepository crawlRepository) {
        this.crawlRepository = crawlRepository;
    }
    
    public void getCrawling(){        

        crawlRepository.deleteAllInBatch();

        WebDriver driver = WebDriverUtil.getChromeDriver();
        String[] keyWord = {"노인", "요양", "복지", "간병"};
        String url = "https://www.mohw.go.kr/board.es?mid=a10501010500&bid=0003";

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        for(String kw : keyWord){
            driver.findElement(By.name("keyWord")).sendKeys(kw);
            driver.findElement(By.cssSelector("#srhForm > fieldset > div:nth-child(3) > span.item.type1.btn > button")).click();
            driver.findElement(By.cssSelector("#contents_body > div.board_list.flexible > table > tbody > tr:nth-child(1) > td.txt_left > a")).click();

            String title = driver.findElement(By.cssSelector("#contents_body > article > h2")).getText();            
            String content = driver.findElement(By.cssSelector("#contents_body > article > div.contents")).getText();

            CrawlingData crawlingData = new CrawlingData();
            crawlingData.setTitle(title);
            crawlingData.setContent(content);

            crawlRepository.save(crawlingData);


            driver.get(url);
        }

    }

    public List<CrawlingData> findAll(){
        return crawlRepository.findAll();
    }
}
