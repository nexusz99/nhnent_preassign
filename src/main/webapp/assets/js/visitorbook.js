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


function ValidateEmail(mail)
{
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
    {
        return (true)
    }
    return (false)
}

function write_article() {
    var content = $("#write_article_content").val();
    var email = $("#write_article_email").val();
    var passwd = $("#write_article_passwd").val();

    if(!ValidateEmail(email)) {
        alert("이메일 형식이 올바르지 않습니다.");
    }
    var req_body = {'content': content, 'email': email, 'passwd': passwd};

    $.ajax({
        type: "POST",
        data: JSON.stringify(req_body),
        contentType: 'application/json',
        url: '/articles',
        success: function (msg) {
            $("#write_article_modal").modal('hide');
            $("#write_article_content").val('');
            $("#write_article_email").val('');
            $("#write_article_passwd").val('');
            load_article_list();
        },
        statusCode: {
            400: function(data) {
                alert(data);
            }
        }
    });
}

function rewrite_article() {
    var article_idx = $("#read_article_id").val();
    var content = $("#read_article_content").val();
    var passwd = $("#read_article_passwd").val();

    var req_body = {'content': content, 'passwd': passwd};

    $.ajax({
        type: "POST",
        data: JSON.stringify(req_body),
        contentType: 'application/json',
        url: '/articles/'+article_idx,
        success: function (msg) {
            $("#read_article_modal").modal('hide');
            load_article_list();
        },
        statusCode: {
            400: function(data) {
                alert(data);
            },
            401: function(data) {
                alert("비밀번호가 틀립니다.");
            }
        }
    });


}