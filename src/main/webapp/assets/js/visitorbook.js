$(function() {
   load_article_list();
});

function load_article_list() {
    $.ajax({
        type: "GET",
        url: "/articles",
        success: function(data) {
            var content = "<tr><td>글 번호</td><td>내용</td><td>작성 시간</td></tr>"
            for(var a = 0; a < data.length; a++) {
                var d = "<tr>";
                var article = data[a];
                d += "<td>"+article.idx+"</td>";
                d += "<td data-toggle='modal' data-target='#read_article_modal' onclick='load_article("+article.idx+")'><a href='#'>"+article.content+"</a></td>";
                d += "<td>"+new Date(article.created_at)+"</td>";
                d += "</tr>";
                content += d;
            }
            $("#article_list").html(content);
        }
    });
}


function load_article(idx) {
    $.ajax({
        type: "GET",
        url: "/articles/"+idx,
        success: function(data) {
            $("#read_article_id").val(data['idx']);
            $("#read_article_content").val(data['content']);
            $("#read_article_email").val(data['email']);
            $("#read_article_created").val(new Date(data['created_at']));
            $("#read_article_modified").val(new Date(data['modified_at']));
        }
    });
}


function write_araticle() {

}