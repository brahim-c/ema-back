package com.octo.repository;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;

import java.util.List;

public interface VideoCustomRepository {
    List<VideoDTO> retrieveVideosByTagAndLevel(List<String> tags, Level level);
}
