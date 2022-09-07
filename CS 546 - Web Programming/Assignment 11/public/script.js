(function ($) {
  // Initializing AJAX Request !
  var requestConfig = {
      method: 'GET',
      url: 'http://api.tvmaze.com/shows',
  };
  $.ajax(requestConfig).then(function (responseMessage) {
      // making showlist empty and hidden initially
      $('#showList').empty();
      $('#showList').hide();
      // making show hidden initially
      $('#show').hide();
      // making homeLink hidden initially
      $('#homeLink').hide();
      $.each(responseMessage, function () { $('#showList').append(`<li><a class="shownLink" href='${this._links.self.href}'>${this.name}</a></li>`); });
      // initially show the list of TV Shows on homepage
      $('#showList').show();

      // overriding defaults to prevent clicks by hiding the elements
      $('a.shownLink').on('click', function (event) {
          event.preventDefault();
          $('#showList').hide();
          $('#show').empty();
          // Making an AJAX request to the URL and fetch the data for respective show
          linkClicked(event.target.href);
          // Making the show element visible
          $('#show').show();
          // Making the homeLink element visible
          $('#homeLink').show();
      });
  });

  $('#searchForm').submit(function (event) {
      event.preventDefault();
      // checking for no input or empty spaces, if so, it should inform user of an error somehow
      if (!$('#search_term').val() || $('#search_term').val().trim() == "") {
          alert("Please enter a valid search term!");
      }
      else {
          var requestConfig2 = {
              method: 'GET',
              url: 'http://api.tvmaze.com/search/shows?q=' + $('#search_term').val()
          };
          $.ajax(requestConfig2).then(function (responseMessage) {
              // hide the homeLink element
              $('#homeLink').hide();
              // empty and hide the list item elements in the showList element
              $('#showList').empty();
              $('#showList').hide();
              // hide the show element
              $('#show').hide();
              // append each list item to the showList UL element
              $.each(responseMessage, function () { $('#showList').append(`<li><a class="shownLink" href='${this.show._links.self.href}'>${this.show.name}</a></li>`); });
              // show the showList and homeLink element
              $('#showList').show();
              $('#homeLink').show();

              // if a link is clicked, call linkClicked
              // prevent default
              $('a.shownLink').on('click', function (event) {
                  event.preventDefault();
                  console.log("hello");
                  // hide the showList element
                  $('#showList').hide();
                  // empty the show element
                  $('#show').empty();
                  // make an AJAX request to the URL and fetch the data for that show
                  console.log(event.target.href);
                  linkClicked(event.target.href);
                  // show the show element 
                  $('#show').show();
                  // show the homeLink element
                  $('#homeLink').show();
              });
          });
      }
  });

  function linkClicked(link) {
      var requestConfig3 = {
          method: 'GET',
          url: link
      };
      $.ajax(requestConfig3).then(function (responseMessage) {
          // check if image does not exist
          if (responseMessage.image) {
              if (!responseMessage.image.medium) {
                  responseMessage.image.medium = "/public/no_image.jpeg";
              }
          }
          // check if name, language, rating.average, network.name, summary, genres do not exist
          if (!responseMessage.name || responseMessage.name.trim() == "") {
              responseMessage.name = "N/A";
          }
          if (!responseMessage.language || responseMessage.language.trim() == "") {
              responseMessage.language = "N/A";
          }
          if (responseMessage.rating) {
              if (!responseMessage.rating.average) {
                  responseMessage.rating.average = "N/A";
              }
          }
          if (responseMessage.network) {
              if (!responseMessage.network.name || responseMessage.network.name.trim() == "") {
                  responseMessage.network.name = "N/A";
              }
          }
          if (!responseMessage.summary || responseMessage.summary.trim() == "") {
              responseMessage.summary = "N/A";
          }
          
          if (responseMessage.genres.length == 0) {
              responseMessage.genres = ["N/A"];
          }
          $('#show').append(`<h1>${responseMessage.name}<h1>
      <img src="${responseMessage.image && responseMessage.image.medium ? responseMessage.image.medium : "/public/no_image.jpeg"}"/>
      <dl>
        <dt>Language</dt>
        <dd>${responseMessage.language}</dd>
        <dt>Genres</dt>
        <ul>
                    ${responseMessage.genres.map((g) => `<li>${g}</li>`)}
                </ul>
        <dt>Average Rating</dt>
        <dd>${responseMessage.rating.average}</dd>
        <dt>Network</dt>
        <dd>${responseMessage.network && responseMessage.network.name ? responseMessage.network.name : "N/A"}</dd>
        <dt>Summary</dt>
        <dd>${responseMessage.summary}</dd>`);
      });
  }
})(window.jQuery);