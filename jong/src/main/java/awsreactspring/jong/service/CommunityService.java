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

    // public Community findCommunityByUserid(Long userid) { // 유저 아이디를 통해 게시물조회
    //     return communityRepository.findByUserid(userid)
    //             .orElseThrow(() -> new IllegalStateException("존재하지 않습니다."));
    // }

    // public Community findCommunityByTitle(String title){ //제목으로 게시물조회
    //     Optional<Community> optionalCommunity = communityRepository.findByTitleContaining(title);
    //     if(optionalCommunity.isEmpty()){
    //         throw new IllegalStateException("잘못된 요청입니다.");
    //     }else{
    //         return optionalCommunity.get();
    //     }
    // }

    public List<Community> findCommunityByTitle(String title){  //제목으로 게시물 조회
        List<Community> communities = communityRepository.findByTitleContaining(title);
        if(communities.isEmpty()){
            throw new IllegalStateException("해당하는 제목의 게시글 없음");
        }else{
            return communities;
        }
    }

    public List<Community> findCommunityByContent(String content){ //내용으로 게시물조회
        List<Community> communities = communityRepository.findByContentContaining(content);
        if(communities.isEmpty()){
            throw new IllegalStateException("잘못된 요청입니다.");
        }else{
            return communities;
        }
    }

    /**public Community changeCommunity(Long postid, Community changedCommunity){ // 게시글 아이디를 이용하여, 제목 및 내용 수정
        Community existingCommunity = findByPostid(postid);

        existingCommunity.setTitle(changedCommunity.getTitle());
        existingCommunity.setContent(changedCommunity.getContent());

        return communityRepository.save(existingCommunity);
    } */
    public Community changeCommunity(Long postid, Community changedCommunity) { //게시글 수정 postid ->
        Community existingCommunity = findByPostid(postid);
        
        if(existingCommunity != null){
            existingCommunity.setTitle(changedCommunity.getTitle());
            existingCommunity.setContent(changedCommunity.getContent());
            return communityRepository.save(existingCommunity);
        }
        else{
            System.out.println("해당 id로 게시글을 찾을수 없음");
            return null;
        }
    
    } 


    // public void changeCommunity(Long postid, Community changedCommunity) { //게시글 수정 postid ->
    //     Community existingCommunity = findByPostid(postid);
        
    //     if(existingCommunity != null){
    //         existingCommunity.setTitle(changedCommunity.getTitle());
    //         existingCommunity.setContent(changedCommunity.getContent());
    //     }
    //     else{
    //         System.out.println("해당 id로 게시글을 찾을수 없음");
    //     }
    
    // } 

    // public Community changeCommunity(Long postid, Community changedCommunity) { //게시글 수정
    //     Community existingCommunity = findByPostId(postid);
    
    //     existingCommunity.setTitle(changedCommunity.getTitle());
    //     existingCommunity.setContent(changedCommunity.getContent());
    
    //     return communityRepository.save(existingCommunity);
    // } 

    /**public void deleteCommunity(Long postid){  // 게시글 아이디를 이용하여,삭제
        Community existingCommunity = findByPostid(postid);

        communityRepository.delete(existingCommunity);
    }*/
    
    public void deleteCommunity(Long postid) {    // 게시글 아이디를 이용하여,삭제
        Optional<Community> existingCommunityOptional = communityRepository.findByPostid(postid);
        Community existingCommunity = existingCommunityOptional.orElseThrow(() -> new NoSuchElementException("해당 ID의 게시글이 존재하지 않습니다."));
        
        communityRepository.delete(existingCommunity);;
    }

    public List<Community> findAll(){ // 전체 게시물조회
        return communityRepository.findAll();
    }

    public Community findByPostid(Long postid){  // 게시글 id를 통한 조회  ??
        return communityRepository.findByPostid(postid).orElse(null);
        
    }
}
