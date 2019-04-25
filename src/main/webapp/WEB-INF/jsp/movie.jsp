<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Movie</title>
</head>
<body>
<h1>Edit movie: ${movie.title}</h1>

<br/><br/>
<form method="post" action="/addMovie/${movie.id}">
    <table>
        <tr>
            <td>id</td>
            <td>
                ${movie.id}
                <input type="hidden" name="id" value="${movie.id}"/>
            </td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="${movie.title}"/></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description" value="${movie.description}"/></td>
        </tr>
        <tr>
            <td>
                <input type="Submit" name="operation" value="Update"/>
        </tr>
    </table>
</form>
</body>

</html>