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

            <div class='btn-toolbar pull-right'>
                <div class='btn-group'>
                    <button type='button' class='btn btn-default' data-toggle="modal" data-target="#article_modal" onclick="get_autoscale_setting()">방명록 작성</button>
                </div>
            </div>

        </div>

        <div class="page-header">
            <h3>방명록 글 목록</h3>
        </div>
        <div class="row marketing">
            <div class="col-lg-12">
                <div class="row">
                    <table id="article_list" class="table table-bordered table-hover">

                    </table>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="article_modal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title"></h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="내용" id="article_content"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="이메일" id="article_email"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-dismiss="modal" onclick="upload_article()"></button>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <p>2016 NHN Entertainment Corp</p>
        </footer>
    </div>
</body>
</html>
