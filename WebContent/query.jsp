<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%
	String cardNO=request.getParameter("cardno")==null?"":request.getParameter("cardno");  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="发卡平台系统,激活码,体验码,新手卡">
<title>自主提卡 - 发卡平台系统 - ESUP网游</title>
</head>

<body>
<div class="container">
<%@include file="head.jsp"%>
<form class="form-horizontal">
  <legend>自主提卡</legend>
  <div class="well" style="max-width: 70%; margin: 0 auto 10px;">
    <div class="control-group">
      <label class="control-label" for="inputEmail">充值卡号</label>
      <div class="controls">
        <input type="text" id="inputEmail" placeholder="充值卡号" value="<%=cardNO%>">
        &nbsp;<span class="label label-important">请输入充值卡号</span></div>
    </div>
    <div class="control-group">
      <div class="controls">
        <button type="submit" class="btn btn-primary">查询</button>
      </div>
    </div>
    <div class="alert alert-error">
      <button type="button" class="close" data-dismiss="alert">×</button>
      充值卡号<strong>不正确！</strong>
    </div>
    <div class="control-group">
      <table class="table table-bordered"  style="background-color:#FFF">
        <thead>
          <tr>
            <th>充值卡号</th>
            <th>充值游戏</th>
            <th>充值面值</th>
            <th>充值时间</th>
            <th>充值帐号</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>DNW7HGDFHJH3GA</td>
            <td>斗牛棋牌银子</td>
            <td>1000</td>
            <td>2012-08-23 17:04:50</td>
            <td>a***s</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</form>
<%@include file="foot.jsp"%>
</div>
</body>
</html>
