package com.octo.services;


import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;
import java.util.stream.Collectors;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoService.class);

    @Autowired
    private VideoRepository videoRepository;



    public List<VideoDTO> retrieveVideosByTagAndLevel(List<String> tags, Level level) {

        // TODO code goes here

        List<Video> videos = videoRepository.findByLevel((level));
        if (videos.isEmpty()){
            return null;
        }

        List<Video> filteredVideos = videoRepository.findByTags(tags);
        if (filteredVideos.isEmpty()){
            return null;
        }
        return filteredVideos.stream().map(video -> VideoToVideoDTOMapper.convert(video))
                .collect(Collectors.toList());

        // 1. search videos by tags AND/OR level
        // 2. use videoToVideoDTOMapper to map videos to videos DTO
        // 3 return the list

    }


}
