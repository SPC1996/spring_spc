<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Spring MVC : Static</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<pre>
    Config : /css/** ==>/WEB-INF/resource/css/
    -----------------------------------------------------
             /css/common.css ==> /WEN-INF/resource/css/common.css
             /css/other.css ==> /WEN-INF/resource/css/other.css
</pre>
<div class="red-text">RED TEXT</div>
<br>
<div class="green-text">GREEN TEXT</div>
<br>
<input type="button" class="button" onclick="sayHello()" value="CLICK ME">
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</html>
