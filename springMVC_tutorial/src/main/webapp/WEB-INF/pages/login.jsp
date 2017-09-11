<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="label.title"/></title>
</head>
<body>
<div style="text-align: right;padding: 5px;margin: 5px 0px;background: #cccccc;">
    <a href="${pageContext.request.contextPath}/en/admin/login">
        <spring:message code="option.english"/>
    </a>
    &nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/zh/admin/login">
        <spring:message code="option.chinese"/>
    </a>
</div>
<form method="post">
    <table>
        <tr>
            <td>
                <strong>
                    <spring:message code="label.username"/>
                </strong>
            </td>
            <td>
                <input name="username"/>
            </td>
        </tr>
        <tr>
            <td>
                <strong>
                    <spring:message code="label.password"/>
                </strong>
            </td>
            <td>
                <input name="password"/>
            </td>
        </tr>
        <tr>
            <td colspan="1">
                <spring:message code="label.submit" var="labelSubmit"/>
            </td>
            <td>
                <input type="submit" value="${labelSubmit}"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
