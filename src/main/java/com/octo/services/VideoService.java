package com.octo.services;


import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoCustomRepository;
import com.octo.repository.VideoRepository;
import java.util.stream.Collectors;
import java.util.List;

import com.octo.specifications.VideoSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class VideoService implements VideoCustomRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private EntityManager entityManager;



    @Override
    public List<VideoDTO> retrieveVideosByTagAndLevel(List<String> tags, Level level) {

        // TODO code goes here


        Specification<Video> specifications = Specification.where(VideoSpecification.hasTags(tags)
                .and(VideoSpecification.hasLevel(level)));
        return videoRepository.findAll(specifications)
                              .stream().map(video -> VideoToVideoDTOMapper.convert(video))
                              .collect(Collectors.toList());




    }


}
