$(function() {
   load_article();
});

function load_article() {
    $.ajax({
        type: "GET",
        url: "/articles",
        success: function(data) {
            var content = "<tr><td>글 번호</td><td>내용</td><td>작성 시간</td></tr>"
            for(var a = 0; a < data.length; a++) {
                var d = "<tr>";
                var article = data[a];
                d += "<td>"+article.idx+"</td>";
                d += "<td data-toggle='modal' data-target='#article_modal'><a href='#'>"+article.content+"</a></td>";
                d += "<td>"+new Date(article.created_at)+"</td>";
                d += "</tr>";
                content += d;
            }
            $("#article_list").html(content);
        }
    });
}