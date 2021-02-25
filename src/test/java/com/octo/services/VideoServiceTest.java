package com.octo.services;

import com.octo.domain.enums.Level;
import com.octo.domain.video.Video;
import com.octo.dto.video.VideoDTO;
import com.octo.mappers.VideoToVideoDTOMapper;
import com.octo.repository.VideoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class VideoServiceTest {


    @InjectMocks
    private VideoService videoService;
    @Mock
    private VideoRepository videoRepository;
    @Mock
    private VideoToVideoDTOMapper videoToVideoDTOMapper;



    @Test
    public void retrieveVideoByTagsAndOrLevel_test() {

        List<Video> list = new ArrayList<Video>();
        List<Video> listT = new ArrayList<Video>();

        Video video1 = new Video();
        Video video2 = new Video();
        Video video3 = new Video();


        video1.setId("15c45b452");
        video1.setTitle("course 1");
        video1.setDescription("desc");
        video1.setTags(Arrays.asList("spring", "react", "redux"));
        video1.setLevel(Level.EASY);
        video1.setDuration(Double.valueOf(56));
        video1.setUrl("url");

        video2.setId("15c4aa32");
        video2.setTitle("course 2");
        video2.setDescription("desc");
        video2.setTags(Arrays.asList("spring"));
        video2.setLevel(Level.EASY);
        video2.setDuration(Double.valueOf(56));
        video2.setUrl("url");

        video3.setId("15c45abc12");
        video3.setTitle("course 3");
        video3.setDescription("desc");
        video3.setTags(Arrays.asList("react","redux"));
        video3.setLevel(Level.HARD);
        video3.setDuration(Double.valueOf(56));
        video3.setUrl("url");

        list.add(video1);
        list.add(video2);

        listT.add(video1);
        listT.add(video2);
        listT.add(video3);


        videoRepository.saveAll(listT);

        List<VideoDTO> listDTO = list.stream().map(video -> VideoToVideoDTOMapper.convert(video)).collect(Collectors.toList());
        List<VideoDTO> listTDTO = listT.stream().map(video -> VideoToVideoDTOMapper.convert(video)).collect(Collectors.toList());

        when(videoService.retrieveVideosByTagAndLevel(Arrays.asList("spring","react","redux"), Level.EASY))
                .thenReturn(listDTO);

        List<VideoDTO> newList = videoService.retrieveVideosByTagAndLevel(Arrays.asList("spring","react","redux"), Level.EASY);
        List<VideoDTO> newList1 = videoService.retrieveVideosByTagAndLevel(Collections.<String>emptyList(), null);

        assertEquals(listDTO, newList);
        assertEquals(listTDTO, newList1);
    }


}