package com.octo.specifications;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoSpecification {

    public static Specification<Video> hasTags(List<String> tags){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("tags"), tags);
        });
    }

    public static Specification<Video> hasLevel(Level level){
        return ((root, criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("level"), level);
        });
    }
}
