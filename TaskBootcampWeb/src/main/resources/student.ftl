<!DOCTYPE html>
<html>
<head>
    <title>User page</title>
</head>
<body>
<table>
    <tbody>
    <#list data as item>
        <tr>
            <td>${item.name}</td>
            <td>${item.age}</td>
            <td>${item.group}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>