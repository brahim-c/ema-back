package com.octo.repository;


import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video, String>, VideoCustomRepository, JpaSpecificationExecutor<Video> {



//    @Query("FROM Video WHERE Video.level = ?1")
//    List<Video> findByLevel(Level level);
//
//    @Query("FROM Video WHERE Video.tags in (:tags)")
//    List<Video> findByTags(List<String> tags);

}
