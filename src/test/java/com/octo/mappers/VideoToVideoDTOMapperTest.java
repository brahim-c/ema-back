package com.octo.mappers;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Arrays;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VideoToVideoDTOMapperTest {

    @Test
    @DisplayName("---Testing method Map_vid_To_VidDto---")
     void Should_Map_vid_To_VidDto() {

        Video video = new Video();

        video.setId("15c458c55");
        video.setTitle("course 1");
        video.setDescription("desc");
        video.setTags(Arrays.asList("spring", "react"));
        video.setLevel(Level.EASY);
        video.setDuration(Double.valueOf(56));
        video.setUrl("url");

        assumeTrue(true);


        VideoDTO videoDTO = VideoToVideoDTOMapper.convert(video);

        assertEquals("15c458c55", videoDTO.getId());
        assertEquals("course 1", videoDTO.getTitle() );
        assertEquals("desc", videoDTO.getDescription());
        assertEquals(Arrays.asList("spring", "react"), videoDTO.getTags());
        assertEquals(Level.EASY, videoDTO.getLevel());
        assertEquals(Double.valueOf(56), videoDTO.getDuration());
        assertEquals("url", videoDTO.getUrl());
    }

}