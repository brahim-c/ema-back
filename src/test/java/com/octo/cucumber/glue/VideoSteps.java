package com.octo.cucumber.glue;

import com.octo.domain.video.Video;
import io.cucumber.java.en.Given;

import java.util.List;

public class VideoSteps {

    @Given("^the list of videos$")
    public void theListOfVideos(final List<Video> videos){

    }
}
