var express = require('express');
var storyroute = express.Router();
const story= {
    "storyTitle": "Random Story",
    "story": "Living their dream life, the main character is forced to watch the world around them crumble when they witness a secret exchange that could cost them their life. \nRefusing to back down, the main character, with no one on their side and few resources, desperately searches for a missing item.In the end, after being permanently disabled, the main character loses what they had, but gains a new love interest."
  }

  storyroute.get('/', function(req, res){
    
   res.json(story);
});
storyroute.post('/', function(req, res){
   res.send('POST route on story.');
});

//export this router to use in our app.js
module.exports = storyroute;