Feature: video feature

  Scenario: get videos list by level and tags
    Given the list of videos
      | title | description | url | level | tags |
      | video 1 | desc 1 | url1 | EASY | react, spring |
      | video 2 | desc 2 | url2 | HARD | react, redux |
    When the user request videoList with level EASY and tags list : react
    Then video 1 should be returned