<%@ page pageEncoding="utf-8" %>
<html>

<%@include file="header.jsp" %>

<body>
    <div class="container">
        <div class="header clearfix">
            <a href="#" class="navbar-left">
                <img width="50px" height="50px" style="margin-right:5px;" src="/static/images/chick.png">
            </a>
            <h3 class="text-muted"> 유치원 방명록 </h3>

        </div>

        <div class="page-header">
            <h3>방명록 글 목록</h3>
        </div>
        <div class="row marketing">
            <div class="col-lg-12">
                <div class="row">
                    <table id="article_list" class="table table-bordered table-hover">
                        <tr>
                            <td>글 번호</td>
                            <td>내용</td>
                            <td>작성 시간</td>
                            <td>마지막 수정 시간</td>
                            <td>이메일</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

    </div>
</body>
</html>
