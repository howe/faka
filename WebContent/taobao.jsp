<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%
	String ts=request.getParameter("top_session")==null?"":request.getParameter("top_session");  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
    <meta name="keywords" content="发卡平台系统,激活码,体验码,新手卡">
    <title>取TOP_SESSION - 发卡平台系统 - ESUP网游</title>
    <script type="text/javascript">
        (function(){
            var start, end, obj, data;
            obj = document.getElementById('data');
            data = document.getElementById('data').value;
            end = data.length;
            document.getElementById('btn').onclick = function(){
                if(-[1,]){             //处理费IE浏览器
                    alert("您使用的浏览器不支持此复制功能，请使用Ctrl+C或鼠标右键。");
                    document.getElementById('data').setSelectionRange(0,end);
                    document.getElementById('data').focus();
                }else{
                    var flag = window.clipboardData.setData("text",data);
                    if(flag == true){
                        alert("复制成功。");
                    }else{
                        alert("复制失败。");
                    }
                    var range = obj.createTextRange();
                    range.moveEnd("character",end);
                    range.moveStart("character",0);
                    range.select();
                }
 
            }
        })()
    </script>
    </head>

    <body>
<div class="container">
<%@include file="head.jsp"%>
<form class="form-horizontal">
  <legend>取TOP_SESSION</legend>
  <div class="well" style="max-width: 75%; margin: 0 auto 10px;">
    <div class="control-group">
      <label class="control-label" for="inputEmail">TOP_SESSION</label>
      <div class="controls">
        <div class="input-append">
          <input class="input-xlarge" name="data" id="data" size="16" type="text" value="<%=ts%>">
          <a class="btn btn-primary" id="btn">复 制</a></div>
      </div>
    </div>
  </div>
</form>
<%@include file="foot.jsp"%>
</div>
</body>
</html>
