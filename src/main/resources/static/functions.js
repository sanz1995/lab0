$(document).ready(function() {
	registerSearch();
});

function registerSearch() {
	$("#search").submit(function(ev){
		event.preventDefault();
		target = $(this).attr('action')
        query = $("#q").val()
		$.get(target, { q: query } )
            .done( function(data) {

                var template = $("#template").html();

                var rendered = "";

                var tweet = "";
                for (var i in data){
                    tweet = data[i];
                    console.log(tweet);
                    rendered = Mustache.render(template, {text: tweet.unmodifiedText,user: tweet.fromUser, id: tweet.idStr});
                    $("#resultsBlock").append(rendered);
                }


            }).fail(function() {
                $("#resultsBlock").empty();
            });
	});
}

