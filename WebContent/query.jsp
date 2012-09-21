<%@ page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="发卡平台系统,激活码,体验码,新手卡">
<title>自助提卡 - 发卡平台系统 - ESUP网游</title>
</head>

<body>
<div class="container">
<%@include file="head.jsp"%>
<form class="form-horizontal">
  <legend>自助提卡</legend>
  <div class="well" style="max-width: 75%; margin: 0 auto 10px;">
    <div class="control-group">
      <label class="control-label" for="inputEmail">订单编号</label>
      <div class="controls">
        <input type="text" id="inputEmail" placeholder="淘宝或拍拍订单编号">
        &nbsp;<span class="label label-important">请输入订单编号</span></div>
    </div>
    <div class="control-group">
      <label class="control-label" for="inputEmail">支付流水号</label>
      <div class="controls">
        <input type="text" id="inputEmail" placeholder="支付宝交易号或财付通订单号">
        &nbsp;<span class="label label-important">请输入支付流水号</span></div>
    </div>
    <div class="control-group">
      <div class="controls">
        <button type="submit" class="btn btn-primary">提 取</button>
      </div>
    </div>
    <div class="alert alert-error">
      <button type="button" class="close" data-dismiss="alert">×</button>
      订单编号或支付流水号<strong>不正确！</strong>
    </div>
    <div class="alert alert-info">
      <button type="button" class="close" data-dismiss="alert">×</button>
      <strong>无此订单！</strong>有疑问请联系客服。
    </div>
    <div class="control-group">
      <table class="table table-bordered"  style="background-color:#FFF">
        <thead>
          <tr>
            <th>订单编号</th>
            <th>卡号</th>
            <th>密码</th>
            <th>充值链接</th>
            <th>过期时间</th>
            <th>名称</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td title="85500561220120724855729115">85500561220...</td>
            <td>HSEKLFHKJSDE83</td>
            <td>DSF43VGSF3</td>
            <td><a href="#" target="_blank">http://chong.esup.cn</a></td>
            <td>2013-09-17 15:55:45</td>
            <td>心动游戏10元充值礼券</td>
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
