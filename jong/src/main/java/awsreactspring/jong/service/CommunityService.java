package awsreactspring.jong.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import awsreactspring.jong.domain.Community;
import awsreactspring.jong.repository.CommunityRepository;
import jakarta.transaction.Transactional;

@Transactional
public class CommunityService {
    private final CommunityRepository communityRepository;

    
    public CommunityService(CommunityRepository communityRepository){
        this.communityRepository = communityRepository;
    }
    // 생성(create??), 모든 게시물 조회(findAll), 일반 게시물 조회(id,title,content 등),수정(change),삭제(delete)정도면 될려나??

    public Community saveCommunity(Community community){ //게시물 저장
        return communityRepository.save(community);
    }

    public Community findCommunityByUserId(Long userid) { // 유저 아이디를 통해 게시물조회
        return communityRepository.findByUserId(userid)
                .orElseThrow(() -> new IllegalStateException("존재하지 않습니다."));
    }

    public Community findCommunityByTitle(String title){ //제목으로 게시물조회
        Optional<Community> optionalCommunity = communityRepository.findByTitle(title);
        if(optionalCommunity.isEmpty()){
            throw new IllegalStateException("잘못된 요청입니다.");
        }else{
            return optionalCommunity.get();
        }
    }

    public Community findCommunityByContent(String content){ //내용으로 게시물조회
        Optional<Community> optionalCommunity = communityRepository.findByContent(content);
        if(optionalCommunity.isEmpty()){
            throw new IllegalStateException("잘못된 요청입니다.");
        }else{
            return optionalCommunity.get();
        }
    }

    /**public Community changeCommunity(Long postid, Community changedCommunity){ // 게시글 아이디를 이용하여, 제목 및 내용 수정
        Community existingCommunity = findByPostId(postid);

        existingCommunity.setTitle(changedCommunity.getTitle());
        existingCommunity.setContent(changedCommunity.getContent());

        return communityRepository.save(existingCommunity);
    } */
    public Community changeCommunity(Long postid, Community changedCommunity) { //게시글 수정
        Community existingCommunity = findByPostId(postid);
    
        existingCommunity.setTitle(changedCommunity.getTitle());
        existingCommunity.setContent(changedCommunity.getContent());
    
        return communityRepository.save(existingCommunity);
    } 

    /**public void deleteCommunity(Long postid){  // 게시글 아이디를 이용하여,삭제
        Community existingCommunity = findByPostId(postid);

        communityRepository.delete(existingCommunity);
    }*/
    
    public void deleteCommunity(Long postid) {    // 게시글 아이디를 이용하여,삭제
        Optional<Community> existingCommunityOptional = communityRepository.findByPostId(postid);
        Community existingCommunity = existingCommunityOptional.orElseThrow(() -> new NoSuchElementException("해당 ID의 게시글이 존재하지 않습니다."));
        
        communityRepository.delete(existingCommunity);;
    }

    public List<Community> findAll(){ // 전체 게시물조회
        return communityRepository.findAll();
    }

    public Community findByPostId(Long postid){  // 게시글 id를 통한 조회
        return communityRepository.findByPostId(postid).orElse(null);
        
    }
}
